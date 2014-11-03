package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_FeriasVO;
	
	public class Adm_FeriasService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_FeriasService;
		public static function getInstance():Adm_FeriasService{
			if (instance == null){
				instance = new Adm_FeriasService();
			}
			return instance;
		}

		public function select(dados:Adm_FeriasVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Adm_FeriasVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Adm_FeriasVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Adm_FeriasVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Adm_FeriasService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_FeriasService';
		}
	}
}