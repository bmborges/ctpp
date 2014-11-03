package valueObjects.procedure;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class Pdg_CriaDiarioVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2358283542004226774L;
	/**
	 * 
	 */
	@Select
	Integer id_turma;
	@Select
	Integer id_modulo;
	@Select
	Timestamp dt_inicio;
	
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
	public Integer getId_modulo() {
		return id_modulo;
	}
	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}
	public Timestamp getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Timestamp dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	
	
	

}
