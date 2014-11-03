package service.crs
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.alu.Alu_AlunoVO;
	import vo.crs.Crs_TurmaVO;
	
	public class Crs_TurmaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Crs_TurmaService;
		public static function getInstance():Crs_TurmaService{
			if (instance == null){
				instance = new Crs_TurmaService();
			}
			return instance;
		}
		
//		public function pdg_criadiario(id_turma:int,modulo:int,data:Object,result:Function,fault:Function):void{
//			var async:AsyncToken = bridge.pdg_criadiario(id_turma,modulo,data);
//			async.addResponder(new Responder(result, fault));
//		}
		public function Select_AlunoTurma(turma:Crs_TurmaVO,aluno:Alu_AlunoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Select_AlunoTurma(turma,aluno);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBox_IdTurma(id_turma:Object,result:Function,fault:Function):void{
			ComboBoxQuery("select nmturma as label, id_turma as data from crs_turma where id_turma = ?::integer",id_turma,result,fault);
		}
		public function TurmaModulo(id:Object,result:Function,fault:Function):void{
			ComboBoxQuery("select distinct id_modulo as data, nmmodulo as label from crs_turma t" +
				"	inner join crs_cursomateria using (id_curso)" +
				"	inner join crs_modulo using (id_modulo)" +
				"	where id_turma = ?::integer order by nmmodulo",id,result,fault);
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		public function select(dados:Crs_TurmaVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Crs_TurmaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Crs_TurmaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Crs_TurmaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}

		
		public function Crs_TurmaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Crs_TurmaService';
		}
	}
}