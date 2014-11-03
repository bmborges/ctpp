package service.adm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.Database;
import valueObjects.Adm_Permissao_CargoVO;

public class Adm_Permissao_CargoService {

	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private Adm_Permissao_CargoService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	public int nextval_permissaocargo() throws Exception{
		int retorno = 0;
		
		query = "select nextval('adm_permissao_cargo_id_permissaocargo');";
		
		stmt = conn.prepareStatement(query);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getInt(0);
		}

		stmt.close();
		rs.close();		
		
		return retorno;
				
	}   	
		   	
	public List select_permissaocargao(Adm_Permissao_CargoVO permissao) throws Exception{
			lista = new ArrayList();
		
			query = "select id_cargo, id_permissaocargo, id_itemnenu, nmcargo " +
					" from adm_permissao_cargo" +
					" inner join adm_cargo using (id_cargo)";

			if(permissao.getId_cargo() > 0) {
				query += "where id_cargo = ?";
			}
			
			stmt = conn.prepareStatement(query);
			
			if(permissao.getId_cargo() > 0) {
				stmt.setInt(1, permissao.getId_cargo());
			}
			rs = stmt.executeQuery();
			
			while(rs.next()){
				HashMap dados = new HashMap();
				
				dados.put("id_cargo", rs.getInt("id_cargo"));
				dados.put("id_permissaocargo", rs.getInt("id_permissaocargo"));
				dados.put("id_itemnenu", rs.getInt("id_itemnenu"));
				dados.put("nmcargo", rs.getString("nmcargo"));
				
				lista.add(dados);
			}
			
			stmt.close();
			rs.close();			
			
			return lista;
		}   	
	public int inserir_permissaocargo(Adm_Permissao_CargoVO dados) throws Exception{
			
			if (dados.getId_permissaocargo() == 0){
				dados.setId_permissaocargo(nextval_permissaocargo());
			}
			
			query = "insert into adm_permissao_cargo (id_permissaocargo , id_cargo , id_itemmenu)" +
					" values (?,?,?);";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, dados.getId_permissaocargo());
			stmt.setInt(2, dados.getId_cargo());
			stmt.setInt(3, dados.getId_itemmenu());
			stmt.executeQuery();
			
			stmt.close();
			rs.close();
			
			return dados.getId_permissaocargo();
			
	}

}
