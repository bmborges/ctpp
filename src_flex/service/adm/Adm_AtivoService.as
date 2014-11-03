package service.adm
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_AtivoVO;
	
	public class Adm_AtivoService{
		private var bridge:RemoteObject;
		private static var instance:Adm_AtivoService;
		public static function getInstance():Adm_AtivoService{
			if (instance == null){
				instance = new Adm_AtivoService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBoxSimNao(result:Function,fault:Function):void{
			ComboBox("nmsimnao","id_ativo",result,fault);
		}
		public function select(dados:Adm_AtivoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Adm_AtivoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Adm_AtivoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Adm_AtivoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		public function Adm_AtivoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_AtivoService';
		}
	}
}