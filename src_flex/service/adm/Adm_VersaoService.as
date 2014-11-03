package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_VersaoVO;
	import vo.adm.Adm_cargoVO;
	
	
	public class Adm_VersaoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_VersaoService;
		public static function getInstance():Adm_VersaoService{
			if (instance == null){
				instance = new Adm_VersaoService();
			}
			return instance;
		}

		public function select(dados:Adm_VersaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		

		public function Adm_VersaoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_VersaoService';
		}
	}
}