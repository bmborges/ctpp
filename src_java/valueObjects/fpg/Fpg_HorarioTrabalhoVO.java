package valueObjects.fpg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_HorarioTrabalhoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 542995522255893553L;

	@Sequence
	String fpg_horariotrabalho_id_horariotrabalho;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_horariotrabalho;
	@Select	@Insert	@Update	@Delete
	Timestamp h_entrada;
	@Select	@Insert	@Update	@Delete
	Timestamp h_saida;
	@Select	@Insert	@Update	@Delete
	Timestamp int_saida;
	@Select	@Insert	@Update	@Delete
	Timestamp int_entrada;
	@Select	@Insert	@Update	@Delete
	String folga;
	@Select	@Insert	@Update	@Delete
	Integer dia_semana;
	@Select	@Insert	@Update	@Delete
	Integer id_horario;
	@Select	@Insert	@Update	@Delete
	String horasprevistas;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	public Integer getId_horariotrabalho() {
		return id_horariotrabalho;
	}
	public void setId_horariotrabalho(Integer id_horariotrabalho) {
		this.id_horariotrabalho = id_horariotrabalho;
	}
	public Timestamp getH_entrada() {
		return h_entrada;
	}
	public void setH_entrada(Timestamp h_entrada) {
		this.h_entrada = h_entrada;
	}
	public Timestamp getH_saida() {
		return h_saida;
	}
	public void setH_saida(Timestamp h_saida) {
		this.h_saida = h_saida;
	}
	public Timestamp getInt_saida() {
		return int_saida;
	}
	public void setInt_saida(Timestamp int_saida) {
		this.int_saida = int_saida;
	}
	public Timestamp getInt_entrada() {
		return int_entrada;
	}
	public void setInt_entrada(Timestamp int_entrada) {
		this.int_entrada = int_entrada;
	}
	public String getFolga() {
		return folga;
	}
	public void setFolga(String folga) {
		this.folga = folga;
	}
	public Integer getDia_semana() {
		return dia_semana;
	}
	public void setDia_semana(Integer dia_semana) {
		this.dia_semana = dia_semana;
	}
	public Integer getId_horario() {
		return id_horario;
	}
	public void setId_horario(Integer id_horario) {
		this.id_horario = id_horario;
	}
	public String getHorasprevistas() {
		return horasprevistas;
	}
	public void setHorasprevistas(String horasprevistas) {
		this.horasprevistas = horasprevistas;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}


}
