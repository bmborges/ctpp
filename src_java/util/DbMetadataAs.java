package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DbMetadataAs {
	
	Connection conn = null;
	ResultSet rs = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DbMetadataAs md = new DbMetadataAs();
		md.GetMetaData("Ctr_FinRestricao");

		

	}
	
	public DbMetadataAs() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	public void GetMetaData(String tabela) throws Exception{
		try {
			boolean fazer = true;
			DatabaseMetaData metadata = conn.getMetaData();
		    ResultSet resultSet = null;
		    resultSet = metadata.getColumns(null, null, tabela.toLowerCase(), null);
		    String out = null;
		    String tb[] = new String[2];
		    
		    tb = tabela.split("_");
		    
//		    resultSet = metadata.getPrimaryKeys(null, null, "adm_ativo");
		    while (resultSet.next()) {
		    	fazer = false;
		    	String name = resultSet.getString("COLUMN_NAME");
		    	String type = resultSet.getString("TYPE_NAME");
		    	
		    	if(resultSet.isFirst()){
		    		out = "[Bindable]\n" +
		    			  "[RemoteClass(alias=\"valueObjects."+tb[0].toLowerCase()+"."+tabela+"VO\")]\n" +
		    			  "public class "+tabela+"VO\n" +
		    			  "{";
		    		System.out.println(out);
		    	}

				System.out.println("public var "+ name+":Object;");
				if(resultSet.isLast()){
					System.out.println("}");
				}	
		    }
		    resultSet.close();
		   if (!fazer){
			   Service(tabela, 0);
		   } else {
			   resultSet = metadata.getProcedureColumns(null, null, tabela.toLowerCase(), null);
			   while (resultSet.next()) {
				   String name = resultSet.getString("COLUMN_NAME");
			    	String type = resultSet.getString("TYPE_NAME");
			    	
			    	if(resultSet.isFirst()){
			    		out = "[Bindable]\n" +
			    			  "[RemoteClass(alias=\"valueObjects.procedure."+tabela+"VO\")]\n" +
			    			  "public class "+tabela+"VO\n" +
			    			  "{";
			    		System.out.println(out);
			    	}

					System.out.println("public var "+ name+":Object;");
					if(resultSet.isLast()){
						System.out.println("}");
					}	
			    }
			   Service(tabela, 1);
		   }
		    
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
				conn.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void Service(String tabela, int tipo) throws Exception{
		String out = null;
		
		System.out.println("\n");
		System.out.println("\n");
		
		out = "import mx.rpc.AsyncToken;\n" +
				"import mx.rpc.Responder;\n" +
				"import mx.rpc.remoting.RemoteObject;\n" +
				"\n" +
				"public class "+tabela+"Service{\n" +
				"private var bridge:RemoteObject;\n" +
				"private static var instance:"+tabela+"Service;\n" +
				"public static function getInstance():"+tabela+"Service{\n" +
					"if (instance == null){\n" +
						"	instance = new "+tabela+"Service();\n" +
						"}\n" +
						"return instance;\n" +
				"}\n";
		if (tipo == 0 && !tabela.toLowerCase().contains("view")) {							
				out += "public function ComboBox(label:String,data:String,result:Function,fault:Function):void{\n" +
				"			var async:AsyncToken = bridge.ComboBox(label,data);\n" +
				"			async.addResponder(new Responder(result, fault));\n" +
				"		}\n" +
				"		public function select(dados:"+tabela+"VO,result:Function,fault:Function,where:Array,order:Array):void{\n" +
				"			var async:AsyncToken = bridge.select(dados,null,null);\n" +
				"			async.addResponder(new Responder(result, fault));\n" +
				"		}\n" +
				"		public function inserir(dados:"+tabela+"VO,result:Function,fault:Function):void{\n" +
				"			var async:AsyncToken = bridge.inserir(dados);\n" +
				"			async.addResponder(new Responder(result, fault));\n" +
				"		}\n" +
				"		public function atualizar(dados:"+tabela+"VO,result:Function,fault:Function):void{\n" +
				"			var async:AsyncToken = bridge.atualizar(dados,null);\n" +
				"			async.addResponder(new Responder(result, fault));\n" +
				"		}\n" +
				"		public function deletar(dados:"+tabela+"VO,result:Function,fault:Function):void{\n" +
				"			var async:AsyncToken = bridge.deletar(dados);\n" +
				"			async.addResponder(new Responder(result, fault));\n" +
				"		}\n" +
				"		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{\n" +
				"			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);\n" +
				"			async.addResponder(new Responder(result,fault));\n" +
				"		}\n" +
				"		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{\n" +
				"			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);\n" +
				"			async.addResponder(new Responder(result, fault));\n" +
				"		}\n";
		}
		if (tipo == 1){
			 out += "public function Procedure(dados:"+tabela+"VO,result:Function,fault:Function):void{\n" +
					"	var async:AsyncToken = bridge.Procedure(dados);\n" +
					"	async.addResponder(new Responder(result, fault));\n" +
					"}\n";
		}
		if (tipo == 0 && tabela.toLowerCase().contains("view")) {						
			out += "public function ComboBox(label:String,data:String,result:Function,fault:Function):void{\n" +
			"			var async:AsyncToken = bridge.ComboBox(label,data);\n" +
			"			async.addResponder(new Responder(result, fault));\n" +
			"		}\n" +
			"		public function select(dados:"+tabela+"VO,result:Function,fault:Function,where:Array,order:Array):void{\n" +
			"			var async:AsyncToken = bridge.select(dados,null,null);\n" +
			"			async.addResponder(new Responder(result, fault));\n" +
			"		}\n" +
			"		public function ComboBoxQuery(query:String,atributo:Object,result:Function,fault:Function):void{\n" +
			"			var async:AsyncToken = bridge.ComboBoxQuery(query,atributo);\n" +
			"			async.addResponder(new Responder(result,fault));\n" +
			"		}\n" +
			"		public function Report(parametros:Object,p_retorno:String,relatorio:String,pasta:String,result:Function,fault:Function):void{\n" +
			"			var async:AsyncToken = bridge.Report(parametros,p_retorno,relatorio,pasta);\n" +
			"			async.addResponder(new Responder(result, fault));\n" +
			"		}\n";
		}
		out += "public function "+tabela+"Service()\n" +
		"		{\n" +
		"			bridge = new RemoteObject();\n" +
		"			bridge.showBusyCursor = true;\n" +
		"			bridge.destination = '"+tabela+"Service';\n" +
		"		}\n" +
		"}";
		
		

		System.out.println(out);
		
	}
	
	
	public String TrocaType(String tipo){
		String retorno = "";
		if (tipo.equals("int4")||tipo.equals("int2")||tipo.equals("serial")){
			retorno = "Integer";
		} else if (tipo.equals("varchar")||tipo.equals("bpchar")||tipo.equals("text")){
			retorno = "String";
		} else if (tipo.equals("timestamp")){
			retorno = "Timestamp";
		} else {
			retorno = tipo;
		}

		
		
		return retorno;
	}

}
