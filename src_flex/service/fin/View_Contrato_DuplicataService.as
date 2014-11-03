package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.View_Contrato_DuplicataVO;
	
	public class View_Contrato_DuplicataService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Contrato_DuplicataService;
		public static function getInstance():View_Contrato_DuplicataService{
			if (instance == null){
				instance = new View_Contrato_DuplicataService();
			}
			return instance;
		}
		
		public function select(dados:View_Contrato_DuplicataVO,where:Array,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function View_Contrato_DuplicataService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Contrato_DuplicataService';
		}
	}
}