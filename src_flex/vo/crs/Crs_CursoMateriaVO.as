package vo.crs
{
	[Bindable]
	[RemoteClass(alias="valueObjects.crs.Crs_CursoMateriaVO")]
	public class Crs_CursoMateriaVO
	{
		
		public var id_cursomateria:Object;
		public var qtd_aulas:Object;
		public var carga_horaria:Object;
		public var id_curso:Object;
		public var id_materia:Object;
		public var id_modulo:Object;
		public var id_ativo:Object;
		
		public function Crs_CursoMateriaVO()
		{
		}
	}
}