package valueObjects.adm;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_FeriadoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 8082696914691441055L;


@Sequence
String adm_feriado_id_feriado;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_feriado;
@Select	@Insert	@Update	@Delete
Timestamp dt_feriado;
@Select	@Insert	@Update	@Delete
String nmferiado;
public Integer getId_feriado() {
	return id_feriado;
}
public void setId_feriado(Integer id_feriado) {
	this.id_feriado = id_feriado;
}
public Timestamp getDt_feriado() {
	return dt_feriado;
}
public void setDt_feriado(Timestamp dt_feriado) {
	this.dt_feriado = dt_feriado;
}
public String getNmferiado() {
	return nmferiado;
}
public void setNmferiado(String nmferiado) {
	this.nmferiado = nmferiado;
}
}
