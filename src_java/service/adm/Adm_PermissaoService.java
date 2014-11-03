package service.adm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import util.Database;
import valueObjects.adm.Adm_OperadorVO;

public class Adm_PermissaoService {
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

	public Adm_PermissaoService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	public String Adm_permissaoauto(Adm_OperadorVO operador) throws Exception{

		query = "select adm_permissaoauto(?);";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, operador.getId_operador());

		System.out.println(stmt);
		
		stmt.executeUpdate();
		stmt.close();
		
		retorno = tree_permissao(operador);
		
		return retorno;
	}
	public String deletar_todas(Adm_OperadorVO operador) throws Exception{
		query = "delete from adm_permissao where id_operador = ?";
		
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, operador.getId_operador());

		System.out.println(stmt);
		
		stmt.executeUpdate();
		stmt.close();
		
		retorno = tree_permissao(operador);
		
		return retorno;
	}
	public String tree_permissao(Adm_OperadorVO operador) throws Exception{
		query = "select tree_permissao(?)";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, operador.getId_operador());

		rs = stmt.executeQuery();
		if(rs.next()){
			retorno = rs.getString("tree_permissao");
		}
		
		System.out.println(retorno);
		
		stmt.close();
		rs.close();
		
   		return retorno;
	}
	public void adm_permissao(int id, int idoperador,int operacao) throws Exception{
		query = "select adm_permissao(?,?,?);";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		stmt.setInt(2, idoperador);
		stmt.setInt(3, operacao);

		System.out.println(stmt);
		
		stmt.executeQuery();
		
		stmt.close();
		
	}	
	
	
 
}
