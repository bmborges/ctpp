package service.procedure
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Fin_Gera_Confissao_DividaVO;
	
	
	public class Fin_Gera_Confissao_DividaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_Gera_Confissao_DividaService;
		public static function getInstance():Fin_Gera_Confissao_DividaService{
			if (instance == null){
				instance = new Fin_Gera_Confissao_DividaService();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_Gera_Confissao_DividaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_Gera_Confissao_DividaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_Gera_Confissao_DividaService';
		}
	}
}