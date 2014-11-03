package service.procedure
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.procedure.Tree_Permissao_RelatorioVO;
	
	public class Tree_Permissao_RelatorioService{
		private var bridge:RemoteObject;
		private static var instance:Tree_Permissao_RelatorioService;
		public static function getInstance():Tree_Permissao_RelatorioService{
			if (instance == null){
				instance = new Tree_Permissao_RelatorioService();
			}
			return instance;
		}
		public function Procedure(dados:Tree_Permissao_RelatorioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Tree_Permissao_RelatorioService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Tree_Permissao_RelatorioService';
		}
	}
}