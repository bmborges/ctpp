package classes
{
	import flash.display.DisplayObject;
	import flash.events.MouseEvent;
	import flash.utils.getDefinitionByName;
	
	import flexmdi.containers.MDIWindow;
	
	import frm.frm_pesquisa;
	
	import mx.controls.Alert;
	import mx.core.FlexGlobals;
	import mx.managers.PopUpManager;
	
	import skins.TextInput_Maiusculo;
	
	
	public class UtilPesquisa
	{
		private var pesquisawindow:frm_pesquisa = new frm_pesquisa();
		private var retorno:Array = [];
     
		public function Alu_aluno(tela:MDIWindow,r1:String,r2:String):void{
			openpesquisa("alu_aluno","Aluno",tela,r1,r2);
		}
		public function Crs_Curso(tela:MDIWindow,r1:String,r2:String):void{
			openpesquisa("crs_curso","Curso",tela,r1,r2);
		}
		public function Crs_Turma(tela:MDIWindow,r1:String,r2:String):void{
			openpesquisa("crs_turma","Turma",tela,r1,r2);
		}
		public function Ctr_Contrato(tela:MDIWindow,r1:String,r2:String):void{
			openpesquisa("ctr_contrato","Contrato",tela,r1,r2);
		}
		private function openpesquisa(tablename:String,title:String,tela:MDIWindow,r1:String,r2:String):void{
			
			PopUpManager.addPopUp(pesquisawindow,DisplayObject(FlexGlobals.topLevelApplication),true);
			pesquisawindow.title = "Pesquisa " + title;
			pesquisawindow.tablename = tablename;
			pesquisawindow["list_data_grid"].addEventListener(MouseEvent.DOUBLE_CLICK,closePopUpWindow(tablename,tela,r1,r2));
			
			PopUpManager.centerPopUp(pesquisawindow);
			
			
		}
		
		private function closePopUpWindow(tablename:String,tela:MDIWindow,r1:String,r2:String):Function {
			
			return function(evt:MouseEvent):void{
				if (tablename == 'alu_aluno'){
					retorno[1] = pesquisawindow.list_data_grid.selectedItem.id_aluno;
					retorno[2] = pesquisawindow.list_data_grid.selectedItem.nome;
				}
				if (tablename == 'crs_curso'){
					retorno[1] = pesquisawindow.list_data_grid.selectedItem.id_curso;
					retorno[2] = pesquisawindow.list_data_grid.selectedItem.nmcurso;
				}
				PopUpManager.removePopUp(pesquisawindow);
			}
		}
	}
}