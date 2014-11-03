package skins
{
	import flash.events.FocusEvent;
	import flash.events.KeyboardEvent;
	import flash.ui.Keyboard;
	
	import mx.controls.DateField;
	import mx.events.FlexEvent;
	import mx.managers.IFocusManager;
	import mx.managers.IFocusManagerComponent;
	import mx.validators.DateValidator;
	
	public class DateField_Data extends DateField
	{
		public function DateField_Data()
		{
			super();
			init();
		}
		private function init():void {
			editable = true; //O componente é editável
			restrict = "0-9"; //Serão aceitos apenas números
			// Formato para data
			formatString = 'DD/MM/YYYY';
			width = 100;
			// Inicia o calendário no Domingo   
			firstDayOfWeek = 0;
			// Habilita a navegação por ano.
			yearNavigationEnabled = true;
			// Tradução dos meses 
			monthNames = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 
				'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
			// Legenda para os dias da semana
			dayNames = ['D', 'S', 'T', 'Q', 'Q', 'S', 'S'];
			/* Adicionando ao evento de focusOut o método que irá colocar
			máscara na data digitada pelo usuário */
			addEventListener(FocusEvent.FOCUS_OUT, proSetMask, false, 0, true);
			addEventListener(FlexEvent.ENTER, moveFoco, false, 0, true);
		}
		/**
		 * Esse método é sobrescrito para tratar cada tecla pressionada
		 *
		 */
		private function proSetMask(evFocus: FocusEvent): void {
			if(text.length > 0){
			      if ((text.charAt(2) != '/') || (text.charAt(5) != '/')) {
				        if (text.length == 6)
					          text = text.substr(0, 2) + '/' + text.substr(2,2) + '/' + text.substr(4, 4);
				        else if (text.length == 8)
					          text = text.substr(0, 2) + '/' + text.substr(2,2) + '/' + text.substr(4, 4);
			      }
			       
			     
		       proCheckDate();
		
			   setaSelectDate();
		    }
		}	
		     
	    private function proCheckDate(): void {
		      var      
		        _rDateValidator: DateValidator = new DateValidator();
		         
		      _rDateValidator.source = this;
		      _rDateValidator.required = false;
		      _rDateValidator.property = 'text';
		      _rDateValidator.inputFormat = 'dd/mm/yyyy';
		      _rDateValidator.allowedFormatChars = '/-';
		      _rDateValidator.wrongDayError = 'Favor informar um dia válido para o mês.'
		      _rDateValidator.wrongLengthError = 'Favor informar a data no formato dd/mm/aaaa.'
		      _rDateValidator.wrongMonthError = 'Favor informar um mês entre 1 e 12.'
		      _rDateValidator.validate();
	    }
		private function setaSelectDate():void{
			var date_ar:Array = text.split("/");
			selectedDate = new Date(date_ar[2], date_ar[1]-1, date_ar[0]);
		}
		
		
		protected function moveFoco(event:FlexEvent):void
		{
			var fm:IFocusManager = event.target.focusManager;
			var next:IFocusManagerComponent = fm.getNextFocusManagerComponent();
			fm.setFocus(next);
		}
	}
}