package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Crs_TurmaHorVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -7871107589824433469L;
@Select
Integer id_turma;
@Select
Integer id_modulo;
@Select
String nmmodulo;
@Select
Integer id_dow;
@Select
String nmdia;
@Select
Integer id_sala;
@Select
String nmsala;
@Select
Integer id_cursomateria;
@Select
String nmmateria;
@Select
Integer id_operador;
@Select
String nmoperador;
@Select
Timestamp hr_inicio;
@Select
Timestamp hr_termino;
@Select
Integer id_turmahor;
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
}
public Integer getId_modulo() {
	return id_modulo;
}
public void setId_modulo(Integer id_modulo) {
	this.id_modulo = id_modulo;
}
public String getNmmodulo() {
	return nmmodulo;
}
public void setNmmodulo(String nmmodulo) {
	this.nmmodulo = nmmodulo;
}
public Integer getId_dow() {
	return id_dow;
}
public void setId_dow(Integer id_dow) {
	this.id_dow = id_dow;
}
public String getNmdia() {
	return nmdia;
}
public void setNmdia(String nmdia) {
	this.nmdia = nmdia;
}
public Integer getId_sala() {
	return id_sala;
}
public void setId_sala(Integer id_sala) {
	this.id_sala = id_sala;
}
public String getNmsala() {
	return nmsala;
}
public void setNmsala(String nmsala) {
	this.nmsala = nmsala;
}
public Integer getId_cursomateria() {
	return id_cursomateria;
}
public void setId_cursomateria(Integer id_cursomateria) {
	this.id_cursomateria = id_cursomateria;
}
public String getNmmateria() {
	return nmmateria;
}
public void setNmmateria(String nmmateria) {
	this.nmmateria = nmmateria;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
public String getNmoperador() {
	return nmoperador;
}
public void setNmoperador(String nmoperador) {
	this.nmoperador = nmoperador;
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
public Integer getId_turmahor() {
	return id_turmahor;
}
public void setId_turmahor(Integer id_turmahor) {
	this.id_turmahor = id_turmahor;
}
}

