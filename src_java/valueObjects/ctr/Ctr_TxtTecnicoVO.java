package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_TxtTecnicoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1124125787271252761L;


	@Sequence
	String ctr_txttecnico_id_txttecnico;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_txttecnico;
	@Select	@Insert	@Update	@Delete
	Integer sequencia;
	@Select	@Insert	@Update	@Delete
	String texto;
	public Integer getId_txttecnico() {
		return id_txttecnico;
	}
	public void setId_txttecnico(Integer id_txttecnico) {
		this.id_txttecnico = id_txttecnico;
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

