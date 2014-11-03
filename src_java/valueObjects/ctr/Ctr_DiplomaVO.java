package valueObjects.ctr;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_DiplomaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 6598206571729067014L;


@Sequence
String ctr_diploma_id_diploma;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_diploma;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Integer id_operador;
@Select	@Insert	@Update	@Delete
Timestamp dt_sistema;
@Select	@Insert	@Update	@Delete
String livro;
@Select	@Insert	@Update	@Delete
String pagina;
@Select	@Insert	@Update	@Delete
Timestamp dt_livro;
String texto;
@Select	@Insert	@Update	@Delete
String sistec;
public Integer getId_diploma() {
	return id_diploma;
}
public void setId_diploma(Integer id_diploma) {
	this.id_diploma = id_diploma;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
public Timestamp getDt_sistema() {
	return dt_sistema;
}
public void setDt_sistema(Timestamp dt_sistema) {
	this.dt_sistema = dt_sistema;
}
public String getLivro() {
	return livro;
}
public void setLivro(String livro) {
	this.livro = livro;
}
public String getPagina() {
	return pagina;
}
public void setPagina(String pagina) {
	this.pagina = pagina;
}
public Timestamp getDt_livro() {
	return dt_livro;
}
public void setDt_livro(Timestamp dt_livro) {
	this.dt_livro = dt_livro;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String getSistec() {
	return sistec;
}
public void setSistec(String sistec) {
	this.sistec = sistec;
}
}

