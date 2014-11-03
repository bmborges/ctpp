package valueObjects.fin;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_RenegociacaoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 2895848947062063042L;


@Sequence
String fin_renegociacao_id_renegociacao;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_renegociacao;
@Select	@Insert	@Update	@Delete
Integer id_operador;
@Select	@Insert	@Update	@Delete
Timestamp dt_sistema;
@Select	@Insert	@Update	@Delete
String texto;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
public Integer getId_renegociacao() {
	return id_renegociacao;
}
public void setId_renegociacao(Integer id_renegociacao) {
	this.id_renegociacao = id_renegociacao;
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
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
}

