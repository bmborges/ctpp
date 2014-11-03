package service.fpg
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fpg.Fpg_Ponto_DadosAhgoraVO;
	
	public class Fpg_Ponto_DadosAhgoraService{
		private var bridge:RemoteObject;
		private static var instance:Fpg_Ponto_DadosAhgoraService;
		public static function getInstance():Fpg_Ponto_DadosAhgoraService{
			if (instance == null){
				instance = new Fpg_Ponto_DadosAhgoraService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Fpg_Ponto_DadosAhgoraVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Fpg_Ponto_DadosAhgoraVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fpg_Ponto_DadosAhgoraVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fpg_Ponto_DadosAhgoraVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function StringJson(dados:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.StringJson(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Fpg_Ponto_DadosAhgoraService()
		{			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fpg_Ponto_DadosAhgoraService';
		}
	}
}