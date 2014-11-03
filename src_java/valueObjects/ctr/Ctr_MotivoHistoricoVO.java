package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_MotivoHistoricoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6265264443592425301L;


	@Sequence
	String ctr_motivohistorico_id_motivohistorico;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_motivohistorico;
	@Select	@Insert	@Update	@Delete
	String nmmotivohistorico;
	@Select	@Insert	@Update	@Delete
	Integer id_tipohistorico;
	public Integer getId_motivohistorico() {
		return id_motivohistorico;
	}
	public void setId_motivohistorico(Integer id_motivohistorico) {
		this.id_motivohistorico = id_motivohistorico;
	}
	public String getNmmotivohistorico() {
		return nmmotivohistorico;
	}
	public void setNmmotivohistorico(String nmmotivohistorico) {
		this.nmmotivohistorico = nmmotivohistorico;
	}
	public Integer getId_tipohistorico() {
		return id_tipohistorico;
	}
	public void setId_tipohistorico(Integer id_tipohistorico) {
		this.id_tipohistorico = id_tipohistorico;
	}
}
