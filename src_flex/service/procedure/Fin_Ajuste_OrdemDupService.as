package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fin_Ajuste_OrdemDupVO;
	
	
	public class Fin_Ajuste_OrdemDupService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_Ajuste_OrdemDupService;
		public static function getInstance():Fin_Ajuste_OrdemDupService{
			if (instance == null){
				instance = new Fin_Ajuste_OrdemDupService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_Ajuste_OrdemDupVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_Ajuste_OrdemDupService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_Ajuste_OrdemDupService';
		}
	}
}