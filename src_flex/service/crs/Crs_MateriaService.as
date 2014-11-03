package service.crs
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.crs.Crs_MateriaVO;
	import vo.ctr.Ctr_DocumentacaoVO;
	
	
	
	public class Crs_MateriaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Crs_MateriaService;
		public static function getInstance():Crs_MateriaService{
			if (instance == null){
				instance = new Crs_MateriaService();
			}
			return instance;
		}

		public function select(dados:Crs_MateriaVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Crs_MateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Crs_MateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Crs_MateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function MateriaAproveitamento(id:Object,result:Function,fault:Function):void{
			ComboBoxQuery("select id_turmamateria as data, nmmateria as label from ctr_turmamateria" +
				" inner join crs_cursomateria using (id_cursomateria)" +
				" inner join crs_materia using (id_materia)" +
				" where id_contrato = ?::integer and (media is null or unid_ensino is not null) and aprov_materia = 1",id,result,fault);
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		public function Crs_MateriaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Crs_MateriaService';
		}
	}
}