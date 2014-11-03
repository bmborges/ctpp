package service
{
	import classes.UtilRetornoBanco;
	
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	

	public class ReportService
	{
		private var bridge:RemoteObject;
		
		private static var instance:ReportService;
		public static function getInstance():ReportService{
			if (instance == null){
				instance = new ReportService();
			}
			return instance;
		}
		
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		
		public function ReportService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'ReportService';
		}
	}
}