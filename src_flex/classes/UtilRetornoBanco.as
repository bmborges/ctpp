package classes
{
	import mx.controls.Alert;
	import mx.rpc.events.FaultEvent;

	public class UtilRetornoBanco
	{
		private static const Unicidade:String = "Registro já Existe.";
		
		public function RetornoBanco(e:FaultEvent):void
		{
			var msg:String = e.fault.faultString;
			msg = msg.replace("java.lang.Exception :","");
			msg = msg.replace("ERRO:","");
			msg = msg.replace("org.postgresql.util.PSQLException :","");
			msg = msg.replace("This connection has been closed.","A conexão foi encerrada, feche o navegador e abra novamente.");
			msg = msg.replace("duplicar valor da chave viola a restrição de unicidade \"adm_operador_nickname\"","Esse nome de Usuário já existe");
			msg = msg.replace("duplicar valor da chave viola a restrição de unicidade \"fin_retornobanco_id_banco_key\"","Arquivo já esta Gravado");
			
			msg = msg.replace("Cannot invoke method","Não é possível chamar o Método ");
			

			if(msg.indexOf("duplicar valor") == 1){
				msg = "Registro já existe";
			}
			if (msg.indexOf("atualização ou exclusão em tabela") == 1 ){
				msg = "Atualização ou Exclusão não Permitida, registro possui dependência(s)";
			}
			
			
			Alert.show(msg,"Alerta !");
		}
		public function RetornoBancoString(e:FaultEvent):String
		{
			var msg:String = e.fault.faultString;
			msg = msg.replace("java.lang.Exception :","");
			msg = msg.replace("ERRO:","");
			msg = msg.replace("org.postgresql.util.PSQLException :","");
			msg = msg.replace("This connection has been closed.","A conexão foi encerrada, feche o navegador e abra novamente.");
			msg = msg.replace("duplicar valor da chave viola a restrição de unicidade \"adm_operador_nickname\"","Esse nome de Usuário já existe");
			msg = msg.replace("duplicar valor da chave viola a restrição de unicidade \"fin_retornobanco_id_banco_key\"","Arquivo já esta Gravado");
			
			msg = msg.replace("Cannot invoke method","Não é possível chamar o Método ");
			
			
			if(msg.indexOf("duplicar valor") == 1){
				msg = "Registro já existe";
			}
			if (msg.indexOf("atualização ou exclusão em tabela") == 1 ){
				msg = "Atualização ou Exclusão não Permitida, registro possui dependência(s)";
			}
			
			return msg;	
		}
	}
}