package valueObjects.pdg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_DiarioStatusVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5890455831458787716L;
	@Sequence
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_status;
	@Select	@Insert	@Update	@Delete
	String nmstatus;
	
	public Integer getId_status() {
		return id_status;
	}
	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}
	public String getNmstatus() {
		return nmstatus;
	}
	public void setNmstatus(String nmstatus) {
		this.nmstatus = nmstatus;
	}
}

