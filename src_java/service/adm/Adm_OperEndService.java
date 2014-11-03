package service.adm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.Adm_OperEndVO;

public class Adm_OperEndService extends AbstractService<Adm_OperEndVO>{
	
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

	public Adm_OperEndService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	
	@Override
	public int inserir(Adm_OperEndVO t) throws Exception {
		// TODO Auto-generated method stub
		super.inserir(t);
		return t.getId_operend();
	}
	
	
}
