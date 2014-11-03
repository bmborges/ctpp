package service.fornec
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fornec.For_FornecedorVO;
	
	
	public class For_FornecedorService
	{
		private var bridge:RemoteObject;
		
		private static var instance:For_FornecedorService;
		public static function getInstance():For_FornecedorService{
			if (instance == null){
				instance = new For_FornecedorService();
			}
			return instance;
		}
		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		
		public function select(dados:For_FornecedorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:For_FornecedorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:For_FornecedorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:For_FornecedorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function For_FornecedorService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'For_FornecedorService';
		}
	}
}