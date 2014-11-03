package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fpg_Ponto_TrocadoVO;
	
	
	public class Fpg_Ponto_TrocadoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fpg_Ponto_TrocadoService;
		public static function getInstance():Fpg_Ponto_TrocadoService{
			if (instance == null){
				instance = new Fpg_Ponto_TrocadoService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fpg_Ponto_TrocadoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fpg_Ponto_TrocadoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fpg_Ponto_TrocadoService';
		}
	}
}