package classes
{
	
	import flash.events.Event;
	import flash.events.MouseEvent;
	import flash.net.URLRequest;
	import flash.net.navigateToURL;
	
	import flexmdi.containers.MDICanvas;
	import flexmdi.containers.MDIWindow;
	
	import mx.collections.ArrayCollection;
	import mx.containers.Form;
	import mx.containers.FormItem;
	import mx.controls.Alert;
	import mx.controls.CheckBox;
	import mx.controls.ComboBox;
	import mx.controls.TextArea;
	import mx.controls.TextInput;
	import mx.core.FlexGlobals;
	import mx.core.UIComponent;
	import mx.events.ValidationResultEvent;
	import mx.formatters.DateFormatter;
	import mx.managers.PopUpManager;
	import mx.rpc.events.FaultEvent;
	import mx.validators.NumberValidator;
	import mx.validators.StringValidator;
	
	import skins.DateField_Data;
	import skins.TextButtonText;
	import skins.TextButtonText1;
	import skins.TextInput_Cep;
	import skins.TextInput_Cnpj;
	import skins.TextInput_Cpf;
	import skins.TextInput_Hora;
	import skins.TextInput_Tel;
	
	import spark.components.ComboBox;
		
	public class Util
	{
		
		public function dthoje():String{
			var date:Date = new Date();
			var date_mes:int = date.getMonth();
			var date_dia:int = date.getDate();
			var date_ano:int = date.getFullYear();
			
			var datahj:String = date_dia + '/' + ( date_mes + 1 ) + '/' + date_ano;
			 return datahj;
		}
		public function dthoje_date():Date{
			return new Date();
		}
		public function formatData_DDMMYYYY(data:Date):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = "DD/MM/YYYY";
			
			return df.format(data);
			
		}
		public function formatDataHora(data:Date):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = "DD/MM/YYYY HH:NN:SS";
			
			return df.format(data);
			
		}
		public function formatHora(hora:Date):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = "HH:NN";
			return df.format(hora);
		}
		public function formatTimestamp(data:String):String{
			var df:DateFormatter = new DateFormatter();
			df.formatString = "YYYY-MM-DD HH:NN:SS";
			
			return df.format(data);
		}
		public function selecionarCombobox(id:int,Array:ArrayCollection):Object {
			for ( var cont:int = 0; cont < Array.length; cont++ ) {
				if (Array[cont]['data'] == id) {
					return Array[cont];
				}
			}
			return null;
		}
		public function selecionarComboboxString(id:String,Array:ArrayCollection):Object {
			for ( var cont:int = 0; cont < Array.length; cont++ ) {
				if (Array[cont]['data'] == id) {
					return Array[cont];
				}
			}
			return null;
		}
		public function selecionarArray(id:int,pk:String,Array:ArrayCollection):Object {
			for ( var cont:int = 0; cont < Array.length; cont++ ) {
				if (Array[cont][pk] == id) {
					return Array[cont];
				}
			}
			return null;
		}
		public function doubleDigitFormat(num:uint):String {
			if(num < 10) {
				return ("0" + num);
			}
			return num.toString();
		}
		public function localizaPermissao(id_itemmenu:int):Boolean{
			var retorno:Boolean = false;
			var permissao:ArrayCollection = FlexGlobals.topLevelApplication.permissao;
			
			for (var i:int = 0; i < permissao.length; i++) 
			{
				if (permissao[i]['id_itemmenu'] == id_itemmenu){
					retorno = true;
				}
			}
			return retorno;
		}
		
		public function limpar_formulario(formulario:mx.containers.Form):void{
			formulario.errorString = null;
			formulario.errorString = '';
			var itensdoFormulario:Array = formulario.getChildren();
			var i:int;
			for (i = 0; i < itensdoFormulario.length; i++)
			{
				trace(itensdoFormulario[i].getChildren());
				var formItem:Array = itensdoFormulario[i].getChildren();
				var j:int;
				for (j = 0; j < formItem.length; j ++){
					trace(formItem[j]);
					if(formItem[j] is mx.controls.ComboBox){
						formItem[j].selectedIndex = 0;
						formItem[j].errorString = '';
					}
					if(formItem[j] is DateField_Data){
						formItem[j].selectedDate = null;
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextArea){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextInput){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextInput_Cep){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextInput_Cnpj){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextInput_Cpf){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextInput_Hora){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextInput_Tel){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextArea){
						formItem[j].text = '';
						formItem[j].errorString = '';
					}
					if(formItem[j] is CheckBox){
						formItem[j].selected = false;
						formItem[j].errorString = '';
					}
					if(formItem[j] is TextButtonText){
						formItem[j].txt_id.text = '';
						formItem[j].txt_nome.text = '';
						
						formItem[j].txt_id.errorString = '';
						formItem[j].txt_nome.errorString = '';
						formItem[j].bt.errorString = '';
						formItem[j].txt_id.errorString = null;
						formItem[j].txt_nome.errorString = null;
						formItem[j].bt.errorString = null;
						
						
					}
					if(formItem[j] is TextButtonText1){
						formItem[j].txt_id.text = '';
						formItem[j].txt_nome.text = '';
						
						formItem[j].txt_id.errorString = '';
						formItem[j].txt_nome.errorString = '';
						formItem[j].bt.errorString = '';
						formItem[j].txt_id.errorString = null;
						formItem[j].txt_nome.errorString = null;
						formItem[j].bt.errorString = null;
						
						
					}
					
				}
			}
		}
		public function abrepdf(myurl:String):void{
  			var urltonav:URLRequest = new URLRequest(myurl);
   			navigateToURL(urltonav,"_blank"); 
		}
		
		public function getFields(form:Form, requiredOnly:Boolean=false):Array
		{
			var a:Array = [];
			// get every child of the Form
			var formItems:Array = form.getChildren();
			for (var i:int=0; i<formItems.length; i++)
			{
				// make sure it's a FormItem - if you use FormHeading or have
				// items that are not wrapped in a FormItem tag then ignore those
				if (formItems[i] is FormItem)
				{
					var formItem:FormItem = formItems[i];
					// add the formItem's child to the array.
					// if you only need required items, set requiredOnly = true
					// Note: this assumes you only have one form field per FormItem
					//          You could easily add additional logic here for more
					if (formItem.required || !requiredOnly){
						a.push(formItem.getChildAt(0));
						trace("a:" + a);
					}
					trace("formItems[i]" + formItems[i]);
				}
//				var formItems2:Array = formItems[i].getChildren();
//				if (formItems2.length > 0){
//					for (var j:int = 0; j < formItems2.length; j++){
//						trace("formItems2[i]" + formItems2[i]);
//						if(formItems2[i] is FormItem){
//							var formItem2:FormItem = formItems2[i];
//							if (formItem2.required || !requiredOnly){
//								a.push(formItem.getChildAt(0));
//							}
//						}
//					}
//				}
			}
			return a;
		}
		
		public function validateForm(form:Form):Boolean
		{
			// reset the flag
			var _isValid:Boolean = true;
			
			// populate the fields - if your fields aren't dynamic then put this in creationComplete
			
			var fields:Array = getFields(form, true);
			var source:UIComponent;
			var result:ValidationResultEvent;

			for each(source in fields)
			{
				// create a simple string validator
				var validator:StringValidator = new StringValidator();
				validator.minLength = 1;
				validator.source = source;
				validator.property = "text";
				validator.requiredFieldError = "Campo Obrigatório";
					
				// typical validation, but check to this checks for any different
				// types of UIComponent here
				if (source is TextInput){
					result = validator.validate(TextInput(source).text);
				} else if (source is TextArea){
					result = validator.validate(TextArea(source).text);
				} else if (source is DateField_Data){
					result = validator.validate(DateField_Data(source).text);
				} else if (source is TextInput_Cep){
					result = validator.validate(TextInput_Cep(source).text);
				} else if (source is TextInput_Cnpj){
					result = validator.validate(TextInput_Cnpj(source).text);
				} else if (source is TextInput_Cpf){
					result = validator.validate(TextInput_Cpf(source).text);
				} else if (source is TextInput_Hora){
					result = validator.validate(TextInput_Hora(source).text);
				} else if (source is TextInput_Tel){
					result = validator.validate(TextInput_Tel(source).text);
				} else if (source is TextButtonText){
					TextButtonText(source).errorString = null;
					TextButtonText(source).errorString = '';
					result = validator.validate(TextButtonText(source).txt_id.text);
				} else if (source is TextButtonText1){
					TextButtonText1(source).errorString = null;
					TextButtonText1(source).errorString = '';
					result = validator.validate(TextButtonText1(source).txt_id.text);
				} else if (source is mx.controls.ComboBox){
					
					var validator_combobox:NumberValidator = new NumberValidator();
					validator_combobox.minValue = "1";
					validator_combobox.source = source;
					validator_combobox.property="selectedIndex"; 
					validator_combobox.lowerThanMinError="Campo Obrigatório";
					
					result = validator_combobox.validate(mx.controls.ComboBox(source).selectedIndex);
				} 
				// if the source is valid, then mark the form as valid
				_isValid = (result.type == ValidationResultEvent.VALID) && _isValid;
			}
			return _isValid;
		}
		
		
	}
}