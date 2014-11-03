package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class Adm_DowVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -1711064769275512724L;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_dow;
	@Select	@Insert	@Update	@Delete
	String nmdia;
	
	public Integer getId_dow() {
		return id_dow;
	}
	public void setId_dow(Integer id_dow) {
		this.id_dow = id_dow;
	}
	public String getNmdia() {
		return nmdia;
	}
	public void setNmdia(String nmdia) {
		this.nmdia = nmdia;
	}
}

