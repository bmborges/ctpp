package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fpg_ImportaPonto_AhgoraVO;
	
	public class Fpg_ImportaPonto_AhgoraService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fpg_ImportaPonto_AhgoraService;
		public static function getInstance():Fpg_ImportaPonto_AhgoraService{
			if (instance == null){
				instance = new Fpg_ImportaPonto_AhgoraService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fpg_ImportaPonto_AhgoraVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fpg_ImportaPonto_AhgoraService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fpg_ImportaPonto_AhgoraService';
		}
	}
}