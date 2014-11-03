package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.Pdg_DiarioArquivosVO;
	
	
	public class Pdg_DiarioArquivosService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_DiarioArquivosService;
		public static function getInstance():Pdg_DiarioArquivosService{
			if (instance == null){
				instance = new Pdg_DiarioArquivosService();
			}
			return instance;
		}

		public function select(dados:Pdg_DiarioArquivosVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Pdg_DiarioArquivosVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Pdg_DiarioArquivosVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Pdg_DiarioArquivosVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function baixar_arquivo(dados:Pdg_DiarioArquivosVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.baixar_arquivo(dados);
			async.addResponder(new Responder(result, fault));
		}	
		
		
		public function Pdg_DiarioArquivosService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_DiarioArquivosService';
		}
	}
}