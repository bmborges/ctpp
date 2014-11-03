package valueObjects.pdg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_RequerimentoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -3751806176176291227L;


@Sequence
String pdg_requerimento_id_requerimento;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_requerimento;
@Select	@Insert	@Update	@Delete
String nmrequerimento;
@Select	@Insert	@Update	@Delete
Double vrrequerimento;
@Select	@Insert	@Update	@Delete
Integer id_operador;
@Select	
Timestamp dt_cadastro;
@Select	
Timestamp dt_alteracao;
@Select	@Insert	@Update	@Delete
Integer id_tiporec;
@Select	@Insert	@Update	@Delete
Integer dias_entrega;
@Select	@Insert	@Update	@Delete
String txtservico;


public Integer getId_requerimento() {
	return id_requerimento;
}
public void setId_requerimento(Integer id_requerimento) {
	this.id_requerimento = id_requerimento;
}
public String getNmrequerimento() {
	return nmrequerimento;
}
public void setNmrequerimento(String nmrequerimento) {
	this.nmrequerimento = nmrequerimento;
}
public Double getVrrequerimento() {
	return vrrequerimento;
}
public void setVrrequerimento(Double vrrequerimento) {
	this.vrrequerimento = vrrequerimento;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
public Timestamp getDt_cadastro() {
	return dt_cadastro;
}
public void setDt_cadastro(Timestamp dt_cadastro) {
	this.dt_cadastro = dt_cadastro;
}
public Timestamp getDt_alteracao() {
	return dt_alteracao;
}
public void setDt_alteracao(Timestamp dt_alteracao) {
	this.dt_alteracao = dt_alteracao;
}
public Integer getId_tiporec() {
	return id_tiporec;
}
public void setId_tiporec(Integer id_tiporec) {
	this.id_tiporec = id_tiporec;
}
public Integer getDias_entrega() {
	return dias_entrega;
}
public void setDias_entrega(Integer dias_entrega) {
	this.dias_entrega = dias_entrega;
}
public String getTxtservico() {
	return txtservico;
}
public void setTxtservico(String txtservico) {
	this.txtservico = txtservico;
}
}

