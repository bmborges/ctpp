package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class For_ForTelVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7932273394665069491L;

	@Sequence
	String for_fortel_id_fortel;
	
	@PrimaryKey
	@Select	@Insert
	Integer id_fortel;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	Integer id_fornecedor;
	
	public Integer getId_fortel() {
		return id_fortel;
	}
	public void setId_fortel(Integer id_fortel) {
		this.id_fortel = id_fortel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	
	
}
