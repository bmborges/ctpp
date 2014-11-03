package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.Pdg_Diario_Novos_AlunosVO;
	
	
	public class Pdg_Diario_Novos_AlunosService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_Diario_Novos_AlunosService;
		public static function getInstance():Pdg_Diario_Novos_AlunosService{
			if (instance == null){
				instance = new Pdg_Diario_Novos_AlunosService();
			}
			return instance;
		}
		
		public function Procedure(dados:Pdg_Diario_Novos_AlunosVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Pdg_Diario_Novos_AlunosService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_Diario_Novos_AlunosService';
		}
	}
}