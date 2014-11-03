package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_RacaCorVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -6621862308946647376L;


@Sequence
String adm_racacor_id_racacor;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_racacor;
@Select	@Insert	@Update	@Delete
String nmracacor;
public Integer getId_racacor() {
	return id_racacor;
}
public void setId_racacor(Integer id_racacor) {
	this.id_racacor = id_racacor;
}
public String getNmracacor() {
	return nmracacor;
}
public void setNmracacor(String nmracacor) {
	this.nmracacor = nmracacor;
}
}

