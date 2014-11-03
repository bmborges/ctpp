package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class For_ForEmailVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6939482598266485506L;

	@Sequence
	String for_foremail_id_foremail;
	
	@PrimaryKey
	@Select	@Insert
	Integer id_foremail;
	@Select	@Insert	@Update	@Delete
	String email;
	@Select	@Insert	@Update	@Delete
	Integer id_fornecedor;
	
	public Integer getId_foremail() {
		return id_foremail;
	}
	public void setId_foremail(Integer id_foremail) {
		this.id_foremail = id_foremail;
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
