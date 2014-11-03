package valueObjects.crs;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Crs_ModuloVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1597484993794339171L;


@Sequence
String crs_modulo_id_modulo;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_modulo;
@Select	@Insert	@Update	@Delete
String nmmodulo;
public Integer getId_modulo() {
	return id_modulo;
}
public void setId_modulo(Integer id_modulo) {
	this.id_modulo = id_modulo;
}
public String getNmmodulo() {
	return nmmodulo;
}
public void setNmmodulo(String nmmodulo) {
	this.nmmodulo = nmmodulo;
}
}
