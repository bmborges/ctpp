package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class ProcedureFpg_Ponto_DadosAhgoraService
	{
		private var bridge:RemoteObject;
		
		private static var instance:ProcedureFpg_Ponto_DadosAhgoraService;
		public static function getInstance():ProcedureFpg_Ponto_DadosAhgoraService{
			if (instance == null){
				instance = new ProcedureFpg_Ponto_DadosAhgoraService();
			}
			return instance;
		}
		
		public function Procedure(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function ProcedureFpg_Ponto_DadosAhgoraService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'ProcedureFpg_Ponto_DadosAhgoraService';
		}
	}
}