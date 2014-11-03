package valueObjects.crs;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Crs_AvaliacaoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -437303918276574982L;


@Sequence
String crs_avaliacao_id_avaliacao;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_avaliacao;
@Select	@Insert	@Update	@Delete
String nmavaliacao;
@Select	@Insert	@Update	@Delete
Integer id_tipoavaliacao;
public Integer getId_avaliacao() {
	return id_avaliacao;
}
public void setId_avaliacao(Integer id_avaliacao) {
	this.id_avaliacao = id_avaliacao;
}
public String getNmavaliacao() {
	return nmavaliacao;
}
public void setNmavaliacao(String nmavaliacao) {
	this.nmavaliacao = nmavaliacao;
}
public Integer getId_tipoavaliacao() {
	return id_tipoavaliacao;
}
public void setId_tipoavaliacao(Integer id_tipoavaliacao) {
	this.id_tipoavaliacao = id_tipoavaliacao;
}
}