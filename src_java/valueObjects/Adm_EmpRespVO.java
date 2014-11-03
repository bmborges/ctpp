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

public class Adm_EmpRespVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5635002928880950139L;

	@Sequence
	String adm_empresp_id_empresp;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_empresp;
	@Select	@Insert	@Update	@Delete
	Integer id_empresa;
	@Select	@Insert	@Update	@Delete
	Integer id_cargo;
	@Select	@Insert	@Update	@Delete
	String nmresponsavel;
	
	
	public Integer getId_empresp() {
		return id_empresp;
	}
	public void setId_empresp(Integer id_empresp) {
		this.id_empresp = id_empresp;
	}
	public Integer getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public Integer getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getNmresponsavel() {
		return nmresponsavel;
	}
	public void setNmresponsavel(String nmresponsavel) {
		this.nmresponsavel = nmresponsavel;
	}
	
	
	
	
	

}
