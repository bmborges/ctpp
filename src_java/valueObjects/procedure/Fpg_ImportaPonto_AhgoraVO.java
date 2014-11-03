package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fpg_ImportaPonto_AhgoraVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4051594140000899657L;
	@Select
	String registro;
	@Select
	String operador;
	@Select
	Integer id_parceiro;
	
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getOperador() {
		return operador;
	}
	public void setOperador(String operador) {
		this.operador = operador;
	}
	public Integer getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Integer id_parceiro) {
		this.id_parceiro = id_parceiro;
	}
	

}
