package valueObjects.fin;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_MalaDiretaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6809073167278971878L;


	@Sequence
	String fin_maladireta_id_maladireta;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_maladireta;
	@Select	@Insert	@Update	@Delete
	Integer id_contrato;
	@Select	@Insert	@Update	@Delete
	String texto;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer id_txtmaladireta;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	public Integer getId_maladireta() {
		return id_maladireta;
	}
	public void setId_maladireta(Integer id_maladireta) {
		this.id_maladireta = id_maladireta;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getId_txtmaladireta() {
		return id_txtmaladireta;
	}
	public void setId_txtmaladireta(Integer id_txtmaladireta) {
		this.id_txtmaladireta = id_txtmaladireta;
	}
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
}

