package service.adm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.adm.Adm_EmpresaVO;

public class Adm_EmpresaService extends AbstractService<Adm_EmpresaVO> {
	
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
		Adm_EmpresaService e =new Adm_EmpresaService();
		Adm_EmpresaVO v = new Adm_EmpresaVO();
		v.setId_empresa(3);
		e.SelectImg(v);
		
		
	}
	
	public Adm_EmpresaService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	
	public List SelectImg(Adm_EmpresaVO t)throws Exception {
		// TODO Auto-generated method stub
		lista = new ArrayList();
		
		query = "select logotipo from adm_empresa where id_empresa = ?";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, t.getId_empresa());
		
		System.out.println(stmt);
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			HashMap dados = new HashMap();
			dados.put("img", rs.getBytes("logotipo"));
			lista.add(dados);
		}
		
		stmt.close();
		rs.close();
		
		System.out.println(lista);
		
		return lista;
		
	}	
	
	
 
}
