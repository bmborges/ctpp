package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Crs_TurmaEduVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -7310334523738176478L;
@Select
Integer id_modulo;
@Select
Integer id_turmaedu;
@Select
Integer id_operador;
@Select
String nmoperador;
@Select
Integer id_cursomateria;
@Select
String nmmateria;
@Select
String nmmodulo;
@Select
Integer id_turma;
@Select
Integer id_diario;
@Select
Timestamp dt_inicio;
@Select
Integer id_status;
@Select
String nmstatus;

public Integer getId_modulo() {
	return id_modulo;
}
public void setId_modulo(Integer id_modulo) {
	this.id_modulo = id_modulo;
}
public Integer getId_turmaedu() {
	return id_turmaedu;
}
public void setId_turmaedu(Integer id_turmaedu) {
	this.id_turmaedu = id_turmaedu;
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
public String getNmmodulo() {
	return nmmodulo;
}
public void setNmmodulo(String nmmodulo) {
	this.nmmodulo = nmmodulo;
}
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
}
public Integer getId_diario() {
	return id_diario;
}
public void setId_diario(Integer id_diario) {
	this.id_diario = id_diario;
}
public Timestamp getDt_inicio() {
	return dt_inicio;
}
public void setDt_inicio(Timestamp dt_inicio) {
	this.dt_inicio = dt_inicio;
}
public Integer getId_status() {
	return id_status;
}
public void setId_status(Integer id_status) {
	this.id_status = id_status;
}
public String getNmstatus() {
	return nmstatus;
}
public void setNmstatus(String nmstatus) {
	this.nmstatus = nmstatus;
}
}

