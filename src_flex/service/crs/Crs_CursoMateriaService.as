package service.crs
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.crs.Crs_CursoMateriaVO;
	
	public class Crs_CursoMateriaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Crs_CursoMateriaService;
		public static function getInstance():Crs_CursoMateriaService{
			if (instance == null){
				instance = new Crs_CursoMateriaService();
			}
			return instance;
		}
		
		public function select(dados:Crs_CursoMateriaVO,result:Function,fault:Function,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,order);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Crs_CursoMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Crs_CursoMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Crs_CursoMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Crs_CursoMateriaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Crs_CursoMateriaService';
		}
	}
}