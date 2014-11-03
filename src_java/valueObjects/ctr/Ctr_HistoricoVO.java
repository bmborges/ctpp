package valueObjects.ctr;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_HistoricoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7477409295121247271L;


	@Sequence
	String ctr_historico_id_historico;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_historico;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Select	@Insert	@Update	@Delete
	Integer id_motivohistorico;
	@Select	@Insert	@Update	@Delete
	Integer id_tipohistorico;
	@Select	@Insert	@Delete
	Integer id_contrato;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer status;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_cadastro;
	public Integer getId_historico() {
		return id_historico;
	}
	public void setId_historico(Integer id_historico) {
		this.id_historico = id_historico;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId_motivohistorico() {
		return id_motivohistorico;
	}
	public void setId_motivohistorico(Integer id_motivohistorico) {
		this.id_motivohistorico = id_motivohistorico;
	}
	public Integer getId_tipohistorico() {
		return id_tipohistorico;
	}
	public void setId_tipohistorico(Integer id_tipohistorico) {
		this.id_tipohistorico = id_tipohistorico;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Timestamp dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
}

