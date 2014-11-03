package valueObjects;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class For_FornecedorVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8182145654352331161L;

	@Sequence
	String for_fornecedor_id_fornecedor;
	
	@PrimaryKey
	@Select	@Insert
	Integer id_fornecedor;
	@Select	@Insert	@Update	@Delete
	String nmfornecedor;
	@Select	@Insert	@Update	@Delete
	String cpf;
	@Select	@Insert	@Update	@Delete
	String cnpj;
	@Select @Insert	@Delete
	Timestamp dt_cadastro;
	@Select	@Insert	@Update	@Delete
	String nmfantasia;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	
	public Integer getId_fornecedor() {
		return id_fornecedor;
	}
	public void setId_fornecedor(Integer id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}
	public String getNmfornecedor() {
		return nmfornecedor;
	}
	public void setNmfornecedor(String nmfornecedor) {
		this.nmfornecedor = nmfornecedor;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Timestamp getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Timestamp dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public String getNmfantasia() {
		return nmfantasia;
	}
	public void setNmfantasia(String nmfantasia) {
		this.nmfantasia = nmfantasia;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
}
