package valueObjects.crs;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Crs_TurmaEduVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 440241889303945871L;


@Sequence
String crs_turmaedu_id_turmaedu;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_turmaedu;
@Select	@Insert	@Update	@Delete
Integer id_turma;
@Select	@Insert	@Update	@Delete
Integer id_operador;
@Select	@Insert	@Update	@Delete
Integer id_cursomateria;
@Select	@Insert	@Update	@Delete
Timestamp dt_sistema;

public Integer getId_turmaedu() {
	return id_turmaedu;
}
public void setId_turmaedu(Integer id_turmaedu) {
	this.id_turmaedu = id_turmaedu;
}
public Integer getId_turma() {
	return id_turma;
}
public void setId_turma(Integer id_turma) {
	this.id_turma = id_turma;
}
public Integer getId_operador() {
	return id_operador;
}
public void setId_operador(Integer id_operador) {
	this.id_operador = id_operador;
}
public Integer getId_cursomateria() {
	return id_cursomateria;
}
public void setId_cursomateria(Integer id_cursomateria) {
	this.id_cursomateria = id_cursomateria;
}
public Timestamp getDt_sistema() {
	return dt_sistema;
}
public void setDt_sistema(Timestamp dt_sistema) {
	this.dt_sistema = dt_sistema;
}
}

