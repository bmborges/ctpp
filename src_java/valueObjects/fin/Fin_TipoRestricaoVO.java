package valueObjects.fin;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_TipoRestricaoVO implements Serializable{



/**
	 * 
	 */
	private static final long serialVersionUID = 1928351534802332279L;


@Sequence
String fin_tiporestricao_id_tiporestricao;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_tiporestricao;
@Select	@Insert	@Update	@Delete
String nmtiporestricao;
public Integer getId_tiporestricao() {
	return id_tiporestricao;
}
public void setId_tiporestricao(Integer id_tiporestricao) {
	this.id_tiporestricao = id_tiporestricao;
}
public String getNmtiporestricao() {
	return nmtiporestricao;
}
public void setNmtiporestricao(String nmtiporestricao) {
	this.nmtiporestricao = nmtiporestricao;
}
}
