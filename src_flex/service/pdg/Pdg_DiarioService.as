package service.pdg
{
	import mx.controls.Alert;
	import mx.rpc.AsyncToken;
	import mx.rpc.Responder;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.RemoteObject;
	
	import vo.pdg.Pdg_DiarioContVO;
	import vo.pdg.Pdg_DiarioVO;
	
	public class Pdg_DiarioService
	{
		private var bridge:RemoteObject;
		
		private static var instance:Pdg_DiarioService;
		public static function getInstance():Pdg_DiarioService{
			if (instance == null){
				instance = new Pdg_DiarioService();
			}
			return instance;
		}

		public function select(dados:Pdg_DiarioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select(dados,null,null);
			async.addResponder(new Responder(result, fault));
		}
		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);
			async.addResponder(new Responder(result, fault));
		}
		
		public function atualizar(dados:Pdg_DiarioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar2(dados:Pdg_DiarioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar2(dados,null);
			async.addResponder(new Responder(result, fault));
		}
		public function atualizar_status(dados:Pdg_DiarioVO,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.atualizar_status(dados);
			async.addResponder(new Responder(result, fault));
		}
		
		
//		public function select_diario(id_diario:int,result:Function,fault:Function):void{
//			var async:AsyncToken = bridge.select_diario(id_diario);
//			async.addResponder(new Responder(result, fault));
//		}
		public function update_diarionotas(id_diarionotas:int,campo:String,valor:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.update_diarionotas(id_diarionotas,campo,valor);
			async.addResponder(new Responder(result, fault));
		}
		public function select_diarioatividades(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select_diarioatividades(id_diario);
			async.addResponder(new Responder(result, fault));
		}
		public function select_diarioatividades_qtd_ativi(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select_diarioatividades_qtd_ativi(id_diario);
			async.addResponder(new Responder(result, fault));
		}
		public function update_diarioatividades(id_diarionotas:int,campo:String,valor:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.update_diarioatividades(id_diarionotas,campo,valor);
			async.addResponder(new Responder(result, fault));
		}
		public function pdg_cria_atividades(id_diario:int,descricao:String,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.pdg_cria_atividades(id_diario,descricao,data);
			async.addResponder(new Responder(result, fault));
		}
		public function select_cabecalho_atividades(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select_cabecalho_atividades(id_diario);
			async.addResponder(new Responder(result, fault));
		}
		
		public function select_diarioatividades2(id_diario:int,id_atividade:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select_diarioatividades2(id_diario,id_atividade);
			async.addResponder(new Responder(result, fault));
		}
		public function deleta_diarioatividades(id_diario:int,id_atividade:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.deleta_diarioatividades(id_diario,id_atividade);
			async.addResponder(new Responder(result, fault));
		}
//		public function pdg_diario_media(id_diario:int,result:Function,fault:Function):void{
//			var async:AsyncToken = bridge.pdg_diario_media(id_diario);
//			async.addResponder(new Responder(result, fault));
//		}

		public function select_diariofaltas(id_diario:int,dt_aula:String,id_aluno:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.select_diariofaltas(id_diario,dt_aula,id_aluno);
			async.addResponder(new Responder(result, fault));
		}
		public function update_diariofaltas(id_diariofaltas:int,id_ativo:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.update_diariofaltas(id_diariofaltas,id_ativo);
			async.addResponder(new Responder(result, fault));
		}
		public function pdg_diario_falta(id_diario:int,data:String,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.pdg_diario_falta(id_diario,data);
			async.addResponder(new Responder(result, fault));
		}

		
		public function GraficoFaltaDiario(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.GraficoFaltaDiario(id_diario);
			async.addResponder(new Responder(result, fault));		
		}
		public function GraficoNotaDiario(id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.GraficoNotaDiario(id_diario);
			async.addResponder(new Responder(result, fault));		
		}
		public function EnviarMensagemContArquivo(parametros:Object,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.EnviarMensagemContArquivo(parametros);
			async.addResponder(new Responder(result, fault));
		}
		
		// academico
		
		public function ConteudoFalta(id_turma:int,id_aluno:int,id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.ConteudoFalta(id_turma,id_aluno,id_diario);
			async.addResponder(new Responder(result, fault));		
		}
		public function GraficoFalta(id_turma:int,id_aluno:int,id_diario:int,result:Function,fault:Function):void{
			var async:AsyncToken = bridge.GraficoFalta(id_turma,id_aluno,id_diario);
			async.addResponder(new Responder(result, fault));		
		}
//		public function GraficoNota(id_turma:int,id_aluno:int,id_diario:int,result:Function,fault:Function):void{
//			var async:AsyncToken = bridge.GraficoNota(id_turma,id_aluno,id_diario);
//			async.addResponder(new Responder(result, fault));		
//		}
//		
		
		

		public function Pdg_DiarioService()
		{
			bridge = new RemoteObject();
			bridge.showBusyCursor = true;
			bridge.destination = 'Pdg_DiarioService';
		}
	}
}