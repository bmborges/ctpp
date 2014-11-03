package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Adm_PermissaoAutoVO;
	
	
	public class Adm_PermissaoAutoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_PermissaoAutoService;
		public static function getInstance():Adm_PermissaoAutoService{
			if (instance == null){
				instance = new Adm_PermissaoAutoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Adm_PermissaoAutoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Adm_PermissaoAutoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_PermissaoAutoService';
		}
	}
}