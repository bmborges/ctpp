package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Fin_Ctr_BaixadasVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863683180809409387L;
	
	@Select
	Integer id_contrato;
	@Select
	Integer cdseqpgto;
	@Select
	String parcela;
	@Select
	String nmtiporec;
	@Select
	String dt_vencimento;
	@Select
	String dt_baixa;
	@Select
	String vr_movim;
	@Select
	String vr_desconto;
	@Select
	String subtotal;
	@Select
	String nickname;
	@Select
	Integer id_retornobanco;
	@Select
	Timestamp dt_vencimento2;
	@Select
	Timestamp dt_baixa2;
	public Integer getCdseqpgto() {
		return cdseqpgto;
	}
	public void setCdseqpgto(Integer cdseqpgto) {
		this.cdseqpgto = cdseqpgto;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public String getNmtiporec() {
		return nmtiporec;
	}
	public void setNmtiporec(String nmtiporec) {
		this.nmtiporec = nmtiporec;
	}
	public String getDt_vencimento() {
		return dt_vencimento;
	}
	public void setDt_vencimento(String dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}
	public String getDt_baixa() {
		return dt_baixa;
	}
	public void setDt_baixa(String dt_baixa) {
		this.dt_baixa = dt_baixa;
	}
	public String getVr_movim() {
		return vr_movim;
	}
	public void setVr_movim(String vr_movim) {
		this.vr_movim = vr_movim;
	}
	public String getVr_desconto() {
		return vr_desconto;
	}
	public void setVr_desconto(String vr_desconto) {
		this.vr_desconto = vr_desconto;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getId_retornobanco() {
		return id_retornobanco;
	}
	public void setId_retornobanco(Integer id_retornobanco) {
		this.id_retornobanco = id_retornobanco;
	}
	public Timestamp getDt_vencimento2() {
		return dt_vencimento2;
	}
	public void setDt_vencimento2(Timestamp dt_vencimento2) {
		this.dt_vencimento2 = dt_vencimento2;
	}
	public Timestamp getDt_baixa2() {
		return dt_baixa2;
	}
	public void setDt_baixa2(Timestamp dt_baixa2) {
		this.dt_baixa2 = dt_baixa2;
	}			

}
