// ActionScript file
import classes.*;

import flash.events.Event;
import flash.events.FocusEvent;
import flash.events.MouseEvent;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.controls.dataGridClasses.DataGridColumn;
import mx.core.Application;
import mx.core.FlexGlobals;
import mx.events.CloseEvent;
import mx.events.DataGridEvent;
import mx.events.IndexChangedEvent;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.validators.Validator;

import service.ComboBoxService;
import service.alu.Alu_RespEndService;
import service.alu.Alu_RespService;
import service.alu.Alu_RespTelService;

import vo.alu.Alu_RespEndVO;
import vo.alu.Alu_RespTelVO;
import vo.alu.Alu_RespVO;


[Bindable] private var ArrayEstado:ArrayCollection;
[Bindable] private var ArrayTipoTel:ArrayCollection;
[Bindable] private var ArrayTipoEnd:ArrayCollection;
[Bindable] private var ArraySexo:ArrayCollection;
[Bindable] private var ArrayEstadoCivil:ArrayCollection;
private var retorno:UtilRetornoBanco;
private var util:Util = new Util();
private var ro_resp:Alu_RespService = Alu_RespService.getInstance();
private var ro_respend:Alu_RespEndService = Alu_RespEndService.getInstance();
private var ro_resptel:Alu_RespTelService = Alu_RespTelService.getInstance();
private var ro_combobox:ComboBoxService = ComboBoxService.getInstance();
private var alu_respVO:Alu_RespVO;
private var alu_respendVO:Alu_RespEndVO;
private var alu_resptelVO:Alu_RespTelVO;
[Bindable] private var isValid:Boolean = false;
            
                          
private function init():void{
	this.width = FlexGlobals.topLevelApplication.mdiCanvas.width;
	this.height = FlexGlobals.topLevelApplication.mdiCanvas.height;
	
	this.x = 0;
	this.y = 0;
	
	ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
	ctrlbar.bt_inserir.addEventListener(MouseEvent.CLICK,inserir);
	ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,alterar);
	ctrlbar.bt_excluir.addEventListener(MouseEvent.CLICK,deletar);
	ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
	
	txtcpf.addEventListener(FocusEvent.FOCUS_OUT,localizaCPF);
	
	
	ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
	ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
	ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
	ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
	ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
	
	ro_combobox.Adm_Sexo(createcomboxsexo,defaultFaultHandler);
	ro_combobox.Adm_EstadoCivil(createcomboxestadocivil,defaultFaultHandler);
}
private function localizaCPF(e:Event):void{
	if(txtcpf.text.length == 14){
		alu_respVO = new Alu_RespVO();
		alu_respVO.cpf = txtcpf.text;
		
		ro_resp.select(alu_respVO,localizaCPFResult,defaultFaultHandler);
	}
	
}
private function localizaCPFResult(e:ResultEvent):void{
	if(int(e.result[0]['id_resp']) > 0){
		Alert.yesLabel='Sim';
		Alert.noLabel='Não';
		Alert.show('C.P.F. Já cadastrado deseja consultar ?','C.P.F. Já Cadastrado',Alert.YES|Alert.NO,this,confirmLocaliza(int(e.result[0]['id_resp'])));
	}
}
private function confirmLocaliza(id_resp:int):Function{
	return function(e:CloseEvent):void{
		if (e.detail == Alert.YES){
			limpar(e);
			
			alu_respVO = new Alu_RespVO();
			alu_respVO.id_resp = id_resp;
			
			ro_resp.select(alu_respVO,createDataGrid,defaultFaultHandler);
		}
	}
}                
private function accordioncomplete(e:IndexChangedEvent):void{
   	var currentIndex:int=e.newIndex;
   	if (currentIndex == 0){
		c_endereco.label = 'Endereço(s)';
		c_telefone.label = 'Telefone(s)';
   	}else if (currentIndex == 1){
		limpar(e);
		if (txtnome.text.length > 0){
			c_endereco.label = 'Endereço(s) - ' + c_responsavel.label + ' ( ' + txtnome.text + ' )';
		}
   		selecionar(e);
		ro_combobox.Adm_Estado(createcomboxestado,defaultFaultHandler);
		ro_combobox.Adm_TipoEnd(createcomboboxtipoend,defaultFaultHandler);
   	}else if (currentIndex == 2){
		limpar(e);
		if (txtnome.text.length > 0){
			c_telefone.label = 'Telefone(s) - ' + c_responsavel.label + ' ( ' + txtnome.text + ' )';
		}
   		selecionar(e);
		ro_combobox.Adm_TipoTel(createcomboxtipotel,defaultFaultHandler);
   	}
}

private function createDataGrid(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_resp.selectedIndex == 0){
		dg_resp.dataProvider = e.result;
	} else if (accordion_resp.selectedIndex == 1 ){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_resp.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	}
}

private function createcomboxestado(event:ResultEvent):void{
	ArrayEstado = event.result as ArrayCollection;
	cbuf_end.dataProvider = ArrayEstado;
}
private function createcomboxtipotel(event:ResultEvent):void{
	ArrayTipoTel = event.result as ArrayCollection;
	cbtipo_tel.dataProvider = ArrayTipoTel;
}
private function createcomboboxtipoend(event:ResultEvent):void{
	ArrayTipoEnd = event.result as ArrayCollection;
	cb_tipoend.dataProvider = ArrayTipoEnd;
}
private function createcomboxestadocivil(event:ResultEvent):void{
	ArrayEstadoCivil = event.result as ArrayCollection;
	cbestadocivil.dataProvider = ArrayEstadoCivil;
}
private function createcomboxsexo(event:ResultEvent):void{
	cbsexo.dataProvider = event.result as ArrayCollection;
	ArraySexo = event.result as ArrayCollection;
}
protected function lblfunction_dt(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_nascimento);
}
protected function lf_estado(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_estado,ArrayEstado);
	return retorno.label;
}
protected function lf_tipotel(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_tipotel,ArrayTipoTel);
	return retorno.label;
}

private function selecionar(e:Event):void{
	this.enabled = false;
	if (accordion_resp.selectedIndex == 0){
		popular_responsavel();
		ro_resp.select(alu_respVO,createDataGrid,defaultFaultHandler);
	} else if (accordion_resp.selectedIndex == 1){
		if (txtid.text.length > 0){
			popular_endereco();
			ro_respend.select(alu_respendVO,createDataGrid,defaultFaultHandler);
		}	
	} else if (accordion_resp.selectedIndex == 2){
		if (txtid.text.length > 0){
			popular_telefone();
			ro_resptel.select(alu_resptelVO,createDataGrid,defaultFaultHandler);
		}
	} 
}

public function inserir(e:Event):void{
	if (accordion_resp.selectedIndex == 0){
		isValid = util.validateForm(form_r1);
		isValid = util.validateForm(form_r2) && isValid;
		if (!isValid){
			mensagem_resp.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_responsavel();
			ro_resp.inserir(alu_respVO,inserirResult,defaultFaultHandler);
		}
	} else if (accordion_resp.selectedIndex == 1){
		isValid = util.validateForm(form_e1);
		isValid = util.validateForm(form_e2) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_endereco();
			ro_respend.inserir(alu_respendVO,inserirResult,defaultFaultHandler);
		}
	} else if (accordion_resp.selectedIndex == 2){
		isValid = util.validateForm(form_t1);
		isValid = util.validateForm(form_t2) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_telefone();
			ro_resptel.inserir(alu_resptelVO,inserirResult,defaultFaultHandler);
		}
	}
}
private function inserirResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_resp.selectedIndex == 0){
		txtid.text = e.result.toString();
	} else if (accordion_resp.selectedIndex == 1){
		txtidresp_end.text = e.result.toString();
	} else if (accordion_resp.selectedIndex == 2){
		txtidresp_tel.text = e.result.toString();
	} 
	selecionar(e);
}
public function alterar(e:Event):void{
	if (accordion_resp.selectedIndex == 0){
		isValid = util.validateForm(form_r1);
		isValid = util.validateForm(form_r2) && isValid;
		if (!isValid){
			mensagem_resp.text = UtilMensagens.PreenchaCampo;			
		} else {
			popular_responsavel()
			ro_resp.atualizar(alu_respVO,alterarResult,defaultFaultHandler);
		}
	} else if (accordion_resp.selectedIndex == 1){
		isValid = util.validateForm(form_e1);
		isValid = util.validateForm(form_e2) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;			
		} else {
			popular_endereco();
			ro_respend.atualizar(alu_respendVO,alterarResult,defaultFaultHandler);
		}
   	} else if (accordion_resp.selectedIndex == 2){
		isValid = util.validateForm(form_t1);
		isValid = util.validateForm(form_t2) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;			
		} else {
			popular_telefone();
			ro_resptel.atualizar(alu_resptelVO,alterarResult,defaultFaultHandler);
		}
  	}
}
private function alterarResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_resp.selectedIndex == 0){
		dg_resp.dataProvider = e.result;
	} else if (accordion_resp.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_resp.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	}
}
private function deletar(e:Event):void{
	if (accordion_resp.selectedIndex == 0){
		isValid = util.validateForm(form_r1);
		isValid = util.validateForm(form_r2) && isValid;
		if (!isValid){
			mensagem_resp.text = UtilMensagens.PreenchaCampo;			
		} else {
			popular_responsavel();
			ro_resp.deletar(alu_respVO,deletarResult,defaultFaultHandler);
		}
    } else if (accordion_resp.selectedIndex == 1){
		isValid = util.validateForm(form_e1);
		isValid = util.validateForm(form_e2) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;			
		} else {
			popular_endereco();
			ro_respend.deletar(alu_respendVO,deletarResult,defaultFaultHandler);
		}
    } else if (accordion_resp.selectedIndex == 2){
		isValid = util.validateForm(form_t1);
		isValid = util.validateForm(form_t2) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;			
		} else {
			popular_telefone();
			ro_resptel.deletar(alu_resptelVO,deletarResult,defaultFaultHandler);
		}
   	}
}
private function deletarResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_resp.selectedIndex == 0){
		dg_resp.dataProvider = e.result;
	} else if (accordion_resp.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_resp.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	} 
	limpar(e);
}
private function popular_responsavel():void{
	alu_respVO = new Alu_RespVO();
	alu_respVO.id_resp = txtid.text.length <= 0 ? null : txtid.text;
	alu_respVO.nome = txtnome.text.length <= 0 ? null : txtnome.text.toUpperCase();
	alu_respVO.cpf = txtcpf.text.length <= 0 ? null : txtcpf.text;
	alu_respVO.rg = txtrg.text.length <= 0 ? null : txtrg.text.toUpperCase();
	alu_respVO.dt_nascimento = txtdtnascimento.selectedDate ? txtdtnascimento.selectedDate : null;
	alu_respVO.id_sexo = cbsexo.selectedItem ? cbsexo.selectedItem.data : null;
	alu_respVO.cnpj = txtcnpj.text.length <= 0 ? null : txtcnpj.text;
	alu_respVO.email = txtemail.text.length <= 0 ? null : txtemail.text.toUpperCase();
	alu_respVO.local_trabalho = txtlocaltrabalho.text.length <= 0 ? null : txtlocaltrabalho.text.toUpperCase();
	alu_respVO.profissao = txtprofissao.text.length <= 0 ? null : txtprofissao.text.toUpperCase();
	alu_respVO.id_estadocivil = cbestadocivil.selectedItem ? cbestadocivil.selectedItem.data : null;
}
private function popular_endereco():void{
	alu_respendVO = new Alu_RespEndVO();
	alu_respendVO.id_respend = txtidresp_end.text.length <= 0 ? null : parseInt(txtidresp_end.text);
	alu_respendVO.endereco = txtendereco_end.text.length <= 0 ? null : txtendereco_end.text.toUpperCase();
	alu_respendVO.complemento = txtcomplemento_end.text.length <= 0 ? null : txtcomplemento_end.text.toUpperCase();
	alu_respendVO.bairro = txtbairro_end.text.length <= 0 ? null : txtbairro_end.text.toUpperCase();
	alu_respendVO.cep = txtcep_end.text.length <= 0 ? null : txtcep_end.text;
	alu_respendVO.cidade = txtcidade_end.text.length <= 0 ? null : txtcidade_end.text.toUpperCase();
	alu_respendVO.id_estado = cbuf_end.selectedItem ? cbuf_end.selectedItem.data : null;
	alu_respendVO.id_resp = txtid.text;
	alu_respendVO.id_tipoend = cb_tipoend.selectedItem ? cb_tipoend.selectedItem.data : null;
	alu_respendVO.numero = txtnumero_end.text.length <= 0 ? null : txtnumero_end.text.toUpperCase();
}
private function popular_telefone():void{
	alu_resptelVO = new Alu_RespTelVO();
	alu_resptelVO.id_resptel = txtidresp_tel.text.length <= 0 ? null : parseInt(txtidresp_tel.text);
	alu_resptelVO.descricao = txtdescricao_tel.text.length <= 0 ? null : txtdescricao_tel.text.toUpperCase();
	alu_resptelVO.numero = txtnumero_tel.text.length <= 0 ? null : txtnumero_tel.text;
	alu_resptelVO.ddd = txtddd_tel.text.length <= 0 ? null : txtddd_tel.text;
	alu_resptelVO.id_resp = parseInt(txtid.text);
	alu_resptelVO.id_tipotel = cbtipo_tel.selectedItem ? cbtipo_tel.selectedItem.data : null;
}
public function limpar(e:Event):void{
              	
  	if (accordion_resp.selectedIndex == 0){
		util.limpar_formulario(form_r1);
		util.limpar_formulario(form_r2);
		util.limpar_formulario(form_e1);
		util.limpar_formulario(form_e2);
		util.limpar_formulario(form_t1);
		util.limpar_formulario(form_t2);		

  		mensagem_resp.text = "";
       	mensagem_end.text = "";
		mensagem_tel.text = "";
		
		dg_resp.dataProvider = null;
		dg_endereco.dataProvider = null;
		dg_telefone.dataProvider = null;
   	} else if (accordion_resp.selectedIndex == 1){
		util.limpar_formulario(form_e1);
		util.limpar_formulario(form_e2);
		
		mensagem_end.text = "";

		dg_endereco.dataProvider = null;
   	} else if (accordion_resp.selectedIndex == 2){
		util.limpar_formulario(form_t1);
		util.limpar_formulario(form_t2);
		
		mensagem_tel.text = "";
		
		dg_telefone.dataProvider = null;
   	}
}
public function setcampos(e:Event):void{
	if (accordion_resp.selectedIndex == 0){
		txtid.text = dg_resp.selectedItem.id_resp;
		txtnome.text = dg_resp.selectedItem.nome;
		txtcpf.text= dg_resp.selectedItem.cpf;
		txtrg.text = dg_resp.selectedItem.rg;
		txtdtnascimento.selectedDate = dg_resp.selectedItem.dt_nascimento ? dg_resp.selectedItem.dt_nascimento : null;
		cbsexo.selectedItem = util.selecionarCombobox(dg_resp.selectedItem.id_sexo,ArraySexo);
		txtcnpj.text = dg_resp.selectedItem.cnpj;
		txtemail.text = dg_resp.selectedItem.email;
		txtlocaltrabalho.text = dg_resp.selectedItem.local_trabalho;
		txtprofissao.text = dg_resp.selectedItem.profissao;
		cbestadocivil.selectedItem = util.selecionarCombobox(dg_resp.selectedItem.id_estadocivil,ArrayEstadoCivil);
	}else if (accordion_resp.selectedIndex == 1 ){
		txtidresp_end.text = dg_endereco.selectedItem.id_respend;
		txtendereco_end.text = dg_endereco.selectedItem.endereco;
		txtcep_end.text = dg_endereco.selectedItem.cep;
		cbuf_end.selectedItem = util.selecionarCombobox(dg_endereco.selectedItem.id_estado,ArrayEstado);
		txtbairro_end.text = dg_endereco.selectedItem.bairro;
		txtcidade_end.text = dg_endereco.selectedItem.cidade;
		txtcomplemento_end.text = dg_endereco.selectedItem.complemento;
		txtnumero_end.text = dg_endereco.selectedItem.numero;
		cb_tipoend.selectedItem = util.selecionarCombobox(dg_endereco.selectedItem.id_tipoend,ArrayTipoEnd);

	} else if (accordion_resp.selectedIndex == 2){
		txtidresp_tel.text = dg_telefone.selectedItem.id_resptel;
		txtdescricao_tel.text = dg_telefone.selectedItem.descricao;
		txtddd_tel.text = dg_telefone.selectedItem.ddd;
		txtnumero_tel.text = dg_telefone.selectedItem.numero;
		cbtipo_tel.selectedItem = util.selecionarCombobox(dg_telefone.selectedItem.id_tipotel,ArrayTipoTel);
	}
}
private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
	
	if (accordion_resp.selectedIndex == 0){
		mensagem_resp.text = "";
	} else if (accordion_resp.selectedIndex == 1){
		mensagem_end.text = "";
	} else if (accordion_resp.selectedIndex == 2){
		mensagem_tel.text = "";
	}
	
}
