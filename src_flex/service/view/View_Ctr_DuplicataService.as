package service.view
{
	
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.view.View_Ctr_DuplicataVO;
	
	public class View_Ctr_DuplicataService{
		private var bridge:RemoteObject;
		private static var instance:View_Ctr_DuplicataService;
		public static function getInstance():View_Ctr_DuplicataService{
			if (instance == null){
				instance = new View_Ctr_DuplicataService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:View_Ctr_DuplicataVO,where:Array,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:View_Ctr_DuplicataVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:View_Ctr_DuplicataVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:View_Ctr_DuplicataVO,result:Function,fault:Function):void{
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
		public function View_Ctr_DuplicataService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Ctr_DuplicataService';
		}
	}
}