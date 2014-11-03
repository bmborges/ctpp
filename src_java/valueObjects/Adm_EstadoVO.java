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

public class Adm_EstadoVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1862374357137097344L;

	@Sequence
	String adm_estado_id_estado;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_estado;
	@Select	@Insert	@Update	@Delete
	String nmestado;
	@Select	@Insert	@Update	@Delete
	Integer ordem;
	@Select	@Insert	@Update	@Delete
	String estado;
	
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public String getNmestado() {
		return nmestado;
	}
	public void setNmestado(String nmestado) {
		this.nmestado = nmestado;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	

}
