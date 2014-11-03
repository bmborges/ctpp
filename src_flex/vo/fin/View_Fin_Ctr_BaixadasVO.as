package vo.fin
{
	[Bindable]
	[RemoteClass(alias="valueObjects.view.View_Fin_Ctr_BaixadasVO")]
	public class View_Fin_Ctr_BaixadasVO
	{
		
		public var id_contrato:Object;
		public var cdseqpgto:Object;			
		public var parcela:Object;			
		public var nmtiporec:Object;			
		public var dt_vencimento:Object;			
		public var dt_baixa:Object;			
		public var vr_movim:Object;			
		public var vr_desconto:Object;
		public var subtotal:Object;	
		public var nickname:Object;	
		public var id_retornobanco:Object;	


		public function View_Fin_Ctr_BaixadasVO()
		{
		}
	}
}