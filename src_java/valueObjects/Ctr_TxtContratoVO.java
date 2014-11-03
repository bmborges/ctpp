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
public class Ctr_TxtContratoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3625638275379082686L;

	@Sequence
	String ctr_txtcontrato_id_txtcontrato;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_txtcontrato;
	@Select	@Insert	@Update	@Delete
	Integer id_tipocurso;
	@Select	@Insert	@Update	@Delete
	String nmtexto;
	@Select	@Insert	@Update	@Delete
	Integer sequencia;
	
	public Integer getId_txtcontrato() {
		return id_txtcontrato;
	}
	public void setId_txtcontrato(Integer id_txtcontrato) {
		this.id_txtcontrato = id_txtcontrato;
	}
	public Integer getId_tipocurso() {
		return id_tipocurso;
	}
	public void setId_tipocurso(Integer id_tipocurso) {
		this.id_tipocurso = id_tipocurso;
	}
	public String getNmtexto() {
		return nmtexto;
	}
	public void setNmtexto(String nmtexto) {
		this.nmtexto = nmtexto;
	}
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	
}
