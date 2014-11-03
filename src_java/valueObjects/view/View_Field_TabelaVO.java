package valueObjects.view;

import java.io.Serializable;

import annotations.Select;

public class View_Field_TabelaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 8777618306960354504L;
@Select
String relname;
@Select
String attname;
@Select
String typname;
@Select
String description;
@Select
String tabela_ref;
@Select
String retorno;
public String getRelname() {
	return relname;
}
public void setRelname(String relname) {
	this.relname = relname;
}
public String getAttname() {
	return attname;
}
public void setAttname(String attname) {
	this.attname = attname;
}
public String getTypname() {
	return typname;
}
public void setTypname(String typname) {
	this.typname = typname;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getTabela_ref() {
	return tabela_ref;
}
public void setTabela_ref(String tabela_ref) {
	this.tabela_ref = tabela_ref;
}
public String getRetorno() {
	return retorno;
}
public void setRetorno(String retorno) {
	this.retorno = retorno;
}
}