package vo.adm
{
	import flash.utils.ByteArray;

	[Bindable]
	[RemoteClass(alias="valueObjects.adm.Adm_OperadorVO")]
	public class Adm_operadorVO
	{
		public var id_operador:Object;
		public var nickname:Object;
		public var senha:Object;
		public var dt_acesso:Object;
		public var nmoperador:Object;
		public var dt_nascimento:Object;
		public var cpf:Object;
		public var rg:Object;
		public var dt_admissao:Object;
		public var dt_demissao:Object;
		public var id_escolaridade:Object;
		public var id_cargo:Object;
		public var salario:Object;
		public var obs:Object;
		public var id_ativo:Object;
		public var id_empresa:Object;
		public var senha_nova:Object;
		public var id_aluno:Object;
		public var foto:Object;
		public var email:Object;
		
		public function Adm_operadorVO()
		{
		}
	}
}