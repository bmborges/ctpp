package classes
{
	import com.flexpernambuco.controls.MasterTextInput;
	
	import flashx.textLayout.tlf_internal;
	
	import mx.core.IVisualElementContainer;
	import mx.core.UIComponent;
	import mx.events.ValidationResultEvent;
	import mx.validators.NumberValidator;
	import mx.validators.StringValidator;
	
	import skins.DateField_Data;
	import skins.TextInput_Cep;
	import skins.TextInput_Cnpj;
	import skins.TextInput_Cpf;
	import skins.TextInput_Hora;
	import skins.TextInput_Tel;
	
	import spark.components.ComboBox;
	import spark.components.DropDownList;
	import spark.components.Form;
	import spark.components.FormItem;
	import spark.components.TextArea;
	import spark.components.TextInput;

	public class UtilSpark
	{
		public function getFields(form:Form, requiredOnly:Boolean=false):Array
		{
			var a:Array = [];
			// get every child of the Form
//			var formItems:Array = form.numElements;
//			trace(form.numElements);
			for (var i:int=0; i<form.numElements; i++)
			{
				// make sure it's a FormItem - if you use FormHeading or have
				// items that are not wrapped in a FormItem tag then ignore those
				if (form.getElementAt(i) is FormItem)
				{
					var formItem:FormItem = form.getElementAt(i) as FormItem;
					// add the formItem's child to the array.
					// if you only need required items, set requiredOnly = true
					// Note: this assumes you only have one form field per FormItem
					//          You could easily add additional logic here for more
					if (formItem.required || !requiredOnly){
						a.push(formItem.getChildAt(0));
//						trace("a:" + a);
					}
//					trace("formItem" + formItem);
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
			var result:ValidationResultEvent;
			var i:int;
			for (i = 0; i < form.numElements; i++)
			{
				if (form.getElementAt(i) is FormItem)
				{
					var formItem:FormItem = form.getElementAt(i) as FormItem;
					if (formItem.required){
						trace(formItem.numElements);
						var j:int;
						for (j = 0; j < formItem.numElements; j++)
						{
							var input:UIComponent = formItem.getElementAt(j) as UIComponent; 
							trace(input);
							// create a simple string validator
							var validator:StringValidator = new StringValidator();
							validator.minLength = 1;
							validator.source = input;
							validator.property = "text";
							validator.requiredFieldError = "Campo Obrigatório";
							
							if(input is MasterTextInput){
								result = validator.validate(MasterTextInput(input).text);
							} else if (input is DateField_Data){
								result = validator.validate(DateField_Data(input).text);
							} else if (input is TextInput_Cep){
								result = validator.validate(TextInput_Cep(input).text);
							} else if (input is TextInput_Cnpj){
								result = validator.validate(TextInput_Cnpj(input).text);
							} else if (input is TextInput_Cpf){
								result = validator.validate(TextInput_Cpf(input).text);
							} else if (input is TextInput_Hora){
								result = validator.validate(TextInput_Hora(input).text);
							} else if (input is TextInput_Tel){
								result = validator.validate(TextInput_Tel(input).text);
							}
//							else if (input is DropDownList){
//								var validator_combobox:NumberValidator = new NumberValidator();
//								validator_combobox.minValue = "0";
//								validator_combobox.source = input;
//								validator_combobox.property = "selectedIndex"; 
//								validator_combobox.lowerThanMinError = "Campo Obrigatório";
//								
//								result = validator_combobox.validate(DropDownList(input).selectedIndex);
//							}

						_isValid = (result.type == ValidationResultEvent.VALID) && _isValid;
							
						}
					}
				}
			}
			return _isValid;
		}
		
		public function limpar_formulario(form:Form):void{
			var i:int;
			for (i = 0; i < form.numElements; i++)
			{
				if (form.getElementAt(i) is FormItem)
				{
					var formItem:IVisualElementContainer = form.getElementAt(i) as IVisualElementContainer;
					var j:int;
					for (j = 0; j < formItem.numElements; j++)
					{
						var input:UIComponent = formItem.getElementAt(j) as UIComponent; 
						if(input.hasOwnProperty('text'))
							input['text'] = '';
						if(input.hasOwnProperty('textFlow'))
							input['textFlow'] = null;
						if(input.hasOwnProperty('selectedItem'))
							input['selectedItem'] = null;
						if(input is ComboBox)
							ComboBox(input).textInput.text =''; // fix the bug on default ComboBoxSkin class
						if(input.hasOwnProperty('selectedItems'))
							input['selectedItems'] = null;
						if(input.hasOwnProperty('selectedIndex'))
							input['selectedIndex'] = -1;
						if(input.hasOwnProperty('selected'))
							input['selected']= false;
					}
				}
//			
//				trace(formulario[i].getChildren());
//				var formItem:Array = formulario[i].getChildren();
//				var j:int;
//				for (j = 0; j < formItem.length; j ++){
//					trace(formItem[j]);
//					
//					if(formItem[j] is ComboBox){
//						formItem[j].selectedIndex = -1;
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is DateField_Data){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextInput){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextInput_Cep){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextInput_Cnpj){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextInput_Cpf){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextInput_Hora){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextInput_Tel){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//					if(formItem[j] is TextArea){
//						formItem[j].text = '';
//						formItem[j].errorString = '';
//					}
//				}
			}
		}
	}
}