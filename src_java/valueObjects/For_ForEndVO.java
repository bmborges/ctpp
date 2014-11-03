package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class For_ForEndVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7006716177229476645L;

	@Sequence
	String for_forend_id_forend;
	
	@PrimaryKey
	@Select	@Insert
	Integer id_forend;
	@Select	@Insert	@Update	@Delete
	String endereco;
	@Select	@Insert	@Update	@Delete
	String cep;
	@Select	@Insert	@Update	@Delete
	Integer id_fornecedor;
	@Select	@Insert	@Update	@Delete
	Integer id_cidade;
	@Select	@Insert	@Update	@Delete
	String bairro;
	
	public Integer getId_forend() {
		return id_forend;
	}
	public void setId_forend(Integer id_forend) {
		this.id_forend = id_forend;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public Integer getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	
	
}
