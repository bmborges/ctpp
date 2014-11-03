package service.view
{
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.view.View_Ctr_TurmaMateriaVO;
	
	public class View_Ctr_TurmaMateriaService{
		private var bridge:RemoteObject;
		private static var instance:View_Ctr_TurmaMateriaService;
		public static function getInstance():View_Ctr_TurmaMateriaService{
			if (instance == null){
				instance = new View_Ctr_TurmaMateriaService();
			}
			return instance;
		}
		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select(dados:View_Ctr_TurmaMateriaVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		public function View_Ctr_TurmaMateriaService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'View_Ctr_TurmaMateriaService';
		}
	}
}