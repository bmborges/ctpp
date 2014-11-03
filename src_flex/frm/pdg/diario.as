// ActionScript file
import classes.Util;

import flash.events.Event;
import flash.events.MouseEvent;

import frm.frm_pesquisar;
import frm.pdg.frm_imparquivo;

import mx.collections.ArrayCollection;
import mx.controls.Button;
import mx.managers.PopUpManager;
import mx.rpc.events.ResultEvent;

import service.ComboBoxService;
import service.ReportService;
import service.crs.Crs_AvaliacaoService;
import service.pdg.Pdg_DiarioContService;
import service.pdg.Pdg_DiarioFaltasService;
import service.pdg.Pdg_DiarioNotasService;
import service.pdg.Pdg_DiarioService;
import service.pdg.Pdg_Diario_MediaService;
import service.pdg.View_Pdg_Diario_ContService;
import service.pdg.View_Pdg_Diario_NotasService;
import service.view.View_Pdg_Diario_FaltasService;

import spark.components.supportClasses.ItemRenderer;

import vo.adm.SystemVO;
import vo.pdg.Pdg_DiarioContVO;
import vo.pdg.Pdg_DiarioFaltasVO;
import vo.pdg.Pdg_DiarioNotasVO;
import vo.pdg.Pdg_DiarioVO;
import vo.procedure.Pdg_Diario_MediaVO;
import vo.pdg.View_Pdg_Diario_ContVO;
import vo.view.View_Pdg_Diario_FaltasVO;
import vo.view.View_Pdg_Diario_NotasVO;

private var systemvo:SystemVO = SystemVO.getInstance();
private var combobox:ComboBoxService = ComboBoxService.getInstance();

private var ro_report:ReportService = ReportService.getInstance();
private var ro_diario:Pdg_DiarioService = Pdg_DiarioService.getInstance();
private var ro_diariomedia:Pdg_Diario_MediaService = Pdg_Diario_MediaService.getInstance();
private var ro_diariocont:Pdg_DiarioContService = Pdg_DiarioContService.getInstance();
private var ro_viewdiariocont:View_Pdg_Diario_ContService = View_Pdg_Diario_ContService.getInstance();
private var ro_viewdiariofalta:View_Pdg_Diario_FaltasService = View_Pdg_Diario_FaltasService.getInstance();
private var ro_viewdiarionotas:View_Pdg_Diario_NotasService = View_Pdg_Diario_NotasService.getInstance();
private var ro_diariofaltas:Pdg_DiarioFaltasService = Pdg_DiarioFaltasService.getInstance();
private var ro_avaliacao:Crs_AvaliacaoService = Crs_AvaliacaoService.getInstance();
private var ro_diarionota:Pdg_DiarioNotasService = Pdg_DiarioNotasService.getInstance();


private var pesquisatitlewindow:frm_pesquisar;
private var imparquivowindow:frm_imparquivo;
private var retorno:UtilRetornoBanco;

private var bt_calcularnotas:Button = new Button();
private var bt_fechadiario:Button = new Button();


[Bindable] private var view_diariocontVO:View_Pdg_Diario_ContVO;
[Bindable] private var pdg_diariocontVO:Pdg_DiarioContVO;
[Bindable] private var pdg_diarioVO:Pdg_DiarioVO;
private var view_diariofaltasVO:View_Pdg_Diario_FaltasVO;
private var pdg_diariomediaVO:Pdg_Diario_MediaVO;
private var pdg_diariofaltasVO:Pdg_DiarioFaltasVO;
private var view_pdg_diarionotasVO:View_Pdg_Diario_NotasVO;


[Bindable] private var isValid:Boolean = false;
[Bindable] private var qtde_ativ:int = 0;
[Bindable] public var ArrayStatus:ArrayCollection;
[Bindable] public var ArrayAvaliacao:ArrayCollection;
private var util:Util = new Util();
public var columns:Array = new Array();
private var vScroll:int;
private var dg_rowindex:int;
private var dg_columnindex:int;
import mx.events.DataGridEvent;
import mx.controls.Alert;
import mx.controls.TextInput;
import mx.events.DataGridEventReason;
import classes.UtilMensagens;
import mx.events.IndexChangedEvent;
import mx.controls.dataGridClasses.DataGridColumn;
import flash.events.DataEvent;
import mx.events.FlexEvent;
import mx.core.mx_internal;
import mx.events.CloseEvent;
import flexmdi.events.MDIWindowEvent;
import flashx.textLayout.formats.Float;
import mx.events.ListEvent;
import classes.UtilPermissaoPrograma;
import classes.UtilNamesPesquisa;
import mx.core.FlexGlobals;
import mx.rpc.events.FaultEvent;
import classes.UtilRetornoBanco;
import mx.controls.DateField;
import mx.controls.ComboBox;


protected function mdiwindow1_closeHandler(event:MDIWindowEvent):void
{
	if (txtid_diario.text.length > 0){
		pdg_diarioVO = new Pdg_DiarioVO;
		pdg_diarioVO.id_diario =  txtid_diario.text;
		pdg_diarioVO.editando = 2;
		
		ro_diario.atualizar2(pdg_diarioVO,closeResult,defaultFaultHandler);
	}
	
}
private function closeResult(e:ResultEvent):void{
		pdg_diariomediaVO = new Pdg_Diario_MediaVO();
		pdg_diariomediaVO.id_diario = txtid_diario.text;
		
		ro_diariomedia.Procedure(pdg_diariomediaVO,pdg_diario_mediaResult_sair,defaultFaultHandler);
}
protected function lf_datacont(item:Object, column:DataGridColumn):String{
	return util.formatData_DDMMYYYY(item.data);
}
protected function lf_datafalta(item:Object, column:DataGridColumn):String{
	return util.formatData_DDMMYYYY(item.dt_aula);
}
protected function lf_avaliacao(item:Object, column:DataGridColumn):String
{
	var retorno:Object = util.selecionarCombobox(item.id_avaliacao,ArrayAvaliacao);
	if (retorno == null){
		return "";	
	}
	return retorno.label;
}
private function createArrayAvaliacao(event:ResultEvent):void{
	ArrayAvaliacao = event.result as ArrayCollection;
}
private function pdg_diario_mediaResult_sair(e:ResultEvent):void{
	this.enabled = true;
	util.limpar_formulario(form_diario);
	util.limpar_formulario(form_professor);
	
	dg_diario.dataProvider = null;
	dg_atividades.dataProvider = null;
	
	mensagem.text = ''
}
private function initButtons():void{
	ctrlbar.removeAllChildren();
	ctrlbar.enabled = true;
	if (tbnavigator.selectedIndex == 0){
		
		ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,1);
		ctrlbar.addChildAt(ctrlbar.bt_imprime,2);
		ctrlbar.addChildAt(bt_calcularnotas,3);
		bt_calcularnotas.label = "Calcular Notas";
		bt_calcularnotas.styleName="searchButton";
		
		if (util.localizaPermissao(UtilPermissaoPrograma.Diario_EncerrarDiario)){
			ctrlbar.addChildAt(bt_fechadiario,4);
			bt_fechadiario.label = "Fechar Diário";
			bt_fechadiario.styleName="searchButton";
			if (cb_diariostatus.selectedItem.data == 2){
				bt_fechadiario.label = "Reabrir Diário";
			}
		}
		
	} else if (tbnavigator.selectedIndex == 1){
		ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
		ctrlbar.addChildAt(ctrlbar.bt_inserir,1);
		ctrlbar.addChildAt(ctrlbar.bt_alterar,2);
		ctrlbar.addChildAt(ctrlbar.bt_excluir,3);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,4);
		
		
	} else if (tbnavigator.selectedIndex == 2){
		
		var i:int = 0;
		//permissao para inserir data 
		if (util.localizaPermissao(UtilPermissaoPrograma.Diario_InserirData)){
			ctrlbar.addChildAt(ctrlbar.bt_inserir,i);
			i = i + 1;
		}
		
		//permissao para alterar data 
		if (util.localizaPermissao(UtilPermissaoPrograma.Diario_AlterarData) || util.localizaPermissao(UtilPermissaoPrograma.Diario_InserirData) ){
			txtdtaula.enabled = true;
		} else {
			txtdtaula.enabled = false;
		}
		
		ctrlbar.addChildAt(ctrlbar.bt_alterar,i);
//		ctrlbar.bt_alterar.label = "Gravar";
		i = i + 1;
		
		if (util.localizaPermissao(UtilPermissaoPrograma.Diario_DeletarData)){
			ctrlbar.addChildAt(ctrlbar.bt_excluir,i);
			i = i + 1;
		}
		
		ctrlbar.addChildAt(ctrlbar.bt_limpar,i);
		
	} else if (tbnavigator.selectedIndex == 3){

		ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,1);
		
	}
	

	
}
public function init():void{
	
	this.width = FlexGlobals.topLevelApplication.mdiCanvas.width;
	this.height = FlexGlobals.topLevelApplication.mdiCanvas.height;
	
	this.x = 0;
	this.y = 0;
	
	
	ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK,select);
	ctrlbar.bt_inserir.addEventListener(MouseEvent.CLICK,inserir);
	ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,alterar);
	ctrlbar.bt_excluir.addEventListener(MouseEvent.CLICK,deletar);
	ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
	bt_calcularnotas.addEventListener(MouseEvent.CLICK,pdg_diario_media);
	bt_fechadiario.addEventListener(MouseEvent.CLICK,pdg_diario_fechadiario);
	ctrlbar.bt_imprime.addEventListener(MouseEvent.CLICK,imprime);
	
	combobox.Pdg_DiarioStatus(createcombox_diariostatus,defaultFaultHandler);
	
	initButtons();
}

private function pdg_diario_fechadiario(e:Event):void{
	this.enabled = false;
	pdg_diarioVO = new Pdg_DiarioVO;
	pdg_diarioVO.id_diario = parseInt(txtid_diario.text);
	if (cb_diariostatus.selectedItem.data == 1){
		pdg_diarioVO.id_status = 2;
	} else {
		pdg_diarioVO.id_status = 1;
	}
	
	ro_diario.atualizar_status(pdg_diarioVO,FechaDiarioResult,defaultFaultHandler);
}
private function FechaDiarioResult(e:ResultEvent):void{
	cb_diariostatus.selectedItem = util.selecionarCombobox(parseInt(e.result.toString()),ArrayStatus);
	
	tbnavigator.selectedIndex = 0;
	
	
	pdg_diariomediaVO = new Pdg_Diario_MediaVO();
	pdg_diariomediaVO.id_diario = txtid_diario.text;
	
	ro_diariomedia.Procedure(pdg_diariomediaVO,pdg_diario_mediaResult_sair,defaultFaultHandler);

}
protected function tabnav_changeHandler(e:IndexChangedEvent):void{
	this.enabled = false;
	vScroll = 0;
	var i:int = 0;
	var Index:int=e.newIndex;
	initButtons();
	if (Index == 0) {
		select(e);
	} else if (Index == 1){
		select(e);
	} else if (Index == 2){
		select(e);
	} else if (Index == 3){
		
		var query:String = "select  distinct 1 as data, to_char(data,'dd/mm/yyyy') as label, data" +
			" from pdg_diariocont dc" +
			" where id_diario = ? order by dc.data";
		
		combobox.ComboBoxQuery(query,parseInt(txtid_diario.text),createcombox_dtaula,defaultFaultHandler);
		
		query = "select distinct a.id_aluno as data, nome as label	from pdg_diariofaltas df" +
			"		inner join pdg_diario using (id_diario)" +
			"		inner join crs_turmaedu te using (id_turmaedu)" +
			"		left join crs_turma t using (id_turma)" +
			"		left join ctr_contrato c on (t.id_turma = c.id_turma and c.id_aluno = df.id_aluno)" +
			"		inner join adm_operador o on (o.id_operador = te.id_operador)" +
			"		inner join alu_aluno a on (a.id_aluno = df.id_aluno)" +
			"		where id_diario = ? and id_ctrstatus != 9" +
			"		order by nome";
		
		combobox.ComboBoxQuery(query,parseInt(txtid_diario.text),createcombox_aluno,defaultFaultHandler);
		dg_faltas.dataProvider = null;
		this.enabled = true;
	} else if (Index == 4){
		isValid = util.validateForm(form_diario);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			tb_graficos.selectedIndex = 0;
			ro_diario.GraficoFaltaDiario(parseInt(txtid_diario.text),GraficoFaltaResult,defaultFaultHandler);
		}
	}

}
private function tb_graficosChange(e:IndexChangedEvent):void{
	this.enabled = false;
	if(tb_graficos.selectedIndex == 0){
		ro_diario.GraficoFaltaDiario(parseInt(txtid_diario.text),GraficoFaltaResult,defaultFaultHandler);
	} else if (tb_graficos.selectedIndex == 1){
		ro_diario.GraficoNotaDiario(parseInt(txtid_diario.text),GraficoNotaResult,defaultFaultHandler);
	}
}
private function GraficoNotaResult(e:ResultEvent):void{
	this.enabled = true;
	graficonotas.dataProvider = e.result;
}
private function GraficoFaltaResult(e:ResultEvent):void{
	this.enabled = true;
	graficofalta.dataProvider = e.result;
}
private function trim( s:String ):String
{
	return s.replace( /^([\s|\t|\n]+)?(.*)([\s|\t|\n]+)?$/gm, "$2" );
}
protected function dg_diario_itemFocusOutHandler(event:DataGridEvent):void
{
	vScroll = dg_diario.verticalScrollPosition;
	dg_rowindex	= event.rowIndex;
	dg_columnindex = event.columnIndex;
	// TODO Auto-generated method stub
	if (event.reason == DataGridEventReason.CANCELLED){
		// Do not update cell.
		return;
	}
	var campo:String;
	
	if (event.columnIndex == 1){
		campo = "nota1";
	} else if (event.columnIndex == 2){
		campo = "nota2";
	} else if (event.columnIndex == 4){
		campo = "nota_recup";
	} else if (event.columnIndex == 5){
		campo = "nota_cons";
	}
	// Get the cell editor and cast it to TextInput.
	var newVal:String = TextInput(event.currentTarget.itemEditorInstance).text;
	
	newVal = newVal.replace(",",".");
	
	if(parseFloat(trim(newVal)) < 0 || parseFloat(trim(newVal)) > 100) {
		// Prevent the user from removing focus, 
		// and leave the cell editor open.
		event.preventDefault();
		// Write a message to the errorString property. 
		// This message appears when the user 
		// mouses over the editor.
		TextInput(dg_diario.itemEditorInstance).errorString=
			"Defina uma nota entre 0 a 100";
		return;
	}
	
	if (trim(newVal).length > 0){
		ro_diario.update_diarionotas(parseInt(dg_diario.selectedItem.id_diarionotas),campo,newVal,update_diarionotasResult,defaultFaultHandler);
	} else {
		ro_diario.update_diarionotas(parseInt(dg_diario.selectedItem.id_diarionotas),campo,'null',update_diarionotasResult,defaultFaultHandler);
	}
	
	
	// Get the old value.
	//		var oldVal:String = 
	//			event.currentTarget.editedItemRenderer.data[event.dataField]; 
	
	
	// Write out the cell coordinates, new value, 
	//		// and old value to the TextArea control.
	//		cellInfo.text = "cell edited.\n";
	//		cellInfo.text += "Row, column: " + event.rowIndex + ", " + 
	//			event.columnIndex + "\n";
	//		cellInfo.text += "New value: " + newVal + "\n";
	//		cellInfo.text += "Old value: " + oldVal;
}
protected function dg_faltas_itemFocusOutHandler(event:DataGridEvent):void
{
	vScroll = dg_faltas.verticalScrollPosition;
	dg_rowindex	= event.rowIndex;
	dg_columnindex = event.columnIndex;
	// TODO Auto-generated method stub
	if (event.reason == DataGridEventReason.CANCELLED){
		// Do not update cell.
		return;
	}
	// Get the cell editor and cast it to TextInput.
	var newVal:String = TextInput(event.currentTarget.itemEditorInstance).text;
	
	
	if (event.columnIndex == 4){
		pdg_diariofaltasVO = new Pdg_DiarioFaltasVO();
		pdg_diariofaltasVO.id_diariofaltas = dg_faltas.selectedItem.id_diariofaltas;
		pdg_diariofaltasVO.justificativa = trim(newVal).length <= 0 ? null : newVal;
	}
	
	ro_diariofaltas.atualizar(pdg_diariofaltasVO,null,defaultFaultHandler);
}
protected function dg_atividades_itemFocusOutHandler(event:DataGridEvent):void
{
	// TODO Auto-generated method stub
	if (event.reason == DataGridEventReason.CANCELLED){
		// Do not update cell.
		return;
	}
	var campo:String;
	if (event.columnIndex == 1){
		campo = "1";
	} else if (event.columnIndex == 2){
		campo = "2";
	} else if (event.columnIndex == 3){
		campo = "3";
	} else if (event.columnIndex == 4){
		campo = "4";
	} else if (event.columnIndex == 5){
		campo = "5";
	} else if (event.columnIndex == 6){
		campo = "6";
	} else if (event.columnIndex == 7){
		campo = "7";
	} else if (event.columnIndex == 8){
		campo = "8";
	} else if (event.columnIndex == 9){
		campo = "9";
	} else if (event.columnIndex == 10){
		campo = "10";
	}
	// Get the cell editor and cast it to TextInput.
	var newVal:String = TextInput(event.currentTarget.itemEditorInstance).text;
	newVal = newVal.replace(",",".");
	if(parseFloat(trim(newVal)) < 0 || parseFloat(trim(newVal)) > 100) {
		// Prevent the user from removing focus, 
		// and leave the cell editor open.
		event.preventDefault();
		// Write a message to the errorString property. 
		// This message appears when the user 
		// mouses over the editor.
		TextInput(dg_atividades.itemEditorInstance).errorString=
			"Defina uma nota entre 0 a 100";
		return;
	}
	if(event.columnIndex != 0){
		if (trim(newVal).length > 0){
			ro_diario.update_diarioatividades(parseInt(dg_atividades.selectedItem.id_diarionotas),campo,newVal,update_diarioatividadesResult,defaultFaultHandler);
		} else {
			ro_diario.update_diarioatividades(parseInt(dg_atividades.selectedItem.id_diarionotas),campo,'null',update_diarioatividadesResult,defaultFaultHandler);
		}
	}
}
private function update_diarioatividadesResult(e:ResultEvent):void{
	//	pdg_diario_media();	
}
private function update_diarionotasResult(e:ResultEvent):void{
	//	pdg_diario_media();	
}
private function pdg_diario_media(e:Event):void{
	vScroll = dg_diario.verticalScrollPosition;
	
	
	pdg_diariomediaVO = new Pdg_Diario_MediaVO();
	pdg_diariomediaVO.id_diario = txtid_diario.text;
	
	ro_diariomedia.Procedure(pdg_diariomediaVO,createDataGrid,defaultFaultHandler);
}

private function select_cabecalho_atividadesResult(e:ResultEvent):void{
	columns.push(getColumn("nome", "Aluno"));
	var retorno:ArrayCollection = e.result as ArrayCollection;
	
	if (qtde_ativ >=1) {
		columns.push(getColumn("atividade1", retorno[0]['dtatividade1']));
	}
	if (qtde_ativ >= 2) {
		columns.push(getColumn("atividade2", retorno[0]['dtatividade2']));
	}
	if (qtde_ativ >= 3) {
		columns.push(getColumn("atividade3", retorno[0]['dtatividade3']));
	}
	if (qtde_ativ >= 4) {
		columns.push(getColumn("atividade4", retorno[0]['dtatividade4']));
	}
	if (qtde_ativ >= 5) {
		columns.push(getColumn("atividade5", retorno[0]['dtatividade5']));
	}
	if (qtde_ativ >= 6) {
		columns.push(getColumn("atividade6", retorno[0]['dtatividade6']));
	}
	if (qtde_ativ >= 7) {
		columns.push(getColumn("atividade7", retorno[0]['dtatividade7']));
	}
	if (qtde_ativ >= 8) {
		columns.push(getColumn("atividade8", retorno[0]['dtatividade8']));
	}
	if (qtde_ativ >= 9) {
		columns.push(getColumn("atividade9", retorno[0]['dtatividade9']));
	}
	if (qtde_ativ >= 10) {
		columns.push(getColumn("atividade10", retorno[0]['dtatividade10']));
	}
	dg_atividades.columns = columns;
	
	ro_diario.select_diarioatividades(parseInt(txtid_diario.text),createDataGrid,defaultFaultHandler);
	
	
}
private function getColumn(dataField:String, headerText:String):DataGridColumn
{
	var column:DataGridColumn = new DataGridColumn(dataField);
	column.headerText = headerText;
	return column;
}
private function select(e:Event):void{
	if (tbnavigator.selectedIndex == 0){
		//		notas
		isValid = util.validateForm(form_diario);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			mensagem.text = null;
			
			pdg_diarioVO = new Pdg_DiarioVO;
			pdg_diarioVO.id_diario = txtid_diario.text;
			
			ro_diario.select(pdg_diarioVO,selectResult,defaultFaultHandler);
			
		}
	} else if (tbnavigator.selectedIndex == 1){
		//		atividade
		isValid = util.validateForm(form_diario);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			mensagem.text = null;
			columns = new Array();
			dg_atividades.columns = new Array();
			ro_diario.select_diarioatividades_qtd_ativi(parseInt(txtid_diario.text), select_diarioatividades_qtd_ativiResult,defaultFaultHandler);
			
		}
	} else if (tbnavigator.selectedIndex == 2){
		//		conteudo
		isValid = util.validateForm(form_diario);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			mensagem.text = null;
			
			view_diariocontVO = new View_Pdg_Diario_ContVO();
			view_diariocontVO.id_diario = txtid_diario.text;
			
			ro_viewdiariocont.select(view_diariocontVO, createDataGrid,defaultFaultHandler);
			dg_conteudo.verticalScrollPosition = vScroll;
		}
	} else if (tbnavigator.selectedIndex == 3){
		//		faltas
		isValid = util.validateForm(form_diario);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			this.enabled = false;
			mensagem.text = null;
			
			view_diariofaltasVO = new View_Pdg_Diario_FaltasVO();
			view_diariofaltasVO.id_diario = txtid_diario.text;
			
			if (cb_dtaula.selectedIndex != 0 && !cb_aluno.selectedIndex != 0){
				
				view_diariofaltasVO.dt_aula = DateField.stringToDate(cb_dtaula.selectedItem.label,"DD-MM-YYYY");
				
				ro_viewdiariofalta.select(view_diariofaltasVO,createDataGrid,defaultFaultHandler);
//				ro_diario.select_diariofaltas(parseInt(txtid_diario.text),cb_dtaula.selectedItem.data,0,createDataGrid,defaultFaultHandler);
			} else if (cb_aluno.selectedIndex != 0){
				
				view_diariofaltasVO.id_aluno = cb_aluno.selectedItem.data;
				
				ro_viewdiariofalta.select(view_diariofaltasVO,createDataGrid,defaultFaultHandler);
//				ro_diario.select_diariofaltas(parseInt(txtid_diario.text),"",cb_aluno.selectedItem.data,createDataGrid,defaultFaultHandler);
			} else {
				mensagem.text = "Selecione uma data ou um aluno";
			}
		}
	}
}
private function selectResult(e:ResultEvent):void{
	if (tbnavigator.selectedIndex == 0){
		var result:ArrayCollection = e.result as ArrayCollection;
		
		if (result[0]['editando'] == 1) {
			pdg_diariomediaVO = new Pdg_Diario_MediaVO();
			pdg_diariomediaVO.id_diario = txtid_diario.text;
			ro_diariomedia.Procedure(pdg_diariomediaVO,diariomediaResult,defaultFaultHandler);
		} else {
			view_pdg_diarionotasVO = new View_Pdg_Diario_NotasVO;
			view_pdg_diarionotasVO.id_diario = txtid_diario.text;
			ro_viewdiarionotas.select(view_pdg_diarionotasVO,createDataGrid,defaultFaultHandler);
		}

	}
	
}
private function diariomediaResult(e:ResultEvent):void{
	select(e);
}
//resultado select diario atividades 
private function select_diarioatividades_qtd_ativiResult(e:ResultEvent):void{
	qtde_ativ = parseInt(e.result.toString());
	ro_diario.select_cabecalho_atividades(parseInt(txtid_diario.text),select_cabecalho_atividadesResult,defaultFaultHandler);
}
//resultados select
//private function select_diariofaltasResult(e:ResultEvent):void{
//	dg_faltas.dataProvider = e.result;
//}
private function createcombox_diariostatus(event:ResultEvent):void{
	ArrayStatus = event.result as ArrayCollection;
	cb_diariostatus.dataProvider = ArrayStatus;
	cb_diariostatus.selectedIndex = 0;
}
private function createcombox_dtaula(event:ResultEvent):void{
	cb_dtaula.dataProvider = event.result as ArrayCollection;
	cb_dtaula.selectedIndex = 0;
}
private function createcombox_aluno(event:ResultEvent):void{
	cb_aluno.dataProvider = event.result as ArrayCollection;
	cb_aluno.selectedIndex = 0;
}

private function createDataGrid(e:ResultEvent):void{
	this.enabled = true;
	ctrlbar.enabled = true;
	if(tbnavigator.selectedIndex == 0){
		if (this.currentState == "nota") {
			dg_diario.dataProvider = e.result;
			dg_diario.verticalScrollPosition = vScroll;
		} else {
			dg_avaliacao.dataProvider = e.result;
			dg_avaliacao.verticalScrollPosition = vScroll;
		}
	} else if (tbnavigator.selectedIndex == 1){
		dg_atividades.dataProvider = e.result;
		if (cb_diariostatus.selectedItem.data == 2){
			ctrlbar.enabled = false;
		}
	} else if (tbnavigator.selectedIndex == 2){
		dg_conteudo.dataProvider = e.result;
		dg_conteudo.verticalScrollPosition = vScroll;
		if (cb_diariostatus.selectedItem.data == 2){
			ctrlbar.enabled = false;
			bt_envarquivo.enabled = false;
		}
	} else if (tbnavigator.selectedIndex == 3){
		dg_faltas.dataProvider = e.result;
		dg_faltas.verticalScrollPosition = vScroll;
		if (cb_diariostatus.selectedItem.data == 2){
			ctrlbar.enabled = false;
		}
	}
}
private function inserir(e:Event):void{
	if (tbnavigator.selectedIndex == 0){
	} else if (tbnavigator.selectedIndex == 1){
		isValid = util.validateForm(form_atividades);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			mensagem.text = null;
			columns = new Array();
			dg_atividades.columns = new Array();
			ro_diario.pdg_cria_atividades(parseInt(txtid_diario.text),txtdescricao.text.toUpperCase(),txtdata.text,inserirResult,defaultFaultHandler);
		}
	} else if (tbnavigator.selectedIndex == 2){
		
		formi_conteudo.required = false;
		
		isValid = util.validateForm(form_conteudo);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			mensagem.text = null;
			popula_diariocont();
			vScroll = dg_conteudo.verticalScrollPosition;
			ro_diariocont.inserir(pdg_diariocontVO,inserirResult,defaultFaultHandler);
			
		}
	}
}

private function inserirResult(e:ResultEvent):void{
	if (tbnavigator.selectedIndex == 0){
	} else if (tbnavigator.selectedIndex == 1){
		limpar(e);
		ro_diario.select_diarioatividades_qtd_ativi(parseInt(txtid_diario.text), select_diarioatividades_qtd_ativiResult,defaultFaultHandler);		
	} else if (tbnavigator.selectedIndex == 2){
		mensagem.text = UtilMensagens.OperacaoRealizadaSucesso;
		select(e);
		//		ro_diario.pdg_diario_falta(parseInt(txtid_diario.text),txtdtaula.text,createDataGrid,defaultFaultHandler);
	}
}

private function deletar(e:Event):void{
	if (tbnavigator.selectedIndex == 0){
	} else if (tbnavigator.selectedIndex == 1){
		isValid = util.validateForm(form_atividades);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			ro_diario.deleta_diarioatividades(parseInt(txtid_diario.text),parseInt(txtid_atividade.text),deletarResult,defaultFaultHandler);	
		}
	} else if (tbnavigator.selectedIndex == 2){
		formi_conteudo.required = false;
		isValid = util.validateForm(form_conteudo);
		if (!isValid){
			mensagem.text = UtilMensagens.SelecioneUmRegistro;
		} else {
			vScroll = dg_conteudo.verticalScrollPosition;
			popula_diariocont();
			ro_diariocont.deletar(pdg_diariocontVO,deletarResult,defaultFaultHandler);
		}
	} else if (tbnavigator.selectedIndex == 3){
	}
}

private function deletarResult(e:ResultEvent):void{
	if (tbnavigator.selectedIndex == 0){
	} else if (tbnavigator.selectedIndex == 1){
		util.limpar_formulario(form_atividades);
		columns = new Array();
		dg_atividades.columns = new Array();
		ro_diario.select_diarioatividades_qtd_ativi(parseInt(txtid_diario.text), select_diarioatividades_qtd_ativiResult,defaultFaultHandler);
	} else if (tbnavigator.selectedIndex == 2){
		formi_conteudo.required = true;
		mensagem.text = UtilMensagens.OperacaoRealizadaSucesso;
		select(e);
	} else if (tbnavigator.selectedIndex == 3){
	}
}

private function alterar(e:Event):void{
	if (tbnavigator.selectedIndex == 0){
	} else if (tbnavigator.selectedIndex == 1){
	} else if (tbnavigator.selectedIndex == 2){
		formi_conteudo.required = true;
		isValid = util.validateForm(form_conteudo);
		if (!isValid){
			mensagem.text = UtilMensagens.PreenchaCampo;
		} else {
			vScroll = dg_conteudo.verticalScrollPosition;
			popula_diariocont();
			ro_diariocont.atualizar(pdg_diariocontVO,alterarResult,defaultFaultHandler);
		}
	} else if (tbnavigator.selectedIndex == 3){
	}
}
private function alterarResult(e:ResultEvent):void{
	if (tbnavigator.selectedIndex == 0){
	} else if (tbnavigator.selectedIndex == 1){
	} else if (tbnavigator.selectedIndex == 2){
		select(e);
	} else if (tbnavigator.selectedIndex == 3){
	}
}

// abre pop up pesquisa                
private function openpesquisa():void{
	pesquisatitlewindow = PopUpManager.createPopUp(this,frm_pesquisar,true) as frm_pesquisar;
	PopUpManager.centerPopUp(pesquisatitlewindow);
	
	var X:Number = pesquisatitlewindow.width / 2;
	var Y:Number = pesquisatitlewindow.height / 2;
	
	var newX:Number = FlexGlobals.topLevelApplication.mdiCanvas.width / 2;
	var newY:Number = FlexGlobals.topLevelApplication.mdiCanvas.height / 2;
	
	pesquisatitlewindow.x = newX - X;
	pesquisatitlewindow.y = newY - Y;
	
	pesquisatitlewindow["list_data_grid"].addEventListener(MouseEvent.DOUBLE_CLICK,closePopUpWindow);
	
	pesquisatitlewindow.title = "Selecionar um Diário";
	pesquisatitlewindow.tablename = UtilNamesPesquisa.pdg_diario;
	
	if (util.localizaPermissao(UtilPermissaoPrograma.Diario_PesquisarTodosDiarios)){
		pesquisatitlewindow.currentState = "com_pesquisa";
	} else {
		pesquisatitlewindow.currentState = "sem_pesquisa";
	}	
}

private function closePopUpWindow(evt:Event):void {
	txtid_diario.text = String(pesquisatitlewindow.list_data_grid.selectedItem.id_diario);
	txt_nmturma.text = String(pesquisatitlewindow.list_data_grid.selectedItem.nmturma);	
	txt_nmoperador.text = String(pesquisatitlewindow.list_data_grid.selectedItem.nmoperador);
	txt_nmmateria.text = String(pesquisatitlewindow.list_data_grid.selectedItem.nmmateria);
	cb_diariostatus.selectedItem = util.selecionarCombobox(pesquisatitlewindow.list_data_grid.selectedItem.id_status,ArrayStatus);
	txt_dtinicio.text = util.formatData_DDMMYYYY(pesquisatitlewindow.list_data_grid.selectedItem.dt_inicio);
	
	if (cb_diariostatus.selectedItem.data == 2){
		//? 'Encerrar Diário' : 'Reabrir Diário'  )
		dg_diario.editable = false;
		bt_fechadiario.label = "Reabrir Diário";
		
	} else {
		dg_diario.editable = true;
		bt_fechadiario.label = "Fechar Diário";
	}
	
		tbnavigator.selectedIndex = 0;
		
	if (pesquisatitlewindow.list_data_grid.selectedItem.id_tipoavaliacao > 0){
		bt_calcularnotas.enabled = false;
		cnv_atividade.enabled = false;
		cnv_conteudo.enabled = false;
		cnv_faltas.enabled = false;
		cnv_graficos.enabled = false;
		this.currentState = "avaliacao";
		
		ro_avaliacao.ComboBoxAvaliacaoTipo(pesquisatitlewindow.list_data_grid.selectedItem.id_tipoavaliacao,createArrayAvaliacao,defaultFaultHandler);
	
	} else {
		bt_calcularnotas.enabled = true;
		cnv_atividade.enabled = true;
		cnv_conteudo.enabled = true;
		cnv_faltas.enabled = true;
		cnv_graficos.enabled = true;
		this.currentState = "nota";

		
	}
	
	select(evt);	
	
	PopUpManager.removePopUp(pesquisatitlewindow);
	
}
public function limpar(e:Event):void{
	if (tbnavigator.selectedIndex == 0){
		if(txtid_diario.text.length > 0){
			pdg_diariomediaVO = new Pdg_Diario_MediaVO();
			pdg_diariomediaVO.id_diario = txtid_diario.text;
		
			ro_diariomedia.Procedure(pdg_diariomediaVO,pdg_diario_mediaResult_sair,defaultFaultHandler);
		}
		util.limpar_formulario(form_diario);
		util.limpar_formulario(form_professor);
		dg_diario.dataProvider = null;
		mensagem.text = null;
		columns = new Array();
		util.limpar_formulario(form_atividades);
		cb_diariostatus.selectedIndex = 0;
		mensagem.text = null;
		util.limpar_formulario(form_conteudo);
		dg_faltas.dataProvider = null;
		util.limpar_formulario(form_faltas);
		
	} else if (tbnavigator.selectedIndex == 1){
		mensagem.text = null;
		columns = new Array();
		util.limpar_formulario(form_atividades);
		cb_diariostatus.selectedIndex = 0;
	}else if (tbnavigator.selectedIndex == 2){
		mensagem.text = null;
		util.limpar_formulario(form_conteudo);
	} else if (tbnavigator.selectedIndex == 3){
		mensagem.text = null;
		dg_faltas.dataProvider = null;
		util.limpar_formulario(form_faltas);
	}
}
private function changeStyles(data:Object, column:DataGridColumn):Object
{
	var o:Object = new Object();
	
	o.color = data[column.dataField];
	
	return o;
}
private function situacao_labelFunction(data:Object, column:DataGridColumn):String
{
	var value:String = data["nmsituacao"];
	return value;
}

protected function dg_atividades_headerReleaseHandler(event:DataGridEvent):void
{
	event.preventDefault();
	if (event.columnIndex != 0){
		ro_diario.select_diarioatividades2(parseInt(txtid_diario.text),event.columnIndex,diarioatividades2Result,defaultFaultHandler);
	}
}
private function diarioatividades2Result(e:ResultEvent):void{
	var retorno:ArrayCollection = e.result as ArrayCollection
	
	txtdata.text = retorno[0]['data'];
	txtdescricao.text = retorno[0]['descricao'];
	txtid_atividade.text = retorno[0]['id_atividade'];
}
private function setcampos(e:Event):void{
	if (tbnavigator.selectedIndex == 2 ){
		txtid_diariocont.text = dg_conteudo.selectedItem.id_diariocont;
		txtdtaula.selectedDate = dg_conteudo.selectedItem.data;
		txtarea.text = dg_conteudo.selectedItem.descricao;
	}
}
// atualiza presenca
public function atualiza_presenca(data:Boolean):void{
	this.enabled = false;
	vScroll = dg_faltas.verticalScrollPosition;
	if (data == true){
		ro_diario.update_diariofaltas(dg_faltas.selectedItem.id_diariofaltas,1,select,defaultFaultHandler);
	} else {
		ro_diario.update_diariofaltas(dg_faltas.selectedItem.id_diariofaltas,2,select,defaultFaultHandler);
	}
}
public function popula_diariocont():void{
	pdg_diariocontVO = new Pdg_DiarioContVO();
	pdg_diariocontVO.data = txtdtaula.selectedDate ? txtdtaula.selectedDate : null;
	pdg_diariocontVO.descricao = txtarea.text.length <= 0 ? null : txtarea.text;
	pdg_diariocontVO.id_diario = parseInt(txtid_diario.text);
	pdg_diariocontVO.id_diariocont = txtid_diariocont.text.length <= 0 ? null : txtid_diariocont.text;
}

public function imprime(e:Event):void{
	
	isValid = util.validateForm(form_diario);
	if (!isValid){
		mensagem.text = UtilMensagens.PreenchaCampo;
	} else {
		this.enabled = false;
		mensagem.text = UtilMensagens.RelatorioGerando;
		var map:Object = new Object();
		map.id_diario = parseInt(txtid_diario.text);
		map.nmoperador = systemvo.nickname;
		ro_report.Report(map,"PDF","Rpt_DiarioNotas","pdg",imprimeResult,defaultFaultHandler);
	}
}
private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	mensagem.text = "";
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
}
public function imprimeResult(e:ResultEvent):void{
	this.enabled = true;
	mensagem.text = UtilMensagens.RelatorioGerado;
	util.abrepdf(e.result[0]['destinationUrl']);
}
// abre importa arquivo
private function open_imparquivo(e:Event):void{
	imparquivowindow = PopUpManager.createPopUp(this,frm_imparquivo,true) as frm_imparquivo;
	PopUpManager.centerPopUp(imparquivowindow);
	
	imparquivowindow.id_diariocont = parseInt(txtid_diariocont.text);
	imparquivowindow.addEventListener(CloseEvent.CLOSE,close_imparquivo);
	
}

private function close_imparquivo(e:Event):void {
	
	PopUpManager.removePopUp(imparquivowindow);
	select(e);
	
}
public function atualiza_avaliacao(id_diarionota:int,cb:ComboBox):void{
	this.enabled = false;
	vScroll = dg_avaliacao.verticalScrollPosition;
	
	var sql:String = "";
	var where:String = "";
	if (cb.selectedIndex > 0) {
		sql = "id_avaliacao = " + cb.selectedItem.data;
		
	} else {
		sql = "id_avaliacao = null";
	}
	where = "id_diarionotas = " + id_diarionota;
	ro_diarionota.SqlAtualizar(sql,where,null,defaultFaultHandler);
	
	pdg_diariomediaVO = new Pdg_Diario_MediaVO();
	pdg_diariomediaVO.id_diario = txtid_diario.text;
	
	ro_diariomedia.Procedure(pdg_diariomediaVO,createDataGrid,defaultFaultHandler);
	
}

