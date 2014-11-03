package vo.ctr
{
	[Bindable]
	[RemoteClass(alias="valueObjects.ctr.Ctr_StatusVO")]
	public class Ctr_StatusVO
	{
		
		public var id_ctrstatus:Object;
		public var nmstatus:Object;
		public var opcao:Object;
		public var nmopcao:Object;
		public var mostra_diario:Object;
		public var ativo_opcao:Object;
		public var abre_hist:Object;
		public var abre_cancparc:Object;
		
		public function Ctr_StatusVO()
		{
		}
	}
}