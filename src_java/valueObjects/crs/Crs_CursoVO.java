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
public class Crs_CursoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4966441549959782895L;

	@Sequence
	String crs_curso_id_curso;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_curso;
	@Select	@Insert	@Update	@Delete
	String nmcurso;
	@Select	@Insert	@Update	@Delete
	Integer id_tipocurso;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	@Select	@Insert	@Update	@Delete
	Integer curriculo;
	@Select	@Insert	@Update	@Delete
	String autorizacao;
	@Select	@Insert	@Update	@Delete
	String habilitacao;
	
	
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public String getNmcurso() {
		return nmcurso;
	}
	public void setNmcurso(String nmcurso) {
		this.nmcurso = nmcurso;
	}
	public Integer getId_tipocurso() {
		return id_tipocurso;
	}
	public void setId_tipocurso(Integer id_tipocurso) {
		this.id_tipocurso = id_tipocurso;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	public Integer getCurriculo() {
		return curriculo;
	}
	public void setCurriculo(Integer curriculo) {
		this.curriculo = curriculo;
	}
	public String getAutorizacao() {
		return autorizacao;
	}
	public void setAutorizacao(String autorizacao) {
		this.autorizacao = autorizacao;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	
	
	
	
}
