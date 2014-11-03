package vo.alu
{
	[Bindable]
	[RemoteClass(alias="valueObjects.alu.Alu_RespVO")]
	public class Alu_RespVO
	{
		
		public var id_resp:Object;
		public var nome:Object;
		public var rg:Object;
		public var cpf:Object;
		public var dt_nascimento:Object;
		public var id_estadocivil:Object;
		public var profissao:Object;
		public var id_sexo:Object;
		public var cnpj:Object;
		public var email:Object;
		public var local_trabalho:Object;
		
		public function Alu_RespVO()
		{
		}
	}
}