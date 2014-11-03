package vo.ctr
{
	[Bindable]
	[RemoteClass(alias="valueObjects.ctr.Ctr_ContratoVO")]
	public class Ctr_ContratoVO
	{
		
		public var id_contrato:Object;
		public var id_ctrstatus:Object;
		public var dt_cadastro:Object;
		public var id_turma:Object;
		public var dt_inicial:Object;
		public var dt_final:Object;
		public var id_aluno:Object;
		public var id_resplegal:Object;
		public var id_respfinan:Object;
		public var id_operador:Object;
		public var id_curso:Object;
		
		public function Ctr_ContratoVO()
		{
		}
	}
}