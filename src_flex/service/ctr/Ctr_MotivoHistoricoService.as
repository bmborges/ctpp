package service.ctr
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.Ctr_MotivoHistoricoVO;
	
	public class Ctr_MotivoHistoricoService{
		private var bridge:RemoteObject;
		private static var instance:Ctr_MotivoHistoricoService;
		public static function getInstance():Ctr_MotivoHistoricoService{
			if (instance == null){
				instance = new Ctr_MotivoHistoricoService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Ctr_MotivoTipoHistorico(atributo:Object,result:Function,fault:Function):void{
			ComboBoxQuery("SELECT id_motivohistorico as data, nmmotivohistorico as label from ctr_motivohistorico where id_tipohistorico = ?::integer order by nmmotivohistorico",atributo,result,fault);
		}
		
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		
		public function select(dados:Ctr_MotivoHistoricoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function inserir(dados:Ctr_MotivoHistoricoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Ctr_MotivoHistoricoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Ctr_MotivoHistoricoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function Ctr_MotivoHistoricoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_MotivoHistoricoService';
		}
	}
}