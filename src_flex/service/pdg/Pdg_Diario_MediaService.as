package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Pdg_Diario_MediaVO;
	
	
	public class Pdg_Diario_MediaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_Diario_MediaService;
		public static function getInstance():Pdg_Diario_MediaService{
			if (instance == null){
				instance = new Pdg_Diario_MediaService();
			}
			return instance;
		}
		
		public function Procedure(dados:Pdg_Diario_MediaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Pdg_Diario_MediaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_Diario_MediaService';
		}
	}
}