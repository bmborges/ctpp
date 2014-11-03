/**
 * 
 */
package valueObjects.alu;

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
public class Alu_RespTelVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3105753836837254524L;
	
	@Sequence
	String alu_resptel_id_resptel;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_resptel;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Select	@Insert	@Update	@Delete
	String ddd;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	Integer id_resp;
	@Select	@Insert	@Update	@Delete
	Integer imp;
	@Select	@Insert	@Update	@Delete
	Integer id_tipotel;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	
	
	public Integer getId_resptel() {
		return id_resptel;
	}
	public void setId_resptel(Integer id_resptel) {
		this.id_resptel = id_resptel;
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
	public Integer getId_resp() {
		return id_resp;
	}
	public void setId_resp(Integer id_resp) {
		this.id_resp = id_resp;
	}
	public Integer getImp() {
		return imp;
	}
	public void setImp(Integer imp) {
		this.imp = imp;
	}
	public Integer getId_tipotel() {
		return id_tipotel;
	}
	public void setId_tipotel(Integer id_tipotel) {
		this.id_tipotel = id_tipotel;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}	  
	
}
