package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_HorarioVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4316314647535338137L;

	@Sequence
	String fpg_horario_id_horario;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_horario;
	@Select	@Insert	@Update	@Delete
	String folgaflutuante;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	@Select	@Insert	@Update	@Delete
	String nmhorario;
	public Integer getId_horario() {
		return id_horario;
	}
	public void setId_horario(Integer id_horario) {
		this.id_horario = id_horario;
	}
	public String getFolgaflutuante() {
		return folgaflutuante;
	}
	public void setFolgaflutuante(String folgaflutuante) {
		this.folgaflutuante = folgaflutuante;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
	public String getNmhorario() {
		return nmhorario;
	}
	public void setNmhorario(String nmhorario) {
		this.nmhorario = nmhorario;
	}


}
