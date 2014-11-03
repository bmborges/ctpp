package valueObjects.ctr;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_RequerimentoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -2681159088536513988L;


@Sequence
String ctr_requerimento_id_ctrrequerimento;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_ctrrequerimento;
@Select	@Insert	@Update	@Delete
Integer id_requerimento;
@Select	@Insert	@Update	@Delete
Integer id_operador;
@Select
Timestamp dt_sistema;
@Select	@Insert	@Update	@Delete
Integer requerimento;
@Select	@Insert	@Update	@Delete
Integer id_duplicata;
@Select	@Insert	@Update	@Delete
Integer id_formapgt;
@Select	@Insert	@Update	@Delete
Integer id_tiporec;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Timestamp dt_pentrega;
@Select	@Insert	@Update	@Delete
Timestamp dt_entrega;
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
}

