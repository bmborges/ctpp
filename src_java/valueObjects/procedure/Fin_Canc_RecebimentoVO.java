package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fin_Canc_RecebimentoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5429486875853123837L;
	@Select
	Integer cdseqpgto;

	public Integer getCdseqpgto() {
		return cdseqpgto;
	}

	public void setCdseqpgto(Integer cdseqpgto) {
		this.cdseqpgto = cdseqpgto;
	}
	
	
}
