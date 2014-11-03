package service.procedure
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fin_RetornoSicrediVO;
	
	public class Fin_RetornoSicrediService{
		private var bridge:RemoteObject;
		private static var instance:Fin_RetornoSicrediService;
		public static function getInstance():Fin_RetornoSicrediService{
			if (instance == null){
				instance = new Fin_RetornoSicrediService();
			}
			return instance;
		}
		public function Procedure(dados:Fin_RetornoSicrediVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Fin_RetornoSicrediService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_RetornoSicrediService';
		}
	}
}