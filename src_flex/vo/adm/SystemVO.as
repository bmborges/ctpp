package vo.adm
{
	public class SystemVO
	{
		public var id_operador:Object;
		public var nickname:Object;
		public var nmoperador:Object;
		public var cpf:Object;
		public var rg:Object;
		public var id_cargo:Object;
		public var id_aluno:Object;
		
		private static var instance:SystemVO;
		
		public static function getInstance():SystemVO{
			if (instance == null) {
				instance = new SystemVO();	
			}
			return instance;
		}
		
	}
}