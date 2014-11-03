package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_operendVO;
	
	
	public class Adm_OperendService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_OperendService;
		public static function getInstance():Adm_OperendService{
			if (instance == null){
				instance = new Adm_OperendService();
			}
			return instance;
		}
		
		
		public function select(dados:Adm_operendVO,result:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}		
		
		public function inserir(dados:Adm_operendVO,result:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function atualizar(dados:Adm_operendVO,result:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function deletar(dados:Adm_operendVO,result:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function Adm_OperendService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_OperEndService';
		}
	}
}