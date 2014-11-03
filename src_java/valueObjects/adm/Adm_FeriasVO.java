package valueObjects.adm;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_FeriasVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 8015224365018970595L;


@Sequence
String adm_ferias_id_ferias;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_ferias;
@Select	@Insert	@Update	@Delete
Integer ano;
@Select	@Insert	@Update	@Delete
Timestamp dt_inicio_meio;
@Select	@Insert	@Update	@Delete
Timestamp dt_final_meio;
@Select	@Insert	@Update	@Delete
Timestamp dt_inicio_fim;
@Select	@Insert	@Update	@Delete
Timestamp dt_final_fim;
@Select	@Insert	@Update	@Delete
Integer id_turma;
public Integer getId_ferias() {
	return id_ferias;
}
public void setId_ferias(Integer id_ferias) {
	this.id_ferias = id_ferias;
}
public Integer getAno() {
	return ano;
}
public void setAno(Integer ano) {
	this.ano = ano;
}
public Timestamp getDt_inicio_meio() {
	return dt_inicio_meio;
}
public void setDt_inicio_meio(Timestamp dt_inicio_meio) {
	this.dt_inicio_meio = dt_inicio_meio;
}
public Timestamp getDt_final_meio() {
	return dt_final_meio;
}
public void setDt_final_meio(Timestamp dt_final_meio) {
	this.dt_final_meio = dt_final_meio;
}
public Timestamp getDt_inicio_fim() {
	return dt_inicio_fim;
}
public void setDt_inicio_fim(Timestamp dt_inicio_fim) {
	this.dt_inicio_fim = dt_inicio_fim;
}
public Timestamp getDt_final_fim() {
	return dt_final_fim;
}
public void setDt_final_fim(Timestamp dt_final_fim) {
	this.dt_final_fim = dt_final_fim;
}
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
}
}
