package service.ctr
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.View_Ctr_GeraBoletoVO;
	
	public class View_Ctr_GeraBoletoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Ctr_GeraBoletoService;
		public static function getInstance():View_Ctr_GeraBoletoService{
			if (instance == null){
				instance = new View_Ctr_GeraBoletoService();
			}
			return instance;
		}
		
		public function select(dados:View_Ctr_GeraBoletoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function View_Ctr_GeraBoletoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Ctr_GeraBoletoService';
		}
	}
}