package service.view
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.view.View_Fin_MalaDiretaVO;
	
	public class View_Fin_MalaDiretaService{
		private var bridge:RemoteObject;
		private static var instance:View_Fin_MalaDiretaService;
		public static function getInstance():View_Fin_MalaDiretaService{
			if (instance == null){
				instance = new View_Fin_MalaDiretaService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:View_Fin_MalaDiretaVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,order);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:View_Fin_MalaDiretaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:View_Fin_MalaDiretaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:View_Fin_MalaDiretaVO,result:Function,fault:Function):void{
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
		public function View_Fin_MalaDiretaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Fin_MalaDiretaService';
		}
	}
}