package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.Pdg_DiarioContVO;
	
	
	public class Pdg_DiarioContService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_DiarioContService;
		public static function getInstance():Pdg_DiarioContService{
			if (instance == null){
				instance = new Pdg_DiarioContService();
			}
			return instance;
		}

		public function select(dados:Pdg_DiarioContVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Pdg_DiarioContVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function atualizar(dados:Pdg_DiarioContVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Pdg_DiarioContVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Pdg_DiarioContService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_DiarioContService';
		}
	}
}