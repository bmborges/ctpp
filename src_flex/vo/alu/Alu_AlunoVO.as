package vo.alu
{
	[Bindable]
	[RemoteClass(alias="valueObjects.alu.Alu_AlunoVO")]
	public class Alu_AlunoVO
	{
		
		public var id_aluno:Object;
		public var nome:Object;
		public var rg:Object;
		public var cpf:Object;
		public var dt_nascimento:Object;
		public var id_estadocivil:Object;
		public var profissao:Object;
		public var id_sexo:Object;
		public var email:Object;
		public var local_trabalho:Object;
		public var nome_pai:Object;
		public var nome_mae:Object;
		public var id_nacionalidade:Object;
		public var id_cidade:Object;
		public var id_racacor:Object;
		
		public function Alu_AlunoVO()
		{
		}
	}
}