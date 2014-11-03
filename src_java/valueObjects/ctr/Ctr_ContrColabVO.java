package valueObjects.ctr;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Ctr_ContrColabVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -5377420193998044814L;


@Sequence
String ctr_contrcolab_id_contrcolab;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_contrcolab;
@Select	@Insert	@Update	@Delete
Integer id_contrato;
@Select	@Insert	@Update	@Delete
Integer id_operador;
public Integer getId_contrcolab() {
	return id_contrcolab;
}
public void setId_contrcolab(Integer id_contrcolab) {
	this.id_contrcolab = id_contrcolab;
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
}

