package valueObjects.view;

import java.io.Serializable;

import annotations.PrimaryKey;
import annotations.Select;

public class View_Contrato_DuplicataVO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5591049502810446102L;
	
	@Select 
	Integer id_duplicata;
	@Select 
	String parcela;
	@Select 
	String nmtiporec;
	@Select 
	String nmformapgt;
	@Select 
	String dt_vencimento;
	@Select 
	String valor;	
	@Select 
	String desconto;
	@Select 
	String vr_juro;	
	@Select 
	String saldo;
	@Select 
	String subtotal;
	@Select 
	String vr_pago;	
	@Select 
	String dt_pagamento;
	@Select 
	String nmmodulo;
	@Select 
	String dt_cancelamento;
	@Select
	Integer id_contrato;
	
	
	public Integer getId_duplicata() {
		return id_duplicata;
	}
	public void setId_duplicata(Integer id_duplicata) {
		this.id_duplicata = id_duplicata;
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
	public String getNmformapgt() {
		return nmformapgt;
	}
	public void setNmformapgt(String nmformapgt) {
		this.nmformapgt = nmformapgt;
	}
	public String getDt_vencimento() {
		return dt_vencimento;
	}
	public void setDt_vencimento(String dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}
	public String getVr_juro() {
		return vr_juro;
	}
	public void setVr_juro(String vr_juro) {
		this.vr_juro = vr_juro;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public String getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	public String getVr_pago() {
		return vr_pago;
	}
	public void setVr_pago(String vr_pago) {
		this.vr_pago = vr_pago;
	}
	public String getDt_pagamento() {
		return dt_pagamento;
	}
	public void setDt_pagamento(String dt_pagamento) {
		this.dt_pagamento = dt_pagamento;
	}
	public String getNmmodulo() {
		return nmmodulo;
	}
	public void setNmmodulo(String nmmodulo) {
		this.nmmodulo = nmmodulo;
	}
	public String getDt_cancelamento() {
		return dt_cancelamento;
	}
	public void setDt_cancelamento(String dt_cancelamento) {
		this.dt_cancelamento = dt_cancelamento;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}			

}