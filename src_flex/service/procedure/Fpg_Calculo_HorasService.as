package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fpg_Calculo_HorasVO;
	
	public class Fpg_Calculo_HorasService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fpg_Calculo_HorasService;
		public static function getInstance():Fpg_Calculo_HorasService{
			if (instance == null){
				instance = new Fpg_Calculo_HorasService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fpg_Calculo_HorasVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fpg_Calculo_HorasService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fpg_Calculo_HorasService';
		}
	}
}