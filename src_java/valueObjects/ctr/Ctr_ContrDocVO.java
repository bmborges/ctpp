package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_ContrDocVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -8290546793944661541L;


@Sequence
String ctr_contrdoc_id_contrdoc;


	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_contrdoc;
	@Select	@Insert	@Update	@Delete
	Integer id_contrato;
	@Select	@Insert	@Update	@Delete
	Integer id_documentacao;
	@Select	@Insert	@Update	@Delete
	Integer status;
	public Integer getId_contrdoc() {
		return id_contrdoc;
	}
	public void setId_contrdoc(Integer id_contrdoc) {
		this.id_contrdoc = id_contrdoc;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Integer getId_documentacao() {
		return id_documentacao;
	}
	public void setId_documentacao(Integer id_documentacao) {
		this.id_documentacao = id_documentacao;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}

