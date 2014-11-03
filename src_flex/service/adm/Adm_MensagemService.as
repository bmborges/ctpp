package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_MensagemVO;
	
	
	public class Adm_MensagemService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_MensagemService;
		public static function getInstance():Adm_MensagemService{
			if (instance == null){
				instance = new Adm_MensagemService();
			}
			return instance;
		}
		
		public function select(dados:Adm_MensagemVO,where:Object,order:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}		
		public function inserir(dados:Adm_MensagemVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Adm_MensagemVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Adm_MensagemVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Adm_MensagemService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_MensagemService';
		}
	}
}