package service.crs
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.crs.Crs_TurmaEduVO;
	
	public class Crs_TurmaEduService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Crs_TurmaEduService;
		public static function getInstance():Crs_TurmaEduService{
			if (instance == null){
				instance = new Crs_TurmaEduService();
			}
			return instance;
		}
		
		public function select(dados:Crs_TurmaEduVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Crs_TurmaEduVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Crs_TurmaEduVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Crs_TurmaEduVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}

		
		public function Crs_TurmaEduService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Crs_TurmaEduService';
		}
	}
}