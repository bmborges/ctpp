package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_EstadoVO;
	
	
	public class Adm_EstadoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_EstadoService;
		public static function getInstance():Adm_EstadoService{
			if (instance == null){
				instance = new Adm_EstadoService();
			}
			return instance;
		}
		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}	
		public function Adm_EstadoOrdem(result:Function,fault:Function):void{
			ComboBoxQuery("SELECT id_estado as data, nmestado as label from adm_estado order by ordem desc, nmestado",null,result,fault);
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		
		public function select(dados:Adm_EstadoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Adm_EstadoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Adm_EstadoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Adm_EstadoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		

		public function Adm_EstadoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_EstadoService';
		}
	}
}