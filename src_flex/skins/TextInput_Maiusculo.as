package skins
{
	
	import flash.events.FocusEvent;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.controls.TextInput;
	import mx.events.FlexEvent;
	import mx.managers.IFocusManager;
	import mx.managers.IFocusManagerComponent;
	
	
	public class TextInput_Maiusculo extends TextInput
	{
		public function TextInput_Maiusculo()
		{
			super();
			init();
		}
		private function init():void {
			editable = true; //O componente é editável
			restrict = "^'";
			maxWidth = 160;
			addEventListener(FlexEvent.ENTER, moveFoco);
		}
		
		/**
		 * Esse método é sobrescrito para tratar cada tecla pressionada
		 *
		 */
		override protected function keyUpHandler(e:KeyboardEvent):void{
			var texto:String = textField.text;
			textField.text = texto.toUpperCase();
		}
		override protected function keyDownHandler(event:KeyboardEvent):void{
//			var texto:String = textField.text;
//			textField.text = texto.toUpperCase();
		}
		
		override protected function focusOutHandler(e:FocusEvent):void{
			var texto:String = textField.text;
			textField.text = texto.toUpperCase();
		}
		
		protected function moveFoco(event:FlexEvent):void
		{
			var fm:IFocusManager = event.target.focusManager;
			var next:IFocusManagerComponent = fm.getNextFocusManagerComponent();
			fm.setFocus(next);
		}
	}	
		
}