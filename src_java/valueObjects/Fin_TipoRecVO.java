package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_TipoRecVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 43403121067345589L;

	@Sequence
	String fin_tiporec_id_tiporec;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_tiporec;
	@Select	@Insert	@Update	@Delete
	String nmtiporec;
	
	
	public Integer getId_tiporec() {
		return id_tiporec;
	}
	public void setId_tiporec(Integer id_tiporec) {
		this.id_tiporec = id_tiporec;
	}
	public String getNmtiporec() {
		return nmtiporec;
	}
	public void setNmtiporec(String nmtiporec) {
		this.nmtiporec = nmtiporec;
	}
	
	

}
