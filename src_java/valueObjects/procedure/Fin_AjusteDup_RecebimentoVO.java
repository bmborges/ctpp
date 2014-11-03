package valueObjects.procedure;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class Fin_AjusteDup_RecebimentoVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 679089870548544315L;
	@Select
	Integer id_contrato;
	@Select
	Timestamp dthj;
	
	
	public Integer getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}

	public Timestamp getDthj() {
		return dthj;
	}

	public void setDthj(Timestamp dthj) {
		this.dthj = dthj;
	}

}
