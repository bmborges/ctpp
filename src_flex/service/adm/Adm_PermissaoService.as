package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_operadorVO;
	
	public class Adm_PermissaoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_PermissaoService;
		public static function getInstance():Adm_PermissaoService{
			if (instance == null){
				instance = new Adm_PermissaoService();
			}
			return instance;
		}
		
		public function Adm_permissaoauto(dados:Adm_operadorVO,result:Function):void{
			var async:AsyncToken = bridge.Adm_permissaoauto(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function deletar_todas(dados:Adm_operadorVO,result:Function):void{
			var async:AsyncToken = bridge.deletar_todas(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function tree_permissao(dados:Adm_operadorVO,result:Function):void{
			var async:AsyncToken = bridge.tree_permissao(dados);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function adm_permissao(id:int, idoperador:int,operacao:int,result:Function):void{
			var async:AsyncToken = bridge.adm_permissao(id,idoperador,operacao);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function Adm_PermissaoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_PermissaoService';
		}
	}
}