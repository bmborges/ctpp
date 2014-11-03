package service.procedure
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Pdg_Gera_TransferenciaVO;
	
	public class Pdg_Gera_TransferenciaService{
		private var bridge:RemoteObject;
		private static var instance:Pdg_Gera_TransferenciaService;
		public static function getInstance():Pdg_Gera_TransferenciaService{
			if (instance == null){
				instance = new Pdg_Gera_TransferenciaService();
			}
			return instance;
		}
		public function Procedure(dados:Pdg_Gera_TransferenciaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Pdg_Gera_TransferenciaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_Gera_TransferenciaService';
		}
	}
}