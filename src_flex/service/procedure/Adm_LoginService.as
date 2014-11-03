package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Adm_LoginVO;
	
	
	public class Adm_LoginService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_LoginService;
		public static function getInstance():Adm_LoginService{
			if (instance == null){
				instance = new Adm_LoginService();
			}
			return instance;
		}
		
		public function Procedure(dados:Adm_LoginVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Adm_LoginService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_LoginService';
		}
	}
}