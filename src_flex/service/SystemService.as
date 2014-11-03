package service
{
	import classes.UtilRetornoBanco;
	
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;

	public class SystemService
	{
		private var bridge:RemoteObject;
		private var retorno:UtilRetornoBanco;
		
		private static var instance:SystemService;
		public static function getInstance():SystemService{
			if (instance == null){
				instance = new SystemService();
			}
			return instance;
		}
		
		
		public function VerificaSession(result:Function):void{
			var async:AsyncToken = bridge.VerificaSession();
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		public function authlogin(username:String,password:String,result:Function):void{
			var async:AsyncToken = bridge.authlogin(username,password);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function monta_menu(id_operador:int,result:Function):void{
			var async:AsyncToken = bridge.monta_menu(id_operador);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		public function select_permissao(id_operador:int,result:Function):void{
			var async:AsyncToken = bridge.select_permissao(id_operador);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		private function defaultFaultHandler(e:FaultEvent):void{
			retorno = new UtilRetornoBanco;
			retorno.RetornoBanco(e);
//			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function SystemService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'SystemService';
		}
	}
}