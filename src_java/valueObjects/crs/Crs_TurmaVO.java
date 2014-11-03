/**
 * 
 */
package valueObjects.crs;

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
public class Crs_TurmaVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 5850316092459522565L;
	
	@Sequence
	String crs_turma_id_turma;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_turma;
	@Select	@Insert	@Update	@Delete
	String nmturma;
	@Select	@Insert	@Update	@Delete
	Integer id_curso;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_inicial;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_final;
	@Select	@Insert	@Update	@Delete
	Integer status;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_cadastro;
	@Select	@Insert	@Update	@Delete
	Integer id_sala;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
	public String getNmturma() {
		return nmturma;
	}
	public void setNmturma(String nmturma) {
		this.nmturma = nmturma;
	}
	public Integer getId_curso() {
		return id_curso;
	}
	public void setId_curso(Integer id_curso) {
		this.id_curso = id_curso;
	}
	public Timestamp getDt_inicial() {
		return dt_inicial;
	}
	public void setDt_inicial(Timestamp dt_inicial) {
		this.dt_inicial = dt_inicial;
	}
	public Timestamp getDt_final() {
		return dt_final;
	}
	public void setDt_final(Timestamp dt_final) {
		this.dt_final = dt_final;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getDt_cadastro() {
		return dt_cadastro;
	}
	public void setDt_cadastro(Timestamp dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}
	public Integer getId_sala() {
		return id_sala;
	}
	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	
	
	
	
}
