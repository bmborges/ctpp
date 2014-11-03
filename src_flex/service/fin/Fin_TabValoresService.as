package service.fin
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_TabValoresVO;
	
	public class Fin_TabValoresService{
		private var bridge:RemoteObject;
		private static var instance:Fin_TabValoresService;
		public static function getInstance():Fin_TabValoresService{
			if (instance == null){
				instance = new Fin_TabValoresService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:Fin_TabValoresVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Fin_TabValoresVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fin_TabValoresVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fin_TabValoresVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function DiaPagamentoCurso(atributo:Object,result:Function,fault:Function):void{
			var qry:String = "select id_tabvalores as data, 'Dia: '||extract('day' from dt_vencto)||' - Valor: '|| valor ||' - Qtde. Parc. '|| qtd_parcelas  as label from crs_turma" +
				" inner join fin_tabvalores using (id_curso)" +
				" inner join ctr_contrato using (id_turma)" +
				" where id_contrato = ?::integer" +
				" order by label";
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
		public function Fin_TabValoresService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_TabValoresService';
		}
	}
}