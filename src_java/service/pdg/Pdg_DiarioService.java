package service.pdg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import service.AbstractService;
import util.Database;
import valueObjects.pdg.Pdg_DiarioVO;

public class Pdg_DiarioService extends AbstractService<Pdg_DiarioVO>{
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public Pdg_DiarioService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public static void main(String[] args) throws Exception {
		Pdg_DiarioService s = new Pdg_DiarioService();
		Pdg_DiarioVO v = new Pdg_DiarioVO();
		
		
		v.setId_diario(121);
		
//		s.GraficoNota(19, 39, 59);
		s.select(v, null, null);
	}
	public int nextval_diario() throws Exception{
		int retorno = 0;
		query = "select nextval('pdg_diario_id_diario');";
		
		stmt = conn.prepareStatement(query);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getInt(1);
		}
		
		stmt.close();
		rs.close();

		return retorno;
				
	}
	public int nextval_diarionotas() throws Exception{
		int retorno = 0;
		
		query = "select nextval('pdg_diarionotas_id_diarionotas');";
		
		stmt = conn.prepareStatement(query);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getInt(0);
		}

		stmt.close();
		rs.close();		
		
		return retorno;
				
	}
	
	public int atualizar_status(Pdg_DiarioVO t) throws Exception {
		// TODO Auto-generated method stub
		
		query = "update pdg_diario set id_status = ? where id_diario = ?;";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, t.getId_status());
		stmt.setInt(2, t.getId_diario());
		stmt.executeUpdate();
		
		return t.getId_status();
	}
	
	
	public void update_diarionotas(int id_diarionotas,String campo,Double valor) throws Exception{
		query = "update pdg_diarionotas set "+ campo +" = ? where id_diarionotas = ? ";
		
		stmt = conn.prepareStatement(query);
		stmt.setDouble(1, valor);
		stmt.setInt(2, id_diarionotas);
		
		System.out.println("update_diarionotas>>>>> "+stmt);
		
		int rows = stmt.executeUpdate();
		
		if (rows <= 0){
			throw new Exception("Erro update_diarionotas");
		}
		
	}
	public List select_cabecalho_atividades(int id_diario) throws Exception{
		lista = new ArrayList();
		
		query = "select distinct	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 1),'dd/mm/yyyy'),'') as dtatividade1," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 2),'dd/mm/yyyy'),'') as dtatividade2," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 3),'dd/mm/yyyy'),'') as dtatividade3," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 4),'dd/mm/yyyy'),'') as dtatividade4," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 5),'dd/mm/yyyy'),'') as dtatividade5," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 6),'dd/mm/yyyy'),'') as dtatividade6," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 7),'dd/mm/yyyy'),'') as dtatividade7," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 8),'dd/mm/yyyy'),'') as dtatividade8," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 9),'dd/mm/yyyy'),'') as dtatividade9," +
				"	coalesce(to_char((select distinct data from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas and id_atividade = 10),'dd/mm/yyyy'),'') as dtatividade10" +
				"	from pdg_diarionotas dn" +
				"	inner join alu_aluno using (id_aluno)" +
				"	where id_diario = ?";

		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_diario);
		rs = stmt.executeQuery();

		if (rs.next()){
			
			HashMap dados = new HashMap();
			
			dados.put("dtatividade1", rs.getString("dtatividade1"));
			dados.put("dtatividade2", rs.getString("dtatividade2"));
			dados.put("dtatividade3", rs.getString("dtatividade3"));
			dados.put("dtatividade4", rs.getString("dtatividade4"));
			dados.put("dtatividade5", rs.getString("dtatividade5"));
			dados.put("dtatividade6", rs.getString("dtatividade6"));
			dados.put("dtatividade7", rs.getString("dtatividade7"));
			dados.put("dtatividade8", rs.getString("dtatividade8"));
			dados.put("dtatividade9", rs.getString("dtatividade9"));
			dados.put("dtatividade10", rs.getString("dtatividade10"));
			
			lista.add(dados);
		}
		
			return lista;
	}
	public int select_diarioatividades_qtd_ativi(int id_diario) throws Exception{
		int retorno = 0;
		
		query = "select distinct (select count(id_atividade) from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas ) as qtd_ativi" +
				"	from pdg_diarionotas dn" +
				"	inner join alu_aluno using (id_aluno)" +
				"	where id_diario = ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_diario);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getInt("qtd_ativi");
		}
		
		
		stmt.close();
		rs.close();

			
		return retorno;
	}
	public void update_diarioatividades(int id_diarionotas, int campo, Double valor) throws Exception{
		query = "update pdg_diarioatividades set" +
				"	nota = ? where id_diarionotas = ? and id_atividade = ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setDouble(1, valor);
		stmt.setInt(2, id_diarionotas);
		stmt.setInt(3, campo);
		
		System.out.println("update_diarioatividades>>>>>>>>>>"+stmt);
		
		stmt.executeUpdate();
		
		stmt.close();

	}

		public List select_diarioatividades(int id_diario) throws Exception{
			
			lista = new ArrayList();
			
			query = "select * from pdg_diario_atividades" +
					"	where id_diario = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_diario);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				HashMap dados = new HashMap();

				dados.put("id_diarionotas", rs.getInt("id_diarionotas"));
				dados.put("id_aluno", rs.getInt("id_aluno"));
				dados.put("nome", rs.getString("nome"));
				dados.put("qtd_ativi", rs.getInt("qtd_ativi"));
				dados.put("atividade1", rs.getInt("atividade1"));
				dados.put("atividade2", rs.getInt("atividade2"));
				dados.put("atividade3", rs.getInt("atividade3"));
				dados.put("atividade4", rs.getInt("atividade4"));
				dados.put("atividade5", rs.getInt("atividade5"));
				dados.put("atividade6", rs.getInt("atividade6"));
				dados.put("atividade7", rs.getInt("atividade7"));
				dados.put("atividade8", rs.getInt("atividade8"));
				dados.put("atividade9", rs.getInt("atividade9"));
				dados.put("atividade10", rs.getInt("atividade10"));
				
				lista.add(dados);
			}
			
			
			stmt.close();
			rs.close();

			return lista;
		}
		
		
		public List select_diariofaltas(int id_diario, String dt_aula, int id_aluno) throws Exception{
			lista = new ArrayList();
			
			query = "select distinct id_diariofaltas, a.id_aluno, a.id_aluno||' - '||a.nome as nome, to_char(dt_aula,'dd/mm/yyyy') as dt_aula," +
					"	df.id_ativo, dt_aula as dt_aula_o," +
					"	nr_aula, a.nome as nome_aluno" +
					"	from pdg_diariofaltas df" +
					"	inner join pdg_diario using (id_diario)" +
					"	inner join crs_turmaedu te using (id_turmaedu)" +
					"	left join crs_turma t using (id_turma)" +
					"	left join ctr_contrato c on (t.id_turma = c.id_turma and c.id_aluno = df.id_aluno)" +
					"	inner join adm_operador o on (o.id_operador = te.id_operador)" +
					"	inner join alu_aluno a on (a.id_aluno = df.id_aluno)" +
					"	where id_diario = ?";
			
					if (id_aluno > 0) {
						query += " and a.id_aluno = ? ";
					} else {
						query += " and date(dt_aula) = date(?) ";
					}
					query += " and id_ctrstatus != 9 order by nome_aluno, dt_aula_o, nr_aula";
			
					stmt = conn.prepareStatement(query);
					stmt.setInt(1, id_diario);

					if (id_aluno > 0) {
						stmt.setInt(2, id_aluno);
					} else {
						stmt.setString(2, dt_aula);
					}

					rs = stmt.executeQuery();
					
					while(rs.next()){
						HashMap dados = new HashMap();
						
						dados.put("id_diariofaltas", rs.getInt("id_diariofaltas"));
						dados.put("id_aluno", rs.getInt("id_aluno"));
						dados.put("nome", rs.getString("nome"));
						dados.put("dt_aula", rs.getString("dt_aula"));
						dados.put("id_ativo", rs.getInt("id_ativo"));
						dados.put("nr_aula", rs.getInt("nr_aula"));
						
						lista.add(dados);
					}
					
					
					stmt.close();
					rs.close();		
					
					
					return lista;
		}
		
		public void update_diariofaltas(int id_diariofaltas,int id_ativo) throws Exception{
			query = "update pdg_diariofaltas set" +
					"	id_ativo = ? where id_diariofaltas = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_ativo);
			stmt.setInt(2, id_diariofaltas);
			stmt.executeUpdate();
			
			stmt.close();

		}
		public List select_diarioatividades2(int id_diario, int id_atividade) throws Exception{
			
			lista = new ArrayList();
			
			query = "select distinct descricao, id_atividade, to_char(data,'dd/mm/yyyy') as data " +
					"from pdg_diarioatividades where id_diarioatividades in (" +
					"	select id_diarioatividades from pdg_diarionotas d" +
					"	inner join pdg_diarioatividades using (id_diarionotas)" +
					"	where id_atividade = ?" +
					"	and id_diario = ?" +
					")";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_atividade);
			stmt.setInt(2, id_diario);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				HashMap dados = new HashMap();
				
				dados.put("descricao", rs.getString("descricao"));
				dados.put("id_atividade", rs.getInt("id_atividade"));
				dados.put("data", rs.getString("data"));
				
				lista.add(dados);
			}
			
			stmt.close();
			rs.close();

			System.out.println(lista);
			
			return lista;
		}
		public int deleta_diarioatividades(int id_diario, int id_atividade) throws Exception{
			
			query = "delete from pdg_diarioatividades where id_diarioatividades in (" +
					"	select id_diarioatividades from pdg_diarionotas d" +
					"	inner join pdg_diarioatividades using (id_diarionotas)" +
					"	where id_atividade = ?" +
					"	and id_diario = ? )";

			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_atividade);
			stmt.setInt(2, id_diario);
			stmt.executeUpdate();
			
			System.out.println("deleta_diarioatividades>>>>"+stmt);

			pdg_organiza_atividades(id_diario);
			
			stmt.close();

			
			return id_diario;
		}
		public void pdg_organiza_atividades(int id_diario) throws Exception{
			query = "select pdg_organiza_atividades(?);";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_diario);
			
			System.out.println("pdg_organiza_atividades>>>>"+stmt);
			
			stmt.executeQuery();
			
		}

		public int pdg_cria_atividades(int id_diario, String descricao, String data) throws Exception{
			query = "select pdg_cria_atividades(?, ?, ?::timestamp);";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_diario);
			stmt.setString(2, descricao);
			stmt.setString(3, data);
			stmt.executeQuery();
			
			System.out.println("pdg_cria_atividades>>>>"+stmt);
			
			stmt.close();
			
			return id_diario;
		}

//		public List pdg_diario_media(int id_diario) throws Exception{
//			
//			lista = new ArrayList();
//			
//			query = "select pdg_diario_media(?);";
//			
//			stmt = conn.prepareStatement(query);
//			stmt.setInt(1, id_diario);
//			stmt.executeQuery();
//			
//			lista = select_diario(id_diario);
//			
//			System.out.println(lista);
//			
//			return lista;
//		}	

		public List GraficoFaltaDiario(int id_diario) throws Exception{
			lista = new ArrayList();
			
			query = "  select * from pdg_diario_totfaltas" +
					" where id_diario = ? and id_ctrstatus <> 9";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_diario);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				HashMap dados = new HashMap();
				dados.put("nome", rs.getString("nome"));
				dados.put("tot_aulas", rs.getInt("tot_aulas"));
				dados.put("tot_faltas", rs.getInt("tot_faltas"));
				
				lista.add(dados);
			}
			
			
			stmt.close();
			rs.close();

			System.out.println(lista);	
			return lista;
		}
		public List GraficoNotaDiario(int id_diario) throws Exception{
			lista = new ArrayList();
			
			query = "  select * from pdg_diario_notas" +
					" where id_diario = ?";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_diario);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				HashMap dados = new HashMap();
				dados.put("nome", rs.getString("nome"));
				dados.put("nota1", rs.getDouble("nota1"));
				dados.put("nota2", rs.getDouble("nota2"));
				dados.put("atividades", rs.getDouble("atividades"));
				
				lista.add(dados);
			}
			
			
			stmt.close();
			rs.close();

			System.out.println(lista);	
			return lista;
		}
		
		public void EnviarMensagemContArquivo(HashMap parametros) throws Exception{
			query = "select adm_msg_diariocontarquivo(?, ?, ?)";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, Integer.parseInt(parametros.get("id_diariocont").toString()));
			stmt.setInt(2, Integer.parseInt(parametros.get("id_operador").toString()));
			stmt.setString(3, parametros.get("mensagem").toString());
			rs = stmt.executeQuery();
			
			
		}
		
		
		// academico
		
//		public List pontuacao(int id_turma,int id_aluno) throws Exception{
//			lista = new ArrayList();
//			
//			query = "select md.nmmodulo, nmmateria, id_diarionotas, a.id_aluno, nome, nota1, nota2," +
//					"	(select sum(nota) from pdg_diarioatividades where id_diarionotas = dn.id_diarionotas) as atividades," +
//					"	t.id_turma, t.nmturma, media, nmsituacao, estilo" +
//					"	from pdg_diario d" +
//					"	inner join pdg_diarionotas dn using (id_diario)" +
//					"	inner join pdg_diariomedia s on (dn.id_situacao = s.id_media)" +
//					"	inner join crs_turmaedu te using (id_turmaedu)" +
//					"	inner join crs_cursomateria cm using (id_cursomateria)" +
//					"	inner join crs_modulo md using (id_modulo)" +
//					"	inner join crs_materia m using (id_materia)" +
//					"	left join crs_turma t using (id_turma)" +
//					"	left join ctr_contrato c on (t.id_turma = c.id_turma and c.id_aluno = dn.id_aluno)" +
//					"	inner join adm_operador o on (o.id_operador = te.id_operador)" +
//					"	inner join alu_aluno a on (a.id_aluno = dn.id_aluno)" +
//					"	where id_ctrstatus != 9" +
//					"	and t.id_turma = ? " +
//					"	and a.id_aluno = ? " +
//					"	order by md.id_modulo, nmmateria";
//			
//			stmt = conn.prepareStatement(query);
//			stmt.setInt(1, id_turma);
//			stmt.setInt(2, id_aluno);
//			rs = stmt.executeQuery();
//			
//			while(rs.next()){
//				HashMap dados = new HashMap();
//				dados.put("nmmodulo", rs.getString("nmmodulo"));
//				dados.put("nmmateria", rs.getString("nmmateria"));
//				dados.put("nota1", rs.getDouble("nota1"));
//				dados.put("nota2", rs.getDouble("nota2"));
//				dados.put("atividades", rs.getDouble("atividades"));
//				dados.put("media", rs.getDouble("media"));
//				dados.put("nmsituacao", rs.getString("nmsituacao"));
//				dados.put("estilo", rs.getString("estilo"));
//				
//				lista.add(dados);
//			}
//			
//			
//			stmt.close();
//			rs.close();
//
//			System.out.println(lista);	
//			return lista;
//		}
		
		public List ConteudoFalta(int id_turma,int id_aluno, int id_diario) throws Exception{
			lista = new ArrayList();
			
			query = "select to_char(data,'dd/mm/yyyy') as dt_aula, nr_aula, descricao," +
					"	(select id_ativo from pdg_diariofaltas" +
					"	where id_aluno = ? and id_diario = d.id_diario and nr_aula = dc.nr_aula and dt_aula = dc.data limit 1) as id_ativo," +
					"	(select count(*) from pdg_diarioarquivos where id_diariocont = dc.id_diariocont) as qtd_arq," +
					"	dc.id_diariocont" +
					"	from pdg_diario d" +
					"	inner join pdg_diariocont dc using (id_diario)" +
					"	inner join crs_turmaedu using (id_turmaedu)" +
					"	inner join crs_cursomateria using (id_cursomateria)" +
					"	inner join crs_materia using (id_materia)" +
					"	where d.id_diario = ?" +
					"	and (date(data) <= date(now()) or descricao is not null)" +
					"	order by data, nr_aula";
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_aluno);
//			stmt.setInt(2, id_turma);
			stmt.setInt(2, id_diario);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				HashMap dados = new HashMap();
				dados.put("dt_aula", rs.getString("dt_aula"));
				dados.put("nr_aula", rs.getInt("nr_aula"));
				dados.put("descricao", rs.getString("descricao"));
				dados.put("id_ativo", rs.getInt("id_ativo"));
				dados.put("qtd_arq", rs.getInt("qtd_arq"));
				dados.put("id_diariocont", rs.getInt("id_diariocont"));
				
				lista.add(dados);
			}
			
			
			stmt.close();
			rs.close();

			System.out.println(lista);	
			return lista;
		}		
		public List GraficoFalta(int id_turma,int id_aluno, int id_diario) throws Exception{
			lista = new ArrayList();
			
			query = "  select * from pdg_diario_totfaltas" +
					" where id_aluno = ?" +
					" and id_contrato = ?" +
					" and id_diario = ?";
			
			
			stmt = conn.prepareStatement(query);
			stmt.setInt(1, id_aluno);
			stmt.setInt(2, id_turma);
			stmt.setInt(3, id_diario);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				HashMap dados = new HashMap();
				dados.put("nmmateria", rs.getString("nmmateria"));
				dados.put("tot_aulas", rs.getInt("tot_aulas"));
				dados.put("tot_faltas", rs.getInt("tot_faltas"));
				
				lista.add(dados);
			}
			
			
			stmt.close();
			rs.close();

			System.out.println(lista);	
			return lista;
		}				
//		public List GraficoNota(int id_turma,int id_aluno, int id_diario) throws Exception{
//			lista = new ArrayList();
//			
//			query = "  select * from pdg_diario_notas" +
//					" where id_aluno = ?" +
//					" and id_turma = ?" +
//					" and id_diario = ?";
//			
//			
//			stmt = conn.prepareStatement(query);
//			stmt.setInt(1, id_aluno);
//			stmt.setInt(2, id_turma);
//			stmt.setInt(3, id_diario);
//			rs = stmt.executeQuery();
//			
//			while(rs.next()){
//				HashMap dados = new HashMap();
//				dados.put("nome", rs.getString("nome"));
//				dados.put("nota1", rs.getDouble("nota1"));
//				dados.put("nota2", rs.getDouble("nota2"));
//				dados.put("atividades", rs.getDouble("atividades"));
//				
//				lista.add(dados);
//			}
//			
//			
//			stmt.close();
//			rs.close();
//
//			System.out.println(lista);	
//			return lista;
//		}
		
}
