package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Ctr_RequerimentoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 4814409897035470526L;
@Select
Integer id_ctrrequerimento;
@Select
Integer id_requerimento;
@Select
Integer id_operador;
@Select
Timestamp dt_sistema;
@Select
Integer requerimento;
@Select
Integer id_duplicata;
@Select
Integer id_formapgt;
@Select
Integer id_tiporec;
@Select
Integer id_contrato;
@Select
Timestamp dt_pentrega;
@Select
Timestamp dt_entrega;
@Select
String nmrequerimento;
@Select
Double valor;
@Select
String nmoperador;
@Select
Timestamp dt_pagamento;
@Select
Timestamp dt_vencimento;
@Select
String nmformapgt;
@Select
String nmtiporec;
public Integer getId_ctrrequerimento() {
	return id_ctrrequerimento;
}
public void setId_ctrrequerimento(Integer id_ctrrequerimento) {
	this.id_ctrrequerimento = id_ctrrequerimento;
}
public Integer getId_requerimento() {
	return id_requerimento;
}
public void setId_requerimento(Integer id_requerimento) {
	this.id_requerimento = id_requerimento;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
public Timestamp getDt_sistema() {
	return dt_sistema;
}
public void setDt_sistema(Timestamp dt_sistema) {
	this.dt_sistema = dt_sistema;
}
public Integer getRequerimento() {
	return requerimento;
}
public void setRequerimento(Integer requerimento) {
	this.requerimento = requerimento;
}
public Integer getId_duplicata() {
	return id_duplicata;
}
public void setId_duplicata(Integer id_duplicata) {
	this.id_duplicata = id_duplicata;
}
public Integer getId_formapgt() {
	return id_formapgt;
}
public void setId_formapgt(Integer id_formapgt) {
	this.id_formapgt = id_formapgt;
}
public Integer getId_tiporec() {
	return id_tiporec;
}
public void setId_tiporec(Integer id_tiporec) {
	this.id_tiporec = id_tiporec;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Timestamp getDt_pentrega() {
	return dt_pentrega;
}
public void setDt_pentrega(Timestamp dt_pentrega) {
	this.dt_pentrega = dt_pentrega;
}
public Timestamp getDt_entrega() {
	return dt_entrega;
}
public void setDt_entrega(Timestamp dt_entrega) {
	this.dt_entrega = dt_entrega;
}
public String getNmrequerimento() {
	return nmrequerimento;
}
public void setNmrequerimento(String nmrequerimento) {
	this.nmrequerimento = nmrequerimento;
}
public Double getValor() {
	return valor;
}
public void setValor(Double valor) {
	this.valor = valor;
}
public String getNmoperador() {
	return nmoperador;
}
public void setNmoperador(String nmoperador) {
	this.nmoperador = nmoperador;
}
public Timestamp getDt_pagamento() {
	return dt_pagamento;
}
public void setDt_pagamento(Timestamp dt_pagamento) {
	this.dt_pagamento = dt_pagamento;
}
public Timestamp getDt_vencimento() {
	return dt_vencimento;
}
public void setDt_vencimento(Timestamp dt_vencimento) {
	this.dt_vencimento = dt_vencimento;
}
public String getNmformapgt() {
	return nmformapgt;
}
public void setNmformapgt(String nmformapgt) {
	this.nmformapgt = nmformapgt;
}
public String getNmtiporec() {
	return nmtiporec;
}
public void setNmtiporec(String nmtiporec) {
	this.nmtiporec = nmtiporec;
}
}

