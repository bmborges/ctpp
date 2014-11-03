package service.pbl
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pbl.Pbl_PublicMsgVO;
	
	public class Pbl_PublicMsgService{
		private var bridge:RemoteObject;
		private static var instance:Pbl_PublicMsgService;
		public static function getInstance():Pbl_PublicMsgService{
			if (instance == null){
				instance = new Pbl_PublicMsgService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Pbl_PublicMsgVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Pbl_PublicMsgVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Pbl_PublicMsgVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Pbl_PublicMsgVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function SelectImg(dados:Pbl_PublicMsgVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.SelectImg(dados);
			async.addResponder(new Responder(result, fault));
		}		
		
		
		public function Pbl_PublicMsgService()
		{			
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pbl_PublicMsgService';
		}
	}
}