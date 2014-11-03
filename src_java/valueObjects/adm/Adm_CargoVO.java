/**
 * 
 */
package valueObjects.adm;

import java.io.Serializable;
import java.sql.Timestamp;

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

public class Adm_CargoVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5765976848453945290L;
	
	@Sequence
	String adm_cargo_id_cargo;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_cargo;
	@Select	@Insert	@Update	@Delete
	String nmcargo;
	@Select
	Timestamp dt_cadastro;
	
	public Integer getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getNmcargo() {
		return nmcargo;
	}
	public void setNmcargo(String nmcargo) {
		this.nmcargo = nmcargo;
	}
	public Timestamp getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Timestamp dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	
	
	
	

}
