package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_cargoVO;
	
	
	public class Adm_CargoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_CargoService;
		public static function getInstance():Adm_CargoService{
			if (instance == null){
				instance = new Adm_CargoService();
			}
			return instance;
		}

		public function select(dados:Adm_cargoVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Adm_cargoVO,result:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function atualizar(dados:Adm_cargoVO,result:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function deletar(dados:Adm_cargoVO,result:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function Adm_CargoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_CargoService';
		}
	}
}