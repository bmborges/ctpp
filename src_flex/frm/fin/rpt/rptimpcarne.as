// ActionScript file
import classes.*;

import crud.fin.Fin_duplicataCRUD;

import flash.events.Event;
import flash.events.MouseEvent;
import flash.net.URLRequest;
import flash.net.URLRequestMethod;
import flash.net.URLVariables;
import flash.net.navigateToURL;

import frm.frm_pesquisa;

import mx.collections.ArrayCollection;
import mx.controls.Alert;
import mx.core.Application;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.validators.Validator;

import vo.fin.Fin_duplicataVO;
import vo.SystemVO;

[Bindable] public var s_tabela:String;
[Bindable] public var s_statement:String;
[Bindable] public var s_atributos:String;
[Bindable] public var s_valores:String;

public var columns:Array = new Array();
public var gridData:ArrayCollection = new ArrayCollection();
public var myValidators:Array;
private var pesquisatitlewindow:frm_pesquisa; 
private var dados_duplicata:Fin_duplicataVO;
private var remote:Fin_duplicataCRUD = Fin_duplicataCRUD.getInstance();
private var systemvo:SystemVO = SystemVO.getInstance();
private var util:Util = new Util();
[Bindable] private var pathreport:String;

private function init():void{
	txtid_contrato.setFocus();
	myValidators = [valid_txtid_contrato];
}

private function createDatagrid_carne(event:ResultEvent):void {
       dg_carne.dataProvider = event.result;
       gridData = event.result as ArrayCollection;
}
private function statementResult(e:Event):void{
}

private function imprime():void{
	var errors:Array = Validator.validateAll(myValidators);
	if (errors.length) {
		mensagemerro.text = "Selecione um contrato.";
	} else {
		var url:String = "http://" + systemvo.pathreport + "/ServletIreport/relatorios";
		var request:URLRequest = new URLRequest(url);
	
		var variables:URLVariables = new URLVariables();
		variables.nmrelatorio = "Rpt_Impcarne";
		variables.retorno = "PDF";
		request.data = variables;
		request.method = URLRequestMethod.POST;
	
		navigateToURL(request,"_blank");
	}
}
private function limpar():void{
      dg_carne.dataProvider = null;
      txtid_contrato.text = '';
      txtid_aluno.text = '';
	  txtid_aluno.errorString = '';
      txt_nmaluno.text = '';
      mensagemerro.text = '';
      chk_selectall.selected = false;
      txtid_contrato.errorString = '';
}

private function selecionar():void{
	var errors:Array = Validator.validateAll(myValidators);
	if (errors.length) {
  		mensagemerro.text = "Preencha os campos requeridos.";
	} else {
		mensagemerro.text = "";
	
		remote.selectTable_carne(parseInt(txtid_contrato.text),createDatagrid_carne);
		select_allimpcarne();
		chk_selectall.selected = true;
	}
}
// selecionar / desmarca checkbox
private function selectAllCheckboxes():void{
   
    var allRows:int = dg_carne.dataProvider.length;
               
                for (var i:int = 0; i < allRows; i++){
                    if (chk_selectall.selected == true){
                    	if (i == 1){
							select_allimpcarne();
                    	}
                        trace ("Checked is true");
                        gridData[i].checked = true;
                    }else{
                    	if (i == 1){
                    		unselect_allimpcarne();
                    	}
                        trace ("Checked is false");
                        gridData[i].checked = false;
                    }
              }
               
                //After the loop, reset the data provider to refresh the check boxes
                dg_carne.dataProvider = gridData;
                
}
// atualiza status impressao carne
public function select_impcarne(data:Boolean):void{
	dados_duplicata = new Fin_duplicataVO();
	if (data == false){
		dados_duplicata.imp = 1;
		dados_duplicata.id_duplicata = dg_carne.selectedItem.id_parcela;
		
		remote.atualizar_impcarne(dados_duplicata,statementResult);
 	} else {
		dados_duplicata.imp = 0;
		dados_duplicata.id_duplicata = dg_carne.selectedItem.id_parcela;
		
		remote.atualizar_impcarne(dados_duplicata,statementResult);
 	}
	
}

public function select_allimpcarne():void{
	dados_duplicata = new Fin_duplicataVO();
	dados_duplicata.imp = 1;
	dados_duplicata.id_contrato = parseInt(txtid_contrato.text);
	dados_duplicata.id_tiporec = 2;
	
	remote.atualizar_allimpcarne(dados_duplicata,statementResult);
}
public function unselect_allimpcarne():void{
	dados_duplicata = new Fin_duplicataVO();
	dados_duplicata.imp = 0;
	dados_duplicata.id_contrato = parseInt(txtid_contrato.text);
	dados_duplicata.id_tiporec = 2;
	
	remote.atualizar_allimpcarne(dados_duplicata,statementResult);
}

// abre pop up pesquisa                
private function openpesquisa():void{
	pesquisatitlewindow = PopUpManager.createPopUp(this,frm_pesquisa,true) as frm_pesquisa;
	PopUpManager.centerPopUp(pesquisatitlewindow);
	
	pesquisatitlewindow.title = "Pesquisa Contrato";
	pesquisatitlewindow.tablename = "adm_contrato";
    	
	
	pesquisatitlewindow["list_data_grid"].addEventListener(MouseEvent.DOUBLE_CLICK,closePopUpWindow);
	
}

private function closePopUpWindow(evt:Event):void {
	txtid_contrato.text = String(pesquisatitlewindow.list_data_grid.selectedItem.id_contrato);
	txtid_aluno.text = String(pesquisatitlewindow.list_data_grid.selectedItem.id_aluno);
	txt_nmaluno.text = String(pesquisatitlewindow.list_data_grid.selectedItem.nome);	
	
    PopUpManager.removePopUp(pesquisatitlewindow);
}                
