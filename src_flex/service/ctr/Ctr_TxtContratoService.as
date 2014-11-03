package service.ctr
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.Ctr_TxtContratoVO;
	
	
	
	public class Ctr_TxtContratoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Ctr_TxtContratoService;
		public static function getInstance():Ctr_TxtContratoService{
			if (instance == null){
				instance = new Ctr_TxtContratoService();
			}
			return instance;
		}

		public function select(dados:Ctr_TxtContratoVO,result:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}		
		
		public function inserir(dados:Ctr_TxtContratoVO,result:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function atualizar(dados:Ctr_TxtContratoVO,result:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function deletar(dados:Ctr_TxtContratoVO,result:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function Ctr_TxtContratoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_TxtContratoService';
		}
	}
}