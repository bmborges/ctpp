package valueObjects.crs;

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
public class Crs_MateriaVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4872180994027096852L;

	@Sequence
	String crs_materia_id_materia;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_materia;
	@Select	@Insert	@Update	@Delete
	String nmmateria;
	@Select	@Insert	@Update	@Delete
	String abreviatura;
	@Select	@Insert	@Delete
	Integer id_tipoavaliacao;
	@Select	@Insert	@Update	@Delete
	String ementa;	
	  
	public Integer getId_materia() {
		return id_materia;
	}
	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}
	public String getNmmateria() {
		return nmmateria;
	}
	public void setNmmateria(String nmmateria) {
		this.nmmateria = nmmateria;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public Integer getId_tipoavaliacao() {
		return id_tipoavaliacao;
	}
	public void setId_tipoavaliacao(Integer id_tipoavaliacao) {
		this.id_tipoavaliacao = id_tipoavaliacao;
	}
	public String getEmenta() {
		return ementa;
	}
	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}
	
	

}
