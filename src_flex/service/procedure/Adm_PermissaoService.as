package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Adm_PermissaoVO;
	
	
	public class Adm_PermissaoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_PermissaoService;
		public static function getInstance():Adm_PermissaoService{
			if (instance == null){
				instance = new Adm_PermissaoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Adm_PermissaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Adm_PermissaoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'P_Adm_PermissaoService';
		}
	}
}