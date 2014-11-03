package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class View_Pdg_Diario_FaltasVO implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 2183025450174915896L;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_diariofaltas;
	@Select	@Insert	@Update	@Delete
	Integer id_aluno;
	@Select	@Insert	@Update	@Delete
	String nome;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_aula;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	@Select	@Insert	@Update	@Delete
	Integer nr_aula;
	@Select	@Insert	@Update	@Delete
	String nome_aluno;
	@Select	@Insert	@Update	@Delete
	String justificativa;
	@Select	@Insert	@Update	@Delete
	Integer id_diario;


	public Integer getId_diariofaltas() {
		return id_diariofaltas;
	}
	public void setId_diariofaltas(Integer id_diariofaltas) {
		this.id_diariofaltas = id_diariofaltas;
	}
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Timestamp getDt_aula() {
		return dt_aula;
	}
	public void setDt_aula(Timestamp dt_aula) {
		this.dt_aula = dt_aula;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	public Integer getNr_aula() {
		return nr_aula;
	}
	public void setNr_aula(Integer nr_aula) {
		this.nr_aula = nr_aula;
	}
	public String getNome_aluno() {
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public Integer getId_diario() {
		return id_diario;
	}
	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}



}
