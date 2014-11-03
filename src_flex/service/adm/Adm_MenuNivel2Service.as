package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_menunivel2VO;
	
	
	public class Adm_MenuNivel2Service
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_MenuNivel2Service;
		public static function getInstance():Adm_MenuNivel2Service{
			if (instance == null){
				instance = new Adm_MenuNivel2Service();
			}
			return instance;
		}
		
		public function select(dados:Adm_menunivel2VO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Adm_menunivel2VO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Adm_menunivel2VO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Adm_menunivel2VO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Adm_MenuNivel2Service()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_MenuNivel2Service';
		}
	}
}