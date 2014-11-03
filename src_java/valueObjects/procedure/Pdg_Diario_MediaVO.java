package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Pdg_Diario_MediaVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2240102554258854539L;
	@Select
	Integer id_diario;

	public Integer getId_diario() {
		return id_diario;
	}

	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}
	
	

}
