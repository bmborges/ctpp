package service.ctr
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.Ctr_RequerimentoVO;
	
	public class Ctr_RequerimentoService{
		private var bridge:RemoteObject;
		private static var instance:Ctr_RequerimentoService;
		public static function getInstance():Ctr_RequerimentoService{
			if (instance == null){
				instance = new Ctr_RequerimentoService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Ctr_RequerimentoVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Ctr_RequerimentoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Ctr_RequerimentoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Ctr_RequerimentoVO,result:Function,fault:Function):void{
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
		public function Ctr_RequerimentoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_RequerimentoService';
		}
	}
}