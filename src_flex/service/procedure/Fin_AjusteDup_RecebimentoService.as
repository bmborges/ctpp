package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fin_AjusteDup_RecebimentoVO;
	
	
	public class Fin_AjusteDup_RecebimentoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_AjusteDup_RecebimentoService;
		public static function getInstance():Fin_AjusteDup_RecebimentoService{
			if (instance == null){
				instance = new Fin_AjusteDup_RecebimentoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_AjusteDup_RecebimentoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_AjusteDup_RecebimentoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_AjusteDup_RecebimentoService';
		}
	}
}