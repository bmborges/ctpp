package valueObjects.fin;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_TxtMalaDiretaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1959483178736629775L;


	@Sequence
	String fin_txtmaladireta_id_txtmaladireta;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_txtmaladireta;
	@Select	@Insert	@Update	@Delete
	Integer id_tipomaladireta;
	@Select	@Insert	@Update	@Delete
	String texto;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	public Integer getId_txtmaladireta() {
		return id_txtmaladireta;
	}
	public void setId_txtmaladireta(Integer id_txtmaladireta) {
		this.id_txtmaladireta = id_txtmaladireta;
	}
	public Integer getId_tipomaladireta() {
		return id_tipomaladireta;
	}
	public void setId_tipomaladireta(Integer id_tipomaladireta) {
		this.id_tipomaladireta = id_tipomaladireta;
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
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
}

