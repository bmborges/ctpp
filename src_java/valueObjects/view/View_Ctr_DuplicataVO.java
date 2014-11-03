package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Ctr_DuplicataVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -8293828825039590328L;
@Select
Integer id_duplicata;
@Select
String parcela;
@Select
String nmtiporec;
@Select
String nmformapgt;
@Select
Timestamp dt_vencimento;
@Select
Double valor;
@Select
Double desconto;
@Select
Double vr_juro;
@Select
Double saldo;
@Select
Double subtotal;
@Select
Double vr_pago;
@Select
Timestamp dt_pagamento;
@Select
String nmmodulo;
@Select
Timestamp dt_cancelamento;
@Select
Integer id_contrato;
@Select
Integer renegociar;
@Select
Integer selec;
@Select
Integer cancelar;
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
public Timestamp getDt_vencimento() {
	return dt_vencimento;
}
public void setDt_vencimento(Timestamp dt_vencimento) {
	this.dt_vencimento = dt_vencimento;
}
public Double getValor() {
	return valor;
}
public void setValor(Double valor) {
	this.valor = valor;
}
public Double getDesconto() {
	return desconto;
}
public void setDesconto(Double desconto) {
	this.desconto = desconto;
}
public Double getVr_juro() {
	return vr_juro;
}
public void setVr_juro(Double vr_juro) {
	this.vr_juro = vr_juro;
}
public Double getSaldo() {
	return saldo;
}
public void setSaldo(Double saldo) {
	this.saldo = saldo;
}
public Double getSubtotal() {
	return subtotal;
}
public void setSubtotal(Double subtotal) {
	this.subtotal = subtotal;
}
public Double getVr_pago() {
	return vr_pago;
}
public void setVr_pago(Double vr_pago) {
	this.vr_pago = vr_pago;
}
public Timestamp getDt_pagamento() {
	return dt_pagamento;
}
public void setDt_pagamento(Timestamp dt_pagamento) {
	this.dt_pagamento = dt_pagamento;
}
public String getNmmodulo() {
	return nmmodulo;
}
public void setNmmodulo(String nmmodulo) {
	this.nmmodulo = nmmodulo;
}
public Timestamp getDt_cancelamento() {
	return dt_cancelamento;
}
public void setDt_cancelamento(Timestamp dt_cancelamento) {
	this.dt_cancelamento = dt_cancelamento;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getRenegociar() {
	return renegociar;
}
public void setRenegociar(Integer renegociar) {
	this.renegociar = renegociar;
}
public Integer getSelec() {
	return selec;
}
public void setSelec(Integer selec) {
	this.selec = selec;
}
public Integer getCancelar() {
	return cancelar;
}
public void setCancelar(Integer cancelar) {
	this.cancelar = cancelar;
}
}

