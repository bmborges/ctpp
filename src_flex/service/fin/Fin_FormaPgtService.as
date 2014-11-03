package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_FormaPgtVO;
	
	
	public class Fin_FormaPgtService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_FormaPgtService;
		public static function getInstance():Fin_FormaPgtService{
			if (instance == null){
				instance = new Fin_FormaPgtService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.combobox(label,data);
			async.addResponder(new Responder(result,fault));
		}
		

		public function select(dados:Fin_FormaPgtVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Fin_FormaPgtVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_FormaPgtVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_FormaPgtVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Fin_FormaPgtService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_FormaPgtService';
		}
	}
}