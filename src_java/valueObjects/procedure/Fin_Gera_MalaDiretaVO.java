package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fin_Gera_MalaDiretaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4973212614134322517L;
	@Select
	Integer id_tipomaladireta;
	@Select
	Integer	id_operador;
	
	public Integer getId_tipomaladireta() {
		return id_tipomaladireta;
	}
	public void setId_tipomaladireta(Integer id_tipomaladireta) {
		this.id_tipomaladireta = id_tipomaladireta;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	} 
	
}
