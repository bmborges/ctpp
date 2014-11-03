package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Pdg_DiarioVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4988815097729338558L;
	
	
	@Select
	Integer id_diario;
	@Select
	String nmturma;
	@Select
	String nmoperador;
	@Select
	String nmmateria;
	@Select
	Integer id_status;
	@Select
	Integer id_operador;
	@Select
	Timestamp dt_inicio;
	@Select
	Integer id_tipoavaliacao;
	@Select
	String nmstatus;
	public Integer getId_diario() {
		return id_diario;
	}
	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}
	public String getNmturma() {
		return nmturma;
	}
	public void setNmturma(String nmturma) {
		this.nmturma = nmturma;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
	public String getNmmateria() {
		return nmmateria;
	}
	public void setNmmateria(String nmmateria) {
		this.nmmateria = nmmateria;
	}
	public Integer getId_status() {
		return id_status;
	}
	public void setId_status(Integer id_status) {
		this.id_status = id_status;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Timestamp getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Timestamp dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Integer getId_tipoavaliacao() {
		return id_tipoavaliacao;
	}
	public void setId_tipoavaliacao(Integer id_tipoavaliacao) {
		this.id_tipoavaliacao = id_tipoavaliacao;
	}
	public String getNmstatus() {
		return nmstatus;
	}
	public void setNmstatus(String nmstatus) {
		this.nmstatus = nmstatus;
	}
	
	

}
