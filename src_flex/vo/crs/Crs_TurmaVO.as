package vo.crs
{
	[Bindable]
	[RemoteClass(alias="valueObjects.crs.Crs_TurmaVO")]
	public class Crs_TurmaVO
	{
		
		public var id_turma:Object;
		public var nmturma:Object;
		public var id_curso:Object;
		public var dt_inicial:Object;
		public var dt_final:Object;
		public var status:Object;
		public var dt_cadastro:Object;
		public var id_sala:Object;
		public var id_operador:Object;
		
		public function Crs_TurmaVO()
		{
		}
	}
}