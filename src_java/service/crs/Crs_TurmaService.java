package service.crs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.crs.Crs_TurmaVO;

public class Crs_TurmaService extends AbstractService<Crs_TurmaVO>{
	
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

	public Crs_TurmaService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
//	public List Select_AlunoTurma(Crs_TurmaVO turma, Alu_AlunoVO aluno) throws Exception{
//		lista = new ArrayList();
//		
//		query = "select id_aluno, nome from ctr_contrato" +
//				" inner join alu_aluno using (id_aluno)" +
//				" where id_ctrstatus != 9";
//		
//				if (turma.getId_turma() > 0) {
//					query += " and id_turma = ?";
//				}
//				if (aluno.getNome().length() > 0) {
//					query += " and lower(remove_acento(nome)) ilike lower(remove_acento(?))";
//				}
//				
//				query += " order by nome";
//
//		stmt = conn.prepareStatement(query);
//		int i = 1;
//		if (turma.getId_turma() > 0) {
//			stmt.setInt(i, turma.getId_turma());
//			i++;
//		}
//		if (aluno.getNome().length() > 0) {
//			stmt.setString(i, aluno.getNome());
//		}
//
//		System.out.println("Select_AlunoTurma>>>>>>>> "+stmt);
//		
//		rs = stmt.executeQuery();
//		
//		while(rs.next()){
//			HashMap dados = new HashMap();
//
//			dados.put("id_aluno", rs.getInt("id_aluno"));
//			dados.put("nome", rs.getString("nome"));
//			
//			lista.add(dados);
//		}
//		
//		stmt.close();
//		rs.close();			
//		
//		return lista;
//	}
	
	
	
 
}
