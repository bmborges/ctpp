package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_TxtProfissionalizanteVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9221001511283973924L;


	@Sequence
	String ctr_txtprofissionalizante_id_txtprofissionalizante;


	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_txtprofissionalizante;
	@Select	@Insert	@Update	@Delete
	Integer sequencia;
	@Select	@Insert	@Update	@Delete
	String texto;
	
	public Integer getId_txtprofissionalizante() {
		return id_txtprofissionalizante;
	}
	public void setId_txtprofissionalizante(Integer id_txtprofissionalizante) {
		this.id_txtprofissionalizante = id_txtprofissionalizante;
	}
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
}

