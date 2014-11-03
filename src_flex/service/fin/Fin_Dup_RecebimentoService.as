package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_Dup_RecebimentoVO;
	
	public class Fin_Dup_RecebimentoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_Dup_RecebimentoService;
		public static function getInstance():Fin_Dup_RecebimentoService{
			if (instance == null){
				instance = new Fin_Dup_RecebimentoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_Dup_RecebimentoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_Dup_RecebimentoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_Dup_RecebimentoService';
		}
	}
}