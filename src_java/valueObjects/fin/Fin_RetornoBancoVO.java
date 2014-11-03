package valueObjects.fin;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;

public class Fin_RetornoBancoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8808457345328984341L;

	@Sequence
	String fin_retornobanco_id_retornobanco;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_retornobanco;
	@Select @Insert	@Delete
	Integer id_banco;
	@Select @Insert	@Delete
	Integer id_operador;
	@Select @Insert	@Delete
	String retorno;
	@Select @Insert	@Delete
	String nmarquivo;
	
	public Integer getId_retornobanco() {
		return id_retornobanco;
	}
	public void setId_retornobanco(Integer id_retornobanco) {
		this.id_retornobanco = id_retornobanco;
	}
	public Integer getId_banco() {
		return id_banco;
	}
	public void setId_banco(Integer id_banco) {
		this.id_banco = id_banco;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}
	public String getNmarquivo() {
		return nmarquivo;
	}
	public void setNmarquivo(String nmarquivo) {
		this.nmarquivo = nmarquivo;
	}
	
}
