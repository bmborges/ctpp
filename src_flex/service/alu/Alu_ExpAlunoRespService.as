package service.alu
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Alu_ExpAlunoRespVO;
	
	public class Alu_ExpAlunoRespService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Alu_ExpAlunoRespService;
		public static function getInstance():Alu_ExpAlunoRespService{
			if (instance == null){
				instance = new Alu_ExpAlunoRespService();
			}
			return instance;
		}
		
		public function Procedure(dados:Alu_ExpAlunoRespVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Alu_ExpAlunoRespService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Alu_ExpAlunoRespService';
		}
	}
}