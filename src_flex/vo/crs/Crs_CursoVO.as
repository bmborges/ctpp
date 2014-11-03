package vo.crs
{
	[Bindable]
	[RemoteClass(alias="valueObjects.crs.Crs_CursoVO")]
	public class Crs_CursoVO
	{
		
		public var id_curso:Object;
		public var nmcurso:Object;
		public var id_tipocurso:Object;
		public var id_ativo:Object;
		public var curriculo:Object;
		public var autorizacao:Object;
		public var habilitacao:Object;
		
		public function Crs_CursoVO()
		{
		}
	}
}