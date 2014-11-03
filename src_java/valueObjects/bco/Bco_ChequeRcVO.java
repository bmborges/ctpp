package valueObjects.bco;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Bco_ChequeRcVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -9070488614081941741L;


@Sequence
String bco_chequerc_id_chequerc;


	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_chequerc;
	@Select	@Insert	@Update	@Delete
	Integer cdbanco;
	@Select	@Insert	@Update	@Delete
	Integer id_alinea;
	@Select	@Insert	@Update	@Delete
	Integer nrchequerc;
	@Select	@Insert	@Update	@Delete
	Integer cdagenciarc;
	@Select	@Insert	@Update	@Delete
	String cdcontarc;
	@Select	@Insert	@Update	@Delete
	String cpf_rc;
	@Select	@Insert	@Update	@Delete
	String cdsubcontarc;
	@Select	@Insert	@Update	@Delete
	String historico;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_emissao;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_vencto;
	@Select	@Insert	@Update	@Delete
	Double valor;
	@Select	@Insert	@Update	@Delete
	String ativo;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Update	@Delete
	String serie_ch;
	@Select	@Insert	@Update	@Delete
	String c1;
	@Select	@Insert	@Update	@Delete
	String c2;
	@Select	@Insert	@Update	@Delete
	String c3;
	@Select	@Insert	@Update	@Delete
	Integer compensacao;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	public Integer getId_chequerc() {
		return id_chequerc;
	}
	public void setId_chequerc(Integer id_chequerc) {
		this.id_chequerc = id_chequerc;
	}
	public Integer getCdbanco() {
		return cdbanco;
	}
	public void setCdbanco(Integer cdbanco) {
		this.cdbanco = cdbanco;
	}
	public Integer getId_alinea() {
		return id_alinea;
	}
	public void setId_alinea(Integer id_alinea) {
		this.id_alinea = id_alinea;
	}
	public Integer getNrchequerc() {
		return nrchequerc;
	}
	public void setNrchequerc(Integer nrchequerc) {
		this.nrchequerc = nrchequerc;
	}
	public Integer getCdagenciarc() {
		return cdagenciarc;
	}
	public void setCdagenciarc(Integer cdagenciarc) {
		this.cdagenciarc = cdagenciarc;
	}
	public String getCdcontarc() {
		return cdcontarc;
	}
	public void setCdcontarc(String cdcontarc) {
		this.cdcontarc = cdcontarc;
	}
	public String getCpf_rc() {
		return cpf_rc;
	}
	public void setCpf_rc(String cpf_rc) {
		this.cpf_rc = cpf_rc;
	}
	public String getCdsubcontarc() {
		return cdsubcontarc;
	}
	public void setCdsubcontarc(String cdsubcontarc) {
		this.cdsubcontarc = cdsubcontarc;
	}
	public String getHistorico() {
		return historico;
	}
	public void setHistorico(String historico) {
		this.historico = historico;
	}
	public Timestamp getDt_emissao() {
		return dt_emissao;
	}
	public void setDt_emissao(Timestamp dt_emissao) {
		this.dt_emissao = dt_emissao;
	}
	public Timestamp getDt_vencto() {
		return dt_vencto;
	}
	public void setDt_vencto(Timestamp dt_vencto) {
		this.dt_vencto = dt_vencto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public String getSerie_ch() {
		return serie_ch;
	}
	public void setSerie_ch(String serie_ch) {
		this.serie_ch = serie_ch;
	}
	public String getC1() {
		return c1;
	}
	public void setC1(String c1) {
		this.c1 = c1;
	}
	public String getC2() {
		return c2;
	}
	public void setC2(String c2) {
		this.c2 = c2;
	}
	public String getC3() {
		return c3;
	}
	public void setC3(String c3) {
		this.c3 = c3;
	}
	public Integer getCompensacao() {
		return compensacao;
	}
	public void setCompensacao(Integer compensacao) {
		this.compensacao = compensacao;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
}
