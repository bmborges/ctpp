package skins
{
	import flash.events.FocusEvent;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.controls.Alert;
	import mx.controls.TextInput;
	import mx.events.FlexEvent;
	import mx.managers.IFocusManager;
	import mx.managers.IFocusManagerComponent;
	
	public class TextInput_Hora extends TextInput
	{
		public function TextInput_Hora()
		{
			super();
			init();
		}
		private function init():void {
			editable = true; //O componente é editável
			restrict = "0-9"; //Serão aceitos apenas números
			maxChars = 5; //O componente suportará apenas 9 caracteres
//			addEventListener(FlexEvent.ENTER, moveFoco);
			addEventListener(FocusEvent.FOCUS_OUT, validaData);
		}
		
		protected function validaData(event:FocusEvent):void
		{
			var hora:int = parseInt(textField.text.substr(0,2));
			var minuto:int = parseInt(textField.text.substr(3,2));
			if (hora > 24 || hora < 0){
				Alert.show('Digite uma data Válida','Erro');
			} else if (minuto > 59 || minuto < 0){
				Alert.show('Digite uma data Válida','Erro');
			}
			
		}
		
		/**
		 * Esse método é sobrescrito para tratar cada tecla pressionada
		 *
		 */
		override protected function keyDownHandler(event:KeyboardEvent):void{
			var codigoTecla:int = event.keyCode; //Pega o código da tecla pressionada
			var quantidadeCaracteres:int = textField.text.length; //Pega a quantidade de caracteres
			//dentro do componente
			if(codigoTecla == Keyboard.ENTER){ //Se pressionar ENTER, o foco do componente será mudado
//				dispatchEvent(new FlexEvent(FlexEvent.ENTER));
			}else if( codigoTecla != 8 ){
				if(quantidadeCaracteres == 2){
					//Caso já tenha sido digitado 5 caracteres, o próximo a ser inserido será o hífem "-"
					textField.replaceText(quantidadeCaracteres, quantidadeCaracteres, ":");
					//Move o cursor dentro do componente para a última posição
					textField.setSelection(textField.text.length, textField.text.length);
				}
			}
		}
		
		protected function moveFoco(event:FlexEvent):void
		{
			var fm:IFocusManager = event.target.focusManager;
			var next:IFocusManagerComponent = fm.getNextFocusManagerComponent();
			fm.setFocus(next);
		}
	}
}