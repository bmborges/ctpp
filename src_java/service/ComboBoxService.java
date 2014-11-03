package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.Database;
import valueObjects.ComboBoxVO;

public class ComboBoxService {
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public ComboBoxService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public static void main(String[] args) throws Exception {
		ComboBoxService s = new ComboBoxService();
		s.ComboBox("pdg_diariostatus","nmstatus","id_status");
	}
	
	public List ComboBox(String table,String label,String data) throws Exception{
		
		lista = new ArrayList();
		
	    query = "select "+ data +" as data, "+ label +" as label from "+ table +
	    		"	order by " + data;

	    stmt = conn.prepareStatement(query);
	    System.out.println(stmt);
	    
	    rs = stmt.executeQuery();
		
	    ComboBoxVO combo = new ComboBoxVO();
		combo.setData(null);
		combo.setLabel("Selecione...");
		lista.add(combo);
		
		while(rs.next()){
			combo = new ComboBoxVO();
			combo.setData(rs.getString("data"));
			combo.setLabel(rs.getString("label"));
			lista.add(combo);
		}

		stmt.close();
		rs.close();
		
        return lista;						

	}
	public List ComboBoxQuery(String query, int atributo) throws Exception{
		
		lista = new ArrayList();
		
	    stmt = conn.prepareStatement(query);
	    
	    if (atributo > 0){
	    	stmt.setInt(1, atributo);
	    }
		rs = stmt.executeQuery();
		

	    ComboBoxVO combo = new ComboBoxVO();
		combo.setData(null);
		combo.setLabel("Selecione...");
		lista.add(combo);
		
		while(rs.next()){
			combo = new ComboBoxVO();
			combo.setData(rs.getString("data"));
			combo.setLabel(rs.getString("label"));
			lista.add(combo);
		}

		stmt.close();
		rs.close();
		
        return lista;						

	}

}
