package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Adm_PermissaoAutoVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5393652516902004186L;
	@Select
	Integer id_operador;

	public Integer getId_operador() {
		return id_operador;
	}

	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
}
