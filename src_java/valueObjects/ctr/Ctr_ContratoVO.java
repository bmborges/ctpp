package valueObjects.ctr;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_ContratoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -589073474173253016L;


	@Sequence
	String ctr_contrato_id_contrato;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_contrato;
	@Select	@Insert	@Update	@Delete
	Integer id_ctrstatus;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_cadastro;
	@Select	@Insert	@Update	@Delete
	Integer id_turma;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_inicial;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_final;
	@Select	@Insert	@Update	@Delete
	Integer id_aluno;
	@Select	@Insert	@Update	@Delete
	Integer id_resplegal;
	@Select	@Insert	@Update	@Delete
	Integer id_respfinan;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer id_curso;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_cancelamento;	
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Integer getId_ctrstatus() {
		return id_ctrstatus;
	}
	public void setId_ctrstatus(Integer id_ctrstatus) {
		this.id_ctrstatus = id_ctrstatus;
	}
	public Timestamp getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Timestamp dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
	public Timestamp getDt_inicial() {
		return dt_inicial;
	}
	public void setDt_inicial(Timestamp dt_inicial) {
		this.dt_inicial = dt_inicial;
	}
	public Timestamp getDt_final() {
		return dt_final;
	}
	public void setDt_final(Timestamp dt_final) {
		this.dt_final = dt_final;
	}
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public Integer getId_resplegal() {
		return id_resplegal;
	}
	public void setId_resplegal(Integer id_resplegal) {
		this.id_resplegal = id_resplegal;
	}
	public Integer getId_respfinan() {
		return id_respfinan;
	}
	public void setId_respfinan(Integer id_respfinan) {
		this.id_respfinan = id_respfinan;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public Timestamp getDt_cancelamento() {
		return dt_cancelamento;
	}
	public void setDt_cancelamento(Timestamp dt_cancelamento) {
		this.dt_cancelamento = dt_cancelamento;
	}
}

