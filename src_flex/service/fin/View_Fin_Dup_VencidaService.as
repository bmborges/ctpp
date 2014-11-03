package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.View_Fin_Dup_VencidaVO;
	
	public class View_Fin_Dup_VencidaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Fin_Dup_VencidaService;
		public static function getInstance():View_Fin_Dup_VencidaService{
			if (instance == null){
				instance = new View_Fin_Dup_VencidaService();
			}
			return instance;
		}
		
		public function select(dados:View_Fin_Dup_VencidaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function View_Fin_Dup_VencidaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Fin_Dup_VencidaService';
		}
	}
}