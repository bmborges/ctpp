/**
 * 
 */
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
public class Crs_CursoMateriaVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6532875757667897807L;
	
	@Sequence
	String crs_cursomateria_id_cursomateria;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_cursomateria;
	@Select	@Insert	@Update	@Delete
	Integer qtd_aulas;
	@Select	@Insert	@Update	@Delete
	Double carga_horaria;
	@Select	@Insert	@Update	@Delete
	Integer id_curso;
	@Select	@Insert	@Update	@Delete
	String ativo;
	@Select	@Insert	@Update	@Delete
	Integer id_materia;
	@Select	@Insert	@Update	@Delete
	Integer id_modulo;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	
	
	public Integer getId_cursomateria() {
		return id_cursomateria;
	}
	public void setId_cursomateria(Integer id_cursomateria) {
		this.id_cursomateria = id_cursomateria;
	}
	public Double getCarga_horaria() {
		return carga_horaria;
	}
	public void setCarga_horaria(Double carga_horaria) {
		this.carga_horaria = carga_horaria;
	}
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public Integer getId_materia() {
		return id_materia;
	}
	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}
	public Integer getId_modulo() {
		return id_modulo;
	}
	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}
	public Integer getQtd_aulas() {
		return qtd_aulas;
	}
	public void setQtd_aulas(Integer qtd_aulas) {
		this.qtd_aulas = qtd_aulas;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	
	
	
	
	
	
}
