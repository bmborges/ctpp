package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_TurmaMateriaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 3663997113353119203L;


@Sequence
String ctr_turmamateria_id_turmamateria;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_turmamateria;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Integer id_cursomateria;
@Select	@Insert	@Update	@Delete
Integer id_turma;
@Select	@Insert	@Update	@Delete
Double media;
@Select	@Insert	@Update	@Delete
Integer id_media;
@Select	@Insert	@Update	@Delete
Integer ano;
@Select	@Insert	@Update	@Delete
Double perc_faltas;
@Select	@Insert	@Update	@Delete
Double carga_horaria;
@Select	@Insert	@Update	@Delete
String unid_ensino;
@Select	@Insert	@Update	@Delete
Integer id_operadorcad;
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
public Integer getId_cursomateria() {
	return id_cursomateria;
}
public void setId_cursomateria(Integer id_cursomateria) {
	this.id_cursomateria = id_cursomateria;
}
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
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
public Integer getId_operadorcad() {
	return id_operadorcad;
}
public void setId_operadorcad(Integer id_operadorcad) {
	this.id_operadorcad = id_operadorcad;
}
}

