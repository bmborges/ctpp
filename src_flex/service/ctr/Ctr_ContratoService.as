package service.ctr
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.Ctr_ContratoVO;
	
	
	public class Ctr_ContratoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Ctr_ContratoService;
		public static function getInstance():Ctr_ContratoService{
			if (instance == null){
				instance = new Ctr_ContratoService();
			}
			return instance;
		}
		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		
		public function select(dados:Ctr_ContratoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Ctr_ContratoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Ctr_ContratoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Ctr_ContratoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		public function ReportContratoBranco(id_tipocurso:int,retorno:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ReportContratoBranco(id_tipocurso,retorno);
			async.addResponder(new Responder(result, fault));
		}
		public function SqlAtualizar(sql:String,where:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.SqlAtualizar(sql,where);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Ctr_ContratoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_ContratoService';
		}
	}
}