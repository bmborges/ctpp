package vo.view
{
	/**
	 * @author bruno
	 */
	[Bindable]
	[RemoteClass(alias="valueObjects.view.View_Pdg_DiarioVO")]
	public class View_Pdg_DiarioVO
	{
		public var id_diario:Object;			
		public var nmturma:Object;			
		public var nmoperador:Object;			
		public var nmmateria:Object;			
		public var id_status:Object;	
		public var id_operador:Object;
		public var dt_inicio:Object;
		public var id_tipoavaliacao:Object;
		
		public function View_Pdg_DiarioVO()
		{
			
		}
	}	
}