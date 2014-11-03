// ActionScript file
import classes.*;

import flash.events.Event;
import flash.events.MouseEvent;
import flash.net.URLRequest;
import flash.net.URLRequestMethod;
import flash.net.URLVariables;
import flash.net.navigateToURL;

import flexmdi.events.MDIWindowEvent;

import frm.frm_pesquisar;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.controls.TextInput;
import mx.core.Application;
import mx.core.FlexGlobals;
import mx.events.CloseEvent;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.validators.Validator;

import service.ReportService;
import service.fin.Fin_DuplicataService;

import vo.adm.SystemVO;
import vo.fin.Fin_DuplicataVO;

[Bindable] private var isValid:Boolean = false;
private var pesquisatitlewindow:frm_pesquisar; 
private var fin_duplicataVO:Fin_DuplicataVO;
private var ro_duplicata:Fin_DuplicataService = Fin_DuplicataService.getInstance();
private var systemVO:SystemVO = SystemVO.getInstance();
private var util:Util = new Util();
private var retorno:UtilRetornoBanco;

private function init():void{
//	bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
//	bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
}
private function createDataGrid(event:ResultEvent):void {
       dg_boleto.dataProvider = event.result;
}
private function selecionar(e:Event):void{
		isValid = util.validateForm(form);
		if (!isValid) {
	  		mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			mensagem.text = "";
			popular_duplicata();
			ro_duplicata.DuplicataBoleto(fin_duplicataVO,createDataGrid,defaultFaultHandler);
		}
}
private function limpar(e:Event):void{
      util.limpar_formulario(form);
	  dg_boleto.dataProvider = null;
      mensagem.text = '';
}

public function select_impboleta(data:int):void{
	mensagem.text = UtilMensagens.RelatorioGerando;
	this.enabled = false;

	var obj:Object = new Object();
	obj.p_idboleto = data;
	ro_duplicata.Report(obj,"PDF","Rpt_Boleto","fin",impboletaResult,defaultFaultHandler);
	
}
public function impboletaResult(e:ResultEvent):void{
	this.enabled = true;
	mensagem.text = UtilMensagens.RelatorioGerado;
	util.abrepdf(e.result[0]['destinationUrl']);
}
private function popular_duplicata():void{
	fin_duplicataVO = new Fin_DuplicataVO();
	fin_duplicataVO.id_contrato = parseInt(txtid_contrato.text);
	
}
private function openpesquisa(tablename:String,c:TextInput,r:TextInput):void{
	
	pesquisatitlewindow = PopUpManager.createPopUp(this,frm_pesquisar,true) as frm_pesquisar;
	PopUpManager.centerPopUp(pesquisatitlewindow);
	
	var X:Number = pesquisatitlewindow.width / 2;
	var Y:Number = pesquisatitlewindow.height / 2;
	
	var newX:Number = FlexGlobals.topLevelApplication.mdiCanvas.width / 2;
	var newY:Number = FlexGlobals.topLevelApplication.mdiCanvas.height / 2;
	
	pesquisatitlewindow.x = newX - X;
	pesquisatitlewindow.y = newY - Y;

	pesquisatitlewindow["list_data_grid"].addEventListener(MouseEvent.DOUBLE_CLICK,closePopUpWindow(tablename,c,r));
	
	pesquisatitlewindow.title = "Selecionar um Contrato";
	pesquisatitlewindow.tablename = tablename;
	pesquisatitlewindow.currentState = "sem_pesquisa";
	
	
}

private function closePopUpWindow(tablename:String,c:TextInput,r:TextInput):Function {
	return function(evt:MouseEvent):void{
		c.text = pesquisatitlewindow.list_data_grid.selectedItem.id_contrato;
		r.text = pesquisatitlewindow.list_data_grid.selectedItem.nome;
		txtnmturma.text = pesquisatitlewindow.list_data_grid.selectedItem.nmturma;
		PopUpManager.removePopUp(pesquisatitlewindow);
		selecionar(evt);
	}
}
private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	mensagem.text = "";
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
}
