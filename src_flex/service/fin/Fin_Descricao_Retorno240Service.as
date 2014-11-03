package service.fin
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.fin.Fin_Descricao_Retorno240VO;
	
	public class Fin_Descricao_Retorno240Service
	{
		private var bridge:RemoteObject;
		
		private static var instance:Fin_Descricao_Retorno240Service;
		public static function getInstance():Fin_Descricao_Retorno240Service{
			if (instance == null){
				instance = new Fin_Descricao_Retorno240Service();
			}
			return instance;
		}
		
		public function Procedure(dados:Fin_Descricao_Retorno240VO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Procedure(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Fin_Descricao_Retorno240Service()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Fin_Descricao_Retorno240Service';
		}
	}
}