package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_BancoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 262962689266536542L;

	@Sequence
	String fin_banco_id_banco;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_banco;
	@Select	@Insert	@Update	@Delete
	String nmbanco;
	@Select	@Insert	@Update	@Delete
	String conta;
	@Select	@Insert	@Update	@Delete
	String agencia;
	@Select	@Insert	@Update	@Delete
	String cedente;
	@Select	@Insert	@Update	@Delete
	String processo;
	@Select	@Insert	@Update	@Delete
	String banco;
	
	
	public Integer getId_banco() {
		return id_banco;
	}
	public void setId_banco(Integer id_banco) {
		this.id_banco = id_banco;
	}
	public String getNmbanco() {
		return nmbanco;
	}
	public void setNmbanco(String nmbanco) {
		this.nmbanco = nmbanco;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getCedente() {
		return cedente;
	}
	public void setCedente(String cedente) {
		this.cedente = cedente;
	}
	public String getProcesso() {
		return processo;
	}
	public void setProcesso(String processo) {
		this.processo = processo;
	}
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	

}
