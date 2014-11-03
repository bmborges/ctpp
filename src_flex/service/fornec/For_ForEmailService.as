package service.fornec
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fornec.For_ForEmailVO;
	
	public class For_ForEmailService
	{
		private var bridge:RemoteObject;
		
		private static var instance:For_ForEmailService;
		public static function getInstance():For_ForEmailService{
			if (instance == null){
				instance = new For_ForEmailService();
			}
			return instance;
		}
		
		public function select(dados:For_ForEmailVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:For_ForEmailVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:For_ForEmailVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:For_ForEmailVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function For_ForEmailService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'For_ForEmailService';
		}
	}
}