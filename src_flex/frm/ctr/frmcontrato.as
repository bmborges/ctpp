// ActionScript file
				
import classes.*;

import flash.events.Event;
import flash.events.MouseEvent;
import flash.net.URLRequest;
import flash.net.URLRequestMethod;
import flash.net.URLVariables;
import flash.net.navigateToURL;

import frm.ctr.frm_statuscontrato;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.controls.Button;
import mx.controls.dataGridClasses.DataGridColumn;
import mx.core.FlexGlobals;
import mx.events.CloseEvent;
import mx.events.FlexEvent;
import mx.events.IndexChangedEvent;
import mx.events.ListEvent;
import mx.events.StateChangeEvent;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.validators.Validator;

import service.adm.Adm_OperadorService;
import service.alu.Alu_AlunoService;
import service.alu.Alu_RespService;
import service.cnt.Cnt_MidiaService;
import service.crs.Crs_CursoService;
import service.crs.Crs_MateriaService;
import service.crs.Crs_ModuloService;
import service.crs.Crs_TurmaService;
import service.ctr.Ctr_ContrColabService;
import service.ctr.Ctr_ContrDocService;
import service.ctr.Ctr_ContrMidiaService;
import service.ctr.Ctr_ContratoService;
import service.ctr.Ctr_DocumentacaoService;
import service.ctr.Ctr_HistoricoService;
import service.ctr.Ctr_MotivoHistoricoService;
import service.ctr.Ctr_StatusService;
import service.ctr.Ctr_TipoHistoricoService;
import service.ctr.Ctr_TurmaMateriaService;
import service.fin.Fin_DuplicataService;
import service.fin.Fin_FormaPgtService;
import service.fin.Fin_TabValoresService;
import service.fin.Fin_TipoRecService;
import service.procedure.Fin_Ajuste_OrdemDupService;
import service.view.View_Ctr_DuplicataService;
import service.view.View_Ctr_TurmaMateriaService;

import vo.adm.SystemVO;
import vo.alu.Alu_AlunoVO;
import vo.alu.Alu_RespVO;
import vo.cnt.Cnt_MidiaVO;
import vo.ctr.Ctr_ContrColabVO;
import vo.ctr.Ctr_ContrDocVO;
import vo.ctr.Ctr_ContrMidiaVO;
import vo.ctr.Ctr_ContratoVO;
import vo.ctr.Ctr_DocumentacaoVO;
import vo.ctr.Ctr_HistoricoVO;
import vo.ctr.Ctr_MotivoHistoricoVO;
import vo.ctr.Ctr_TipoHistoricoVO;
import vo.ctr.Ctr_TurmaMateriaVO;
import vo.fin.Fin_DuplicataVO;
import vo.procedure.Fin_Ajuste_OrdemDupVO;
import vo.view.View_Ctr_DuplicataVO;
import vo.view.View_Ctr_TurmaMateriaVO;

private var systemVO:SystemVO = SystemVO.getInstance();
private var ctr_contratoVO:Ctr_ContratoVO;
private var fin_duplicataVO:Fin_DuplicataVO;
private var alu_alunoVO:Alu_AlunoVO;
private var fin_ajusteordemVO:Fin_Ajuste_OrdemDupVO;
private var alu_respVO:Alu_RespVO;
private var ctr_contrdocVO:Ctr_ContrDocVO;
private var ctr_documentacaoVO:Ctr_DocumentacaoVO;
private var ctr_historicoVO:Ctr_HistoricoVO;
private var ctr_tipohistoricoVO:Ctr_TipoHistoricoVO;
private var ctr_motivohistoricoVO:Ctr_MotivoHistoricoVO;
private var ctr_contcolad:Ctr_ContrColabVO
private var cnt_midiaVO:Cnt_MidiaVO;
private var ctr_contrmidiaVO:Ctr_ContrMidiaVO;
private var view_ctrduplicataVO:View_Ctr_DuplicataVO;
private var view_ctrturmamateriaVO:View_Ctr_TurmaMateriaVO;
private var ctr_turmamateriaVO:Ctr_TurmaMateriaVO;

private var ro_operador:Adm_OperadorService = Adm_OperadorService.getInstance();
private var ro_aluno:Alu_AlunoService = Alu_AlunoService.getInstance();
private var ro_resp:Alu_RespService = Alu_RespService.getInstance();
private var ro_duplicata:Fin_DuplicataService = Fin_DuplicataService.getInstance();
private var ro_ctrstatus:Ctr_StatusService = Ctr_StatusService.getInstance();
private var ro_contrato:Ctr_ContratoService = Ctr_ContratoService.getInstance();
private var ro_tiporec:Fin_TipoRecService = Fin_TipoRecService.getInstance();
private var ro_formapgt:Fin_FormaPgtService = Fin_FormaPgtService.getInstance();
private var ro_modulo:Crs_ModuloService = Crs_ModuloService.getInstance();
private var ro_finajusteordem:Fin_Ajuste_OrdemDupService = Fin_Ajuste_OrdemDupService.getInstance();
private var ro_curso:Crs_CursoService = Crs_CursoService.getInstance();
private var ro_contrdoc:Ctr_ContrDocService = Ctr_ContrDocService.getInstance();
private var ro_documentacao:Ctr_DocumentacaoService = Ctr_DocumentacaoService.getInstance();
private var ro_historico:Ctr_HistoricoService = Ctr_HistoricoService.getInstance();
private var ro_tipohistorico:Ctr_TipoHistoricoService = Ctr_TipoHistoricoService.getInstance();
private var ro_motivohistorico:Ctr_MotivoHistoricoService = Ctr_MotivoHistoricoService.getInstance();
private var ro_turma:Crs_TurmaService = Crs_TurmaService.getInstance();
private var ro_tabvalores:Fin_TabValoresService = Fin_TabValoresService.getInstance();
private var ro_contcolab:Ctr_ContrColabService = Ctr_ContrColabService.getInstance();
private var ro_midia:Cnt_MidiaService = Cnt_MidiaService.getInstance();
private var ro_contrmidia:Ctr_ContrMidiaService = Ctr_ContrMidiaService.getInstance();
private var ro_viewctrduplicata:View_Ctr_DuplicataService = View_Ctr_DuplicataService.getInstance();
private var ro_viewturmamateria:View_Ctr_TurmaMateriaService = View_Ctr_TurmaMateriaService.getInstance();
private var ro_materia:Crs_MateriaService = Crs_MateriaService.getInstance();
private var ro_ctrturmamateria:Ctr_TurmaMateriaService = Ctr_TurmaMateriaService.getInstance();


private var util:Util = new Util();
private var retorno:UtilRetornoBanco;
private var verticalScroll:Number;

[Bindable] private var ArrayTipoRec:ArrayCollection;
[Bindable] private var ArrayTipoPag:ArrayCollection;
[Bindable] private var ArrayCompAprov:ArrayCollection;
[Bindable] private var ArrayModulo:ArrayCollection;
[Bindable] private var ArrayMidia:ArrayCollection;
[Bindable] private var ArrayCtrStatus:ArrayCollection;
[Bindable] private var ArrayAluno:ArrayCollection;
[Bindable] private var ArrayOperador:ArrayCollection;
[Bindable] private var ArrayDocumentacao:ArrayCollection;
[Bindable] private var ArrayResp:ArrayCollection;
[Bindable] private var ArrayRespLegal:ArrayCollection;
[Bindable] private var ArrayCurso:ArrayCollection;
[Bindable] private var ArrayTurma:ArrayCollection;
[Bindable] private var ArrayTabValores:ArrayCollection;

[Bindable] private var isValid:Boolean = false;
[Bindable] private var iScrollPosition:Number;
[Bindable] private var ArrayContrato:ArrayCollection;
[Bindable] private var ArrayTipoHistorico:ArrayCollection;
[Bindable] private var ArrayMotivoHistorico:ArrayCollection;

private function addButtons():void{
	ctrlbar.removeAllChildren();
	ctrlbar.bt_alterar.label = "Alterar";
	if (tabnavigator_contrato.selectedIndex == 1){
		ctrlbar.addChildAt(ctrlbar.bt_alterar,0);
		ctrlbar.bt_alterar.label = "Gravar";
		ctrlbar.addChildAt(ctrlbar.bt_excluir,1);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,2);
		ctrlbar.addChildAt(ctrlbar.bt_imprime,3);
	} else if (tabnavigator_contrato.selectedIndex == 2){
		ctrlbar.addChildAt(ctrlbar.bt_inserir,0);
		ctrlbar.addChildAt(ctrlbar.bt_alterar,1);
		ctrlbar.addChildAt(ctrlbar.bt_excluir,2);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,3);
		
		var bt_cancelar:Button = new Button;
		bt_cancelar.label = "Cancelar";
		bt_cancelar.styleName = "editButton";
		bt_cancelar.addEventListener(MouseEvent.CLICK,btcancelar);
		ctrlbar.addChildAt(bt_cancelar,4);
		
//		var bt_duptecnico:Button = new Button;
//		bt_duptecnico.label = "Automático";
		
//		ctrlbar.addChildAt(bt_duptecnico,4);
		
	} else if (tabnavigator_contrato.selectedIndex == 3){
		//pesquisar
		ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,1);
	} else if (tabnavigator_contrato.selectedIndex == 4){
		//documentacao
		ctrlbar.addChildAt(ctrlbar.bt_imprime,0);
	} else if (tabnavigator_contrato.selectedIndex == 5){
		
	} else if (tabnavigator_contrato.selectedIndex == 6){
		
	} else if (tabnavigator_contrato.selectedIndex == 7){
		// historico
		ctrlbar.addChildAt(ctrlbar.bt_inserir,0);
		ctrlbar.addChildAt(ctrlbar.bt_alterar,1);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,2);
		ctrlbar.addChildAt(ctrlbar.bt_imprime,3);
	}  else {
		ctrlbar.addChildAt(ctrlbar.bt_inserir,0);
		ctrlbar.addChildAt(ctrlbar.bt_alterar,1);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,2);
		ctrlbar.addChildAt(ctrlbar.bt_imprime,3);
	}
	
}
// inicialização tela            
private function init():void{
	tabnavigator_contrato.selectedIndex = 3;
	txt_dtcadastro.text = util.dthoje();
	
	this.width = FlexGlobals.topLevelApplication.mdiCanvas.width;
	this.height = FlexGlobals.topLevelApplication.mdiCanvas.height;
	
	this.x = 0;
	this.y = 0;
	
	addButtons();
	
	ro_ctrstatus.ComboBox("nmstatus","id_ctrstatus",createcomboxstatus,defaultFaultHandler);
	ro_midia.ComboBox("nmmidia","id_midia",createcomboxMidia,defaultFaultHandler);
//	ro_aluno.ComboBox("nome","id_aluno",createarrayaluno,defaultFaultHandler);
//	ro_resp.ComboBox("nome","id_resp",createarrayresp,defaultFaultHandler);
	ro_curso.ComboBox("nmcurso","id_curso",createarraycurso,defaultFaultHandler);
//	ro_turma.ComboBox("nmturma","id_turma",createArrayTurma,defaultFaultHandler);
//	ro_operador.ComboBox("nmoperador","id_operador",createarrayoperador,defaultFaultHandler);
	ro_operador.Adm_OperadorSemAluno(createarrayoperador,defaultFaultHandler);

	
	ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
	ctrlbar.bt_inserir.addEventListener(MouseEvent.CLICK,inserir);
	ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,alterar);
	ctrlbar.bt_excluir.addEventListener(MouseEvent.CLICK,deletar);
	ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
	ctrlbar.bt_imprime.addEventListener(MouseEvent.CLICK,imprime);
	chk_selectcanc.addEventListener(Event.CHANGE,pesquisaCancelados);
}
private function createArrayTabValores(e:ResultEvent):void{
	cbdiapag.dataProvider = e.result as ArrayCollection;
	ArrayTabValores = e.result as ArrayCollection;
}
private function createcomboxstatus(e:ResultEvent):void{
	ArrayCtrStatus = e.result as ArrayCollection;
	cbctrstatus.dataProvider = ArrayCtrStatus;
}
private function createcomboxMidia(e:ResultEvent):void{
	ArrayMidia = e.result as ArrayCollection;
	cbmidia.dataProvider = ArrayMidia;
}
private function createarrayaluno(e:ResultEvent):void{
	ArrayAluno = e.result as ArrayCollection;
}

private function createArrayTurma(e:ResultEvent):void{
	ArrayTurma = e.result as ArrayCollection;
	var retorno:Object;
	retorno =  util.selecionarCombobox(ArrayContrato[0].id_turma,ArrayTurma);
	txtid_turma.txt_nome.text = retorno.label;
}
private function createarrayresp(e:ResultEvent):void{
	ArrayResp = e.result as ArrayCollection;
	var retorno:Object;
	retorno =  util.selecionarCombobox(ArrayContrato[0].id_respfinan,ArrayResp);
	txtid_respfinan.txt_nome.text = retorno.label;
}
private function createarrayresplegal(e:ResultEvent):void{
	ArrayRespLegal = e.result as ArrayCollection;
	var retorno:Object;
	retorno =  util.selecionarCombobox(ArrayContrato[0].id_resplegal,ArrayRespLegal);
	txtid_resplegal.txt_nome.text = retorno.label;
}
private function createarraycurso(e:ResultEvent):void{
	ArrayCurso = e.result as ArrayCollection;
}
private function createarrayoperador(e:ResultEvent):void{
	ArrayOperador = e.result as ArrayCollection;
	cbcolaborador.dataProvider = ArrayOperador;
}

private function createarraydocumentacao(e:ResultEvent):void{
	ArrayDocumentacao = e.result as ArrayCollection;
}
private function createarraytipohistorico(e:ResultEvent):void{
	ArrayTipoHistorico = e.result as ArrayCollection;
	cbtipohistorico.dataProvider = ArrayTipoHistorico;
}
private function createarraymotivohistorico(e:ResultEvent):void{
	ArrayMotivoHistorico = e.result as ArrayCollection;
//	cbmotivohistorico.dataProvider = ArrayMotivoHistorico;
}
private function createarrayModulo(e:ResultEvent):void{
	ArrayModulo = e.result as ArrayCollection;
	cbmodulo.dataProvider = ArrayModulo;
}
private function createcomboxtiporec(event:ResultEvent):void{
	ArrayTipoRec = event.result as ArrayCollection;
 	cbtiporec.dataProvider = ArrayTipoRec;
}
private function createcomboxformapgt(event:ResultEvent):void{
	ArrayTipoPag = event.result as ArrayCollection;
 	cbtipopag.dataProvider = ArrayTipoPag;
}
private function createcomboboxmateriaaprov(event:ResultEvent):void{
	ArrayCompAprov =  event.result as ArrayCollection;
	cbcompaprov.dataProvider =  event.result as ArrayCollection;
}
protected function lb_dtcadastro(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_cadastro);	
}
protected function lb_dtvencimento(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_vencimento);	
}
protected function lb_dtpagamento(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_pagamento);	
}
protected function lb_dtcancelamento(item:Object, column:DataGridColumn):String
{
	return util.formatData_DDMMYYYY(item.dt_cancelamento);	
}
protected function lf_aluno(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_aluno,ArrayAluno);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_anocursado(item:Object, column:DataGridColumn):String
{
	if (item.ano == 0){
		return "";	
	}
	return item.ano;
}
protected function lf_modulo(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_modulo,ArrayModulo);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_documentacao(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_documentacao,ArrayDocumentacao);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_resp(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_respfinan,ArrayResp);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_curso(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_curso,ArrayCurso);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_operador(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_operador,ArrayOperador);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_midia(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_midia,ArrayMidia);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_ctrstatus(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_ctrstatus,ArrayCtrStatus);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}

protected function lf_tiporec(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_tiporec,ArrayTipoRec);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_formapgt(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_formapgt,ArrayTipoPag);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_tipohistorico(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_tipohistorico,ArrayTipoHistorico);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
protected function lf_motivohistorico(item:Object, column:DataGridColumn):String{
	var retorno:Object = util.selecionarCombobox(item.id_motivohistorico,ArrayMotivoHistorico);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
private function tabnavigator_contratocomplete(event:IndexChangedEvent):void{
	var currentIndex:int=event.newIndex;
		addButtons();
	this.title = "Cadastro Contrato";	
	if (currentIndex == 0){
		selecionar(event);
	}else if (currentIndex == 1){
		this.title = "Contrato: " + txtid_contrato.text + " Aluno: " + txtid_aluno.txt_nome.text;
		ro_materia.MateriaAproveitamento(txtid_contrato.text,createcomboboxmateriaaprov,defaultFaultHandler);
		selecionar(event);
	}else if (currentIndex == 2){
		this.title = "Contrato: " + txtid_contrato.text + " Aluno: " + txtid_aluno.txt_nome.text;
		selecionar(event);
		unselect_all();
		ro_tiporec.ComboBox("nmtiporec","id_tiporec",createcomboxtiporec,defaultFaultHandler);
		ro_formapgt.ComboBox("nmformapgt","id_formapgt",createcomboxformapgt,defaultFaultHandler);
		ro_modulo.ModuloContrato(txtid_contrato.text,createarrayModulo,defaultFaultHandler);
		ro_tabvalores.DiaPagamentoCurso(txtid_contrato.text,createArrayTabValores,defaultFaultHandler);
	}else if (currentIndex == 3){
		//pesquisa
	}else if (currentIndex == 4){
		this.title = "Contrato: " + txtid_contrato.text + " Aluno: " + txtid_aluno.txt_nome.text;
		//documentacao
		limpar(event);
		ro_documentacao.ComboBox("nmdocumentacao","id_documentacao",createarraydocumentacao,defaultFaultHandler);
		selecionar(event);
	}else if (currentIndex == 5){
		
	}else if (currentIndex == 6){
	
	}else if (currentIndex == 7){
		this.title = "Contrato: " + txtid_contrato.text + " Aluno: " + txtid_aluno.txt_nome.text;
		// historico
		ro_tipohistorico.ComboBox("nmtipohistorico","id_tipohistorico",createarraytipohistorico,defaultFaultHandler);
		ro_motivohistorico.ComboBox("nmmotivohistorico","id_motivohistorico",createarraymotivohistorico,defaultFaultHandler);
		cbtipohistorico.addEventListener(ListEvent.CHANGE,cbmotivoSelect);
		cbmotivohistorico.dataProvider = null;
		limpar(event);
//		selecionar(event);
	}
	
}
protected function cbmotivoSelect(e:Event):void{
	if(cbtipohistorico.selectedIndex > 0){
		ro_motivohistorico.Ctr_MotivoTipoHistorico(cbtipohistorico.selectedItem.data,cbmotivoSelectResult,defaultFaultHandler);
	} else {
		cbmotivohistorico.dataProvider = null;
	}
}
private function cbmotivoSelectResult(e:ResultEvent):void{
	cbmotivohistorico.dataProvider = e.result;
	
	if (dg_historico.selectedItem){
		cbmotivohistorico.selectedItem = util.selecionarCombobox(dg_historico.selectedItem.id_motivohistorico,ArrayMotivoHistorico);
	}
}
private function createDataGrid(e:ResultEvent):void{
	this.enabled = true;
	if (tabnavigator_contrato.selectedIndex == 0){
		ArrayContrato = e.result as ArrayCollection;
		
		util.limpar_formulario(form_aluno);
		util.limpar_formulario(form_turma);
		var retorno:Object;
		txtid_aluno.txt_id.text = ArrayContrato[0].id_aluno;
		retorno = util.selecionarCombobox(ArrayContrato[0].id_aluno,ArrayAluno);
		txtid_aluno.txt_nome.text = retorno.label;
		
		txtid_turma.txt_id.text = ArrayContrato[0].id_turma;
		ro_turma.ComboBox_IdTurma(txtid_turma.txt_id.text,createArrayTurma,defaultFaultHandler);
		
		txtid_respfinan.txt_id.text = ArrayContrato[0].id_respfinan;
		ro_resp.ComboBox_IdResp(txtid_respfinan.txt_id.text,createarrayresp,defaultFaultHandler);

		txtid_resplegal.txt_id.text = ArrayContrato[0].id_resplegal;
		ro_resp.ComboBox_IdResp(txtid_resplegal.txt_id.text,createarrayresplegal,defaultFaultHandler);

		txt_dtcadastro.text = util.formatData_DDMMYYYY(ArrayContrato[0].dt_cadastro);
		txt_dtcancelamento.text = util.formatData_DDMMYYYY(ArrayContrato[0].dt_cancelamento);
		
		cbctrstatus.selectedItem = util.selecionarCombobox(ArrayContrato[0].id_ctrstatus,ArrayCtrStatus);
		
		contcolabPesquisa(e);
		midiaPesquisa(e);
		
	} else if (tabnavigator_contrato.selectedIndex == 1){
		
		dg_turmamateria.dataProvider = e.result;
		
		
		
	} else if (tabnavigator_contrato.selectedIndex == 2){
		dg_duplicata.dataProvider = e.result;
		dg_duplicata.verticalScrollPosition = iScrollPosition;
		iScrollPosition = 0;
	} else if (tabnavigator_contrato.selectedIndex == 3){
		dg_pesquisa.dataProvider = e.result;
	} else if (tabnavigator_contrato.selectedIndex == 4){
		//documentacao
		dg_documentacao.dataProvider = e.result ;
	} else if (tabnavigator_contrato.selectedIndex == 5){
	} else if (tabnavigator_contrato.selectedIndex == 6){
	} else if (tabnavigator_contrato.selectedIndex == 7){
		//historico
		dg_historico.dataProvider = e.result;
		dg_historico.verticalScrollPosition = verticalScroll;
	}
}
private function contcolabPesquisa(e:Event):void{
	this.enabled = false;
	ctr_contcolad = new Ctr_ContrColabVO;
	ctr_contcolad.id_contrato = txtid_contrato.text;
	
	ro_contcolab.select(ctr_contcolad,contcolabResult,defaultFaultHandler,null,null);	
}
private function contcolabResult(e:ResultEvent):void{
	this.enabled = true;
	dg_contcolab.dataProvider = e.result;
}
private function midiaPesquisa(e:Event):void{
	this.enabled = false;
	ctr_contrmidiaVO = new Ctr_ContrMidiaVO;
	ctr_contrmidiaVO.id_contrato = txtid_contrato.text;
	
	ro_contrmidia.select(ctr_contrmidiaVO,midiaResult,defaultFaultHandler,null,null);
	
}
private function midiaResult(e:ResultEvent):void{
	this.enabled = true;
	dg_midia.dataProvider = e.result;
}
private function pesquisaCancelados(e:Event):void{
	selecionar(e);
}
private function selecionar(e:Event):void{
	if (tabnavigator_contrato.selectedIndex == 0){
		if (txtid_contrato.text.length > 0){
			this.enabled = false;
			ctr_contratoVO = new Ctr_ContratoVO();
			ctr_contratoVO.id_contrato = txtid_contrato.text;
			ro_contrato.select(ctr_contratoVO,createDataGrid,defaultFaultHandler);
		} else {
			this.enabled = true;
		}
	} else if (tabnavigator_contrato.selectedIndex == 1 ){
		this.enabled = false;
		view_ctrturmamateriaVO = new View_Ctr_TurmaMateriaVO;
		view_ctrturmamateriaVO.id_contrato = txtid_contrato.text;
		ro_viewturmamateria.select(view_ctrturmamateriaVO,createDataGrid,defaultFaultHandler,null,null);
		
		
	} else if (tabnavigator_contrato.selectedIndex == 2){
		if (txtid_contrato.text.length > 0){
			this.enabled = false;
			executaAjusteRecebimento();
//			fin_duplicataVO = new Fin_DuplicataVO();
//			fin_duplicataVO.id_contrato = txtid_contrato.text;
//			
			var where:Array;
			if(chk_selectcanc.selected){
				where = null;
			} else {
				where = ["dt_cancelamento is null"];
			}
//			
//			var order:Array = ["dt_vencimento"];
//			
//			ro_duplicata.select(fin_duplicataVO,createDataGrid,defaultFaultHandler,where,order);
			
			
			view_ctrduplicataVO = new View_Ctr_DuplicataVO;
			view_ctrduplicataVO.id_contrato = txtid_contrato.text;
			
//			var where:Array = ["saldo > 0"];
			
			ro_viewctrduplicata.select(view_ctrduplicataVO, where,createDataGrid,defaultFaultHandler);
			
			
			
			
		}
	} else if (tabnavigator_contrato.selectedIndex == 3){
		isValid = util.validateForm(form_pesquisa);
		if (!isValid){
			mensagem_pesquisa.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			ro_aluno.ComboBox_IdAluno(txtid_aluno_pesquisa.txt_id.text,createarrayaluno,defaultFaultHandler);
			ctr_contratoVO = new Ctr_ContratoVO();
			ctr_contratoVO.id_aluno = txtid_aluno_pesquisa.txt_id.text;
			ro_contrato.select(ctr_contratoVO,createDataGrid,defaultFaultHandler);
		}
	} else if (tabnavigator_contrato.selectedIndex == 4){
			//documentacao
			this.enabled = false;
			ctr_contrdocVO = new Ctr_ContrDocVO;
			ctr_contrdocVO.id_contrato = txtid_contrato.text;
			ro_contrdoc.select(ctr_contrdocVO,createDataGrid,defaultFaultHandler);
	} else if (tabnavigator_contrato.selectedIndex == 5){
	} else if (tabnavigator_contrato.selectedIndex == 6){
	} else if (tabnavigator_contrato.selectedIndex == 7){
		//historico
		this.enabled = false;
		ctr_historicoVO = new Ctr_HistoricoVO;
		ctr_historicoVO.id_contrato = txtid_contrato.text;
		ro_historico.select(ctr_historicoVO,createDataGrid,defaultFaultHandler);
	} 
}
private function setcampos(e:Event):void{
	if(tabnavigator_contrato.selectedIndex == 0){
		var retorno:Object;
//		txtid_contrato.text = dg_contrato.selectedItem.id_contrato;
//		txtid_aluno.txt_id.text = dg_contrato.selectedItem.id_aluno;
//		retorno = util.selecionarCombobox(dg_contrato.selectedItem.id_aluno,ArrayAluno);
//		txtid_aluno.txt_nome.text = retorno.label;
		
//		txtid_curso.txt_id.text = dg_contrato.selectedItem.id_curso;
//		retorno =  util.selecionarCombobox(dg_contrato.selectedItem.id_curso,ArrayCurso);
//		txtid_curso.txt_nome.text = retorno.label;
		
//		txtid_respfinan.txt_id.text = dg_contrato.selectedItem.id_respfinan;
//		retorno =  util.selecionarCombobox(dg_contrato.selectedItem.id_respfinan,ArrayResp);
//		txtid_respfinan.txt_nome.text = retorno.label;
		
	} else	if (tabnavigator_contrato.selectedIndex == 1 ){
		
		if (dg_turmamateria.selectedItem.id_media == 13){
			cbcompaprov.selectedItem = util.selecionarCombobox(dg_turmamateria.selectedItem.id_turmamateria,ArrayCompAprov);
			txtano.text = dg_turmamateria.selectedItem.ano;
			txtunid_ensino.text = dg_turmamateria.selectedItem.unid_ensino;
			txtch.text = dg_turmamateria.selectedItem.carga_horaria;
			txtch.text = txtch.text.replace(".",",");
			
			txtmedia.text = dg_turmamateria.selectedItem.media;
			txtmedia.text = txtmedia.text.replace(".",",");
			
			txtfaltas.text = dg_turmamateria.selectedItem.perc_faltas;
			txtfaltas.text = txtfaltas.text.replace(".",",");
			
		}  else {
			limpar(e);
		}
		
		
	} else if (tabnavigator_contrato.selectedIndex == 2){
			cbtiporec.selectedItem = util.selecionarCombobox(dg_duplicata.selectedItem.id_tiporec,ArrayTipoRec);
			cbtipopag.selectedItem = util.selecionarCombobox(dg_duplicata.selectedItem.id_formapgt,ArrayTipoPag);
			cbmodulo.selectedItem = util.selecionarCombobox(dg_duplicata.selectedItem.id_modulo,ArrayModulo);
			cbdiapag.selectedItem = dg_duplicata.selectedItem.id_tabvalores > 0 ? util.selecionarCombobox(dg_duplicata.selectedItem.id_tabvalores,ArrayTabValores) : cbdiapag.selectedIndex = 0;
			txtvalor.text = dg_duplicata.selectedItem.valor;
			txtdtvencimento.selectedDate = dg_duplicata.selectedItem.dt_vencimento;
	} else if (tabnavigator_contrato.selectedIndex == 3){
		txtid_contrato.text = dg_pesquisa.selectedItem.id_contrato;
		
		ArrayContrato = null;
		
		tabnavigator_contrato.selectedIndex = 0;
	} else if (tabnavigator_contrato.selectedIndex == 4){
		
	} else if (tabnavigator_contrato.selectedIndex == 5){
		
	} else if (tabnavigator_contrato.selectedIndex == 6){
		
	} else if (tabnavigator_contrato.selectedIndex == 7){
		txtid_historico.text = dg_historico.selectedItem.id_historico;
		cbtipohistorico.selectedItem = util.selecionarCombobox(dg_historico.selectedItem.id_tipohistorico,ArrayTipoHistorico);
		
		cbmotivoSelect(e);
		
		cbmotivohistorico.selectedItem = util.selecionarCombobox(dg_historico.selectedItem.id_motivohistorico,ArrayMotivoHistorico);
		
		txa_historico.text = dg_historico.selectedItem.descricao;
	}
}
// conclui a entrada contrato para impressao
//private function concluir(e:Event):void{
//	if (tabnavigator_contrato.selectedIndex == 0){
//		dados_contrato = new Ctr_contratoVO();
//		dados_contrato.id_contrato = parseInt(txtid_contrato.text);
//		dados_contrato.id_ctrstatus = 2;
//		remote.atualizar_ctrStatus(dados_contrato,statementResult);
//		cb_status.selectedIndex = 1;
//		bt_imprimir.enabled = true;
//
//	} else if (tabnavigator_contrato.selectedIndex == 1){
//                 			
//	} else if (tabnavigator_contrato.selectedIndex == 2){
//
//	}
//}

//private function tira_required():void{
//	fi_desconto.required = false;
//	fi_diapagamento.required = false;
//	fi_dtvenc.required = false;
//	fi_parcelas.required = false;
//	fi_tipopagamento.required = false;
//	fi_tiporecebimento.required = false;
//	fi_valor.required = false;
//	fi_modulo.required = false;
//}
private function inserir(e:Event):void{
	if (tabnavigator_contrato.selectedIndex == 0){
		isValid = util.validateForm(form_aluno);
		isValid =  util.validateForm(form_turma) && isValid;
		if (!isValid){
			mensagem_contrato.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			popular();
			ro_contrato.inserir(ctr_contratoVO,inserirResult,defaultFaultHandler);
		}
	} else if (tabnavigator_contrato.selectedIndex == 1){
		
	} else if (tabnavigator_contrato.selectedIndex == 2){
		isValid = util.validateForm(form_financeiroa);
		isValid =  util.validateForm(form_financeirob) && isValid;
		if (!isValid){
			mensagem_duplicata.text = UtilMensagens.PreenchaCampo;			
		} else {
			
			var parcelas:int = 1;
			if (int(txtparcelas.text) > 0) {
				parcelas = int(txtparcelas.text);
			}
			var i:int = 0;
			var saldo:Number = Number(txtvalor.text);
			do {
				popular();
				ro_duplicata.inserir(fin_duplicataVO,null,defaultFaultHandler);
				i++;
			} while ( i < parcelas);
			util.limpar_formulario(form_financeiroa);
			util.limpar_formulario(form_financeirob);
			executaAjusteOrdemDup();
			selecionar(e);
		}
	} else if (tabnavigator_contrato.selectedIndex == 3){
//	
	} else if (tabnavigator_contrato.selectedIndex == 4){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 5){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 6){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 7){
		//historico
		isValid =  util.validateForm(form_historico);
		if (!isValid){
			mensagem_historico.text = UtilMensagens.PreenchaCampo;
		} else {
			popular();
			ro_historico.inserir(ctr_historicoVO,inserirResult,defaultFaultHandler);
		}
	}
	
}
private function inserirResult(e:ResultEvent):void{
	this.enabled = true;
	if (tabnavigator_contrato.selectedIndex == 0){
		txtid_contrato.text = e.result.toString();
	} else if (tabnavigator_contrato.selectedIndex == 1){
	} else if (tabnavigator_contrato.selectedIndex == 2){
	} else if (tabnavigator_contrato.selectedIndex == 3){
	} else if (tabnavigator_contrato.selectedIndex == 4){
	}
	selecionar(e);
}
private function alterar(e:Event):void{
	if (tabnavigator_contrato.selectedIndex == 0){
		isValid = util.validateForm(form_aluno);
		if (!isValid){
			mensagem_contrato.text = UtilMensagens.PreenchaCampo;
		} else {
			popular();
			ro_contrato.atualizar(ctr_contratoVO,alterarResult,defaultFaultHandler);
		}
	} else if (tabnavigator_contrato.selectedIndex == 1){
		isValid = util.validateForm(form_aprova);
		isValid = util.validateForm(form_aprovb) && isValid;
		if (!isValid){
			mensagem_aproveitamento.text = UtilMensagens.PreenchaCampo;
		} else {
			ctr_turmamateriaVO = new Ctr_TurmaMateriaVO;
			ctr_turmamateriaVO.id_turmamateria = cbcompaprov.selectedItem.data;
			ctr_turmamateriaVO.ano = txtano.text;
			ctr_turmamateriaVO.carga_horaria = txtch.text.replace(",",".");
			ctr_turmamateriaVO.id_operadorcad = systemVO.id_operador;
			ctr_turmamateriaVO.media = txtmedia.text.replace(",",".");
			ctr_turmamateriaVO.perc_faltas = txtfaltas.text.replace(",","."); 
			ctr_turmamateriaVO.unid_ensino = txtunid_ensino.text.toUpperCase();
			
			ro_ctrturmamateria.atualizar2(ctr_turmamateriaVO,alterarResult,defaultFaultHandler);
		}
	} else if (tabnavigator_contrato.selectedIndex == 2){
		popular();
		ro_duplicata.atualizar(fin_duplicataVO,null,alterarResult,defaultFaultHandler);
	} else if (tabnavigator_contrato.selectedIndex == 3){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 4){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 5){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 6){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 7){
		popular();
		ro_historico.atualizar(ctr_historicoVO,alterarResult,defaultFaultHandler);
	}
}
private function alterarResult(e:ResultEvent):void{
	this.enabled = true;
	if (tabnavigator_contrato.selectedIndex == 0){
		ArrayContrato = e.result as ArrayCollection;
	} else if (tabnavigator_contrato.selectedIndex == 1){
		limpar(e);
		selecionar(e);
	} else if (tabnavigator_contrato.selectedIndex == 2){
		selecionar(e);
	} else if (tabnavigator_contrato.selectedIndex == 3){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 4){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 5){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 6){
		//	
	} else if (tabnavigator_contrato.selectedIndex == 7){
		selecionar(e);
	}
}

public function deletar(e:Event):void{
	Alert.yesLabel = "Sim";
	Alert.noLabel = "Não";
	if (tabnavigator_contrato.selectedIndex == 0){
	} else if (tabnavigator_contrato.selectedIndex == 1){
		isValid = util.validateForm(form_aprova);
		isValid = util.validateForm(form_aprovb) && isValid;
		if (!isValid){
			mensagem_aproveitamento.text = UtilMensagens.PreenchaCampo;
		} else {
    		ctr_turmamateriaVO = new Ctr_TurmaMateriaVO;
			ctr_turmamateriaVO.id_turmamateria = cbcompaprov.selectedItem.data;
			ctr_turmamateriaVO.ano = "";
			ctr_turmamateriaVO.carga_horaria = "";
			ctr_turmamateriaVO.id_media = 9;
			ctr_turmamateriaVO.id_operadorcad = systemVO.id_operador;
			ctr_turmamateriaVO.media = "";
			ctr_turmamateriaVO.perc_faltas = ""; 
			ctr_turmamateriaVO.unid_ensino = "";
			
			ro_ctrturmamateria.atualizar2(ctr_turmamateriaVO,deletarResult,defaultFaultHandler);
		}
	} else if (tabnavigator_contrato.selectedIndex == 2){
		Alert.show('Confirmar ?','Deseja Realmente Deletar esse(s) Registro(s)',Alert.YES|Alert.NO,this,confirmDeletar);
	} else if (tabnavigator_contrato.selectedIndex == 6){
	} else if (tabnavigator_contrato.selectedIndex == 7){
		Alert.show('Confirmar ?','Deseja Realmente Deletar esse(s) Registro(s)',Alert.YES|Alert.NO,this,confirmDeletar);
	}
}
private function confirmDeletar(e:CloseEvent):void{
	if (e.detail == Alert.YES){
		this.enabled = false;
		var dg:ArrayCollection;
		if (tabnavigator_contrato.selectedIndex == 0){
		} else if (tabnavigator_contrato.selectedIndex == 1){
		} else if (tabnavigator_contrato.selectedIndex == 2){
			
			fin_duplicataVO = new Fin_DuplicataVO();
 			fin_duplicataVO.id_contrato = txtid_contrato.text;
			
			dg = dg_duplicata.dataProvider as ArrayCollection;
			for (var i:int = 0; i < dg.length; i++) {
				if(dg[i]['selec'] == 4){
					fin_duplicataVO.id_duplicata = dg[i]['id_duplicata'];
					ro_duplicata.deletar(fin_duplicataVO,null,defaultFaultHandler);
				}
			}
			
			if (chk_selectall.selected == true){
				chk_selectall.selected = false;
			}
			util.limpar_formulario(form_financeiroa);
			util.limpar_formulario(form_financeirob);
			executaAjusteOrdemDup();
			selecionar(e);
			
		} else if (tabnavigator_contrato.selectedIndex == 6){
		} else if (tabnavigator_contrato.selectedIndex == 7){
			popular()
			ro_historico.deletar(ctr_historicoVO,deletarResult,defaultFaultHandler);
		}
	}
}
public function deletarResult(e:ResultEvent):void{
	if (tabnavigator_contrato.selectedIndex == 0){
		mensagem_contrato.text = UtilMensagens.OperacaoRealizadaSucesso;
	} else if (tabnavigator_contrato.selectedIndex == 1){
		limpar(e);
		selecionar(e);
	} else if (tabnavigator_contrato.selectedIndex == 2){

	} else if (tabnavigator_contrato.selectedIndex == 6){
	} else if (tabnavigator_contrato.selectedIndex == 7){
		util.limpar_formulario(form_historico);
		selecionar(e);
		
	}
}
private function limpar(e:Event):void{
	if (tabnavigator_contrato.selectedIndex == 0){
		
		util.limpar_formulario(form_turma);
		util.limpar_formulario(form_aluno);
		cbcolaborador.selectedIndex = 0;
		cbctrstatus.selectedIndex = 1;
		txt_dtcadastro.text = util.dthoje();
		txtid_contrato.text = "";
		mensagem_contrato.text = '';
		dg_contcolab.dataProvider = null;
		dg_midia.dataProvider = null;
		
	} else if (tabnavigator_contrato.selectedIndex == 1){
		util.limpar_formulario(form_aprova);
		util.limpar_formulario(form_aprovb);
		mensagem_aproveitamento.text = '';
	} else if (tabnavigator_contrato.selectedIndex == 2){
		util.limpar_formulario(form_financeiroa);
		util.limpar_formulario(form_financeirob);
		mensagem_duplicata.text = null;
	} else if (tabnavigator_contrato.selectedIndex == 3){
		util.limpar_formulario(form_pesquisa);
		dg_pesquisa.dataProvider = null;
		util.limpar_formulario(form_turma);
		util.limpar_formulario(form_aluno);
		txt_dtcadastro.text = util.dthoje();
		txtid_contrato.text = '';
		mensagem_contrato.text = '';
	} else if (tabnavigator_contrato.selectedIndex == 4){
		mensagem_documentacao.text = '';
	} else if (tabnavigator_contrato.selectedIndex == 5){
		
	} else if (tabnavigator_contrato.selectedIndex == 6){
		
	} else if (tabnavigator_contrato.selectedIndex == 7){
		//historico
		util.limpar_formulario(form_historico);
		dg_historico.dataProvider = null;
		selecionar(e);
	}
}

//private function popular_contrcolab():void{
//	dados_contrcolab = new Ctr_contrcolabVO();
//	dados_contrcolab.id_contrato = parseInt(txtid_contrato.text);
//	dados_contrcolab.id_operador = cbcolaborador.selectedItem.data;
//}
private function popular():void{
	if (tabnavigator_contrato.selectedIndex == 0){
		ctr_contratoVO = new Ctr_ContratoVO();
		ctr_contratoVO.id_contrato = txtid_contrato.text.length <= 0 ? null : txtid_contrato.text;
		ctr_contratoVO.id_turma = txtid_turma.txt_id.text;
		ctr_contratoVO.id_respfinan = txtid_respfinan.txt_id.text;
		ctr_contratoVO.id_aluno = txtid_aluno.txt_id.text;
		ctr_contratoVO.id_operador = systemVO.id_operador;
	} else if (tabnavigator_contrato.selectedIndex == 1){
		
	} else if (tabnavigator_contrato.selectedIndex == 2){
		fin_duplicataVO = new Fin_DuplicataVO();
		fin_duplicataVO.id_contrato = txtid_contrato.text;
		fin_duplicataVO.valor = txtvalor.text;
		fin_duplicataVO.saldo = txtvalor.text;
		fin_duplicataVO.id_tiporec = cbtiporec.selectedItem.data;
		fin_duplicataVO.id_formapgt = cbtipopag.selectedItem.data;
		fin_duplicataVO.id_modulo = cbmodulo.selectedIndex > 0 ? cbmodulo.selectedItem.data : null;
		fin_duplicataVO.id_tabvalores = cbdiapag.selectedIndex > 0 ? cbdiapag.selectedItem.data : null;
		fin_duplicataVO.dt_vencimento = txtdtvencimento.selectedDate;
		fin_duplicataVO.subtotal = txtvalor.text;
		fin_duplicataVO.id_situacao = 0;
		fin_duplicataVO.id_operador = systemVO.id_operador;
		fin_duplicataVO.desconto = (Number(txtvalor.text) * (Number(txtdesconto.text) / 100));
		
		
	} else if (tabnavigator_contrato.selectedIndex == 3){
		
	} else if (tabnavigator_contrato.selectedIndex == 4){
		
	} else if (tabnavigator_contrato.selectedIndex == 5){
		
	} else if (tabnavigator_contrato.selectedIndex == 6){
		
	} else if (tabnavigator_contrato.selectedIndex == 7){
		ctr_historicoVO = new Ctr_HistoricoVO;
		ctr_historicoVO.descricao = txa_historico.text.length <= 0 ? null : txa_historico.text;
		ctr_historicoVO.id_contrato = txtid_contrato.text
		ctr_historicoVO.id_historico = txtid_historico.text.length <= 0 ? null : txtid_historico.text;
		ctr_historicoVO.id_motivohistorico = cbmotivohistorico.selectedIndex <= 0 ? null : cbmotivohistorico.selectedItem.data;
		ctr_historicoVO.id_operador = systemVO.id_operador;
		ctr_historicoVO.id_tipohistorico = cbtipohistorico.selectedIndex <= 0 ? null : cbtipohistorico.selectedItem.data
	}
	
}

// atualiza status documentacao
public function atualiza_ctrdoc(data:Boolean):void{
	ctr_contrdocVO = new Ctr_ContrDocVO;
	ctr_contrdocVO.id_contrato = txtid_contrato.text;
	ctr_contrdocVO.id_documentacao = dg_documentacao.selectedItem.id_documentacao;
	ctr_contrdocVO.id_contrdoc = dg_documentacao.selectedItem.id_contrdoc;
	if (data == true){
		ctr_contrdocVO.status = 1;
	} else {
		ctr_contrdocVO.status = 0;
	}
	ro_contrdoc.atualizar(ctr_contrdocVO,null,defaultFaultHandler);
	
}
// atualiza status historico
public function atualiza_imphistorico(data:Boolean):void{
	verticalScroll = dg_historico.verticalScrollPosition;
	ctr_historicoVO = new Ctr_HistoricoVO;
	ctr_historicoVO.descricao = dg_historico.selectedItem.descricao;
	ctr_historicoVO.dt_cadastro = dg_historico.selectedItem.dt_cadastro;
	ctr_historicoVO.id_historico = dg_historico.selectedItem.id_historico;
	ctr_historicoVO.id_motivohistorico = dg_historico.selectedItem.id_motivohistorico;
	ctr_historicoVO.id_operador =  dg_historico.selectedItem.id_operador;
	ctr_historicoVO.id_tipohistorico = dg_historico.selectedItem.id_tipohistorico;
	
	if (data == true){
		ctr_historicoVO.status = 1;
	} else {
		ctr_historicoVO.status = 0;
	}
	ro_historico.atualizar(ctr_historicoVO,selecionar,defaultFaultHandler);
	
}

// atualiza status documentacao
//public function atualiza_excluidup(data:Boolean):void{
//	dados_duplicata = new Fin_duplicataVO();
//	if (data == true){
//		dados_duplicata.selec = 4;
//		dados_duplicata.id_duplicata = dg_duplicata.selectedItem.id_duplicata;
//		
//		remote_duplicata.atualiza_excluidup(dados_duplicata,statementResult_duplicata);
//	} else {
//		dados_duplicata.selec = 0;
//		dados_duplicata.id_duplicata = dg_duplicata.selectedItem.id_duplicata;
//		
//		remote_duplicata.atualiza_excluidup(dados_duplicata,statementResult_duplicata);
//	}
//	
//}
private function alteraStatus(e:Event):void{
	

	var statustitlewindow:frm_statuscontrato = PopUpManager.createPopUp(this,frm_statuscontrato,true) as frm_statuscontrato;
	PopUpManager.centerPopUp(statustitlewindow);
	var X:Number = statustitlewindow.width / 2;
	var Y:Number = statustitlewindow.height / 2;
	
	var newX:Number = FlexGlobals.topLevelApplication.mdiCanvas.width / 2;
	var newY:Number = FlexGlobals.topLevelApplication.mdiCanvas.height / 2;
	
	statustitlewindow.x = newX - X;
	statustitlewindow.y = newY - Y;
	
	statustitlewindow.id_contrato = parseInt(txtid_contrato.text);
	statustitlewindow.id_aluno = parseInt(txtid_aluno.txt_id.text);
	
	statustitlewindow.addEventListener(FlexEvent.REMOVE,selecionar);
	
}
//private function statusResult(e:ResultEvent):void{
//	var id:int = parseInt(e.result.toString());
//	cb_status.selectedItem = util.selecionarCombobox(id,ArrayCtrStatus);
//	
//	if (cb_status.selectedItem.data == 9){
//		Alert.show("Contrato Cancelado");
//	} else {
//		statustitlewindow = PopUpManager.createPopUp(this,frm_statuscontrato,true) as frm_statuscontrato;
//		
//		var X:Number = statustitlewindow.width / 2;
//		var Y:Number = statustitlewindow.height / 2;
//		
//		var newX:Number = FlexGlobals.topLevelApplication.mdiCanvas.width / 2;
//		var newY:Number = FlexGlobals.topLevelApplication.mdiCanvas.height / 2;
//		
//		statustitlewindow.x = newX - X;
//		statustitlewindow.y = newY - Y;
//		
//		statustitlewindow.id_contrato = parseInt(txtid_contrato.text);
//		statustitlewindow.id_aluno = parseInt(txtid_aluno.text);
//	}
//	
//}
// selecionar / desmarca checkbox
private function selectAllCheckboxes(e:Event):void{
	if (chk_selectall.selected == true){
		select_all();
	}else{
		unselect_all();
	}
}
public function select_all():void{
	var sql:String = "selec = 4";
	var where:String = "id_contrato = " + txtid_contrato.text;
	where += " and dt_pagamento is null and dt_cancelamento is null"
	
	ro_duplicata.SqlAtualizar(sql,where,selecionar,defaultFaultHandler);
}
public function unselect_all():void{
	
	var sql:String = "selec = 0";
	var where:String = "id_contrato = " + txtid_contrato.text;
	
	ro_duplicata.SqlAtualizar(sql,where,selecionar,defaultFaultHandler);
	
}
public function btcancelar(e:Event):void{
	Alert.yesLabel = "Sim";
	Alert.noLabel = "Não";
	Alert.show('Confirmar ?','Deseja Realmente Cancelar esse(s) Registro(s)',Alert.YES|Alert.NO,this,confirmCancelar);
}
private function confirmCancelar(e:CloseEvent):void{
	if (e.detail == Alert.YES){
		var sql:String = "dt_cancelamento = now()";
		var where:String = "id_contrato = " + txtid_contrato.text;
		where += " and dt_pagamento is null and dt_cancelamento is null and selec = 4"
		
		ro_duplicata.SqlAtualizar(sql,where,selecionar,defaultFaultHandler);
		unselect_all();
		executaAjusteOrdemDup();
	}
}
public function executaAjusteOrdemDup():void{
	fin_ajusteordemVO = new Fin_Ajuste_OrdemDupVO();
	fin_ajusteordemVO.id_contrato = txtid_contrato.text;
	ro_finajusteordem.Procedure(fin_ajusteordemVO,null,defaultFaultHandler);
}
public function executaAjusteRecebimento():void{
}
public function chk_excluir(selec:int):void{
	iScrollPosition = dg_duplicata.verticalScrollPosition;
	var sql:String = "";
	var where:String = "";
	if (selec == 0){
		sql = "selec = 4";
		where = "id_duplicata = " + dg_duplicata.selectedItem.id_duplicata;
	} else {
		sql = "selec = 0";
		where = "id_duplicata = " + dg_duplicata.selectedItem.id_duplicata;
	}
	ro_duplicata.SqlAtualizar(sql,where,selecionar,defaultFaultHandler);
}

private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
	
	if (tabnavigator_contrato.selectedIndex == 0){
		mensagem_contrato.text = "";
	} else if (tabnavigator_contrato.selectedIndex == 1){
	} else if (tabnavigator_contrato.selectedIndex == 2){
	}
	
}
private function inserir_midia():void{
	if (cbmidia.selectedIndex > 0){
		this.enabled = false;
		ctr_contrmidiaVO = new Ctr_ContrMidiaVO;
		ctr_contrmidiaVO.id_contrato = txtid_contrato.text;
		ctr_contrmidiaVO.id_midia = cbmidia.selectedItem.data;
		
		ro_contrmidia.inserir(ctr_contrmidiaVO,midiaPesquisa,defaultFaultHandler);
	}
	
}
public function deletar_midia(data:int):void{
	this.enabled = false;
	ctr_contrmidiaVO = new Ctr_ContrMidiaVO;
	ctr_contrmidiaVO.id_contrmidia = data;
	
	ro_contrmidia.deletar(ctr_contrmidiaVO,midiaPesquisa,defaultFaultHandler);
	
}
private function inserir_colaborador():void{
	if(cbcolaborador.selectedIndex > 0){
		this.enabled = false;
		ctr_contcolad = new Ctr_ContrColabVO;
		ctr_contcolad.id_operador = cbcolaborador.selectedItem.data;
		ctr_contcolad.id_contrato = txtid_contrato.text;
		
		ro_contcolab.inserir(ctr_contcolad,contcolabPesquisa,defaultFaultHandler);
	}
}
public function deletar_colaboradores(data:int):void{
	this.enabled = false;
	ctr_contcolad = new Ctr_ContrColabVO;
	ctr_contcolad.id_contrcolab = data;
	
	ro_contcolab.deletar(ctr_contcolad,contcolabPesquisa,defaultFaultHandler);
}
public function imprime(e:Event):void{
	var obj:Object;
	if (tabnavigator_contrato.selectedIndex == 0){
		isValid = util.validateForm(form_aluno);
		isValid =  util.validateForm(form_turma) && isValid;
		if (!isValid){
			mensagem_contrato.text = UtilMensagens.PreenchaCampo;			
		} else {
			this.enabled = false;
			mensagem_contrato.text = UtilMensagens.RelatorioGerando;
			
			obj = new Object();
			obj.p_idcontrato = txtid_contrato.text;
			obj.nmoperador = systemVO.nickname;
			ro_contrato.Report(obj,"PDF","","ctr",imprimeResult,defaultFaultHandler);
		}	
	} else if (tabnavigator_contrato.selectedIndex == 1){
		this.enabled = false;
		mensagem_aproveitamento.text = UtilMensagens.RelatorioGerando;
		
		obj = new Object();
		obj.id_alunoini = txtid_aluno.txt_id.text;
		obj.id_alunofin = txtid_aluno.txt_id.text;
		obj.nmoperador = systemVO.nickname;
		ro_ctrturmamateria.Report(obj,"PDF","Rpt_HistoricoEscolar","pdg",imprimeResult,defaultFaultHandler);
	} else if (tabnavigator_contrato.selectedIndex == 2){
	} else if (tabnavigator_contrato.selectedIndex == 3){
	} else if (tabnavigator_contrato.selectedIndex == 4){
		this.enabled = false;
		mensagem_documentacao.text = UtilMensagens.RelatorioGerando;
		
		obj = new Object();
		obj.p_idturmaini = txtid_turma.txt_id.text;
		obj.p_idturmafin = txtid_turma.txt_id.text;
		obj.p_idaluno = txtid_aluno.txt_id.text;
		obj.p_idctrstatus = cbctrstatus.selectedItem.data;
				
		obj.nmoperador = systemVO.nickname;
		ro_historico.Report(obj,"PDF","Rpt_Documentacao","pdg",imprimeResult,defaultFaultHandler);
	} else if (tabnavigator_contrato.selectedIndex == 5){
	} else if (tabnavigator_contrato.selectedIndex == 6){
	} else if (tabnavigator_contrato.selectedIndex == 7){
		this.enabled = false;
		mensagem_historico.text = UtilMensagens.RelatorioGerando;
		
		obj = new Object();
		obj.p_idcontrato = txtid_contrato.text;
		obj.nmoperador = systemVO.nickname;
		ro_historico.Report(obj,"PDF","Rpt_ContratoHistorico","ctr",imprimeResult,defaultFaultHandler);
	}
}
public function imprimeResult(e:ResultEvent):void{
	this.enabled = true;
	if (tabnavigator_contrato.selectedIndex == 0){
		mensagem_contrato.text = UtilMensagens.RelatorioGerado;
	} else if (tabnavigator_contrato.selectedIndex == 1){
		mensagem_aproveitamento.text = UtilMensagens.RelatorioGerado;
	} else if (tabnavigator_contrato.selectedIndex == 2){
	} else if (tabnavigator_contrato.selectedIndex == 3){
	} else if (tabnavigator_contrato.selectedIndex == 4){
		mensagem_historico.text = UtilMensagens.RelatorioGerado;
	} else if (tabnavigator_contrato.selectedIndex == 5){
	} else if (tabnavigator_contrato.selectedIndex == 6){
	} else if (tabnavigator_contrato.selectedIndex == 7){
		mensagem_historico.text = UtilMensagens.RelatorioGerado;
	}
	util.abrepdf(e.result[0]['destinationUrl']);
}