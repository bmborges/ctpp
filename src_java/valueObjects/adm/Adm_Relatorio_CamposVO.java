package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_Relatorio_CamposVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 6244168935031126468L;


@Sequence
String adm_relatorio_campos_id_campos;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_campos;
@Select	@Insert	@Update	@Delete
Integer id_relatorio;
@Select	@Insert	@Update	@Delete
String nmcampo;
@Select	@Insert	@Update	@Delete
Integer obrigatorio;
@Select	@Insert	@Update	@Delete
String nmparametro;
public Integer getId_campos() {
	return id_campos;
}
public void setId_campos(Integer id_campos) {
	this.id_campos = id_campos;
}
public Integer getId_relatorio() {
	return id_relatorio;
}
public void setId_relatorio(Integer id_relatorio) {
	this.id_relatorio = id_relatorio;
}
public String getNmcampo() {
	return nmcampo;
}
public void setNmcampo(String nmcampo) {
	this.nmcampo = nmcampo;
}
public Integer getObrigatorio() {
	return obrigatorio;
}
public void setObrigatorio(Integer obrigatorio) {
	this.obrigatorio = obrigatorio;
}
public String getNmparametro() {
	return nmparametro;
}
public void setNmparametro(String nmparametro) {
	this.nmparametro = nmparametro;
}
}
