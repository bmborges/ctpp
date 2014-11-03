// ActionScript file
import classes.Util;
import classes.UtilMensagens;

import crud.fin.Fin_chequercbCRUD;
import crud.fin.Fin_duplicataCRUD;

import flash.events.Event;
import flash.events.MouseEvent;

import flexmdi.events.MDIWindowEvent;

import frm.fin.frmchequercb;
import frm.frm_pesquisa;

import mx.events.CloseEvent;
import mx.managers.PopUpManager;
import mx.rpc.events.ResultEvent;

import vo.SystemVO;
import vo.fin.Fin_chequercbVO;
import vo.fin.Fin_duplicataVO;



private var pesquisatitlewindow:frm_pesquisa;
private var chequercb:frmchequercb;
private var systemvo:SystemVO = SystemVO.getInstance();
private var util:Util = new Util();
private var ro_chequercb:Fin_chequercbCRUD = Fin_chequercbCRUD.getInstance();

[Bindable] private var fin_chequercbVO:Fin_chequercbVO = null;
[Bindable] private var isValid:Boolean = false;


private function init():void{
	bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
	bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
}

private function createdg(event:ResultEvent):void {
	dg_duplicata.dataProvider = event.result;
}

private function selecionar(e:Event):void{
	isValid = util.validateForm(form_contrato);
	if (!isValid){
		mensagem.text = UtilMensagens.PreenchaCampo;
	} else {
		ro_chequercb.selectTable_duplicata(parseInt(txtid_contrato.text),createdg);
	}
}

private function limpar(e:Event):void{
	dg_duplicata.dataProvider = null;
	util.limpar_formulario(form_contrato);
	mensagem.text = null;
	
}
private function vincheque(e:Event):void{
	chequercb = PopUpManager.createPopUp(this,frmchequercb,true) as frmchequercb;
	PopUpManager.centerPopUp(chequercb);
	
	chequercb.title = "Cadastro Cheque Duplicata (" + dg_duplicata.selectedItem.parcela + ") - Id. " + dg_duplicata.selectedItem.id_duplicata;
	chequercb.id_duplicata = dg_duplicata.selectedItem.id_duplicata;
	
	chequercb.addEventListener(MDIWindowEvent.CLOSE,closeVincheque);
}
private function closeVincheque(e:CloseEvent):void{
	ro_chequercb.selectTable_duplicata(parseInt(txtid_contrato.text),createdg);
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
	txtid_admaluno.text = String(pesquisatitlewindow.list_data_grid.selectedItem.id_aluno);
	txt_nmaluno.text = String(pesquisatitlewindow.list_data_grid.selectedItem.nome);	
	
	PopUpManager.removePopUp(pesquisatitlewindow);
} 