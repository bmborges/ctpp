package valueObjects.fin;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class Fin_DupSituacaoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 199375838213951626L;
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_situacao;
	@Select	@Insert	@Update	@Delete
	String nmsituacao;
	
	public Integer getId_situacao() {
		return id_situacao;
	}
	public void setId_situacao(Integer id_situacao) {
		this.id_situacao = id_situacao;
	}
	public String getNmsituacao() {
		return nmsituacao;
	}
	public void setNmsituacao(String nmsituacao) {
		this.nmsituacao = nmsituacao;
	}
}

