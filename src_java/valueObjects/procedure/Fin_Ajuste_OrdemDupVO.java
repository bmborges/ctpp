package valueObjects.procedure;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class Fin_Ajuste_OrdemDupVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7687430266755345499L;
	@Select
	Integer id_contrato;
	@Select
	Integer operacao;	
	
	public Integer getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}

	public Integer getOperacao() {
		return operacao;
	}

	public void setOperacao(Integer operacao) {
		this.operacao = operacao;
	}


}
