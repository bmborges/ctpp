package service.alu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.Adm_OperEndVO;
import valueObjects.alu.Alu_AlunoEndVO;

public class Alu_AlunoEndService extends AbstractService<Alu_AlunoEndVO>{
	
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

	public Alu_AlunoEndService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	@Override
	public int inserir(Alu_AlunoEndVO t) throws Exception {
		// TODO Auto-generated method stub
		super.inserir(t);
		return t.getId_alunoend();
	}
	
}
