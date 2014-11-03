package valueObjects.crs;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Crs_TurmaHorVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -393911828734742371L;


@Sequence
String crs_turmahor_id_turmahor;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_turmahor;
@Select	@Insert	@Update	@Delete
Integer id_turma;
@Select	@Insert	@Update	@Delete
Timestamp hr_inicio;
@Select	@Insert	@Update	@Delete
Timestamp hr_termino;
@Select	@Insert	@Update	@Delete
Integer id_dow;
@Select	@Insert	@Update	@Delete
Integer id_cursomateria;
@Select	@Insert	@Update	@Delete
Integer id_sala;
@Select	@Insert	@Update	@Delete
Integer id_modulo;
@Select	@Insert	@Update	@Delete
Double carga_horaria;
@Select	@Insert	@Update	@Delete
Integer id_operador;

public Integer getId_turmahor() {
	return id_turmahor;
}
public void setId_turmahor(Integer id_turmahor) {
	this.id_turmahor = id_turmahor;
}
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
}
public Timestamp getHr_inicio() {
	return hr_inicio;
}
public void setHr_inicio(Timestamp hr_inicio) {
	this.hr_inicio = hr_inicio;
}
public Timestamp getHr_termino() {
	return hr_termino;
}
public void setHr_termino(Timestamp hr_termino) {
	this.hr_termino = hr_termino;
}
public Integer getId_dow() {
	return id_dow;
}
public void setId_dow(Integer id_dow) {
	this.id_dow = id_dow;
}
public Integer getId_cursomateria() {
	return id_cursomateria;
}
public void setId_cursomateria(Integer id_cursomateria) {
	this.id_cursomateria = id_cursomateria;
}
public Integer getId_sala() {
	return id_sala;
}
public void setId_sala(Integer id_sala) {
	this.id_sala = id_sala;
}
public Integer getId_modulo() {
	return id_modulo;
}
public void setId_modulo(Integer id_modulo) {
	this.id_modulo = id_modulo;
}
public Double getCarga_horaria() {
	return carga_horaria;
}
public void setCarga_horaria(Double carga_horaria) {
	this.carga_horaria = carga_horaria;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
}

