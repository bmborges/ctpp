package valueObjects.pbl;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pbl_PublicEmailVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5093462803789015157L;


	@Sequence
	String pbl_publicemail_id_publicemail;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_publicemail;
	@Select	@Insert	@Update	@Delete
	String email;
	@Select	@Insert	@Update	@Delete
	String enviado;
	@Select	@Insert	@Update	@Delete
	Integer ativo;
	public Integer getId_publicemail() {
		return id_publicemail;
	}
	public void setId_publicemail(Integer id_publicemail) {
		this.id_publicemail = id_publicemail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEnviado() {
		return enviado;
	}
	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}
	public Integer getAtivo() {
		return ativo;
	}
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
}
