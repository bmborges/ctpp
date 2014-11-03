package vo.adm
{
	[Bindable]
	[RemoteClass(alias="valuesObjects.Adm_permissaoVO")]

	public class Adm_permissaoVO
	{
		
		private static var instance:Adm_permissaoVO;
		
		
		public static function getInstance():Adm_permissaoVO{
			if (instance == null) {
				instance = new Adm_permissaoVO();	
			}
			return instance;
		}
		public var id_permissao:Object;
		public var id_operador:Object;
		public var id_itemmenu:Object;
	}
}