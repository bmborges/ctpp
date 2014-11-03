import classes.Util;
import classes.UtilMensagens;
import classes.UtilRetornoBanco;

import flash.events.Event;
import flash.events.IOErrorEvent;
import flash.events.MouseEvent;
import flash.events.ProgressEvent;
import flash.events.SecurityErrorEvent;
import flash.media.SoundChannel;
import flash.net.FileFilter;
import flash.net.FileReference;
import flash.net.FileReferenceList;
import flash.utils.ByteArray;

import frm.pdg.frm_msgarquivo;

import mx.collections.ArrayCollection;
import mx.controls.dataGridClasses.DataGridColumn;
import mx.core.FlexGlobals;
import mx.core.SoundAsset;
import mx.events.CloseEvent;
import mx.events.CollectionEvent;
import mx.events.IndexChangedEvent;
import mx.managers.PopUpManager;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;

import service.pdg.Pdg_DiarioArquivosService;

import vo.pdg.Pdg_DiarioArquivosVO;

[Embed(source="assets/audio/Ding.mp3")]
public var soundClass:Class;
public var snd:SoundAsset = new soundClass() as SoundAsset;
public var sndChannel:SoundChannel;

public var maxSize:int = 2048000;
// Set the default File Filters you wish to impose on the applicaton
public var documentTypes:FileFilter = new FileFilter("Arquivos (*.pdf)",("*.pdf"));

private var  _totalbytes:Number;

//File Filter vars
[Bindable]
private var _files:ArrayCollection;
private var _fileref:FileReferenceList;
private var _file:FileReference;
private var _filefilter:Array = new Array(documentTypes);

//DataGrid Columns
private var _nameColumn:DataGridColumn;
private var _typeColumn:DataGridColumn;
private var _sizeColumn:DataGridColumn;
private var _creationDate:DataGridColumn;
private var _modificationDate:DataGridColumn;
private var _progressColumn:DataGridColumn;
private var _columns:Array;
private var retorno:UtilRetornoBanco;


private var pdg_diarioarquivosVO:Pdg_DiarioArquivosVO;
private var ro_diarioarquivos:Pdg_DiarioArquivosService = Pdg_DiarioArquivosService.getInstance();
[Bindable] private var arquivo:ByteArray;
[Bindable] private var qtdeArquivo:int;
public var id_diariocont:int;
public var util:Util = new Util();
[Bindable] private var isValid:Boolean = false;


public function initButtons():void{
		ctrlbar.removeAllChildren();
	if(tb_nav.selectedIndex == 0){
		
		ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
		ctrlbar.addChildAt(ctrlbar.bt_alterar,1);
		ctrlbar.addChildAt(ctrlbar.bt_excluir,2);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,3);
		
		ctrlbar.bt_excluir.enabled = false;
		ctrlbar.bt_limpar.enabled = false;
		
		ctrlbar.bt_pesquisar.removeEventListener(MouseEvent.CLICK,selecionar);
		ctrlbar.bt_alterar.removeEventListener(MouseEvent.CLICK,atualizar);
		ctrlbar.bt_limpar.removeEventListener(MouseEvent.CLICK,limpar);
		
		
		ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK, browseFiles);
		ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,uploadFiles);
		ctrlbar.bt_excluir.addEventListener(MouseEvent.CLICK,removeSelectedFileFromCue);
		ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,clearFileCue);

		ctrlbar.bt_pesquisar.label = "Selecionar Arquivo";
		ctrlbar.bt_alterar.label = "Gravar";
		ctrlbar.bt_excluir.label = "Remover";
		ctrlbar.bt_limpar.label = "Remover Todos";
		
	} else if (tb_nav.selectedIndex == 1){
		
		
		ctrlbar.bt_pesquisar.enabled = true;
		ctrlbar.bt_alterar.enabled = true;
		ctrlbar.bt_limpar.enabled = true;
		
		ctrlbar.bt_pesquisar.label = "Selecionar";
		ctrlbar.bt_alterar.label = "Gravar";
		ctrlbar.bt_limpar.label = "Limpar";
		
		ctrlbar.bt_pesquisar.removeEventListener(MouseEvent.CLICK, browseFiles);
		ctrlbar.bt_alterar.removeEventListener(MouseEvent.CLICK,uploadFiles);
		ctrlbar.bt_excluir.removeEventListener(MouseEvent.CLICK,removeSelectedFileFromCue);
		ctrlbar.bt_limpar.removeEventListener(MouseEvent.CLICK,clearFileCue);
		
		
		ctrlbar.bt_pesquisar.addEventListener(MouseEvent.CLICK,selecionar);
		ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,atualizar);
		ctrlbar.bt_limpar.addEventListener(MouseEvent.CLICK,limpar);
		
		ctrlbar.addChildAt(ctrlbar.bt_pesquisar,0);
		ctrlbar.addChildAt(ctrlbar.bt_alterar,1);
		ctrlbar.addChildAt(ctrlbar.bt_limpar,2);
		
		ctrlbar.bt_alterar.label = "Gravar";
	}
}
public function init(e:Event):void{
	
	initButtons();
	resetProgressBar();
	
	maxSize *= 1000; //convert kilobytes to bytes
	//set file browsing filter...
	_files = new ArrayCollection();
	_fileref = new FileReferenceList;
	_file = new FileReference;

	_fileref.addEventListener(Event.SELECT, selectHandler);
	_files.addEventListener(CollectionEvent.COLLECTION_CHANGE,popDataGrid);
	
	initDataGrid();
	
}
private function initDataGrid():void{
	// Set Up DataGrid UI
	_nameColumn = new DataGridColumn;
	_typeColumn = new DataGridColumn;
	_sizeColumn = new DataGridColumn;
	
	_nameColumn.dataField = "name";
	_nameColumn.headerText= "Arquivo";
	
	_typeColumn.dataField = "type";
	_typeColumn.headerText = "Tipo Arquivo";
	_typeColumn.width = 80;
	
	_sizeColumn.dataField = "size";
	_sizeColumn.headerText = "Tamanho Arquivo";
	_sizeColumn.labelFunction = bytesToKilobytes as Function;
	_sizeColumn.width = 150;
	
	_columns = new Array(_nameColumn,_typeColumn,_sizeColumn);
	dg_files.columns = _columns
	dg_files.sortableColumns = false;
	dg_files.dataProvider = _files;
	dg_files.dragEnabled = true;
	dg_files.dragMoveEnabled = true;
	dg_files.dropEnabled = true;
}
private function popular():void{
	pdg_diarioarquivosVO = new Pdg_DiarioArquivosVO();
	var filename:String = _file.name;
	filename = filename.split(" ").join("_");
	filename = filename.split(",").join("");
	filename = filename.split("-").join("");
	filename = filename.split("–").join("");
	filename = filename.split(";").join("");
	filename = filename.split(":").join("");
	filename = filename.split("/").join("");
	filename = filename.split("?").join("");
		
	pdg_diarioarquivosVO.nmarquivo = filename;
		
	pdg_diarioarquivosVO.arquivo = _file.data as ByteArray;
	pdg_diarioarquivosVO.id_diariocont = id_diariocont;
	
}
private function uploadFiles(event:Event):void{
	if (_files.length > 0){
		tb_nav.enabled = false;
		_file = FileReference(_files.getItemAt(0));    
		_file.addEventListener(Event.OPEN, openHandler);
		_file.addEventListener(ProgressEvent.PROGRESS, progressHandler);
		_file.addEventListener(Event.COMPLETE, completeHandler);
		_file.addEventListener(SecurityErrorEvent.SECURITY_ERROR,securityErrorHandler);
		_file.addEventListener(IOErrorEvent.IO_ERROR,ioErrorHandler);
		setupCancelButton(true);
		this._file.load();
	}
}
private function enviarResult(e:ResultEvent):void{
	sndChannel=snd.play();
	uploadFiles(null);
	if (_files.length <= 0){
		resetForm();
		tb_nav.enabled = true
		// abre tela enviar mensagem
		//enviarmensagem();	
	}
}
private function enviarmensagem():void{
	var mensagemwindow:frm_msgarquivo;
	mensagemwindow = PopUpManager.createPopUp(this,frm_msgarquivo,true) as frm_msgarquivo;
	PopUpManager.centerPopUp(mensagemwindow);
	
	var X:Number = mensagemwindow.width / 2;
	var Y:Number = mensagemwindow.height / 2;
	
	var newX:Number = FlexGlobals.topLevelApplication.mdiCanvas.width / 2;
	var newY:Number = FlexGlobals.topLevelApplication.mdiCanvas.height / 2;
	
	mensagemwindow.x = newX - X;
	mensagemwindow.y = newY - Y;
	
	mensagemwindow.qtdeA = qtdeArquivo;
	mensagemwindow.id_diariocont = id_diariocont;
	
}
// only called if there is an  error detected by flash player browsing or uploading a file   
private function ioErrorHandler(event:IOErrorEvent):void{
	mx.controls.Alert.show(String(event),"ioError",0);
} 
// only called if a security error detected by flash player such as a sandbox violation
private function securityErrorHandler(event:SecurityErrorEvent):void{
	mx.controls.Alert.show(String(event),"Security Error",0);
}
private function completeHandler(event:Event):void{
	if (_files.length > 0){
		_files.removeItemAt(0);
		_totalbytes = 0;
		popular();
		ro_diarioarquivos.inserir(pdg_diarioarquivosVO,enviarResult,defaultFaultHandler);
	}else{
		setupCancelButton(false);
		var uploadCompleted:Event = new Event(Event.COMPLETE);
		this.dispatchEvent(uploadCompleted);
		ctrlbar.bt_alterar.enabled = false;
		ctrlbar.bt_excluir.enabled = false;
		ctrlbar.bt_limpar.enabled = false;
		ctrlbar.bt_pesquisar.enabled = false;
	}
}
private function setupCancelButton(x:Boolean):void{
	if (x == true){
		ctrlbar.bt_alterar.label = "Cancelar";
		ctrlbar.bt_pesquisar.enabled = false;
		ctrlbar.bt_excluir.enabled = false;
		ctrlbar.bt_limpar.enabled = false;
		ctrlbar.bt_alterar.addEventListener(MouseEvent.CLICK,cancelFileIO);        
	}else if (x == false){
		ctrlbar.bt_alterar.removeEventListener(MouseEvent.CLICK,cancelFileIO);
		resetForm();
	}
}
// Cancel Current File Upload
private function cancelFileIO(event:Event):void{
	
	_file.cancel();
	setupCancelButton(false);
	checkCue();
	
}
// reset form item elements
private function resetForm():void{
	
	initButtons();
	initDataGrid();
	
	_fileref.addEventListener(Event.SELECT, selectHandler);
	_files.addEventListener(CollectionEvent.COLLECTION_CHANGE,popDataGrid);
	ctrlbar.bt_alterar.enabled = false;
	ctrlbar.bt_alterar.label = "Gravar";
	progressbar.maximum = 0;
	_totalbytes = 0;
	progressbar.label = "";
	ctrlbar.bt_excluir.enabled = false;
	ctrlbar.bt_limpar.enabled = false;
	ctrlbar.bt_pesquisar.enabled = true;
	_files = new ArrayCollection();
	_fileref = new FileReferenceList;
	_file = new FileReference;
}
// called after the file is opened before upload    
private function openHandler(event:Event):void{
	_files;
}
// called during the file upload of each file being uploaded | we use this to feed the progress bar its data
private function progressHandler(event:ProgressEvent):void {        
	progressbar.setProgress(event.bytesLoaded,event.bytesTotal);
	progressbar.label = "Uploading " + Math.round(event.bytesLoaded / 1024) + " kb de " + Math.round(event.bytesTotal / 1024) + " kb " + (_files.length - 1) + " arquivos restando.";
}
// whenever the _files arraycollection changes this function is called to make sure the datagrid data jives
private function popDataGrid(event:CollectionEvent):void{                
	getByteCount();
	checkCue();
}
private function getByteCount():void{
	var i:int;
	_totalbytes = 0;
	for(i=0;i < _files.length;i++){
		_totalbytes +=  _files[i].size;
	}
	progressbar.label = "Total Arquivos: "+  _files.length+ " Tamanho Total: " + Math.round(_totalbytes/1024) + " kb"
}
private function checkCue():void{
	if (_files.length > 0){
		ctrlbar.bt_alterar.enabled = true;
		ctrlbar.bt_excluir.enabled = true;
		ctrlbar.bt_limpar.enabled = true;  
	}else{
		resetProgressBar();
		ctrlbar.bt_alterar.enabled = false;     
	}    
}
// restores progress bar back to normal
private function resetProgressBar():void{
	
	progressbar.label = "";
	progressbar.maximum = 0;
	progressbar.minimum = 0;
}	
//label function for the datagird File Size Column
private function bytesToKilobytes(data:Object,blank:Object):String {
	var kilobytes:String;
	kilobytes = String(Math.round(data.size/ 1024)) + ' kb';
	return kilobytes
}
//Browse for files
private function browseFiles(event:Event):void{        
	_fileref.browse(_filefilter);
	
}
//Remove all files from the upload cue;
private function clearFileCue(event:Event):void{
	_files.removeAll();
	resetForm();
}
//Remove Selected File From Cue
private function removeSelectedFileFromCue(event:Event):void{
	
	if (dg_files.selectedIndex >= 0){
		_files.removeItemAt(dg_files.selectedIndex);
	}
}
private function selectHandler(event:Event):void {
	
	var i:int;
	var msg:String ="";
	var dl:Array = [];
	if (event.currentTarget.fileList.length > 0 ){
		qtdeArquivo = event.currentTarget.fileList.length;
		ctrlbar.bt_alterar.enabled = true;
		ctrlbar.bt_excluir.enabled = true;
		ctrlbar.bt_limpar.enabled = true;
	}
	for (i=0;i < event.currentTarget.fileList.length; i ++){
		if (checkFileSize(event.currentTarget.fileList[i].size)){
			_files.addItem(event.currentTarget.fileList[i]);
		}  else {
			dl.push(event.currentTarget.fileList[i]);
		}
	}	            
	if (dl.length > 0){
		for (i=0;i<dl.length;i++){
			msg += String("Arquivo" + dl[i].name + " é muito grande. \n");
		}
		mx.controls.Alert.show(msg + "Tamanho máximo é : " + Math.round(maxSize / 1024) + " kb","Tamanho Arquivo",4,null).clipContent;
	}        
} 
// Checks the files do not exceed maxFileSize | if _maxFileSize == 0 No File Limit Set
private function checkFileSize(filesize:Number):Boolean{
	
	var r:Boolean = false;
	//if  filesize greater then _maxFileSize
	if (filesize > maxSize){
		r = false;
		trace("false");
	}else if (filesize <= maxSize){
		r = true;
		trace("true");
	}
	
	if (maxSize == 0){
		r = true;
	}
	
	return r;
}
public function selecionar(event:Event):void {
	if(tb_nav.selectedIndex == 1){
		this.enabled = false;
		pdg_diarioarquivosVO = new Pdg_DiarioArquivosVO();
		pdg_diarioarquivosVO.id_diariocont = id_diariocont;
		pdg_diarioarquivosVO.id_diarioarquivos = null;
		ro_diarioarquivos.select(pdg_diarioarquivosVO,selectResult,defaultFaultHandler);
	}
}
public function selectResult(e:ResultEvent):void{
	this.enabled = true;
	dg_arquivos.dataProvider = e.result;
}
private function tb_complete(e:IndexChangedEvent):void{
	initButtons();
	if(tb_nav.selectedIndex == 0){
//		ctr_bar.removeAllChildren();
//		
//		ctr_bar.addChildAt(browseBTN,0);
//		ctr_bar.addChildAt(upload_btn,1);
//		ctr_bar.addChildAt(delButton,2);
//		ctr_bar.addChildAt(clearButton,3);
	} else if (tb_nav.selectedIndex == 1){
//		ctr_bar.removeAllChildren();
//
//		ctr_bar.addChildAt(bt_pesquisar,0);
//		ctr_bar.addChildAt(bt_gravar,1);
//		ctr_bar.addChildAt(bt_limpar,2);
	} 
}
protected function titlewindow1_closeHandler(event:CloseEvent):void		{
	// TODO Auto-generated method stub
	PopUpManager.removePopUp(this);
}
private function limpar(event:Event):void{
	txt_id.text = "";
	txt_filename.text = "";
	txt_descricao.text = "";
	txt_descricao.errorString = "";
	mensagem.text = "";
}
public function baixa_arquivo(data:int):void{
	this.enabled = false;
	pdg_diarioarquivosVO = new Pdg_DiarioArquivosVO();
	pdg_diarioarquivosVO.id_diarioarquivos = data;
	ro_diarioarquivos.baixar_arquivo(pdg_diarioarquivosVO,baixarResult,defaultFaultHandler);

}
private function baixarResult(e:ResultEvent):void{
	this.enabled = true;
	util.abrepdf(e.result[0]['destinationUrl']);
}
private function atualizar(e:Event):void{
	isValid = util.validateForm(form);
	if (!isValid){
		mensagem.text = UtilMensagens.PreenchaCampo;
	} else {
		pdg_diarioarquivosVO = new Pdg_DiarioArquivosVO();
		pdg_diarioarquivosVO.id_diarioarquivos = parseInt(txt_id.text);
		pdg_diarioarquivosVO.descricao = txt_descricao.text;
		pdg_diarioarquivosVO.id_diariocont = id_diariocont;
		pdg_diarioarquivosVO.nmarquivo = txt_filename.text;

		ro_diarioarquivos.atualizar(pdg_diarioarquivosVO,atualizarResult,defaultFaultHandler);
	}
}
private function atualizarResult(e:ResultEvent):void{
	mensagem.text = UtilMensagens.OperacaoRealizadaSucesso;
	selecionar(e);
}

public function deletar_arquivo(data:int):void{
	pdg_diarioarquivosVO = new Pdg_DiarioArquivosVO();
	pdg_diarioarquivosVO.id_diarioarquivos = data;
	ro_diarioarquivos.deletar(pdg_diarioarquivosVO,detetaArquivoResult,defaultFaultHandler);
}
public function detetaArquivoResult(e:ResultEvent):void{
	mensagem.text = UtilMensagens.OperacaoRealizadaSucesso;
	util.limpar_formulario(form);
	selecionar(e);
}
public function editar_arquivo(data:int):void{
	txt_id.text = dg_arquivos.selectedItem.id_diarioarquivos;
	txt_filename.text = dg_arquivos.selectedItem.nmarquivo;
	txt_descricao.text = dg_arquivos.selectedItem.descricao;
}
private function defaultFaultHandler(e:FaultEvent):void{
	this.enabled = true;
	retorno = new UtilRetornoBanco;
	retorno.RetornoBanco(e);
	mensagem.text = "";
	
}
