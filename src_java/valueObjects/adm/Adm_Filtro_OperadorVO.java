package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_Filtro_OperadorVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 3015311681044867412L;


@Sequence
String adm_filtro_operador_operador;


@PrimaryKey
@Select	@Insert	@Update	@Delete
String operador;
@Select	@Insert	@Update	@Delete
String descricao;
public String getOperador() {
	return operador;
}
public void setOperador(String operador) {
	this.operador = operador;
}
public String getDescricao() {
	return descricao;
}
public void setDescricao(String descricao) {
	this.descricao = descricao;
}
}
