package valueObjects.pdg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_DiarioFaltasVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6198405504411441532L;
	@Sequence
	
	
	@PrimaryKey
	@Select	@Insert	@Delete
	Integer id_diariofaltas;
	@Select	@Insert	@Delete
	Integer id_aluno;
	@Select	@Insert	@Delete
	Timestamp dt_aula;
	@Select	@Insert	@Delete
	Integer id_ativo;
	@Select	@Insert	@Delete
	Integer id_diario;
	@Select	@Insert	@Delete
	Integer nr_aula;
	@Select	@Insert	@Delete
	Integer id_diarionotas;
	@Select	@Insert	@Update	@Delete
	String justificativa;
	
	
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
	public Integer getId_diario() {
		return id_diario;
	}
	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}
	public Integer getNr_aula() {
		return nr_aula;
	}
	public void setNr_aula(Integer nr_aula) {
		this.nr_aula = nr_aula;
	}
	public Integer getId_diarionotas() {
		return id_diarionotas;
	}
	public void setId_diarionotas(Integer id_diarionotas) {
		this.id_diarionotas = id_diarionotas;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
}

