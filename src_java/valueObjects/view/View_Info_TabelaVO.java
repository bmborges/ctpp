package valueObjects.view;

import java.io.Serializable;

import annotations.Select;

public class View_Info_TabelaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 7509379751252091919L;
@Select
String relname;
@Select
String comentario;
public String getRelname() {
	return relname;
}
public void setRelname(String relname) {
	this.relname = relname;
}
public String getComentario() {
	return comentario;
}
public void setComentario(String comentario) {
	this.comentario = comentario;
}
}
