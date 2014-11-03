package service
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.alu.Alu_RespVO;
	

	public class Frm_PesquisaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Frm_PesquisaService;
		public static function getInstance():Frm_PesquisaService{
			if (instance == null){
				instance = new Frm_PesquisaService();
			}
			return instance;
		}
		public function ConsultaRel(tabela:String, campo:String, atributo:String, id:int, result:Function):void{
			var async:AsyncToken = bridge.consultarel(tabela,campo,atributo,id);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function selectTable_contrato(limite:int, txtnome:String, result:Function):void{
			var async:AsyncToken = bridge.selectTable_contrato(limite, txtnome);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function selectTable_sala(limite:int, txtnome:String, result:Function):void{
			var async:AsyncToken = bridge.selectTable_sala(limite, txtnome);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function selectTable_curso(limite:int, txtnome:String, result:Function):void{
			var async:AsyncToken = bridge.selectTable_curso(limite, txtnome);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}		
		public function Select_Turma(limite:int, txtnome:String, result:Function):void{
			var async:AsyncToken = bridge.Select_Turma(limite, txtnome);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function Select_Operador(limite:int, txtnome:String, result:Function):void{
			var async:AsyncToken = bridge.Select_Operador(limite, txtnome);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}

		public function selectTable_diario_logado(limite:int, id_operador:int, result:Function):void{
			var async:AsyncToken = bridge.selectTable_diario_logado(limite, id_operador);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		public function select_contratoAcademico(id_aluno:int, result:Function):void{
			var async:AsyncToken = bridge.select_contratoAcademico(id_aluno);
			async.addResponder(new Responder(result, defaultFaultHandler));
		}
		private function defaultFaultHandler(e:FaultEvent):void{
			Alert.show(e.fault.faultString, e.fault.faultDetail);
		}
		public function Frm_PesquisaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Frm_PesquisaService';
		}
	}
}