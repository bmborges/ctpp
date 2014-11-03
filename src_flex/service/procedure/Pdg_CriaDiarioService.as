package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Pdg_CriaDiarioVO;
	
	
	public class Pdg_CriaDiarioService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_CriaDiarioService;
		public static function getInstance():Pdg_CriaDiarioService{
			if (instance == null){
				instance = new Pdg_CriaDiarioService();
			}
			return instance;
		}
		
		public function Procedure(dados:Pdg_CriaDiarioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Pdg_CriaDiarioService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_CriaDiarioService';
		}
	}
}