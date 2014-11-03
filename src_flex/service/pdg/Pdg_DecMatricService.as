package service.pdg
{
	import classes.UtilRetornoBanco;
	
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.Pdg_DecMatricVO;
	
	
	public class Pdg_DecMatricService
	{
		private var bridge:RemoteObject;

		
		private static var instance:Pdg_DecMatricService;
		public static function getInstance():Pdg_DecMatricService{
			if (instance == null){
				instance = new Pdg_DecMatricService();
			}
			return instance;
		}
		
		public function select(dados:Pdg_DecMatricVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function gera_decmatric(dados:Pdg_DecMatricVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.gera_decmatric(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function Pdg_DecMatricService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_DecMatricService';
		}
	}
}