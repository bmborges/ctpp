package valueObjects.fpg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_Horario_FuncVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1443518599986749859L;


@Sequence
String fpg_horario_func_idhorariofunc;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_horariofunc;
@Select	@Insert	@Update	@Delete
Integer id_admissao;
@Select	@Insert	@Update	@Delete
Integer id_horario;
@Select	@Insert	@Update	@Delete
Timestamp dtin_horario;
@Select	@Insert	@Update	@Delete
Timestamp dtfi_horario;
@Select	@Insert	@Update	@Delete
Timestamp dt_sistema;
@Select	@Insert	@Update	@Delete
String nmoperador;
public Integer getId_horariofunc() {
	return id_horariofunc;
}
public void setId_horariofunc(Integer id_horariofunc) {
	this.id_horariofunc = id_horariofunc;
}
public Integer getId_admissao() {
	return id_admissao;
}
public void setId_admissao(Integer id_admissao) {
	this.id_admissao = id_admissao;
}
public Integer getId_horario() {
	return id_horario;
}
public void setId_horario(Integer id_horario) {
	this.id_horario = id_horario;
}
public Timestamp getDtin_horario() {
	return dtin_horario;
}
public void setDtin_horario(Timestamp dtin_horario) {
	this.dtin_horario = dtin_horario;
}
public Timestamp getDtfi_horario() {
	return dtfi_horario;
}
public void setDtfi_horario(Timestamp dtfi_horario) {
	this.dtfi_horario = dtfi_horario;
}
public Timestamp getDt_sistema() {
	return dt_sistema;
}
public void setDt_sistema(Timestamp dt_sistema) {
	this.dt_sistema = dt_sistema;
}
public String getNmoperador() {
	return nmoperador;
}
public void setNmoperador(String nmoperador) {
	this.nmoperador = nmoperador;
}
}

