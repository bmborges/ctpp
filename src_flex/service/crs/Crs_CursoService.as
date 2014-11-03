package service.crs
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.crs.Crs_CursoVO;
	
	public class Crs_CursoService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Crs_CursoService;
		public static function getInstance():Crs_CursoService{
			if (instance == null){
				instance = new Crs_CursoService();
			}
			return instance;
		}

		public function ComboBox(label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBox(label,data);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function select(dados:Crs_CursoVO,result:Function,fault:Function,where:Array,order:Array):void{
			var async:AsyncToken = bridge.select(dados,where,order);
			async.addResponder(new Responder(result, fault));
		}		
		
		public function inserir(dados:Crs_CursoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.inserir(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar(dados:Crs_CursoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function deletar(dados:Crs_CursoVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deletar(dados);
			async.addResponder(new Responder(result, fault));
		}
		public function CursoAtivo(result:Function,fault:Function):void{
			ComboBoxQuery("select id_curso as data, nmcurso as label from crs_curso where id_ativo = ?::integer order by nmcurso","1",result,fault);
		}
		
		public function CursoMateria(id:Object,result:Function,fault:Function):void{
			ComboBoxQuery("select id_cursomateria as data, nmmateria as label from crs_cursomateria cm	left join crs_materia m using (id_materia)	where id_curso = ?::integer	order by nmmateria",id,result,fault);
		}
		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		
		
		public function Crs_CursoService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Crs_CursoService';
		}
	}
}