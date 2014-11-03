/**
 * 
 */
package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;


/**
 * @author bruno
 *
 */
public class Adm_OperTelVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3640206829903818782L;
	@Sequence
	String adm_opertel_id_opertel;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_opertel;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Select	@Insert	@Update	@Delete
	String ddd;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer id_tipotel;
	
	
	public Integer getId_opertel() {
		return id_opertel;
	}
	public void setId_opertel(Integer id_opertel) {
		this.id_opertel = id_opertel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getId_tipotel() {
		return id_tipotel;
	}
	public void setId_tipotel(Integer id_tipotel) {
		this.id_tipotel = id_tipotel;
	}
	

}
