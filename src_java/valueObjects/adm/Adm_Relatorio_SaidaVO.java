package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_Relatorio_SaidaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 7181254894258171775L;


@Sequence
String adm_relatorio_saida_id_relatorio_saida;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_relatorio_saida;
@Select	@Insert	@Update	@Delete
String nmsaida;
public Integer getId_relatorio_saida() {
	return id_relatorio_saida;
}
public void setId_relatorio_saida(Integer id_relatorio_saida) {
	this.id_relatorio_saida = id_relatorio_saida;
}
public String getNmsaida() {
	return nmsaida;
}
public void setNmsaida(String nmsaida) {
	this.nmsaida = nmsaida;
}
}
