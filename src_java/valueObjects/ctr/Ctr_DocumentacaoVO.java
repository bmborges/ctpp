package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_DocumentacaoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4691087872301801118L;


	@Sequence
	String ctr_documentacao_id_documentacao;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_documentacao;
	@Select	@Insert	@Update	@Delete
	String nmdocumentacao;
	public Integer getId_documentacao() {
		return id_documentacao;
	}
	public void setId_documentacao(Integer id_documentacao) {
		this.id_documentacao = id_documentacao;
	}
	public String getNmdocumentacao() {
		return nmdocumentacao;
	}
	public void setNmdocumentacao(String nmdocumentacao) {
		this.nmdocumentacao = nmdocumentacao;
	}
}

