package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_BancoVO;
	
	
	public class Fin_BancoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_BancoService;
		public static function getInstance():Fin_BancoService{
			if (instance == null){
				instance = new Fin_BancoService();
			}
			return instance;
		}

		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.combobox(label,data);
			async.addResponder(new Responder(result,fault));
		}
		
		public function select(dados:Fin_BancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		public function inserir(dados:Fin_BancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_BancoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_BancoVO,result:Function,fault:Function):void{
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
		
		public function ComboBoxBancoAtivo(result:Function,fault:Function):void{
			var qry:String = "select id_banco as data, nmbanco as label from fin_banco where id_ativo = ?::integer";
			ComboBoxQuery(qry,"1",result,fault);
		}
		
		public function Fin_BancoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_BancoService';
		}
	}
}