package service.fin
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_TipoRestricaoVO;
	
	public class Fin_TipoRestricaoService{
		private var bridge:RemoteObject;
		private static var instance:Fin_TipoRestricaoService;
		public static function getInstance():Fin_TipoRestricaoService{
			if (instance == null){
				instance = new Fin_TipoRestricaoService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Fin_TipoRestricaoVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Fin_TipoRestricaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_TipoRestricaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar2(dados:Fin_TipoRestricaoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar2(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_TipoRestricaoVO,result:Function,fault:Function):void{
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
		public function Fin_TipoRestricaoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_TipoRestricaoService';
		}
	}
}