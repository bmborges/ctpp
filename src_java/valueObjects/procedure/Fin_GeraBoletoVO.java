package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fin_GeraBoletoVO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4672780493882009909L;
	@Select
	Integer id_contrato;
	@Select
	Integer id_banco;
	@Select
	Integer id_modulo;
	

	public Integer getId_contrato() {
		return id_contrato;
	}

	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}

	public Integer getId_banco() {
		return id_banco;
	}

	public void setId_banco(Integer id_banco) {
		this.id_banco = id_banco;
	}

	public Integer getId_modulo() {
		return id_modulo;
	}

	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}

}
