package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_TipoHistoricoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023451938447219845L;


	@Sequence
	String ctr_tipohistorico_id_tipohistorico;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_tipohistorico;
	@Select	@Insert	@Update	@Delete
	String nmtipohistorico;
	
	public Integer getId_tipohistorico() {
		return id_tipohistorico;
	}
	public void setId_tipohistorico(Integer id_tipohistorico) {
		this.id_tipohistorico = id_tipohistorico;
	}
	public String getNmtipohistorico() {
		return nmtipohistorico;
	}
	public void setNmtipohistorico(String nmtipohistorico) {
		this.nmtipohistorico = nmtipohistorico;
	}
}

