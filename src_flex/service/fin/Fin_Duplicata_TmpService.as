package service.fin
{
	
	
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_Duplicata_TmpVO;
	
	public class Fin_Duplicata_TmpService{
		private var bridge:RemoteObject;
		private static var instance:Fin_Duplicata_TmpService;
		public static function getInstance():Fin_Duplicata_TmpService{
			if (instance == null){
				instance = new Fin_Duplicata_TmpService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Fin_Duplicata_TmpVO,where:Array,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Fin_Duplicata_TmpVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_Duplicata_TmpVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_Duplicata_TmpVO,result:Function,fault:Function):void{
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
		public function SqlAtualizar(sql:String,where:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.SqlAtualizar(sql,where);
			async.addResponder(new Responder(result, fault));
		}
		public function Fin_Duplicata_TmpService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_Duplicata_TmpService';
		}
	}

}