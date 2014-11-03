package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import util.Database;

public class Frm_PesquisaService {
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public Frm_PesquisaService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public static void main(String[] args) throws Exception {
		Frm_PesquisaService s = new Frm_PesquisaService();
		s.ConsultaRel("alu_aluno", "nome", "id_aluno", 22);
	}
	
	public String ConsultaRel(String tabela,String campo,String atributo,int id) throws Exception{
		String retorno = "";
		
		query = "SELECT "+ campo +" from "+ tabela +"  where "+ atributo +" = ? ";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id);
		
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getString(1);
		}
		
		stmt.close();
		rs.close();
		
		
		return retorno;
	}
	public List Select_Operador(int limite,String nome) throws Exception{
		lista = new ArrayList();
		
		query = "SELECT * from adm_operador o ";
//				"where id_aluno is null";
		if(nome.length() > 0){
			query += " where";
					query += " lower(remove_acento(nmoperador)) ilike lower(remove_acento(?))";
		}
	query += " order by nmoperador limit ?";
	
	
	stmt = conn.prepareStatement(query);
	int i = 1;
	if (nome.length() > 0){
		stmt.setString(i, nome);
		i++;
	}	
	
	stmt.setInt(i, limite);
	rs = stmt.executeQuery();
	
	while(rs.next()){
		HashMap dados = new HashMap();
		dados.put("id_operador", rs.getInt("id_operador"));
		dados.put("nmoperador", rs.getString("nmoperador"));
		dados.put("cpf", rs.getString("cpf"));
		
		lista.add(dados);
	}
	
	stmt.close();
	rs.close();
	
	return lista;
		
	}

	public List Select_Aluno(int limite, String nome) throws Exception{
		lista = new ArrayList();
		
		query = "SELECT id_aluno, nome, rg, cpf, nmsexo, to_char(dt_nascimento,'dd/mm/yyyy') as dt_nascimento, profissao" +
				" from alu_aluno a" +
				" inner join adm_sexo using (id_sexo)" +
				" left join adm_estadocivil es using (id_estadocivil)";
			
		if (nome.length() > 0){
			query += " where lower(remove_acento(nome)) ilike lower(remove_acento(?))";
		}
			
		query += " order by nome limit ?";
		stmt = conn.prepareStatement(query);
		
		int i = 1;
		if (nome.length() > 0){
			stmt.setString(i, nome);
			i++;
		}	
		
		stmt.setInt(i, limite);
		System.out.println("select_Aluno>>>>> "+stmt);
		
		rs = stmt.executeQuery();
		
		while(rs.next()){
			HashMap dados = new HashMap();
			dados.put("id_aluno", rs.getInt("id_aluno"));
			dados.put("nome", rs.getString("nome"));
			dados.put("rg", rs.getString("rg"));
			dados.put("cpf", rs.getString("cpf"));
			dados.put("nmsexo", rs.getString("nmsexo"));
			dados.put("dt_nascimento", rs.getString("dt_nascimento"));
			dados.put("profissao", rs.getString("profissao"));
			
			lista.add(dados);
		}
		
		stmt.close();
		rs.close();
		
   		return lista;
	}
	public List Select_Turma(int limite, String nome) throws Exception{
		lista = new ArrayList();
   		query = "SELECT t.id_turma, nmturma, to_char(dt_inicial,'dd/mm/yyyy') as dt_inicial, to_char(dt_final,'dd/mm/yyyy') as dt_final," +
   				" nmcurso as curso, status" +
   				" from crs_turma t" +
   				" left join crs_sala s using (id_sala)" +
   				" left join crs_curso c using (id_curso)";
   			
		if (nome.length() > 0){
			query += " where lower(remove_acento(nmcurso)) ilike lower(remove_acento(?))";
		}
   			
		query += " order by nmturma limit ?";
   		
   		stmt = conn.prepareStatement(query);
		int i = 1;
		if (nome.length() > 0){
			stmt.setString(i, nome);
			i++;
		}	
		
		stmt.setInt(i, limite);
		System.out.println("selectTable_diario>>>>> "+stmt);
		rs = stmt.executeQuery();
		
		while(rs.next()){
			HashMap dados = new HashMap();
			dados.put("id_turma", rs.getInt("id_turma"));
			dados.put("nmturma", rs.getString("nmturma"));
			dados.put("dt_inicial", rs.getString("dt_inicial"));
			dados.put("dt_final", rs.getString("dt_final"));
			dados.put("curso", rs.getString("curso"));
			dados.put("status", rs.getString("status"));
			
			
			lista.add(dados);
		}
		
		stmt.close();
		rs.close();
		
   		return lista;
   		
	}
//	function selectTable_curso($limite,$nome){
//		
//		$query = "SELECT id_curso, nmcurso 
//				from crs_curso";
//
//		if (strlen($nome) > 0){
//			$query = $query." where lower(remove_acento(nmcurso)) ilike lower(remove_acento('%".$nome."%'))";
//		}	
//		$query = $query." order by nmcurso limit $limite";
//
//		return pg_query($query);
//	}
//	function selectTable_sala($limite,$nome){
//		
//		$query = "SELECT id_sala, nmsala, capacidade, qtde_micros 
//				from crs_sala";
//
//		if (strlen($nome) > 0){
//			$query = $query." where lower(remove_acento(nmsala)) ilike lower(remove_acento('%".$nome."%'))";
//		}	
//   			
//		$query = $query." order by nmsala limit $limite";
//
//		return pg_query($query);
//	}	
//	function selectTable_contrato($limite,$nome){
//		
//		$query = "select cont.id_contrato, al.id_aluno, al.nome from ctr_contrato cont
//				inner join alu_aluno al using (id_aluno)";
//			
//		if (strlen($nome) > 0){
//			$query = $query." where lower(remove_acento(al.nome)) ilike lower(remove_acento('%".$nome."%'))";
//		}
//			
//		$query = $query." order by cont.id_contrato limit $limite";
//		
//		return pg_query($query);
//	}
	public List select_contratoAcademico(int id_aluno) throws Exception{
		lista = new ArrayList();
		
		query = "select cont.id_contrato, al.id_aluno, al.nome, t.nmturma, t.id_turma" +
			" from ctr_contrato cont" +
			" inner join alu_aluno al using (id_aluno)" +
			" inner join crs_turma t using (id_turma)" +
			" where id_aluno = ? and id_ctrstatus != 9" +
			" order by cont.id_contrato";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_aluno);
		
		rs = stmt.executeQuery();
		
		while (rs.next()) {
			HashMap dados = new HashMap();
			dados.put("id_contrato", rs.getInt("id_contrato"));
			dados.put("id_aluno", rs.getInt("id_aluno"));
			dados.put("nome", rs.getString("nome"));
			dados.put("nmturma", rs.getString("nmturma"));
			dados.put("id_turma", rs.getInt("id_turma"));
			
			lista.add(dados);
		}

//		System.out.println(lista);
		return lista;
	}
}

