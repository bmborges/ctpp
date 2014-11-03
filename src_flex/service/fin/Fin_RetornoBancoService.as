package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_RetornoBancoVO;
	
	
	public class Fin_RetornoBancoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_RetornoBancoService;
		public static function getInstance():Fin_RetornoBancoService{
			if (instance == null){
				instance = new Fin_RetornoBancoService();
			}
			return instance;
		}

		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.combobox(label,data);
			async.addResponder(new Responder(result,fault));
		}
		
		public function select(dados:Fin_RetornoBancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		public function inserir(dados:Fin_RetornoBancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_RetornoBancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_RetornoBancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Fin_RetornoBancoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_RetornoBancoService';
		}
	}
}