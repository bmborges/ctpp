package service.fpg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fpg.Fpg_HorarioTrabalhoVO;
	
	public class Fpg_HorarioTrabalhoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fpg_HorarioTrabalhoService;
		public static function getInstance():Fpg_HorarioTrabalhoService{
			if (instance == null){
				instance = new Fpg_HorarioTrabalhoService();
			}
			return instance;
		}

		public function select(dados:Fpg_HorarioTrabalhoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Fpg_HorarioTrabalhoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Fpg_HorarioTrabalhoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Fpg_HorarioTrabalhoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Fpg_HorarioTrabalhoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fpg_HorarioTrabalhoService';
		}
	}
}