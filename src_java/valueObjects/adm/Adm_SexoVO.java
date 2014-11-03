package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_SexoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2127109082819195790L;


	@Sequence
	String adm_sexo_id_sexo;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_sexo;
	@Select	@Insert	@Update	@Delete
	String nmsexo;
	@Select	@Insert	@Update	@Delete
	String sigla;
	
	public Integer getId_sexo() {
		return id_sexo;
	}
	public void setId_sexo(Integer id_sexo) {
		this.id_sexo = id_sexo;
	}
	public String getNmsexo() {
		return nmsexo;
	}
	public void setNmsexo(String nmsexo) {
		this.nmsexo = nmsexo;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	
}

