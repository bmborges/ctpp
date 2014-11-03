package skins
{
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.controls.TextInput;
	import mx.events.FlexEvent;
	import mx.managers.IFocusManager;
	import mx.managers.IFocusManagerComponent;
	
	public class TextInput_Cnpj extends TextInput
	{
		public function TextInput_Cnpj()
		{
			super();
			init();
		}
		private function init():void {
			editable = true; //O componente é editável
			restrict = "0-9"; //Serão aceitos apenas números
			maxChars = 18; //O componente suportará apenas 14 caracteres
			addEventListener(FlexEvent.ENTER, moveFoco);
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
					//Caso já tenha sido digitado 3 caracteres, o próximo a ser inserido será o hífem "."
					textField.replaceText(quantidadeCaracteres, quantidadeCaracteres, ".");
					//Move o cursor dentro do componente para a última posição
					textField.setSelection(textField.text.length, textField.text.length);
				}
				if(quantidadeCaracteres == 6){
					//Caso já tenha sido digitado 7 caracteres, o próximo a ser inserido será o hífem "."
					textField.replaceText(quantidadeCaracteres, quantidadeCaracteres, ".");
					//Move o cursor dentro do componente para a última posição
					textField.setSelection(textField.text.length, textField.text.length);
				}
				if(quantidadeCaracteres == 10){
					//Caso já tenha sido digitado 11 caracteres, o próximo a ser inserido será o hífem "-"
					textField.replaceText(quantidadeCaracteres, quantidadeCaracteres, "/");
					//Move o cursor dentro do componente para a última posição
					textField.setSelection(textField.text.length, textField.text.length);
				}
				if(quantidadeCaracteres == 15){
					//Caso já tenha sido digitado 11 caracteres, o próximo a ser inserido será o hífem "-"
					textField.replaceText(quantidadeCaracteres, quantidadeCaracteres, "-");
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