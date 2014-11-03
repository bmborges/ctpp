/**
 * 
 */
package valueObjects.alu;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

/**
 * @author bruno
 *
 */
public class Alu_RespEndVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6958756236844765100L;
	
	@Sequence
	String alu_respend_id_respend;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_respend;
	@Select	@Insert	@Update	@Delete
	String endereco;
	@Select	@Insert	@Update	@Delete
	String complemento;
	@Select	@Insert	@Update	@Delete
	String bairro;
	@Select	@Insert	@Update	@Delete
	String cep;
	@Select	@Insert	@Update	@Delete
	String cidade;
	@Select	@Insert	@Update	@Delete
	Integer id_resp;
	@Select	@Insert	@Update	@Delete
	Integer imp;
	@Select	@Insert	@Update	@Delete
	Integer id_estado;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	Integer id_tipoend;
	
	public Integer getId_respend() {
		return id_respend;
	}
	public void setId_respend(Integer id_respend) {
		this.id_respend = id_respend;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Integer getId_resp() {
		return id_resp;
	}
	public void setId_resp(Integer id_resp) {
		this.id_resp = id_resp;
	}
	public Integer getImp() {
		return imp;
	}
	public void setImp(Integer imp) {
		this.imp = imp;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getId_tipoend() {
		return id_tipoend;
	}
	public void setId_tipoend(Integer id_tipoend) {
		this.id_tipoend = id_tipoend;
	}	  
	
	
}
