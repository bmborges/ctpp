package vo.crs
{
	[Bindable]
	[RemoteClass(alias="valueObjects.crs.Crs_TurmaHorVO")]
	public class Crs_TurmaHorVO
	{
		
		public var id_turmahor:Object;
		public var id_turma:Object;
		public var hr_inicio:Object;
		public var hr_termino:Object;
		public var id_dow:Object;
		public var id_cursomateria:Object;
		public var id_sala:Object;
		public var id_operador:Object;
		
		public function Crs_TurmaHorVO()
		{
		}
	}
}