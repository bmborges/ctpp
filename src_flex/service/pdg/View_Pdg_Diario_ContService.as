package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.View_Pdg_Diario_ContVO;
	
	public class View_Pdg_Diario_ContService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Pdg_Diario_ContService;
		public static function getInstance():View_Pdg_Diario_ContService{
			if (instance == null){
				instance = new View_Pdg_Diario_ContService();
			}
			return instance;
		}
		
		public function select(dados:View_Pdg_Diario_ContVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function View_Pdg_Diario_ContService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Pdg_Diario_ContService';
		}
	}
}