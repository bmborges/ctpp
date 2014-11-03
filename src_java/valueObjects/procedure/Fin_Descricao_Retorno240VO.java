package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fin_Descricao_Retorno240VO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4996802386634327429L;
	@Select
	String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
