package valueObjects.pdg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_DiarioNotasVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -696122767265144130L;


@Sequence
String pdg_diarionotas_id_diarionotas;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_diarionotas;
@Select	@Insert	@Update	@Delete
Double nota1;
@Select	@Insert	@Update	@Delete
Double nota2;
@Select	@Insert	@Update	@Delete
Integer id_aluno;
@Select	@Insert	@Update	@Delete
Integer id_diario;
@Select	@Insert	@Update	@Delete
Double media;
@Select	@Insert	@Update	@Delete
Double nota_recup;
@Select	@Insert	@Update	@Delete
Double nota_cons;
@Select	@Insert	@Update	@Delete
Integer situacao;
@Select	@Insert	@Update	@Delete
Integer id_situacao;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Integer id_turmamateria;
@Select	@Insert	@Update	@Delete
Integer id_ativo;
@Select	@Insert	@Update	@Delete
Integer id_avaliacao;
public Integer getId_diarionotas() {
	return id_diarionotas;
}
public void setId_diarionotas(Integer id_diarionotas) {
	this.id_diarionotas = id_diarionotas;
}
public Double getNota1() {
	return nota1;
}
public void setNota1(Double nota1) {
	this.nota1 = nota1;
}
public Double getNota2() {
	return nota2;
}
public void setNota2(Double nota2) {
	this.nota2 = nota2;
}
public Integer getId_aluno() {
	return id_aluno;
}
public void setId_aluno(Integer id_aluno) {
	this.id_aluno = id_aluno;
}
public Integer getId_diario() {
	return id_diario;
}
public void setId_diario(Integer id_diario) {
	this.id_diario = id_diario;
}
public Double getMedia() {
	return media;
}
public void setMedia(Double media) {
	this.media = media;
}
public Double getNota_recup() {
	return nota_recup;
}
public void setNota_recup(Double nota_recup) {
	this.nota_recup = nota_recup;
}
public Double getNota_cons() {
	return nota_cons;
}
public void setNota_cons(Double nota_cons) {
	this.nota_cons = nota_cons;
}
public Integer getSituacao() {
	return situacao;
}
public void setSituacao(Integer situacao) {
	this.situacao = situacao;
}
public Integer getId_situacao() {
	return id_situacao;
}
public void setId_situacao(Integer id_situacao) {
	this.id_situacao = id_situacao;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getId_turmamateria() {
	return id_turmamateria;
}
public void setId_turmamateria(Integer id_turmamateria) {
	this.id_turmamateria = id_turmamateria;
}
public Integer getId_ativo() {
	return id_ativo;
}
public void setId_ativo(Integer id_ativo) {
	this.id_ativo = id_ativo;
}
public Integer getId_avaliacao() {
	return id_avaliacao;
}
public void setId_avaliacao(Integer id_avaliacao) {
	this.id_avaliacao = id_avaliacao;
}
}

