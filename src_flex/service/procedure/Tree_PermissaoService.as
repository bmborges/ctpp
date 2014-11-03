package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Tree_PermissaoVO;
	
	
	public class Tree_PermissaoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Tree_PermissaoService;
		public static function getInstance():Tree_PermissaoService{
			if (instance == null){
				instance = new Tree_PermissaoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Tree_PermissaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Tree_PermissaoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Tree_PermissaoService';
		}
	}
}