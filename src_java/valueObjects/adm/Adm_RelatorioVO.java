package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_RelatorioVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 8134323365967201050L;


@Sequence
String adm_relatorio_id_relatorio;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_relatorio;
@Select	@Insert	@Update	@Delete
String nmrelatorio;
@Select	@Insert	@Update	@Delete
Integer id_modulo;
@Select	@Insert	@Update	@Delete
Integer id_itemmenu;
@Select	@Insert	@Update	@Delete
String nmjasper;
@Select	@Insert	@Update	@Delete
String descricao;
@Select	@Insert	@Update	@Delete
Integer id_relatorio_saida;
public Integer getId_relatorio() {
	return id_relatorio;
}
public void setId_relatorio(Integer id_relatorio) {
	this.id_relatorio = id_relatorio;
}
public String getNmrelatorio() {
	return nmrelatorio;
}
public void setNmrelatorio(String nmrelatorio) {
	this.nmrelatorio = nmrelatorio;
}
public Integer getId_modulo() {
	return id_modulo;
}
public void setId_modulo(Integer id_modulo) {
	this.id_modulo = id_modulo;
}
public Integer getId_itemmenu() {
	return id_itemmenu;
}
public void setId_itemmenu(Integer id_itemmenu) {
	this.id_itemmenu = id_itemmenu;
}
public String getNmjasper() {
	return nmjasper;
}
public void setNmjasper(String nmjasper) {
	this.nmjasper = nmjasper;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
public Integer getId_relatorio_saida() {
	return id_relatorio_saida;
}
public void setId_relatorio_saida(Integer id_relatorio_saida) {
	this.id_relatorio_saida = id_relatorio_saida;
}
}
