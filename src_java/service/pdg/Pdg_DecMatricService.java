package service.pdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.Pdg_DecMatricVO;

public class Pdg_DecMatricService extends AbstractService<Pdg_DecMatricVO>{
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public Pdg_DecMatricService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public static void main(String[] args) throws Exception {
		Pdg_DecMatricService s = new Pdg_DecMatricService();
		Pdg_DecMatricVO dados = new Pdg_DecMatricVO();
		dados.setId_operador(2);
		dados.setId_contrato(268);
		
		s.gera_decmatric(dados);
	}
	
	public int gera_decmatric(Pdg_DecMatricVO dados) throws Exception{
		int retorno = 0;
		
		query = "select pdg_gera_decmatric(?,?);";
		
		stmt = conn.prepareStatement(query);
		
		stmt.setInt(1, dados.getId_operador());
		stmt.setInt(2, dados.getId_contrato());
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getInt(1);
		}

		stmt.close();
		rs.close();		
		
		return retorno;
				
	}   	
		
}
