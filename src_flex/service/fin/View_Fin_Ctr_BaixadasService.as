package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.View_Fin_Ctr_BaixadasVO;
	
	public class View_Fin_Ctr_BaixadasService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Fin_Ctr_BaixadasService;
		public static function getInstance():View_Fin_Ctr_BaixadasService{
			if (instance == null){
				instance = new View_Fin_Ctr_BaixadasService();
			}
			return instance;
		}
		
		public function select(dados:View_Fin_Ctr_BaixadasVO,result:Function,fault:Function, where:Array):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function View_Fin_Ctr_BaixadasService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Fin_Ctr_BaixadasService';
		}
	}
}