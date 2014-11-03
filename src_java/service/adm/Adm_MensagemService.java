package service.adm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.Adm_MensagemVO;

public class Adm_MensagemService extends AbstractService<Adm_MensagemVO>{
	
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
		
		Adm_MensagemService s = new Adm_MensagemService();
		Adm_MensagemVO t = new Adm_MensagemVO();
		
		Object[][] where = new Object[2][3]; 
		
		where[0][0] = "id_operador";
		where[0][1] = "=";
		where[0][2] = "2";

		where[1][0] = "dt_mensagem";
		where[1][1] = ">=";
		where[1][2] = "2012-01-05::timestamp";
		
		s.select(t, where, null);

	}

	public Adm_MensagemService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}

	
	@Override
	public List atualizar(Adm_MensagemVO t, Object[][] where) throws Exception {
		query = "update adm_mensagem set id_situacao = ? " +
				"	where id_mensagem = ?";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, t.getId_situacao());
		stmt.setInt(2, t.getId_mensagem());
		
		stmt.executeUpdate();
		
		stmt.close();
		return null;
	}
	public List select_lidas(HashMap parametros) throws Exception{
		lista = new ArrayList();
		
		query = "select * from adm_mensagem " +
				"	where id_situacao = 2 " +
				"	and id_operador = ?::integer" +
				"	and date(dt_mensagem) >= date(?::timestamp)" +
				"	and date(dt_mensagem) <= date(?::timestamp)";
		
		
		stmt = conn.prepareStatement(query);
		
		stmt.setString(1, parametros.get("id_operador").toString());
		stmt.setString(2, parametros.get("dt_inicial").toString());
		stmt.setString(3, parametros.get("dt_final").toString());
		
		rs = stmt.executeQuery();
		
		while(rs.next()){
			HashMap dados = new HashMap();
			
			dados.put("id_mensagem", rs.getInt("id_mensagem"));
			dados.put("id_operador", rs.getInt("id_operador"));
			dados.put("mensagem", rs.getString("mensagem"));
			dados.put("assunto", rs.getString("assunto"));
			dados.put("id_situacao", rs.getInt("id_situacao"));
			dados.put("dt_mensagem", rs.getString("dt_mensagem"));
			dados.put("id_remetente", rs.getInt("id_remetente"));
			
			lista.add(dados);
		}
		
		System.out.print(lista);
		
		stmt.close();
		rs.close();			
		
		return lista;
	}
	
}
