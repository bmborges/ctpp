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

public class Adm_CidadeVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7146024558971852150L;

	@Sequence
	String adm_cidade_id_cidade;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_cidade;
	@Select	@Insert	@Update	@Delete
	String nmcidade;
	@Select	@Insert	@Update	@Delete
	Integer id_estado;
	@Select	@Insert	@Update	@Delete
	Integer id_municipio;
	
	
	public Integer getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	public String getNmcidade() {
		return nmcidade;
	}
	public void setNmcidade(String nmcidade) {
		this.nmcidade = nmcidade;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public Integer getId_municipio() {
		return id_municipio;
	}
	public void setId_municipio(Integer id_municipio) {
		this.id_municipio = id_municipio;
	}
	
	

}
