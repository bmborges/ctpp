package service
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	public class ComboBoxService
	{
		private var bridge:RemoteObject;
		
		private static var instance:ComboBoxService;
		public static function getInstance():ComboBoxService{
			if (instance == null){
				instance = new ComboBoxService();
			}
			return instance;
		}
		
		public function Adm_Ativo(result:Function,fault:Function):void{
			ComboBox("adm_ativo","nmativo","id_ativo",result,fault);
		}
		public function Adm_SimNao(result:Function,fault:Function):void{
			ComboBox("adm_ativo","nmsimnao","id_ativo",result,fault);
		}
		public function Adm_Estado(result:Function,fault:Function):void{
			ComboBoxQuery("SELECT id_estado as data, nmestado as label from adm_estado order by ordem desc",0,result,fault);
		}
		public function Adm_Cidade(id:int,result:Function,fault:Function):void{
			ComboBoxQuery("SELECT id_cidade as data, nmcidade as label from adm_cidade where id_estado = ? order by nmcidade",id,result,fault);
		}
		public function Adm_LimitReg(result:Function,fault:Function):void{
			ComboBox("adm_limitreg","limite","limite",result,fault);
		}
		public function Banco(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.fin_banco();
			async.addResponder(new Responder(result,fault));
		}		
		public function Adm_Cargo(result:Function,fault:Function):void{
			ComboBox("adm_cargo","nmcargo","id_cargo",result,fault);
		}
		public function Adm_Deficiencia(result:Function,fault:Function):void{
			ComboBox("adm_deficiencia","nmdeficiencia","id_deficiencia",result,fault);
		}
		public function Adm_Nacionalidade(result:Function,fault:Function):void{
			ComboBoxQuery("SELECT id_nacionalidade as data, nmnacionalidade as label from adm_nacionalidade order by ordem desc",0,result,fault);
		}
		public function Adm_TipoTel(result:Function,fault:Function):void{
			ComboBox("adm_tipotel","nmtipo","id_tipotel",result,fault);
		}
		public function Adm_TipoEnd(result:Function,fault:Function):void{
			ComboBox("adm_tipoend","nmtipoend","id_tipoend",result,fault);
		}
		public function CondPgto(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.fin_condpgto();
			async.addResponder(new Responder(result,fault));
		}
		public function Adm_Sexo(result:Function,fault:Function):void{
			ComboBox("adm_sexo","nmsexo","id_sexo",result,fault);
		}		
		public function Ctr_Status(result:Function,fault:Function):void{
			ComboBox("ctr_status","id_ctrstatus||' - '||nmstatus","id_ctrstatus",result,fault);
		}
		public function ContatoStatus(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.cnt_contatostatus();
			async.addResponder(new Responder(result,fault));
		}
		public function ContatoPeriodo(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.crs_periodo();
			async.addResponder(new Responder(result,fault));
		}
		public function Colaborador(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.colaborador();
			async.addResponder(new Responder(result,fault));
		}
		public function Educador(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.educador();
			async.addResponder(new Responder(result,fault));
		}
		public function Adm_EstadoCivil(result:Function,fault:Function):void{
			ComboBox("adm_estadocivil","nmestadocivil","id_estadocivil",result,fault);
		}
		public function TipoRecebimento(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.fin_tiporec();
			async.addResponder(new Responder(result,fault));
		}
		public function Fin_TipoPagamento(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Fin_TipoPagamento();
			async.addResponder(new Responder(result,fault));
		}
		public function Crs_TipoCurso(result:Function,fault:Function):void{
			ComboBox("crs_tipocurso","nmtipo","id_tipocurso",result,fault);
		}
		public function Materia(result:Function,fault:Function):void{
			ComboBox("crs_materia","nmmateria","id_materia",result,fault);
		}
		public function Sala(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.crs_sala();
			async.addResponder(new Responder(result,fault));
		}		
		public function DiaSemana(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.adm_dow();
			async.addResponder(new Responder(result,fault));
		}
		public function Modulo(result:Function,fault:Function):void{
			ComboBox("crs_modulo","nmmodulo","id_modulo",result,fault);
		}
		public function Adm_Menu(result:Function,fault:Function):void{
			ComboBox("adm_menu","label","id_menu",result,fault);
		}
		public function Adm_MenuNivel1(result:Function,fault:Function):void{
			ComboBox("adm_menunivel1","label","id_menunivel1",result,fault);
		}
		public function Adm_MenuNivel2(result:Function,fault:Function):void{
			ComboBox("adm_menunivel2","label","id_menunivel2",result,fault);
		}
		public function Crs_curso(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.crs_curso();
			async.addResponder(new Responder(result,fault));
		}
		public function Adm_Empresa(result:Function,fault:Function):void{
			ComboBox("adm_empresa","nmfantasia","id_empresa",result,fault);
		}
		public function Pdg_DiarioStatus(result:Function,fault:Function):void{
			ComboBox("pdg_diariostatus","nmstatus","id_status",result,fault);
		}
		
		public function Fin_diaspagamento(id:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.fin_diaspagamento(id);
			async.addResponder(new Responder(result,fault));
		}
		public function TurmaModulo(id:int,result:Function,fault:Function):void{
			ComboBoxQuery("select distinct id_modulo as data, nmmodulo as label from crs_turma t" +
				"	inner join crs_cursomateria using (id_curso)" +
				"	inner join crs_modulo using (id_modulo)" +
				"	inner join ctr_contrato using (id_turma)" +
				"	where id_contrato = ? order by nmmodulo",id,result,fault);
		}
		public function ctr_tipohistorico(result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ctr_tipohistorico();
			async.addResponder(new Responder(result,fault));
		}
		public function ctr_motivohistorico(id_tipohistorico:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ctr_motivohistorico(id_tipohistorico);
			async.addResponder(new Responder(result,fault));
		}
		public function pdg_diario_dtaula(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.pdg_diario_dtaula(id_diario);
			async.addResponder(new Responder(result,fault));
		}
		public function pdg_diario_alunos(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.pdg_diario_alunos(id_diario);
			async.addResponder(new Responder(result,fault));
		}
		public function diario_modulo(id_turma:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.diario_modulo(id_turma);
			async.addResponder(new Responder(result,fault));
		}
		
		public function ComboBox(table:String,label:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.combobox(table,label,data);
			async.addResponder(new Responder(result,fault));
		}
		public function ComboBoxQuery(query:String,atributo:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);
			async.addResponder(new Responder(result,fault));
		}
		
//		private function defaultFaultHandler(e:FaultEvent):void{
//			Alert.show(e.fault.faultDetail,e.fault.faultString);
//		}
		public function ComboBoxService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'ComboBoxService';
		}
	}
}