package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class Fpg_SituacaoDiaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3890746027790462540L;
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	String id_situacaodia;
	@Select	@Insert	@Update	@Delete
	String nmsitdia;
	public String getId_situacaodia() {
		return id_situacaodia;
	}
	public void setId_situacaodia(String id_situacaodia) {
		this.id_situacaodia = id_situacaodia;
	}
	public String getNmsitdia() {
		return nmsitdia;
	}
	public void setNmsitdia(String nmsitdia) {
		this.nmsitdia = nmsitdia;
	}
}

