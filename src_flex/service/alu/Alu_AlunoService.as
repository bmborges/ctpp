package service.alu
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.alu.Alu_AlunoVO;
	
	
	public class Alu_AlunoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Alu_AlunoService;
		public static function getInstance():Alu_AlunoService{
			if (instance == null){
				instance = new Alu_AlunoService();
			}
			return instance;
		}
		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBox_IdAluno(id_aluno:Object,result:Function,fault:Function):void{
			ComboBoxQuery("select nome as label, id_aluno as data from alu_aluno where id_aluno = ?::integer",id_aluno,result,fault);
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		public function select(dados:Alu_AlunoVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Alu_AlunoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Alu_AlunoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Alu_AlunoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Alu_AlunoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Alu_AlunoService';
		}
	}
}