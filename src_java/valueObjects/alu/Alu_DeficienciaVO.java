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
public class Alu_DeficienciaVO implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2816551569046019658L;
	
	@Sequence
	String alu_deficiencia_id_deficiencia;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_deficiencia;
	@Select	@Insert	@Update	@Delete
	Integer cddeficiencia;
	@Select	@Insert	@Update	@Delete
	Integer id_aluno;
	
	
	public Integer getId_deficiencia() {
		return id_deficiencia;
	}
	public void setId_deficiencia(Integer id_deficiencia) {
		this.id_deficiencia = id_deficiencia;
	}
	public Integer getCddeficiencia() {
		return cddeficiencia;
	}
	public void setCddeficiencia(Integer cddeficiencia) {
		this.cddeficiencia = cddeficiencia;
	}
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	
	
}
