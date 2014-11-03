package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Ctr_TurmaMateriaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 206620182633491089L;
@Select
Integer id_turmamateria;
@Select
Integer id_contrato;
@Select
Integer id_turma;
@Select
String nmturma;
@Select
Integer id_modulo;
@Select
String nmmodulo;
@Select
Integer id_cursomateria;
@Select
Integer id_materia;
@Select
String nmmateria;
@Select
Integer ano;
@Select
Double perc_faltas;
@Select
Double media;
@Select
Integer id_media;
@Select
String nmsituacao;
@Select
Double carga_horaria;
@Select
String unid_ensino;
@Select
String nmcurso;
@Select
Integer id_curso;
@Select
Integer id_diariotm;
@Select
Timestamp dt_inicioaula;
@Select
Timestamp dt_finalaula;
public Integer getId_turmamateria() {
	return id_turmamateria;
}
public void setId_turmamateria(Integer id_turmamateria) {
	this.id_turmamateria = id_turmamateria;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
}
public String getNmturma() {
	return nmturma;
}
public void setNmturma(String nmturma) {
	this.nmturma = nmturma;
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
public Integer getId_cursomateria() {
	return id_cursomateria;
}
public void setId_cursomateria(Integer id_cursomateria) {
	this.id_cursomateria = id_cursomateria;
}
public Integer getId_materia() {
	return id_materia;
}
public void setId_materia(Integer id_materia) {
	this.id_materia = id_materia;
}
public String getNmmateria() {
	return nmmateria;
}
public void setNmmateria(String nmmateria) {
	this.nmmateria = nmmateria;
}
public Integer getAno() {
	return ano;
}
public void setAno(Integer ano) {
	this.ano = ano;
}
public Double getPerc_faltas() {
	return perc_faltas;
}
public void setPerc_faltas(Double perc_faltas) {
	this.perc_faltas = perc_faltas;
}
public Double getMedia() {
	return media;
}
public void setMedia(Double media) {
	this.media = media;
}
public Integer getId_media() {
	return id_media;
}
public void setId_media(Integer id_media) {
	this.id_media = id_media;
}
public String getNmsituacao() {
	return nmsituacao;
}
public void setNmsituacao(String nmsituacao) {
	this.nmsituacao = nmsituacao;
}
public Double getCarga_horaria() {
	return carga_horaria;
}
public void setCarga_horaria(Double carga_horaria) {
	this.carga_horaria = carga_horaria;
}
public String getUnid_ensino() {
	return unid_ensino;
}
public void setUnid_ensino(String unid_ensino) {
	this.unid_ensino = unid_ensino;
}
public String getNmcurso() {
	return nmcurso;
}
public void setNmcurso(String nmcurso) {
	this.nmcurso = nmcurso;
}
public Integer getId_curso() {
	return id_curso;
}
public void setId_curso(Integer id_curso) {
	this.id_curso = id_curso;
}
public Integer getId_diariotm() {
	return id_diariotm;
}
public void setId_diariotm(Integer id_diariotm) {
	this.id_diariotm = id_diariotm;
}
public Timestamp getDt_inicioaula() {
	return dt_inicioaula;
}
public void setDt_inicioaula(Timestamp dt_inicioaula) {
	this.dt_inicioaula = dt_inicioaula;
}
public Timestamp getDt_finalaula() {
	return dt_finalaula;
}
public void setDt_finalaula(Timestamp dt_finalaula) {
	this.dt_finalaula = dt_finalaula;
}
}
