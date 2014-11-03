package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class For_ContatoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 405154458447313061L;

	@Sequence
	String for_contato_id_forcontato;
	
	@PrimaryKey
	@Select	@Insert
	Integer id_forcontato;
	@Select	@Insert	@Update	@Delete
	String nmcontato;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	String email;
	@Select	@Insert	@Update	@Delete
	Integer id_fornecedor;
	
	public Integer getId_forcontato() {
		return id_forcontato;
	}
	public void setId_forcontato(Integer id_forcontato) {
		this.id_forcontato = id_forcontato;
	}
	public String getNmcontato() {
		return nmcontato;
	}
	public void setNmcontato(String nmcontato) {
		this.nmcontato = nmcontato;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
}
