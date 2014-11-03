package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_DuplicataVO;
	
	
	public class Fin_DuplicataService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_DuplicataService;
		public static function getInstance():Fin_DuplicataService{
			if (instance == null){
				instance = new Fin_DuplicataService();
			}
			return instance;
		}

		
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		
		public function SqlAtualizar(sql:String,where:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.SqlAtualizar(sql,where);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function select(dados:Fin_DuplicataVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Fin_DuplicataVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_DuplicataVO,where:Array,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,where);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_DuplicataVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function DuplicataBoleto(duplicata:Fin_DuplicataVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.DuplicataBoleto(duplicata);
			async.addResponder(new Responder(result, fault));		
		}
		public function GeraBoleto(id_contrato:Object,id_banco:Object, id_modulo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.GeraBoleto(id_contrato,id_banco, id_modulo);
			async.addResponder(new Responder(result, fault));		
		}		
		
		
		public function Fin_DuplicataService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_DuplicataService';
		}
	}
}