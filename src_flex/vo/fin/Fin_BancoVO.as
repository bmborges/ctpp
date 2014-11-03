package vo.fin
{
	[Bindable]
	[RemoteClass(alias="valueObjects.Fin_BancoVO")]
	public class Fin_BancoVO
	{
		
		public var id_banco:Object;
		public var nmbanco:Object;
		public var conta:Object;
		public var agencia:Object;
		public var cedente:Object;
		public var processo:Object;
		public var banco:Object;
		
		public function Fin_BancoVO()
		{
		}
	}
}