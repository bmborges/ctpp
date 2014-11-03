package service.ctr
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_menuVO;
	import vo.adm.Adm_menunivel1VO;
	import vo.adm.Adm_menunivel2VO;
	import vo.ctr.Ctr_ContratoVO;
	
	
	public class Ctr_ReportService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Ctr_ReportService;
		public static function getInstance():Ctr_ReportService{
			if (instance == null){
				instance = new Ctr_ReportService();
			}
			return instance;
		}

		public function ReportContratoBranco(id_tipocurso:int,retorno:String,result:Function):void{
			var async:AsyncToken = bridge.ReportContratoBranco(id_tipocurso,retorno);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function ReportContrato(dados:Ctr_ContratoVO,retorno:String,result:Function):void{
			var async:AsyncToken = bridge.ReportContrato(dados,retorno);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultDetail,e.fault.faultString);
		}
		public function Ctr_ReportService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_ReportService';
		}
	}
}