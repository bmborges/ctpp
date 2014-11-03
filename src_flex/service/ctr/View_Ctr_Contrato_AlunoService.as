package service.ctr
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.view.View_Ctr_Contrato_AlunoVO;
	
	
	public class View_Ctr_Contrato_AlunoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:View_Ctr_Contrato_AlunoService;
		public static function getInstance():View_Ctr_Contrato_AlunoService{
			if (instance == null){
				instance = new View_Ctr_Contrato_AlunoService();
			}
			return instance;
		}
		
		public function select(dados:View_Ctr_Contrato_AlunoVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}

		
		
		public function View_Ctr_Contrato_AlunoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Ctr_Contrato_AlunoService';
		}
	}
}