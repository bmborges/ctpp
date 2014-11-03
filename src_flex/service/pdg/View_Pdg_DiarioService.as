package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.view.View_Pdg_DiarioVO;
	
	public class View_Pdg_DiarioService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Pdg_DiarioService;
		public static function getInstance():View_Pdg_DiarioService{
			if (instance == null){
				instance = new View_Pdg_DiarioService();
			}
			return instance;
		}
		
		public function select(dados:View_Pdg_DiarioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function View_Pdg_DiarioService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Pdg_DiarioService';
		}
	}
}