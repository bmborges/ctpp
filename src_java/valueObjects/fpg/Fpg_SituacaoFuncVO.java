package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_SituacaoFuncVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 7162539136301624721L;

@Sequence
String fpg_situacaofunc_id_situacaofunc;

@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer id_situacaofunc;
@Select	@Insert	@Update	@Delete
String nmsituacao;


public Integer getId_situacaofunc() {
	return id_situacaofunc;
}
public void setId_situacaofunc(Integer id_situacaofunc) {
	this.id_situacaofunc = id_situacaofunc;
}
public String getNmsituacao() {
	return nmsituacao;
}
public void setNmsituacao(String nmsituacao) {
	this.nmsituacao = nmsituacao;
}
}

