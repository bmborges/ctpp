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
public class Ctr_DocCursoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6676944018233920768L;

	@Sequence
	String ctr_doccurso_id_doccurso;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_doccurso;
	@Select	@Insert	@Update	@Delete
	Integer id_tipocurso;
	@Select	@Insert	@Update	@Delete
	Integer id_documentacao;
	
	
	public Integer getId_doccurso() {
		return id_doccurso;
	}
	public void setId_doccurso(Integer id_doccurso) {
		this.id_doccurso = id_doccurso;
	}
	public Integer getId_tipocurso() {
		return id_tipocurso;
	}
	public void setId_tipocurso(Integer id_tipocurso) {
		this.id_tipocurso = id_tipocurso;
	}
	public Integer getId_documentacao() {
		return id_documentacao;
	}
	public void setId_documentacao(Integer id_documentacao) {
		this.id_documentacao = id_documentacao;
	}
	
	
	  
	
}
