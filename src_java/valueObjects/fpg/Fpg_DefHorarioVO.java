package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class Fpg_DefHorarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 45877683825595202L;
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_defhorario;
	@Select	@Insert	@Update	@Delete
	String nmdefhorario;
	public Integer getId_defhorario() {
		return id_defhorario;
	}
	public void setId_defhorario(Integer id_defhorario) {
		this.id_defhorario = id_defhorario;
	}
	public String getNmdefhorario() {
		return nmdefhorario;
	}
	public void setNmdefhorario(String nmdefhorario) {
		this.nmdefhorario = nmdefhorario;
	}
	
	
	
}

