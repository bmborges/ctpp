package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_ContrMidiaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 6271742490419182375L;


@Sequence
String ctr_contrmidia_id_contrmidia;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_contrmidia;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Integer id_midia;
public Integer getId_contrmidia() {
	return id_contrmidia;
}
public void setId_contrmidia(Integer id_contrmidia) {
	this.id_contrmidia = id_contrmidia;
}
public Integer getId_contrato() {
	return id_contrato;
}
public void setId_contrato(Integer id_contrato) {
	this.id_contrato = id_contrato;
}
public Integer getId_midia() {
	return id_midia;
}
public void setId_midia(Integer id_midia) {
	this.id_midia = id_midia;
}
}
