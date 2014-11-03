package valueObjects.view;

import java.io.Serializable;

import annotations.Select;

public class View_Adm_RelatorioVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 6041796968716073257L;
	@Select
	Integer id_tipo;
	@Select
	Integer id_relatorio;
	@Select
	String nmrelatorio;
	@Select
	Integer id_modulo;
	@Select
	Integer id_itemmenu;
	@Select
	String nmjasper;
	@Select
	String descricao;
	@Select
	Integer id_campos;
	@Select
	String nmcampo;
	@Select
	Integer obrigatorio;
	@Select
	String nmparametro;
	@Select
	String nmtipo;
	@Select
	String nmcomponente;
	@Select
	String nmmodulo;
	@Select
	String abreviatura;
	@Select
	String nmtabela;
	@Select
	Integer id_relatorio_saida;
public Integer getId_tipo() {
	return id_tipo;
}
public void setId_tipo(Integer id_tipo) {
	this.id_tipo = id_tipo;
}
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
public Integer getId_campos() {
	return id_campos;
}
public void setId_campos(Integer id_campos) {
	this.id_campos = id_campos;
}
public String getNmcampo() {
	return nmcampo;
}
public void setNmcampo(String nmcampo) {
	this.nmcampo = nmcampo;
}
public Integer getObrigatorio() {
	return obrigatorio;
}
public void setObrigatorio(Integer obrigatorio) {
	this.obrigatorio = obrigatorio;
}
public String getNmparametro() {
	return nmparametro;
}
public void setNmparametro(String nmparametro) {
	this.nmparametro = nmparametro;
}
public String getNmtipo() {
	return nmtipo;
}
public void setNmtipo(String nmtipo) {
	this.nmtipo = nmtipo;
}
public String getNmcomponente() {
	return nmcomponente;
}
public void setNmcomponente(String nmcomponente) {
	this.nmcomponente = nmcomponente;
}
public String getNmmodulo() {
	return nmmodulo;
}
public void setNmmodulo(String nmmodulo) {
	this.nmmodulo = nmmodulo;
}
public String getAbreviatura() {
	return abreviatura;
}
public void setAbreviatura(String abreviatura) {
	this.abreviatura = abreviatura;
}
public String getNmtabela() {
	return nmtabela;
}
public void setNmtabela(String nmtabela) {
	this.nmtabela = nmtabela;
}
public Integer getId_relatorio_saida() {
	return id_relatorio_saida;
}
public void setId_relatorio_saida(Integer id_relatorio_saida) {
	this.id_relatorio_saida = id_relatorio_saida;
}
}

