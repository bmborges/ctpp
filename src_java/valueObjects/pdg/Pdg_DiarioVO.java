package valueObjects.pdg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_DiarioVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6101214589869239465L;
	
	@Sequence
	String pdg_diario_id_diario;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_diario;
	@Select	@Insert	@Update	@Delete
	Integer id_turmaedu;
	@Select	@Insert	@Update	@Delete
	Integer id_status;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_inicio;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Update	@Delete
	Integer editando;
	
	public Integer getId_diario() {
		return id_diario;
	}
	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}
	public Integer getId_turmaedu() {
		return id_turmaedu;
	}
	public void setId_turmaedu(Integer id_turmaedu) {
		this.id_turmaedu = id_turmaedu;
	}
	public Integer getId_status() {
		return id_status;
	}
	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}
	public Integer getEditando() {
		return editando;
	}
	public void setEditando(Integer editando) {
		this.editando = editando;
	}
	public Timestamp getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Timestamp dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	
	

}
