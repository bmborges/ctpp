package valueObjects.fpg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_CadFuncVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9150883661375360662L;

	@Sequence
	String fpg_cadfunc_id_parceiro;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_parceiro;
	@Select	@Insert	@Update	@Delete
	Integer situacaofunc;
	@Select	@Insert	@Update	@Delete
	Integer ctps_nr;
	@Select	@Insert	@Update	@Delete
	String ctps_serie;
	@Select	@Insert	@Update	@Delete
	String ctps_uf;
	@Select	@Insert	@Update	@Delete
	Timestamp ctps_data;
	@Select	@Insert	@Update	@Delete
	Integer ctps_ruralnr;
	@Select	@Insert	@Update	@Delete
	String ctps_ruralserie;
	@Select	@Insert	@Update	@Delete
	String tituloeleitor;
	@Select	@Insert	@Update	@Delete
	String zntitulo;
	@Select	@Insert	@Update	@Delete
	String cnh;
	@Select	@Insert	@Update	@Delete
	String cat_cnh;
	@Select	@Insert	@Update	@Delete
	String cert_militar;
	@Select	@Insert	@Update	@Delete
	String estrangeiro;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_pis;
	@Select	@Insert	@Update	@Delete
	String pis;
	@Select	@Insert	@Update	@Delete
	String agencia_pis;
	@Select	@Insert	@Update	@Delete
	String end_pis;
	@Select	@Insert	@Update	@Delete
	String obs;
	@Select	@Insert	@Update	@Delete
	String deficiente;
	@Select	@Insert	@Update	@Delete
	String port_alvara;
	@Select	@Insert	@Update	@Delete
	String nmfuncionario;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	@Select	@Insert	@Update	@Delete
	Integer ano_chegada;
	@Select	@Insert	@Update	@Delete
	String tipodeficiencia;
	@Select	@Insert	@Update	@Delete
	String cipa;
	@Select	@Insert	@Update	@Delete
	String bate_ponto;
	public Integer getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Integer id_parceiro) {
		this.id_parceiro = id_parceiro;
	}
	public Integer getSituacaofunc() {
		return situacaofunc;
	}
	public void setSituacaofunc(Integer situacaofunc) {
		this.situacaofunc = situacaofunc;
	}
	public Integer getCtps_nr() {
		return ctps_nr;
	}
	public void setCtps_nr(Integer ctps_nr) {
		this.ctps_nr = ctps_nr;
	}
	public String getCtps_serie() {
		return ctps_serie;
	}
	public void setCtps_serie(String ctps_serie) {
		this.ctps_serie = ctps_serie;
	}
	public String getCtps_uf() {
		return ctps_uf;
	}
	public void setCtps_uf(String ctps_uf) {
		this.ctps_uf = ctps_uf;
	}
	public Timestamp getCtps_data() {
		return ctps_data;
	}
	public void setCtps_data(Timestamp ctps_data) {
		this.ctps_data = ctps_data;
	}
	public Integer getCtps_ruralnr() {
		return ctps_ruralnr;
	}
	public void setCtps_ruralnr(Integer ctps_ruralnr) {
		this.ctps_ruralnr = ctps_ruralnr;
	}
	public String getCtps_ruralserie() {
		return ctps_ruralserie;
	}
	public void setCtps_ruralserie(String ctps_ruralserie) {
		this.ctps_ruralserie = ctps_ruralserie;
	}
	public String getTituloeleitor() {
		return tituloeleitor;
	}
	public void setTituloeleitor(String tituloeleitor) {
		this.tituloeleitor = tituloeleitor;
	}
	public String getZntitulo() {
		return zntitulo;
	}
	public void setZntitulo(String zntitulo) {
		this.zntitulo = zntitulo;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getCat_cnh() {
		return cat_cnh;
	}
	public void setCat_cnh(String cat_cnh) {
		this.cat_cnh = cat_cnh;
	}
	public String getCert_militar() {
		return cert_militar;
	}
	public void setCert_militar(String cert_militar) {
		this.cert_militar = cert_militar;
	}
	public String getEstrangeiro() {
		return estrangeiro;
	}
	public void setEstrangeiro(String estrangeiro) {
		this.estrangeiro = estrangeiro;
	}
	public Timestamp getDt_pis() {
		return dt_pis;
	}
	public void setDt_pis(Timestamp dt_pis) {
		this.dt_pis = dt_pis;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
	public String getAgencia_pis() {
		return agencia_pis;
	}
	public void setAgencia_pis(String agencia_pis) {
		this.agencia_pis = agencia_pis;
	}
	public String getEnd_pis() {
		return end_pis;
	}
	public void setEnd_pis(String end_pis) {
		this.end_pis = end_pis;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
	public String getDeficiente() {
		return deficiente;
	}
	public void setDeficiente(String deficiente) {
		this.deficiente = deficiente;
	}
	public String getPort_alvara() {
		return port_alvara;
	}
	public void setPort_alvara(String port_alvara) {
		this.port_alvara = port_alvara;
	}
	public String getNmfuncionario() {
		return nmfuncionario;
	}
	public void setNmfuncionario(String nmfuncionario) {
		this.nmfuncionario = nmfuncionario;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
	public Integer getAno_chegada() {
		return ano_chegada;
	}
	public void setAno_chegada(Integer ano_chegada) {
		this.ano_chegada = ano_chegada;
	}
	public String getTipodeficiencia() {
		return tipodeficiencia;
	}
	public void setTipodeficiencia(String tipodeficiencia) {
		this.tipodeficiencia = tipodeficiencia;
	}
	public String getCipa() {
		return cipa;
	}
	public void setCipa(String cipa) {
		this.cipa = cipa;
	}
	public String getBate_ponto() {
		return bate_ponto;
	}
	public void setBate_ponto(String bate_ponto) {
		this.bate_ponto = bate_ponto;
	}


}
