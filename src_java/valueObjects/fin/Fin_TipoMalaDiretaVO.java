package valueObjects.fin;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_TipoMalaDiretaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9132849164444562120L;


	@Sequence
	String fin_tipomaladireta_id_tipomaladireta;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_tipomaladireta;
	@Select	@Insert	@Update	@Delete
	String nmtipomaladireta;
	@Select	@Insert	@Update	@Delete
	Integer dif_dias;
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
	public Integer getDif_dias() {
		return dif_dias;
	}
	public void setDif_dias(Integer dif_dias) {
		this.dif_dias = dif_dias;
	}
}

