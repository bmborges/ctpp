package service.procedure
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Pdg_Gera_RequerimentoVO;
	
	public class Pdg_Gera_RequerimentoService{
		private var bridge:RemoteObject;
		private static var instance:Pdg_Gera_RequerimentoService;
		public static function getInstance():Pdg_Gera_RequerimentoService{
			if (instance == null){
				instance = new Pdg_Gera_RequerimentoService();
			}
			return instance;
		}
		public function Procedure(dados:Pdg_Gera_RequerimentoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Pdg_Gera_RequerimentoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_Gera_RequerimentoService';
		}
	}
}