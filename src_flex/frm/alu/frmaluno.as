// ActionScript file
import classes.*;

import flash.events.Event;
import flash.events.FocusEvent;
import flash.events.MouseEvent;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.controls.Button;
import mx.controls.TextInput;
import mx.controls.dataGridClasses.DataGridColumn;
import mx.core.Application;
import mx.core.FlexGlobals;
import mx.events.CloseEvent;
import mx.events.DataGridEvent;
import mx.events.IndexChangedEvent;
import mx.events.ListEvent;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.validators.Validator;

import service.ComboBoxService;
import service.adm.Adm_CidadeService;
import service.adm.Adm_RacaCorService;
import service.adm.Adm_SexoService;
import service.alu.Alu_AlunoEndService;
import service.alu.Alu_AlunoService;
import service.alu.Alu_AlunoTelService;
import service.alu.Alu_DeficienciaService;
import service.alu.Alu_ExpAlunoRespService;

import vo.adm.Adm_RacaCorVO;
import vo.alu.Alu_AlunoEndVO;
import vo.alu.Alu_AlunoTelVO;
import vo.alu.Alu_AlunoVO;
import vo.alu.Alu_DeficienciaVO;
import vo.procedure.Alu_ExpAlunoRespVO;

[Bindable] private var ArrayEstado:ArrayCollection;
[Bindable] private var ArrayTipoTel:ArrayCollection;
[Bindable] private var ArrayTipoEnd:ArrayCollection;
[Bindable] private var ArraySexo:ArrayCollection;
[Bindable] private var ArrayRacaCor:ArrayCollection;
[Bindable] private var ArrayEstadoCivil:ArrayCollection;
[Bindable] private var ArrayDeficiencia:ArrayCollection;
[Bindable] private var ArrayNacionalidade:ArrayCollection;
[Bindable] private var ArrayCidade:ArrayCollection;
[Bindable] private var ArrayTodasCidades:ArrayCollection;

[Bindable] private var isValid:Boolean = false;
private var util:Util = new Util();
private var retorno:UtilRetornoBanco;
private var ro_combobox:ComboBoxService = ComboBoxService.getInstance();

private var ro_aluno:Alu_AlunoService = Alu_AlunoService.getInstance();
private var ro_expalunoresp:Alu_ExpAlunoRespService = Alu_ExpAlunoRespService.getInstance();
private var ro_alunoend:Alu_AlunoEndService = Alu_AlunoEndService.getInstance();
private var ro_alunotel:Alu_AlunoTelService = Alu_AlunoTelService.getInstance();
private var ro_deficiencia:Alu_DeficienciaService = Alu_DeficienciaService.getInstance();
private var ro_cidade:Adm_CidadeService = Adm_CidadeService.getInstance();
private var ro_sexo:Adm_SexoService = Adm_SexoService.getInstance();
private var ro_racacor:Adm_RacaCorService = Adm_RacaCorService.getInstance();

private var alu_alunoVO:Alu_AlunoVO;
private var alu_exprespVO:Alu_ExpAlunoRespVO;
private var alu_alunoendVO:Alu_AlunoEndVO;
private var alu_alunotelVO:Alu_AlunoTelVO;
private var alu_deficienciaVO:Alu_DeficienciaVO;
private var adm_racacorVO:Adm_RacaCorVO;
            
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
protected function lf_deficiencia(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.cddeficiencia,ArrayDeficiencia);
	return retorno.label;
}
protected function lf_racacor(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_racacor,ArrayRacaCor);
	return retorno.label;
}
private function init():void{
	
	
	this.width = FlexGlobals.topLevelApplication.mdiCanvas.width;
	this.height = FlexGlobals.topLevelApplication.mdiCanvas.height;
	
	this.x = 0;
	this.y = 0;
	
	
	ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
	ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
	ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
	ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
	ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
	ctrlbar.addChildAt(ctrlbar.bt_executar,5);
	ctrlbar.bt_executar.label = "Exporta Aluno";
	
	
	ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
	ctrlbar.bt_inserir.addEventListener(MouseEvent.CLICK,inserir);
	ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,alterar);
	ctrlbar.bt_excluir.addEventListener(MouseEvent.CLICK,deletar);
	ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
	ctrlbar.bt_executar.addEventListener(MouseEvent.CLICK,expaluno_resp);
	
	txtcpf.addEventListener(FocusEvent.FOCUS_OUT,localizaCPF);
	
	cbuf_aluno.addEventListener(ListEvent.CHANGE,cbufAlunoChange);
	
	
	ro_combobox.Adm_EstadoCivil(createcomboxestadocivil,defaultFaultHandler);
	ro_combobox.Adm_Nacionalidade(createcomboxnacionalidade,defaultFaultHandler);
	ro_combobox.Adm_Estado(createcomboxestado,defaultFaultHandler);
	
	ro_sexo.ComboBox("nmsexo","id_sexo",createcomboxsexo,defaultFaultHandler);
	ro_cidade.ComboBox("nmcidade","id_cidade",cbTodasCidades,defaultFaultHandler);
	ro_racacor.ComboBox("nmracacor","id_racacor",createcomboxracacor,defaultFaultHandler);
}

private function localizaCPF(e:Event):void{
	if(txtcpf.text.length == 14){
		alu_alunoVO = new Alu_AlunoVO();
		alu_alunoVO.cpf = txtcpf.text;
		
		ro_aluno.select(alu_alunoVO,localizaCPFResult,defaultFaultHandler,null,null);
	}
	
}
private function localizaCPFResult(e:ResultEvent):void{
	if(int(e.result[0]['id_aluno']) > 0){
		Alert.yesLabel='Sim';
		Alert.noLabel='Não';
		Alert.show('C.P.F. Já cadastrado deseja consultar ?','C.P.F. Já Cadastrado',Alert.YES|Alert.NO,this,confirmLocaliza(int(e.result[0]['id_aluno'])));
	}
}
private function confirmLocaliza(id_aluno:int):Function{
	return function(e:CloseEvent):void{
		if (e.detail == Alert.YES){
			limpar(e);
			
			alu_alunoVO = new Alu_AlunoVO();
			alu_alunoVO.id_aluno = id_aluno;
			
			ro_aluno.select(alu_alunoVO,createDataGrid,defaultFaultHandler,null,null);
		}
	}
}
private function cbTodasCidades(event:ResultEvent):void{
	ArrayTodasCidades = event.result as ArrayCollection;
	cbnaturalidade.dataProvider = ArrayTodasCidades;
}
private function cbufAlunoChange(e:Event):void{
	if(cbuf_aluno.selectedIndex == 0){
		cbnaturalidade.dataProvider = null;		
	} else {
		ro_combobox.Adm_Cidade(cbuf_aluno.selectedItem.data,AdmCidadeResult,defaultFaultHandler);
	}
}
private function AdmCidadeResult(e:ResultEvent):void{
	cbnaturalidade.dataProvider = e.result as ArrayCollection;
	ArrayCidade = e.result as ArrayCollection;
}
private function accordioncomplete(e:IndexChangedEvent):void{
   	var currentIndex:int=e.newIndex;
    	if (currentIndex == 0){
			c_endereco.label = 'Endereço(s)';
			c_telefone.label = 'Telefone(s)';
			c_deficiencia.label = 'Deficiência(s) / Habilidade(s)';
			ctrlbar.removeAllChildren();
			ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
			ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
			ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
			ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
			ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
			ctrlbar.addChildAt(ctrlbar.bt_executar,5);

		} else if (currentIndex == 1){
//			ro_combobox.Adm_Estado(createcomboxestado,defaultFaultHandler);
			ro_combobox.Adm_TipoEnd(createcomboboxtipoend,defaultFaultHandler);
			if(txtid.text.length > 0){
	       		selecionar(e);
			}
			limpar(e);
			if (txtnome.text.length > 0) 
			{
				c_endereco.label = 'Endereço(s) - ' + c_aluno.label + " ( " + txtnome.text + " )";
			}
			ctrlbar.removeAllChildren();
			ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
			ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
			ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
			ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
			ctrlbar.addChildAt(ctrlbar.bt_limpar,4);

		} else if (currentIndex == 2){
			ro_combobox.Adm_TipoTel(createcomboxtipotel,defaultFaultHandler);
			if(txtid.text.length > 0){
				selecionar(e);
			}
			limpar(e);
			if (txtnome.text.length > 0) 
			{
				c_telefone.label = 'Telefone(s) - ' + c_aluno.label + " ( " + txtnome.text + " )";
			}
			ctrlbar.removeAllChildren();
			ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
			ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
			ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
			ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
			ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
		} else if (currentIndex == 3){
			ro_combobox.Adm_Deficiencia(createcomboxdeficiencia,defaultFaultHandler);
			if(txtid.text.length > 0){
				selecionar(e);
			}
			limpar(e);
			if (txtnome.text.length > 0) 
			{
				c_deficiencia.label = 'Deficiência(s) / Habilidade(s) - ' + c_aluno.label + " ( " + txtnome.text + " )";
			}
			ctrlbar.removeAllChildren();
			ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
			ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
			ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
			ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
			ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
		}
}
private function createcomboxestado(event:ResultEvent):void{
	ArrayEstado = event.result as ArrayCollection;
	cbuf_end.dataProvider = ArrayEstado;
	cbuf_aluno.dataProvider = ArrayEstado;
}
private function createcomboboxtipoend(event:ResultEvent):void{
	ArrayTipoEnd = event.result as ArrayCollection;
	cb_tipoend.dataProvider = ArrayTipoEnd;
}
private function createcomboxestadocivil(event:ResultEvent):void{
	ArrayEstadoCivil = event.result as ArrayCollection;
	cbestadocivil.dataProvider = ArrayEstadoCivil;
}
private function createcomboxtipotel(event:ResultEvent):void{
	ArrayTipoTel = event.result as ArrayCollection;
	cbtipotel.dataProvider = ArrayTipoTel;
}
private function createcomboxsexo(event:ResultEvent):void{
	cbsexo.dataProvider = event.result as ArrayCollection;
	ArraySexo = event.result as ArrayCollection;
}
private function createcomboxracacor(event:ResultEvent):void{
	cbracacor.dataProvider = event.result as ArrayCollection;
	ArrayRacaCor = event.result as ArrayCollection;
}
private function createcomboxdeficiencia(event:ResultEvent):void{
	cbdeficiencia.dataProvider = event.result as ArrayCollection;
	ArrayDeficiencia = event.result as ArrayCollection;
}
private function createcomboxnacionalidade(event:ResultEvent):void{
	cbnacionalidade.dataProvider = event.result as ArrayCollection;
	ArrayNacionalidade = event.result as ArrayCollection;
}

private function createDataGrid(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_aluno.selectedIndex == 0){
		dg_aluno.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 1 ){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 3){
		dg_deficiencia.dataProvider = e.result;
	}
}

private function selecionar(e:Event):void{
	this.enabled = false;
	if (accordion_aluno.selectedIndex == 0){
		popular_aluno();
		ro_aluno.select(alu_alunoVO,createDataGrid,defaultFaultHandler,null,null);
	} else if (accordion_aluno.selectedIndex == 1){
		if (txtid.text.length > 0){
			popular_endereco();
			ro_alunoend.select(alu_alunoendVO,createDataGrid,defaultFaultHandler);
		}	
	} else if (accordion_aluno.selectedIndex == 2){
		if (txtid.text.length > 0){
			popular_telefone();
			ro_alunotel.select(alu_alunotelVO,createDataGrid,defaultFaultHandler);
		}
	} else if (accordion_aluno.selectedIndex == 3){
		if (txtid.text.length > 0){
			alu_deficienciaVO = new Alu_DeficienciaVO();
			alu_deficienciaVO.id_aluno = parseInt(txtid.text);
			ro_deficiencia.select(alu_deficienciaVO,createDataGrid,defaultFaultHandler);
		}
	}
}
private function inserir(e:Event):void{
	if (accordion_aluno.selectedIndex == 0){
		isValid = util.validateForm(form_alunoa);
		isValid = util.validateForm(form_alunob) && isValid;
		isValid = util.validateForm(form_alunoc) && isValid;
		if (!isValid){
			mensagem_aluno.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_aluno();
			alu_alunoVO.dt_nascimento = txtdtnascimento.selectedDate ? txtdtnascimento.selectedDate : null;
			ro_aluno.inserir(alu_alunoVO,inserirResult,defaultFaultHandler);
		}
	} else if (accordion_aluno.selectedIndex == 1){
		isValid = util.validateForm(form_enderecoa);
		isValid = util.validateForm(form_enderecob) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_endereco();
			ro_alunoend.inserir(alu_alunoendVO,inserirResult,defaultFaultHandler);
		}
	} else if (accordion_aluno.selectedIndex == 2){
		isValid = util.validateForm(form_telefonea);
		isValid = util.validateForm(form_telefoneb) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			popular_telefone();
			ro_alunotel.inserir(alu_alunotelVO,inserirResult,defaultFaultHandler);
		}
	} else if (accordion_aluno.selectedIndex == 3){
		isValid = util.validateForm(form_deficiencia);
		if (!isValid){
			mensagem_def.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
//			popular_deficiencia();
			alu_deficienciaVO = new Alu_DeficienciaVO();
			alu_deficienciaVO.id_aluno = parseInt(txtid.text);
			alu_deficienciaVO.cddeficiencia = cbdeficiencia.selectedItem ? cbdeficiencia.selectedItem.data : 0;
//			alu_deficienciaVO.id_deficiencia = dg_deficiencia.selectedItem.id_deficiencia;
			ro_deficiencia.inserir(alu_deficienciaVO,inserirResult,defaultFaultHandler);
		}
	}
}
private function inserirResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_aluno.selectedIndex == 0){
		txtid.text = e.result.toString();
   	} else if (accordion_aluno.selectedIndex == 1){
		txtid_end.text = e.result.toString();
   	} else if (accordion_aluno.selectedIndex == 2){
		txtid_tel.text = e.result.toString();
	} else if (accordion_aluno.selectedIndex == 3){
	}
	selecionar(e);
}

private function alterar(e:Event):void{
	if (accordion_aluno.selectedIndex == 0){
		isValid = util.validateForm(form_alunoa);
		isValid = util.validateForm(form_alunob) && isValid;
		isValid = util.validateForm(form_alunoc) && isValid;
		if (!isValid){
			mensagem_aluno.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular_aluno();
			alu_alunoVO.dt_nascimento = txtdtnascimento.selectedDate ? txtdtnascimento.selectedDate : null;

			ro_aluno.atualizar(alu_alunoVO,alterarResult,defaultFaultHandler);
		}
   	} else if (accordion_aluno.selectedIndex == 1){
		isValid = util.validateForm(form_enderecoa);
		isValid = util.validateForm(form_enderecob) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular_endereco();
			ro_alunoend.atualizar(alu_alunoendVO,alterarResult,defaultFaultHandler);
		}
   	} else if (accordion_aluno.selectedIndex == 2){
		isValid = util.validateForm(form_telefonea);
		isValid = util.validateForm(form_telefoneb) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular_telefone();
			ro_alunotel.atualizar(alu_alunotelVO,alterarResult,defaultFaultHandler);
		}
	} else if (accordion_aluno.selectedIndex == 3){
		isValid = util.validateForm(form_deficiencia);
		if (!isValid){
			mensagem_def.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			alu_deficienciaVO = new Alu_DeficienciaVO();
			alu_deficienciaVO.id_aluno = parseInt(txtid.text);
			alu_deficienciaVO.cddeficiencia = cbdeficiencia.selectedItem ? cbdeficiencia.selectedItem.data : 0;
			alu_deficienciaVO.id_deficiencia = dg_deficiencia.selectedItem.id_deficiencia;
			ro_deficiencia.atualizar(alu_deficienciaVO,alterarResult,defaultFaultHandler);
		}
	}
	
	
}
private function alterarResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_aluno.selectedIndex == 0){
		dg_aluno.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 2){
		dg_telefone.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 3){
		dg_deficiencia.dataProvider = e.result;
	}
}
private function deletar(e:Event):void{
	if (accordion_aluno.selectedIndex == 0){
		isValid = util.validateForm(form_alunoa);
		isValid = util.validateForm(form_alunob) && isValid;
		isValid = util.validateForm(form_alunoc) && isValid;
		if (!isValid){
			mensagem_aluno.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular_aluno();
			ro_aluno.deletar(alu_alunoVO,deletarResult,defaultFaultHandler);
		}
  	} else if (accordion_aluno.selectedIndex == 1){
		isValid = util.validateForm(form_enderecoa);
		isValid = util.validateForm(form_enderecob) && isValid;
		if (!isValid){
			mensagem_end.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular_endereco();
			ro_alunoend.deletar(alu_alunoendVO,deletarResult,defaultFaultHandler);
		}
   	} else if (accordion_aluno.selectedIndex == 2){
		isValid = util.validateForm(form_telefonea);
		isValid = util.validateForm(form_telefoneb) && isValid;
		if (!isValid){
			mensagem_tel.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular_telefone();
			ro_alunotel.deletar(alu_alunotelVO,deletarResult,defaultFaultHandler);
		}
   	} else if (accordion_aluno.selectedIndex == 3){
		isValid = util.validateForm(form_deficiencia);
		if (!isValid){
			mensagem_def.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
//			popular_deficiencia()
			alu_deficienciaVO = new Alu_DeficienciaVO();
//			alu_deficienciaVO.id_aluno = parseInt(txtid.text);
//			alu_deficienciaVO.cddeficiencia = cbdeficiencia.selectedItem ? cbdeficiencia.selectedItem.data : 0;
			alu_deficienciaVO.id_deficiencia = dg_deficiencia.selectedItem.id_deficiencia;
			ro_deficiencia.deletar(alu_deficienciaVO,deletarResult,defaultFaultHandler);
		}
	}
}
private function deletarResult(e:ResultEvent):void{
	this.enabled = true;
	if (accordion_aluno.selectedIndex == 0){
		dg_aluno.dataProvider = e.result;
	} else if (accordion_aluno.selectedIndex == 1){
		dg_endereco.dataProvider = e.result;
		selecionar(e);
	} else if (accordion_aluno.selectedIndex == 2){
//		dg_telefone.dataProvider = e.result;
		selecionar(e);
	} else if (accordion_aluno.selectedIndex == 3){
		dg_deficiencia.dataProvider = e.result;
	}
	limpar(e);
}
private function limpar(e:Event):void{
	if (accordion_aluno.selectedIndex == 0){
		util.limpar_formulario(form_alunoa);
		util.limpar_formulario(form_alunob);
		util.limpar_formulario(form_alunoc);
		util.limpar_formulario(form_enderecoa);
		util.limpar_formulario(form_enderecob);
		util.limpar_formulario(form_telefonea);
		util.limpar_formulario(form_telefoneb);
		mensagem_aluno.text = "";
		mensagem_end.text = "";
		mensagem_tel.text = "";
		dg_aluno.dataProvider = null;
		dg_endereco.dataProvider = null;
		dg_telefone.dataProvider = null;
		cbnaturalidade.dataProvider = ArrayTodasCidades;
   	} else if (accordion_aluno.selectedIndex == 1){
		util.limpar_formulario(form_enderecoa);
		util.limpar_formulario(form_enderecob);
		mensagem_end.text = "";
		dg_endereco.dataProvider = null;
	} else if (accordion_aluno.selectedIndex == 2){
		util.limpar_formulario(form_telefonea);
		util.limpar_formulario(form_telefoneb);
		mensagem_tel.text = "";
		dg_telefone.dataProvider = null;
	} else if (accordion_aluno.selectedIndex == 3){
		util.limpar_formulario(form_deficiencia);
		mensagem_def.text = "";
		dg_deficiencia.dataProvider = null;
	}
}
private function expaluno_resp(e:Event):void{
	if (txtid.text.length > 0){
		alu_exprespVO = new Alu_ExpAlunoRespVO();
		alu_exprespVO.id_aluno =  txtid.text;
		
		ro_expalunoresp.Procedure(alu_exprespVO,Resultexpaluno_resp,defaultFaultHandler);
	}
}
private function Resultexpaluno_resp(e:ResultEvent):void{
	mensagem_aluno.text = UtilMensagens.OperacaoRealizadaSucesso + " Código do Responsável: " + String(e.result[0].toString());
}


private function popular_aluno():void{
	alu_alunoVO = new Alu_AlunoVO();
	alu_alunoVO.id_aluno = txtid.text.length > 0 ? txtid.text : null;
	alu_alunoVO.nome = txtnome.text.length > 0 ? txtnome.text.toUpperCase() : null;
	alu_alunoVO.cpf = txtcpf.text.length > 0 ? txtcpf.text : null;
	alu_alunoVO.rg = txtrg.text.length > 0 ? txtrg.text.toUpperCase() : null;
	alu_alunoVO.id_sexo = cbsexo.selectedItem ? cbsexo.selectedItem.data : null;
	alu_alunoVO.id_estadocivil = cbestadocivil.selectedItem ? cbestadocivil.selectedItem.data : null;
	alu_alunoVO.profissao = txtprofissao.text.length > 0 ? txtprofissao.text.toUpperCase() : null;
	alu_alunoVO.email = txtemail.text.length > 0 ? txtemail.text.toUpperCase() : null;
	alu_alunoVO.local_trabalho = txtlocaltrabalho.text.length > 0 ? txtlocaltrabalho.text.toUpperCase() : null;
	alu_alunoVO.nome_pai = txtnome_pai.text.length > 0 ? txtnome_pai.text.toUpperCase() : null;
	alu_alunoVO.nome_mae = txtnome_mae.text.length > 0 ? txtnome_mae.text.toUpperCase() : null;
	alu_alunoVO.id_nacionalidade = cbnacionalidade.selectedItem ? cbnacionalidade.selectedItem.data : null;
	alu_alunoVO.id_cidade = cbnaturalidade.selectedItem ? cbnaturalidade.selectedItem.data : null;
	alu_alunoVO.id_racacor = cbracacor.selectedItem ? cbracacor.selectedItem.data : null;
}
private function popular_endereco():void{
	alu_alunoendVO = new Alu_AlunoEndVO();
	alu_alunoendVO.id_alunoend = txtid_end.text.length <= 0 ? null : txtid_end.text;
	alu_alunoendVO.endereco = txtendereco_end.text.length <= 0 ? null : txtendereco_end.text.toUpperCase();
	alu_alunoendVO.complemento = txtcomplemento_end.text.length <= 0 ? null : txtcomplemento_end.text.toUpperCase();
	alu_alunoendVO.bairro = txtbairro_end.text.length <= 0 ? null : txtbairro_end.text.toUpperCase();
	alu_alunoendVO.cep = txtcep_end.text.length <= 0 ? null : txtcep_end.text;
	alu_alunoendVO.cidade = txtcidade_end.text.length <= 0 ? null : txtcidade_end.text.toUpperCase();
	alu_alunoendVO.id_estado = cbuf_end.selectedItem ? cbuf_end.selectedItem.data : null;
	alu_alunoendVO.id_aluno = parseInt(txtid.text);
	alu_alunoendVO.id_tipoend = cb_tipoend.selectedItem ? cb_tipoend.selectedItem.data : null;
	alu_alunoendVO.numero = txtnumero_end.text.length <= 0 ? null : txtnumero_end.text.toUpperCase();
}
private function popular_telefone():void{
	alu_alunotelVO = new Alu_AlunoTelVO();
	alu_alunotelVO.id_alunotel = txtid_tel.text.length <= 0 ? null : txtid_tel.text;
	alu_alunotelVO.descricao = txtdescricao_tel.text.length <= 0 ? null : txtdescricao_tel.text.toUpperCase();
	alu_alunotelVO.ddd = txtddd_tel.text.length <= 0 ? null : txtddd_tel.text;
	alu_alunotelVO.numero = txtnumero_tel.text.length <= 0 ? null : txtnumero_tel.text;
	alu_alunotelVO.id_aluno = parseInt(txtid.text);
	alu_alunotelVO.id_tipotel = cbtipotel.selectedItem ? cbtipotel.selectedItem.data : null;
}
private function popular_deficiencia():void{
	alu_deficienciaVO = new Alu_DeficienciaVO();
	
	alu_deficienciaVO.id_deficiencia = dg_deficiencia.selectedItem.id_deficiencia ? dg_deficiencia.selectedItem.id_deficiencia : 0;
	alu_deficienciaVO.cddeficiencia = cbdeficiencia.selectedItem ? cbdeficiencia.selectedItem.data : null;
	alu_deficienciaVO.id_aluno = parseInt(txtid.text);
}
private function setcampos(e:Event):void{
	if (accordion_aluno.selectedIndex == 0){
		txtid.text = dg_aluno.selectedItem.id_aluno;
		txtnome.text = dg_aluno.selectedItem.nome;
		txtcpf.text = dg_aluno.selectedItem.cpf;
		txtrg.text = dg_aluno.selectedItem.rg;
		txtdtnascimento.selectedDate = dg_aluno.selectedItem.dt_nascimento ? dg_aluno.selectedItem.dt_nascimento : null;
		cbsexo.selectedItem = dg_aluno.selectedItem.id_sexo ? util.selecionarCombobox(dg_aluno.selectedItem.id_sexo,ArraySexo) : cbsexo.selectedIndex = 0;
		cbestadocivil.selectedItem = dg_aluno.selectedItem.id_estadocivil ? util.selecionarCombobox(dg_aluno.selectedItem.id_estadocivil,ArrayEstadoCivil) : cbestadocivil.selectedIndex = 0;
		txtprofissao.text = dg_aluno.selectedItem.profissao;
		txtemail.text = dg_aluno.selectedItem.email;
		txtlocaltrabalho.text = dg_aluno.selectedItem.local_trabalho;
		txtnome_pai.text = dg_aluno.selectedItem.nome_pai;
		txtnome_mae.text = dg_aluno.selectedItem.nome_mae;
		cbnacionalidade.selectedItem = dg_aluno.selectedItem.id_nacionalidade ? util.selecionarCombobox(dg_aluno.selectedItem.id_nacionalidade,ArrayNacionalidade) : cbnacionalidade.selectedIndex = 0;
		cbnaturalidade.dataProvider = ArrayTodasCidades;
		cbnaturalidade.selectedItem = dg_aluno.selectedItem.id_cidade ? util.selecionarCombobox(dg_aluno.selectedItem.id_cidade,ArrayTodasCidades) : cbnaturalidade.selectedIndex = 0;
		cbracacor.selectedItem = dg_aluno.selectedItem.id_racacor ? util.selecionarCombobox(dg_aluno.selectedItem.id_racacor,ArrayRacaCor) : cbracacor.selectedIndex = 0;
		
	}else if (accordion_aluno.selectedIndex == 1 ){
		
		txtid_end.text = dg_endereco.selectedItem.id_alunoend;
		txtendereco_end.text = dg_endereco.selectedItem.endereco;
		txtcep_end.text = dg_endereco.selectedItem.cep;
		cbuf_end.selectedItem = util.selecionarCombobox(dg_endereco.selectedItem.id_estado,ArrayEstado);
		txtbairro_end.text = dg_endereco.selectedItem.bairro;
		txtcidade_end.text = dg_endereco.selectedItem.cidade;
		txtcomplemento_end.text = dg_endereco.selectedItem.complemento;
		txtnumero_end.text = dg_endereco.selectedItem.numero;
		cb_tipoend.selectedItem = dg_endereco.selectedItem.id_tipoend ? util.selecionarCombobox(dg_endereco.selectedItem.id_tipoend,ArrayTipoEnd) : cb_tipoend.selectedIndex = 0;
		
	} else if (accordion_aluno.selectedIndex == 2){
		txtdescricao_tel.text = dg_telefone.selectedItem.descricao;
		txtddd_tel.text = dg_telefone.selectedItem.ddd;
		txtnumero_tel.text = dg_telefone.selectedItem.numero;
		txtid_tel.text = dg_telefone.selectedItem.id_alunotel;
		cbtipotel.selectedItem = dg_telefone.selectedItem.id_tipotel ? util.selecionarCombobox(dg_telefone.selectedItem.id_tipotel,ArrayTipoTel) : cbtipotel.selectedIndex = 0;
	} else if (accordion_aluno.selectedIndex == 3){
		cbdeficiencia.selectedItem = dg_deficiencia.selectedItem.id_deficiencia? util.selecionarCombobox(dg_deficiencia.selectedItem.cddeficiencia,ArrayDeficiencia) : dg_deficiencia.selectedIndex = 0;
	}
}
private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
	
	if (accordion_aluno.selectedIndex == 0){
		mensagem_aluno.text = "";
	} else if (accordion_aluno.selectedIndex == 1){
		mensagem_end.text = "";
	} else if (accordion_aluno.selectedIndex == 2){
		mensagem_tel.text = "";
	}
	
}
