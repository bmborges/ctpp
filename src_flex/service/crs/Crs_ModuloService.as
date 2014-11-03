package service.crs
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.crs.Crs_ModuloVO;
	
	public class Crs_ModuloService{
		private var bridge:RemoteObject;
		private static var instance:Crs_ModuloService;
		public static function getInstance():Crs_ModuloService{
			if (instance == null){
				instance = new Crs_ModuloService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Crs_ModuloVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Crs_ModuloVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Crs_ModuloVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Crs_ModuloVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function ModuloContrato(atributo:Object,result:Function,fault:Function):void{
			var qry:String = "select distinct id_modulo as data, nmmodulo as label from crs_turma t" +
				" inner join crs_cursomateria using (id_curso)" +
				" inner join crs_modulo using (id_modulo)" +
				" inner join ctr_contrato using (id_turma)" +
				" where id_contrato = ?::integer order by nmmodulo";
			ComboBoxQuery(qry,atributo,result,fault);
		}

		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		public function Crs_ModuloService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Crs_ModuloService';
		}
	}
}