package valueObjects.bco;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class Bco_AlineaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1516580478911665409L;
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_alinea;
	@Select	@Insert	@Update	@Delete
	String nmalinea;
	public Integer getId_alinea() {
		return id_alinea;
	}
	public void setId_alinea(Integer id_alinea) {
		this.id_alinea = id_alinea;
	}
	public String getNmalinea() {
		return nmalinea;
	}
	public void setNmalinea(String nmalinea) {
		this.nmalinea = nmalinea;
	}
}
