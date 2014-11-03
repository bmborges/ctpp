package vo.view
{
	/**
	 * @author bruno
	 */
	[Bindable]
	[RemoteClass(alias="valueObjects.view.View_Ctr_Contrato_AlunoVO")]
	public class View_Ctr_Contrato_AlunoVO
	{
		public var id_contrato:Object;
		public var id_aluno:Object;
		public var nome:Object;
		public var nmcurso:Object;
		public var id_ctrstatus:Object;
		public var nmstatus:Object;
		public var nome_pai:Object;
		public var nome_mae:Object;
		public var cpf:Object;			
		
		public function View_Ctr_Contrato_AlunoVO()
		{
			
		}
	}	
}