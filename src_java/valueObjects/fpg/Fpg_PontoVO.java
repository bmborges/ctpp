package valueObjects.fpg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_PontoVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9046835395493769183L;

	@Sequence
	
	String fpg_ponto_id_ponto;
	
	@PrimaryKey
	@Select	@Insert	@Delete
	Integer id_ponto;
	@Select	@Insert	@Delete
	Integer id_parceiro;
	@Select	@Insert	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Delete
	Timestamp horario_ent;
	@Select	@Insert	@Delete
	Timestamp horario_sai;
	@Select	@Insert	@Delete
	Timestamp intervalo_sai;
	@Select	@Insert	@Delete
	Timestamp intervalo_ent;
	@Select	@Insert	@Update	@Delete
	Integer adm_id_operador;
	@Select	@Insert	@Update	@Delete
	Integer adm2_id_operador;
	@Select	@Insert	@Update	@Delete
	Integer adm3_id_operador;
	@Select	@Insert	@Update	@Delete
	Integer adm4_id_operador;
	@Select	@Insert	@Update	@Delete
	Integer idjustificativa;
	@Select	@Insert	@Update	@Delete
	Integer fpg_idjustificativa;
	@Select	@Insert	@Update	@Delete
	Integer fpg2_idjustificativa;
	@Select	@Insert	@Update	@Delete
	Integer fpg3_idjustificativa;
	@Select	@Insert	@Update	@Delete
	Integer fpg4_idjustificativa;
	@Select	@Insert	@Update	@Delete
	String obs;
//	@Select	@Insert	@Update	@Delete
//	time abono;
//	@Select	@Insert	@Update	@Delete
//	time hextras_1;
//	@Select	@Insert	@Update	@Delete
//	time horatotal;
//	@Select	@Insert	@Update	@Delete
//	time hextras_2;
//	@Select	@Insert	@Update	@Delete
//	time hextras_3;
//	@Select	@Insert	@Update	@Delete
//	time hextras_4;
//	@Select	@Insert	@Update	@Delete
//	time faltas;
//	@Select	@Insert	@Update	@Delete
//	time ad_noturno;
//	@Select	@Insert	@Update	@Delete
//	time pendencias;
	@Select	@Insert	@Delete
	Integer id_horariotrabalho;
	@Select	@Insert	@Update	@Delete
	String folga;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	@Select	@Insert	@Delete
	Timestamp extra_ent;
	@Select	@Insert	@Delete
	Timestamp extra_sai;
	@Select	@Insert	@Delete
	Timestamp ultimo_registro;
	
	public String getFpg_ponto_id_ponto() {
		return fpg_ponto_id_ponto;
	}
	public void setFpg_ponto_id_ponto(String fpg_ponto_id_ponto) {
		this.fpg_ponto_id_ponto = fpg_ponto_id_ponto;
	}
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
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public Timestamp getHorario_ent() {
		return horario_ent;
	}
	public void setHorario_ent(Timestamp horario_ent) {
		this.horario_ent = horario_ent;
	}
	public Timestamp getHorario_sai() {
		return horario_sai;
	}
	public void setHorario_sai(Timestamp horario_sai) {
		this.horario_sai = horario_sai;
	}
	public Timestamp getIntervalo_sai() {
		return intervalo_sai;
	}
	public void setIntervalo_sai(Timestamp intervalo_sai) {
		this.intervalo_sai = intervalo_sai;
	}
	public Timestamp getIntervalo_ent() {
		return intervalo_ent;
	}
	public void setIntervalo_ent(Timestamp intervalo_ent) {
		this.intervalo_ent = intervalo_ent;
	}
	public Integer getAdm_id_operador() {
		return adm_id_operador;
	}
	public void setAdm_id_operador(Integer adm_id_operador) {
		this.adm_id_operador = adm_id_operador;
	}
	public Integer getAdm2_id_operador() {
		return adm2_id_operador;
	}
	public void setAdm2_id_operador(Integer adm2_id_operador) {
		this.adm2_id_operador = adm2_id_operador;
	}
	public Integer getAdm3_id_operador() {
		return adm3_id_operador;
	}
	public void setAdm3_id_operador(Integer adm3_id_operador) {
		this.adm3_id_operador = adm3_id_operador;
	}
	public Integer getAdm4_id_operador() {
		return adm4_id_operador;
	}
	public void setAdm4_id_operador(Integer adm4_id_operador) {
		this.adm4_id_operador = adm4_id_operador;
	}
	public Integer getIdjustificativa() {
		return idjustificativa;
	}
	public void setIdjustificativa(Integer idjustificativa) {
		this.idjustificativa = idjustificativa;
	}
	public Integer getFpg_idjustificativa() {
		return fpg_idjustificativa;
	}
	public void setFpg_idjustificativa(Integer fpg_idjustificativa) {
		this.fpg_idjustificativa = fpg_idjustificativa;
	}
	public Integer getFpg2_idjustificativa() {
		return fpg2_idjustificativa;
	}
	public void setFpg2_idjustificativa(Integer fpg2_idjustificativa) {
		this.fpg2_idjustificativa = fpg2_idjustificativa;
	}
	public Integer getFpg3_idjustificativa() {
		return fpg3_idjustificativa;
	}
	public void setFpg3_idjustificativa(Integer fpg3_idjustificativa) {
		this.fpg3_idjustificativa = fpg3_idjustificativa;
	}
	public Integer getFpg4_idjustificativa() {
		return fpg4_idjustificativa;
	}
	public void setFpg4_idjustificativa(Integer fpg4_idjustificativa) {
		this.fpg4_idjustificativa = fpg4_idjustificativa;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public Integer getId_horariotrabalho() {
		return id_horariotrabalho;
	}
	public void setId_horariotrabalho(Integer id_horariotrabalho) {
		this.id_horariotrabalho = id_horariotrabalho;
	}
	public String getFolga() {
		return folga;
	}
	public void setFolga(String folga) {
		this.folga = folga;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
	public Timestamp getExtra_ent() {
		return extra_ent;
	}
	public void setExtra_ent(Timestamp extra_ent) {
		this.extra_ent = extra_ent;
	}
	public Timestamp getExtra_sai() {
		return extra_sai;
	}
	public void setExtra_sai(Timestamp extra_sai) {
		this.extra_sai = extra_sai;
	}
	public Timestamp getUltimo_registro() {
		return ultimo_registro;
	}
	public void setUltimo_registro(Timestamp ultimo_registro) {
		this.ultimo_registro = ultimo_registro;
	}


}
