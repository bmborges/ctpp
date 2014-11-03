package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_GeraBoletoVO;
	
	public class Fin_GeraBoletoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_GeraBoletoService;
		public static function getInstance():Fin_GeraBoletoService{
			if (instance == null){
				instance = new Fin_GeraBoletoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_GeraBoletoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_GeraBoletoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_GeraBoletoService';
		}
	}
}