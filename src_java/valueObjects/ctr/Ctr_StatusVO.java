package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_StatusVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5259697805989838644L;


@Sequence
String ctr_status_id_ctrstatus;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_ctrstatus;
@Select	@Insert	@Update	@Delete
String nmstatus;
@Select	@Insert	@Update	@Delete
Integer opcao;
@Select	@Insert	@Update	@Delete
String nmopcao;
@Select	@Insert	@Update	@Delete
Integer mostra_diario;
@Select	@Insert	@Update	@Delete
Integer ativo_opcao;
@Select	@Insert	@Update	@Delete
Integer abre_hist;
@Select	@Insert	@Update	@Delete
Integer abre_cancparc;


public Integer getId_ctrstatus() {
	return id_ctrstatus;
}
public void setId_ctrstatus(Integer id_ctrstatus) {
	this.id_ctrstatus = id_ctrstatus;
}
public String getNmstatus() {
	return nmstatus;
}
public void setNmstatus(String nmstatus) {
	this.nmstatus = nmstatus;
}
public Integer getOpcao() {
	return opcao;
}
public void setOpcao(Integer opcao) {
	this.opcao = opcao;
}
public String getNmopcao() {
	return nmopcao;
}
public void setNmopcao(String nmopcao) {
	this.nmopcao = nmopcao;
}
public Integer getMostra_diario() {
	return mostra_diario;
}
public void setMostra_diario(Integer mostra_diario) {
	this.mostra_diario = mostra_diario;
}
public Integer getAtivo_opcao() {
	return ativo_opcao;
}
public void setAtivo_opcao(Integer ativo_opcao) {
	this.ativo_opcao = ativo_opcao;
}
public Integer getAbre_hist() {
	return abre_hist;
}
public void setAbre_hist(Integer abre_hist) {
	this.abre_hist = abre_hist;
}
public Integer getAbre_cancparc() {
	return abre_cancparc;
}
public void setAbre_cancparc(Integer abre_cancparc) {
	this.abre_cancparc = abre_cancparc;
}
}

