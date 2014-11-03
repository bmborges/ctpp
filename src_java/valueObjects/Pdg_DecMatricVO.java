/**
 * 
 */
package valueObjects;

import java.io.Serializable;
import java.sql.Timestamp;

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
public class Pdg_DecMatricVO implements Serializable{

	private static final long serialVersionUID = 1160365394949990409L;
	
	@Sequence
	String pdg_decmatric_id_decmatric;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_decmatric;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	Integer id_contrato;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Update	@Delete
	String cd_controle;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_vencto;
	
	
	public Integer getId_decmatric() {
		return id_decmatric;
	}
	public void setId_decmatric(Integer id_decmatric) {
		this.id_decmatric = id_decmatric;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public String getCd_controle() {
		return cd_controle;
	}
	public void setCd_controle(String cd_controle) {
		this.cd_controle = cd_controle;
	}
	public Timestamp getDt_vencto() {
		return dt_vencto;
	}
	public void setDt_vencto(Timestamp dt_vencto) {
		this.dt_vencto = dt_vencto;
	}
	
	
	  
	
}
