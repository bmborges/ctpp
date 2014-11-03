// ActionScript file
import classes.*;

import flash.events.Event;
import flash.events.FocusEvent;
import flash.events.KeyboardEvent;
import flash.events.MouseEvent;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.controls.Text;
import mx.controls.dataGridClasses.DataGridColumn;
import mx.core.FlexGlobals;
import mx.events.IndexChangedEvent;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.validators.EmailValidator;
import mx.validators.Validator;

import service.ComboBoxService;
import service.adm.Adm_OperadorService;
import service.adm.Adm_OperendService;
import service.adm.Adm_OpertelService;

import vo.adm.Adm_operadorVO;
import vo.adm.Adm_operendVO;
import vo.adm.Adm_opertelVO;

[Bindable] private var ArrayEstado:ArrayCollection;
[Bindable] private var ArrayCargo:ArrayCollection;
[Bindable] private var ArrayTipoTel:ArrayCollection;
[Bindable] private var ArrayAtivo:ArrayCollection;
[Bindable] private var ArrayEmpresa:ArrayCollection;
private var util:Util = new Util();
private var retorno:UtilRetornoBanco;

[Bindable] private var isValid:Boolean = false;
private var ro_operador:Adm_OperadorService = Adm_OperadorService.getInstance();
private var ro_operend:Adm_OperendService = Adm_OperendService.getInstance();
private var ro_opertel:Adm_OpertelService = Adm_OpertelService.getInstance();
private var ro_combobox:ComboBoxService = ComboBoxService.getInstance();
private var adm_operadorVO:Adm_operadorVO;
private var adm_operendVO:Adm_operendVO;
private var adm_opertelVO:Adm_opertelVO;


private function addButtons():void{
	ctrlbar.removeAllChildren();

	ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
	ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
	ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
	ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
	ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
	
}
private function init():void{
	
	this.width = FlexGlobals.topLevelApplication.mdiCanvas.width;
	this.height = FlexGlobals.topLevelApplication.mdiCanvas.height;
	
	this.x = 0;
	this.y = 0;
	
	addButtons();

	// cria combos
	ro_combobox.Adm_Cargo(createcomboboxcargo,defaultFaultHandler);
	ro_combobox.Adm_Ativo(createcomboboxativo,defaultFaultHandler);
	ro_combobox.Adm_Empresa(createcomboboxempresa,defaultFaultHandler);
	//seta eventos
	ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
	ctrlbar.bt_inserir.addEventListener(MouseEvent.CLICK,inserir);
	ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,alterar);
	ctrlbar.bt_excluir.addEventListener(MouseEvent.CLICK,deletar);
	ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
}
protected function txtemail_focusOutHandler(event:FocusEvent):void
{
	// TODO Auto-generated method stub
	var validador:EmailValidator = new EmailValidator;
	validador.property = "text";
	validador.validate(txtemail.text);
	
}
private function testesenha():Boolean{
    var ssenha:String = txtsenha.text;
    var sredigite:String = txtredigite.text;
       if (ssenha == sredigite){
           return true;
       }else{
           mensagem_oper.text = "A senha / redigite não confere digite novamente";
           return false;
       }
}
private function limparedigite(evt:KeyboardEvent):void{
    if (evt.keyCode != 13 || evt.keyCode != 9){
       txtredigite.text = null;	
    }
}
private function accordioncomplete(event:IndexChangedEvent):void{
   var currentIndex:int=event.newIndex;
   if (currentIndex == 0){
	   c_endereco.label = 'Endereço(s)';
	   c_telefone.label = 'Telefone(s)';
   }else if (currentIndex == 1){
	   if (txtnome.text.length > 0){
		   c_endereco.label = 'Endereço(s) - ' + c_operador.label + ' ( ' + txtnome.text + ' )';
	   }
	    ro_combobox.Adm_Estado(createcomboboxestado,defaultFaultHandler);
		util.limpar_formulario(form_enderecoa);
		util.limpar_formulario(form_enderecob);
	   selecionar(event);
   }else if (currentIndex == 2){
	  if (txtnome.text.length > 0){
		  c_telefone.label = 'Telefone(s) - ' + c_operador.label + ' ( ' + txtnome.text + ' )';
	  }
	  ro_combobox.Adm_TipoTel(createcomboboxtipotel,defaultFaultHandler);
	  util.limpar_formulario(form_telefonea);
	  util.limpar_formulario(form_telefoneb);
      selecionar(event);
   }
}

private function createcomboboxativo(event:ResultEvent):void{
	ArrayAtivo = event.result as ArrayCollection;
	cbativo.dataProvider = ArrayAtivo;
}
private function createcomboboxestado(event:ResultEvent):void{
 	ArrayEstado = event.result as ArrayCollection;
	cbuf_end.dataProvider = ArrayEstado;
}
private function createcomboboxcargo(event:ResultEvent):void{
 	ArrayCargo = event.result as ArrayCollection;
	cbcargo.dataProvider = ArrayCargo;
}
private function createcomboboxtipotel(event:ResultEvent):void{
	ArrayTipoTel = event.result as ArrayCollection;
	cbtipotel.dataProvider = ArrayTipoTel;
}
private function createcomboboxempresa(event:ResultEvent):void{
	ArrayEmpresa = event.result as ArrayCollection;
	cbempresa.dataProvider = ArrayEmpresa;
}
protected function labeldtformat_dtacesso(item:Object, column:DataGridColumn):String
{
	return util.formatDataHora(item.dt_acesso);
}
protected function labeldtformat_dtadmissao(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_admissao); 	
}
protected function labeldtformat_dtdemissao(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_demissao);	
}
protected function labeldtformat_dtnascimento(item:Object, column:DataGridColumn):String
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
	if (accordion_operador.selectedIndex == 0){
		popular_operador();
		var where:Array = ["id_aluno is null"];
		ro_operador.select(adm_operadorVO,createDataGrid,defaultFaultHandler,where,null);
	} else if (accordion_operador.selectedIndex == 1){
		if (txtid.text.length > 0){
			popular_endereco();
			ro_operend.select(adm_operendVO,createDataGrid);
		}	
	} else if (accordion_operador.selectedIndex == 2){
		if (txtid.text.length > 0){
			popular_telefone();
			ro_opertel.select(adm_opertelVO,createDataGrid);
		}
	}
}
private function createDataGrid(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_operador.selectedIndex == 0){
		dg_operador.dataProvider = e.result;
	} else if (accordion_operador.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_operador.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	}
}

private function inserir(e:Event):void{
	
	if (accordion_operador.selectedIndex == 0){
		isValid = util.validateForm(form_operadora);
		isValid = util.validateForm(form_operadorb) && isValid;
		isValid = util.validateForm(form_operadorc) && isValid;
		if (!isValid){
			mensagem_oper.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_operador();
			ro_operador.inserir(adm_operadorVO,inserirResult,defaultFaultHandler);
		}
    } else if (accordion_operador.selectedIndex == 1){
		isValid = util.validateForm(form_enderecoa);
		isValid = util.validateForm(form_enderecob) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_endereco();
			ro_operend.inserir(adm_operendVO,inserirResult);
		}
    } else if (accordion_operador.selectedIndex == 2){
		isValid = util.validateForm(form_telefonea);
		isValid = util.validateForm(form_telefoneb) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_telefone();
			ro_opertel.inserir(adm_opertelVO,inserirResult);
		}
    }
}
private function inserirResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_operador.selectedIndex == 0){
		txtid.text = e.result.toString();
	} else if (accordion_operador.selectedIndex == 1){
		txtid_end.text = e.result.toString();
	} else if (accordion_operador.selectedIndex == 2){
		txtid_tel.text = e.result.toString();
	}
		selecionar(e);
	
}
private function alterar(e:Event):void{
	if (accordion_operador.selectedIndex == 0){
		var teste:Boolean = testesenha();
			if (teste == true){
				isValid = util.validateForm(form_operadora);
				isValid = util.validateForm(form_operadorb) && isValid;
				isValid = util.validateForm(form_operadorc) && isValid;
				if (!isValid){
					mensagem_oper.text = UtilMensagens.PreenchaCampo;
				} else {
					this.enabled = false;
					popular_operador();
					ro_operador.atualizar(adm_operadorVO,alterarResult,defaultFaultHandler);
				}
            }
     } else if (accordion_operador.selectedIndex == 1){
		 isValid = util.validateForm(form_enderecoa);
		 isValid = util.validateForm(form_enderecob) && isValid;
		 if (!isValid){
			 mensagem_end.text = UtilMensagens.PreenchaCampo;
		 } else {
			 this.enabled = false;
			 popular_endereco();
			 ro_operend.atualizar(adm_operendVO,alterarResult);
		 }
     } else if (accordion_operador.selectedIndex == 2){
		 isValid = util.validateForm(form_telefonea);
		 isValid = util.validateForm(form_telefoneb) && isValid;
		 if (!isValid){
			 mensagem_tel.text = UtilMensagens.PreenchaCampo;
		 } else {
			 this.enabled = false;
			 popular_telefone();
			 ro_opertel.atualizar(adm_opertelVO,alterarResult);
		 }
     }
                	
}
private function alterarResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_operador.selectedIndex == 0){
		dg_operador.dataProvider = e.result;
	} else if (accordion_operador.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_operador.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	}
}
private function deletar(e:Event):void{
	if (accordion_operador.selectedIndex == 0){
		isValid = util.validateForm(form_operadora);
		isValid = util.validateForm(form_operadorb) && isValid;
		isValid = util.validateForm(form_operadorc) && isValid;
		if (!isValid){
			mensagem_oper.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_operador();
			ro_operador.deletar(adm_operadorVO,deletarResult,defaultFaultHandler);
         }
     } else if (accordion_operador.selectedIndex == 1){
          if (txtid_end.text.length > 0){
			  this.enabled = false;
			popular_endereco();
			ro_operend.deletar(adm_operendVO,deletarResult);
          }
     } else if (accordion_operador.selectedIndex == 2){
          if (txtid_tel.text.length > 0){
			  this.enabled = false;
			popular_telefone();
			ro_opertel.deletar(adm_opertelVO,deletarResult);
          }
      }
}
private function deletarResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_operador.selectedIndex == 0){
		dg_operador.dataProvider = e.result;
	} else if (accordion_operador.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_operador.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	}
	limpar(e);
}
private function popular_operador():void{
	adm_operadorVO = new Adm_operadorVO();
	adm_operadorVO.id_operador = txtid.text.length <= 0 ? null : parseInt(txtid.text);
	adm_operadorVO.nickname = txtnickname.text.length <= 0 ? null : txtnickname.text;
	adm_operadorVO.senha = txtsenha.text.length > 0 ? txtsenha.text : null;
//	adm_operadorVO.dt_admissao = txtdtadmissao.selectedDate ? txtdtadmissao.selectedDate : null;
//	adm_operadorVO.dt_demissao = txtdtdemissao.selectedDate ? txtdtdemissao.selectedDate : null;
	adm_operadorVO.dt_nascimento = txtdtnascimento.selectedDate ? txtdtnascimento.selectedDate : null;
	adm_operadorVO.nmoperador = txtnome.text.length <= 0 ? null : txtnome.text.toUpperCase();
	adm_operadorVO.obs = txtobs.text.length <= 0 ? null : txtobs.text.toUpperCase();
	//adm_operadorVO.rg = txtrg.text.length <= 0 ? null : txtrg.text;
	//adm_operadorVO.salario = txtsalario.text.length > 0 ? txtsalario.text : null;
	//adm_operadorVO.cpf = txtcpf.text.length <= 0 ? null : txtcpf.text;
	adm_operadorVO.id_cargo = cbcargo.selectedItem ? cbcargo.selectedItem.data : null;
	adm_operadorVO.id_ativo = cbativo.selectedItem ? cbativo.selectedItem.data : null;
	adm_operadorVO.id_empresa = cbempresa.selectedItem ? cbempresa.selectedItem.data : null;
	adm_operadorVO.email = txtemail.text.length <= 0 ? null : txtemail.text.toUpperCase();
	adm_operadorVO.dt_acesso = dg_operador.selectedItem ? dg_operador.selectedItem.dt_acesso : null;

	
}
private function popular_endereco():void{
	adm_operendVO = new Adm_operendVO();
	adm_operendVO.id_operend = txtid_end.text.length <= 0 ? null : txtid_end.text;
	adm_operendVO.endereco = txtendereco_end.text.length <= 0 ? null : txtendereco_end.text.toUpperCase();
	adm_operendVO.complemento = txtcomplemento_end.text.length <= 0 ? null : txtcomplemento_end.text.toUpperCase();
	adm_operendVO.bairro = txtbairro_end.text.length <= 0 ? null : txtbairro_end.text.toUpperCase();
	adm_operendVO.cep = txtcep_end.text.length <= 0 ? null : txtcep_end.text.toUpperCase();
	adm_operendVO.cidade = txtcidade_end.text.length <= 0 ? null : txtcidade_end.text.toUpperCase();
	adm_operendVO.id_estado = cbuf_end.selectedItem ? cbuf_end.selectedItem.data : null;
	adm_operendVO.id_operador = parseInt(txtid.text);
	
	
}
private function popular_telefone():void{
	adm_opertelVO = new Adm_opertelVO();
	adm_opertelVO.id_opertel = txtid_tel.text.length <= 0 ? null : txtid_tel.text;
	adm_opertelVO.descricao = txtdescricao_tel.text.length <= 0 ? null : txtdescricao_tel.text.toUpperCase();
	adm_opertelVO.numero = txtnumero_tel.text.length <= 0 ? null : txtnumero_tel.text;
	adm_opertelVO.ddd = txtddd_tel.text.length <= 0 ? null : txtddd_tel.text;
	adm_opertelVO.id_operador = parseInt(txtid.text);
	adm_opertelVO.id_tipotel = cbtipotel.selectedItem ? cbtipotel.selectedItem.data : null;
}

private function limpar(e:Event):void{
    if (accordion_operador.selectedIndex == 0){
		util.limpar_formulario(form_operadora);
		util.limpar_formulario(form_operadorb);
		util.limpar_formulario(form_operadorc);
		util.limpar_formulario(form_enderecoa);
		util.limpar_formulario(form_enderecob);
		util.limpar_formulario(form_telefonea);
		util.limpar_formulario(form_telefoneb);
        dg_operador.dataProvider = null
        dg_endereco.dataProvider = null;
        dg_telefone.dataProvider = null;
		mensagem_oper.text = "";
    } else if (accordion_operador.selectedIndex == 1){
		util.limpar_formulario(form_enderecoa);
		util.limpar_formulario(form_enderecob);
		dg_endereco.dataProvider = null;
		mensagem_end.text = "";
    } else if (accordion_operador.selectedIndex == 2){
		util.limpar_formulario(form_telefonea);
		util.limpar_formulario(form_telefoneb);
		dg_telefone.dataProvider = null;
		mensagem_tel.text = "";
    }
}
private function setcampos(e:Event):void{
	if (accordion_operador.selectedIndex == 0){
		//txtsalario.text = dg_operador.selectedItem.salario;
		//txtdtdemissao.selectedDate = dg_operador.selectedItem.dt_demissao ? dg_operador.selectedItem.dt_demissao : null;
		//txtdtadmissao.selectedDate = dg_operador.selectedItem.dt_admissao ? dg_operador.selectedItem.dt_admissao : null;
		cbcargo.selectedItem = util.selecionarCombobox(dg_operador.selectedItem.id_cargo, ArrayCargo);
		txtnome.text = dg_operador.selectedItem.nmoperador;
		//txtrg.text = dg_operador.selectedItem.rg;
		txtobs.text = dg_operador.selectedItem.obs;
		txtdtnascimento.selectedDate = dg_operador.selectedItem.dt_nascimento ? dg_operador.selectedItem.dt_nascimento : null;
		txtredigite.text = dg_operador.selectedItem.senha;
		txtsenha.text = dg_operador.selectedItem.senha;
		txtnickname.text = dg_operador.selectedItem.nickname;
		//txtcpf.text = dg_operador.selectedItem.cpf;
		txtid.text = dg_operador.selectedItem.id_operador;
		cbativo.selectedItem = util.selecionarCombobox(dg_operador.selectedItem.id_ativo,ArrayAtivo);
		cbempresa.selectedItem = util.selecionarCombobox(dg_operador.selectedItem.id_empresa,ArrayEmpresa);
		txtemail.text = dg_operador.selectedItem.email;
						
	} else if (accordion_operador.selectedIndex == 1){
		txtcomplemento_end.text = dg_endereco.selectedItem.complemento;
		txtcidade_end.text = dg_endereco.selectedItem.cidade;
		txtbairro_end.text = dg_endereco.selectedItem.bairro;
		txtid_end.text = dg_endereco.selectedItem.id_operend;
		cbuf_end.selectedItem = util.selecionarCombobox(dg_endereco.selectedItem.id_estado,ArrayEstado);
		txtcep_end.text = dg_endereco.selectedItem.cep;
		txtendereco_end.text = dg_endereco.selectedItem.endereco;
						
	} else if (accordion_operador.selectedIndex == 2){
		txtdescricao_tel.text = dg_telefone.selectedItem.descricao;
		txtnumero_tel.text = dg_telefone.selectedItem.numero;
		txtid_tel.text = dg_telefone.selectedItem.id_opertel;
		txtddd_tel.text = dg_telefone.selectedItem.ddd;
		cbtipotel.selectedItem = util.selecionarCombobox(dg_telefone.selectedItem.id_tipotel,ArrayTipoTel);
	}
	
}
private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
	
	if (accordion_operador.selectedIndex == 0){
		mensagem_oper.text = "";
	} else if (accordion_operador.selectedIndex == 1){
		mensagem_end.text = "";
	} else if (accordion_operador.selectedIndex == 2){
		mensagem_tel.text = "";
	}
	
}
