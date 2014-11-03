package valueObjects.cnt;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Cnt_MidiaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6962588151770948990L;


	@Sequence
	String cnt_midia_id_midia;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_midia;
	@Select	@Insert	@Update	@Delete
	String nmmidia;
	public Integer getId_midia() {
		return id_midia;
	}
	public void setId_midia(Integer id_midia) {
		this.id_midia = id_midia;
	}
	public String getNmmidia() {
		return nmmidia;
	}
	public void setNmmidia(String nmmidia) {
		this.nmmidia = nmmidia;
	}
}

