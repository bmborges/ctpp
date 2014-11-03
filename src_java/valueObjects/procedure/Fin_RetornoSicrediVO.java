package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fin_RetornoSicrediVO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2610864587155824307L;
	
	
	@Select
	String arquivo;
	@Select
	Integer id_operador;
	@Select
	Integer id_retornobanco;
	
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getId_retornobanco() {
		return id_retornobanco;
	}
	public void setId_retornobanco(Integer id_retornobanco) {
		this.id_retornobanco = id_retornobanco;
	}
	

}
