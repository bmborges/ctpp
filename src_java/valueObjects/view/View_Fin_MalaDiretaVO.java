package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Fin_MalaDiretaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5681273337918123371L;
	@Select
	Timestamp dt_sistema;
	@Select
	Integer id_operador;
	@Select
	String nickname;
	@Select
	Integer id_tipomaladireta;
	@Select
	String nmtipomaladireta;
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getId_tipomaladireta() {
		return id_tipomaladireta;
	}
	public void setId_tipomaladireta(Integer id_tipomaladireta) {
		this.id_tipomaladireta = id_tipomaladireta;
	}
	public String getNmtipomaladireta() {
		return nmtipomaladireta;
	}
	public void setNmtipomaladireta(String nmtipomaladireta) {
		this.nmtipomaladireta = nmtipomaladireta;
	}
}
