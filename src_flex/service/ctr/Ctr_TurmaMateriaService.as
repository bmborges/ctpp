package service.ctr
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.ctr.Ctr_TurmaMateriaVO;
	
	public class Ctr_TurmaMateriaService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Ctr_TurmaMateriaService;
		public static function getInstance():Ctr_TurmaMateriaService{
			if (instance == null){
				instance = new Ctr_TurmaMateriaService();
			}
			return instance;
		}

		public function select(dados:Ctr_TurmaMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Ctr_TurmaMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Ctr_TurmaMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar2(dados:Ctr_TurmaMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar2(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Ctr_TurmaMateriaVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		
		public function Ctr_TurmaMateriaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Ctr_TurmaMateriaService';
		}
	}
}