package vo.fin
{
	[Bindable]
	[RemoteClass(alias="valueObjects.fin.Fin_RetornoBancoVO")]
	public class Fin_RetornoBancoVO
	{
		
		public var id_tiporec:Object;
		public var nmtiporec:Object;
		
		public var id_retornobanco:Object;
		public var id_banco:Object;
		public var id_operador:Object;
		public var retorno:Object;
		public var nmarquivo:Object;
		
		
		public function Fin_RetornoBancoVO()
		{
		}
	}
}