package service.fpg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fpg.Fpg_AdmissaoVO;
	
	
	public class Fpg_AdmissaoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fpg_AdmissaoService;
		public static function getInstance():Fpg_AdmissaoService{
			if (instance == null){
				instance = new Fpg_AdmissaoService();
			}
			return instance;
		}

		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}	
		
		public function select(dados:Fpg_AdmissaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Fpg_AdmissaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fpg_AdmissaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fpg_AdmissaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Fpg_AdmissaoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fpg_AdmissaoService';
		}
	}
}