package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fin_Gera_MalaDiretaVO;
	
	
	public class Fin_Gera_MalaDiretaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_Gera_MalaDiretaService;
		public static function getInstance():Fin_Gera_MalaDiretaService{
			if (instance == null){
				instance = new Fin_Gera_MalaDiretaService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_Gera_MalaDiretaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_Gera_MalaDiretaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_Gera_MalaDiretaService';
		}
	}
}