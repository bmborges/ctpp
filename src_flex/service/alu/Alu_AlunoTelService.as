package service.alu
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.alu.Alu_AlunoTelVO;
	
	
	
	public class Alu_AlunoTelService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Alu_AlunoTelService;
		public static function getInstance():Alu_AlunoTelService{
			if (instance == null){
				instance = new Alu_AlunoTelService();
			}
			return instance;
		}
		
		
		public function select(dados:Alu_AlunoTelVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Alu_AlunoTelVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Alu_AlunoTelVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Alu_AlunoTelVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Alu_AlunoTelService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Alu_AlunoTelService';
		}
	}
}