package service.adm
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.adm.Adm_operadorVO;
	
	
	public class Adm_OperadorService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Adm_OperadorService;
		public static function getInstance():Adm_OperadorService{
			if (instance == null){
				instance = new Adm_OperadorService();
			}
			return instance;
		}
		
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}	
		
		public function Adm_OperadorSemAluno(result:Function,fault:Function):void{
			ComboBoxQuery("select nmoperador as label, id_operador as data from adm_operador where (id_aluno is null and (id_cargo not in (10) or id_cargo is null)) order by nmoperador","",result,fault);
		}
		
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		
		public function select(dados:Adm_operadorVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar2(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar2(dados,null);
			async.addResponder(new Responder(result, fault));
		}		
		public function deletar(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
		public function GravaFoto(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.GravaFoto(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function updatesenha(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.updatesenha(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function GravaFotoTemp(dados:Adm_operadorVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.GravaFotoTemp(dados);
			async.addResponder(new Responder(result, fault));
		}
		
//		public function ReportDiario(p_iddiarioini:int,p_iddiariofin:int,p_idturmaini:int,p_idturmafin:int,p_imprimir:int,p_retorno:String,result:Function):void{
//			var async:AsyncToken = bridge.ReportDiario(p_iddiarioini,p_iddiariofin,p_idturmaini,p_idturmafin,p_imprimir,p_retorno);
//			async.addResponder(new Responder(result, defaultFaultHandler));		
//		}
		

		public function Adm_OperadorService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Adm_OperadorService';
		}
	}
}