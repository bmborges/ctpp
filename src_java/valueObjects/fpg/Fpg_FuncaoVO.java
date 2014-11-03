package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_FuncaoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1967052227245518862L;

	@Sequence
	String fpg_funcao_id_funcao;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_funcao;
	@Select	@Insert	@Update	@Delete
	Integer idcbo;
	@Select	@Insert	@Update	@Delete
	Integer idnivel2;
	@Select	@Insert	@Update	@Delete
	String nmfuncao;
	@Select	@Insert	@Update	@Delete
	String areatrabalho;
	@Select	@Insert	@Update	@Delete
	String jornada;
	@Select	@Insert	@Update	@Delete
	String atividade;
	@Select	@Insert	@Update	@Delete
	String requisitos;
	@Select	@Insert	@Update	@Delete
	String perfil;
	@Select	@Insert	@Update	@Delete
	String ferramentas;
	@Select	@Insert	@Update	@Delete
	String direito_adicional;
	@Select	@Insert	@Update	@Delete
	String obs;
	@Select	@Insert	@Update	@Delete
	String gfip;
	@Select	@Insert	@Update	@Delete
	Integer grau_risco;
	@Select	@Insert	@Update	@Delete
	String epa;
	@Select	@Insert	@Update	@Delete
	String eps;
	@Select	@Insert	@Update	@Delete
	String emf;
	@Select	@Insert	@Update	@Delete
	String ert;
	@Select	@Insert	@Update	@Delete
	String obs_medico;
	@Select	@Insert	@Update	@Delete
	Integer idperito;
	
	public Integer getId_funcao() {
		return id_funcao;
	}
	public void setId_funcao(Integer id_funcao) {
		this.id_funcao = id_funcao;
	}
	public Integer getIdcbo() {
		return idcbo;
	}
	public void setIdcbo(Integer idcbo) {
		this.idcbo = idcbo;
	}
	public Integer getIdnivel2() {
		return idnivel2;
	}
	public void setIdnivel2(Integer idnivel2) {
		this.idnivel2 = idnivel2;
	}
	public String getNmfuncao() {
		return nmfuncao;
	}
	public void setNmfuncao(String nmfuncao) {
		this.nmfuncao = nmfuncao;
	}
	public String getAreatrabalho() {
		return areatrabalho;
	}
	public void setAreatrabalho(String areatrabalho) {
		this.areatrabalho = areatrabalho;
	}
	public String getJornada() {
		return jornada;
	}
	public void setJornada(String jornada) {
		this.jornada = jornada;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getFerramentas() {
		return ferramentas;
	}
	public void setFerramentas(String ferramentas) {
		this.ferramentas = ferramentas;
	}
	public String getDireito_adicional() {
		return direito_adicional;
	}
	public void setDireito_adicional(String direito_adicional) {
		this.direito_adicional = direito_adicional;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getGfip() {
		return gfip;
	}
	public void setGfip(String gfip) {
		this.gfip = gfip;
	}
	public Integer getGrau_risco() {
		return grau_risco;
	}
	public void setGrau_risco(Integer grau_risco) {
		this.grau_risco = grau_risco;
	}
	public String getEpa() {
		return epa;
	}
	public void setEpa(String epa) {
		this.epa = epa;
	}
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	public String getEmf() {
		return emf;
	}
	public void setEmf(String emf) {
		this.emf = emf;
	}
	public String getErt() {
		return ert;
	}
	public void setErt(String ert) {
		this.ert = ert;
	}
	public String getObs_medico() {
		return obs_medico;
	}
	public void setObs_medico(String obs_medico) {
		this.obs_medico = obs_medico;
	}
	public Integer getIdperito() {
		return idperito;
	}
	public void setIdperito(Integer idperito) {
		this.idperito = idperito;
	}
}
