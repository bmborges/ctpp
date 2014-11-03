package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Monta_MenuVO;
	
	
	public class Monta_MenuService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Monta_MenuService;
		public static function getInstance():Monta_MenuService{
			if (instance == null){
				instance = new Monta_MenuService();
			}
			return instance;
		}
		
		public function Procedure(dados:Monta_MenuVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Monta_MenuService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Monta_MenuService';
		}
	}
}