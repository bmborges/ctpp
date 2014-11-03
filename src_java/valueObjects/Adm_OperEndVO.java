/**
 * 
 */
package valueObjects;

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
public class Adm_OperEndVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7766035101612899164L;
	
	@Sequence
	String adm_operend_id_operend;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_operend;
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
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer id_estado;
	
	
	public Integer getId_operend() {
		return id_operend;
	}
	public void setId_operend(Integer id_operend) {
		this.id_operend = id_operend;
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
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	


}
