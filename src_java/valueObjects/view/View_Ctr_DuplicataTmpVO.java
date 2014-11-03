package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Ctr_DuplicataTmpVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -7969651482326507129L;
@Select
Integer id_duplicatatmp;
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
Double saldo;
@Select
Double subtotal;
@Select
String nmmodulo;
@Select
Integer id_contrato;
@Select
Integer id_situacao;
@Select
Integer id_tiporec;
@Select
Integer id_formapgt;
@Select
Integer id_tabvalores; 
@Select
Integer id_modulo;
@Select
Integer selec;

public Integer getId_duplicatatmp() {
	return id_duplicatatmp;
}
public void setId_duplicatatmp(Integer id_duplicatatmp) {
	this.id_duplicatatmp = id_duplicatatmp;
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
public String getNmmodulo() {
	return nmmodulo;
}
public void setNmmodulo(String nmmodulo) {
	this.nmmodulo = nmmodulo;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getId_situacao() {
	return id_situacao;
}
public void setId_situacao(Integer id_situacao) {
	this.id_situacao = id_situacao;
}
public Integer getId_tiporec() {
	return id_tiporec;
}
public void setId_tiporec(Integer id_tiporec) {
	this.id_tiporec = id_tiporec;
}
public Integer getId_formapgt() {
	return id_formapgt;
}
public void setId_formapgt(Integer id_formapgt) {
	this.id_formapgt = id_formapgt;
}
public Integer getId_tabvalores() {
	return id_tabvalores;
}
public void setId_tabvalores(Integer id_tabvalores) {
	this.id_tabvalores = id_tabvalores;
}
public Integer getId_modulo() {
	return id_modulo;
}
public void setId_modulo(Integer id_modulo) {
	this.id_modulo = id_modulo;
}
public Integer getSelec() {
	return selec;
}
public void setSelec(Integer selec) {
	this.selec = selec;
}
}

