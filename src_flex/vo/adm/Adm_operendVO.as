package vo.adm
{
	[Bindable]
	[RemoteClass(alias="valueObjects.Adm_OperEndVO")]
	public class Adm_operendVO
	{
		public var id_operend:Object;
		public var endereco:Object;
		public var complemento:Object;
		public var bairro:Object;
		public var cep:Object;
		public var cidade:Object;
		public var id_operador:Object;
		public var id_estado:Object;
		
		public function Adm_operendVO()
		{
		}
	}
}