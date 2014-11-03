package valueObjects.fin;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_TabValoresVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -4295875994831785868L;


@Sequence
String fin_tabvalores_id_tabvalores;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_tabvalores;
@Select	@Insert	@Update	@Delete
Integer id_curso;
@Select	@Insert	@Update	@Delete
Double valor;
@Select	@Insert	@Update	@Delete
Double desc1;
@Select	@Insert	@Update	@Delete
Double desc2;
@Select	@Insert	@Update	@Delete
Timestamp dt_desc1;
@Select	@Insert	@Update	@Delete
Timestamp dt_desc2;
@Select	@Insert	@Update	@Delete
Integer qtd_parcelas;
@Select	@Insert	@Update	@Delete
Timestamp dt_vencto;
public Integer getId_tabvalores() {
	return id_tabvalores;
}
public void setId_tabvalores(Integer id_tabvalores) {
	this.id_tabvalores = id_tabvalores;
}
public Integer getId_curso() {
	return id_curso;
}
public void setId_curso(Integer id_curso) {
	this.id_curso = id_curso;
}
public Double getValor() {
	return valor;
}
public void setValor(Double valor) {
	this.valor = valor;
}
public Double getDesc1() {
	return desc1;
}
public void setDesc1(Double desc1) {
	this.desc1 = desc1;
}
public Double getDesc2() {
	return desc2;
}
public void setDesc2(Double desc2) {
	this.desc2 = desc2;
}
public Timestamp getDt_desc1() {
	return dt_desc1;
}
public void setDt_desc1(Timestamp dt_desc1) {
	this.dt_desc1 = dt_desc1;
}
public Timestamp getDt_desc2() {
	return dt_desc2;
}
public void setDt_desc2(Timestamp dt_desc2) {
	this.dt_desc2 = dt_desc2;
}
public Integer getQtd_parcelas() {
	return qtd_parcelas;
}
public void setQtd_parcelas(Integer qtd_parcelas) {
	this.qtd_parcelas = qtd_parcelas;
}
public Timestamp getDt_vencto() {
	return dt_vencto;
}
public void setDt_vencto(Timestamp dt_vencto) {
	this.dt_vencto = dt_vencto;
}
}
