package service.ctr
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.Ctr_ContrColabVO;
	
	public class Ctr_ContrColabService{
		private var bridge:RemoteObject;
		private static var instance:Ctr_ContrColabService;
		public static function getInstance():Ctr_ContrColabService{
			if (instance == null){
				instance = new Ctr_ContrColabService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Ctr_ContrColabVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Ctr_ContrColabVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Ctr_ContrColabVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Ctr_ContrColabVO,result:Function,fault:Function):void{
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
		public function Ctr_ContrColabService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_ContrColabService';
		}
	}
}