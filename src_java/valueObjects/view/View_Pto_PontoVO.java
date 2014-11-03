package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.Select;
import annotations.Update;

public class View_Pto_PontoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 453318611806472206L;
	@Select	@Insert	@Update	@Delete
	Integer id_ponto;
	@Select	@Insert	@Update	@Delete
	Integer id_parceiro;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema1;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema2;
	@Select	@Insert	@Update	@Delete
	String dow;
	@Select	@Insert	@Update	@Delete
	String nmfolga;
	@Select	@Insert	@Update	@Delete
	String horario_ent;
	@Select	@Insert	@Update	@Delete
	String intervalo_sai;
	@Select	@Insert	@Update	@Delete
	String intervalo_ent;
	@Select	@Insert	@Update	@Delete
	String horario_sai;
	@Select	@Insert	@Update	@Delete
	String horatotal;
	@Select	@Insert	@Update	@Delete
	String faltas;
	@Select	@Insert	@Update	@Delete
	String extras;
	@Select	@Insert	@Update	@Delete
	Integer id_horariotrabalho;
	@Select	@Insert	@Update	@Delete
	String extra_ent;
	@Select	@Insert	@Update	@Delete
	String extra_sai;
	@Select	@Insert	@Update	@Delete
	Integer ordem;
	@Select	@Insert	@Update	@Delete
	String folga;
	@Select	@Insert	@Update	@Delete
	Integer fpg_idjustificativa;
	@Select	@Insert	@Update	@Delete
	String fpg_idjustificativa_desc;
	@Select	@Insert	@Update	@Delete
	Integer fpg2_idjustificativa;
	@Select	@Insert	@Update	@Delete
	String fpg2_idjustificativa_desc;
	@Select	@Insert	@Update	@Delete
	Integer fpg3_idjustificativa;
	@Select	@Insert	@Update	@Delete
	String fpg3_idjustificativa_desc;
	@Select	@Insert	@Update	@Delete
	Integer fpg4_idjustificativa;
	@Select	@Insert	@Update	@Delete
	String fpg4_idjustificativa_desc;
	
	public Integer getId_ponto() {
		return id_ponto;
	}
	public void setId_ponto(Integer id_ponto) {
		this.id_ponto = id_ponto;
	}
	public Integer getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Integer id_parceiro) {
		this.id_parceiro = id_parceiro;
	}
	public Timestamp getDt_sistema1() {
		return dt_sistema1;
	}
	public void setDt_sistema1(Timestamp dt_sistema1) {
		this.dt_sistema1 = dt_sistema1;
	}
	public Timestamp getDt_sistema2() {
		return dt_sistema2;
	}
	public void setDt_sistema2(Timestamp dt_sistema2) {
		this.dt_sistema2 = dt_sistema2;
	}
	public String getDow() {
		return dow;
	}
	public void setDow(String dow) {
		this.dow = dow;
	}
	public String getNmfolga() {
		return nmfolga;
	}
	public void setNmfolga(String nmfolga) {
		this.nmfolga = nmfolga;
	}
	public String getHorario_ent() {
		return horario_ent;
	}
	public void setHorario_ent(String horario_ent) {
		this.horario_ent = horario_ent;
	}
	public String getIntervalo_sai() {
		return intervalo_sai;
	}
	public void setIntervalo_sai(String intervalo_sai) {
		this.intervalo_sai = intervalo_sai;
	}
	public String getIntervalo_ent() {
		return intervalo_ent;
	}
	public void setIntervalo_ent(String intervalo_ent) {
		this.intervalo_ent = intervalo_ent;
	}
	public String getHorario_sai() {
		return horario_sai;
	}
	public void setHorario_sai(String horario_sai) {
		this.horario_sai = horario_sai;
	}
	public String getHoratotal() {
		return horatotal;
	}
	public void setHoratotal(String horatotal) {
		this.horatotal = horatotal;
	}
	public String getFaltas() {
		return faltas;
	}
	public void setFaltas(String faltas) {
		this.faltas = faltas;
	}
	public String getExtras() {
		return extras;
	}
	public void setExtras(String extras) {
		this.extras = extras;
	}
	public Integer getId_horariotrabalho() {
		return id_horariotrabalho;
	}
	public void setId_horariotrabalho(Integer id_horariotrabalho) {
		this.id_horariotrabalho = id_horariotrabalho;
	}
	public String getExtra_ent() {
		return extra_ent;
	}
	public void setExtra_ent(String extra_ent) {
		this.extra_ent = extra_ent;
	}
	public String getExtra_sai() {
		return extra_sai;
	}
	public void setExtra_sai(String extra_sai) {
		this.extra_sai = extra_sai;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public String getFolga() {
		return folga;
	}
	public void setFolga(String folga) {
		this.folga = folga;
	}
	public Integer getFpg_idjustificativa() {
		return fpg_idjustificativa;
	}
	public void setFpg_idjustificativa(Integer fpg_idjustificativa) {
		this.fpg_idjustificativa = fpg_idjustificativa;
	}
	public String getFpg_idjustificativa_desc() {
		return fpg_idjustificativa_desc;
	}
	public void setFpg_idjustificativa_desc(String fpg_idjustificativa_desc) {
		this.fpg_idjustificativa_desc = fpg_idjustificativa_desc;
	}
	public Integer getFpg2_idjustificativa() {
		return fpg2_idjustificativa;
	}
	public void setFpg2_idjustificativa(Integer fpg2_idjustificativa) {
		this.fpg2_idjustificativa = fpg2_idjustificativa;
	}
	public String getFpg2_idjustificativa_desc() {
		return fpg2_idjustificativa_desc;
	}
	public void setFpg2_idjustificativa_desc(String fpg2_idjustificativa_desc) {
		this.fpg2_idjustificativa_desc = fpg2_idjustificativa_desc;
	}
	public Integer getFpg3_idjustificativa() {
		return fpg3_idjustificativa;
	}
	public void setFpg3_idjustificativa(Integer fpg3_idjustificativa) {
		this.fpg3_idjustificativa = fpg3_idjustificativa;
	}
	public String getFpg3_idjustificativa_desc() {
		return fpg3_idjustificativa_desc;
	}
	public void setFpg3_idjustificativa_desc(String fpg3_idjustificativa_desc) {
		this.fpg3_idjustificativa_desc = fpg3_idjustificativa_desc;
	}
	public Integer getFpg4_idjustificativa() {
		return fpg4_idjustificativa;
	}
	public void setFpg4_idjustificativa(Integer fpg4_idjustificativa) {
		this.fpg4_idjustificativa = fpg4_idjustificativa;
	}
	public String getFpg4_idjustificativa_desc() {
		return fpg4_idjustificativa_desc;
	}
	public void setFpg4_idjustificativa_desc(String fpg4_idjustificativa_desc) {
		this.fpg4_idjustificativa_desc = fpg4_idjustificativa_desc;
	}
}

