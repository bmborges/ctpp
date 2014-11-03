package valueObjects.ctr;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_FinRestricaoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -4179030054412011460L;


@Sequence
String ctr_finrestricao_id_finrestricao;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_finrestricao;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Integer id_tiporestricao;
@Select	@Insert	@Update	@Delete
Integer id_operador;
@Select	@Insert	@Update	@Delete
Timestamp dt_inclusao;
@Select	@Insert	@Update	@Delete
Timestamp dt_retirada;
@Select	@Insert	@Update	@Delete
Integer id_operador_ret;
public Integer getId_finrestricao() {
	return id_finrestricao;
}
public void setId_finrestricao(Integer id_finrestricao) {
	this.id_finrestricao = id_finrestricao;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getId_tiporestricao() {
	return id_tiporestricao;
}
public void setId_tiporestricao(Integer id_tiporestricao) {
	this.id_tiporestricao = id_tiporestricao;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
public Timestamp getDt_inclusao() {
	return dt_inclusao;
}
public void setDt_inclusao(Timestamp dt_inclusao) {
	this.dt_inclusao = dt_inclusao;
}
public Timestamp getDt_retirada() {
	return dt_retirada;
}
public void setDt_retirada(Timestamp dt_retirada) {
	this.dt_retirada = dt_retirada;
}
public Integer getId_operador_ret() {
	return id_operador_ret;
}
public void setId_operador_ret(Integer id_operador_ret) {
	this.id_operador_ret = id_operador_ret;
}
}
