package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.Pdg_DiarioStatusVO;
	
	
	public class Pdg_DiarioStatusService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_DiarioStatusService;
		public static function getInstance():Pdg_DiarioStatusService{
			if (instance == null){
				instance = new Pdg_DiarioStatusService();
			}
			return instance;
		}

		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}	
		
		public function select(dados:Pdg_DiarioStatusVO,result:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}		
		
		public function inserir(dados:Pdg_DiarioStatusVO,result:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function atualizar(dados:Pdg_DiarioStatusVO,result:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function deletar(dados:Pdg_DiarioStatusVO,result:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function Pdg_DiarioStatusService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_DiarioStatusService';
		}
	}
}