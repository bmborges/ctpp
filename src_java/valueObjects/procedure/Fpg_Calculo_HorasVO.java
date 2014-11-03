package valueObjects.procedure;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class Fpg_Calculo_HorasVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -723981889410818319L;
	@Select
	Integer idparceiro_in;
	@Select
	Integer idparceiro_fi;
	@Select
	Timestamp dt_in;
	@Select
	Timestamp dt_fi;
	
	public Integer getIdparceiro_in() {
		return idparceiro_in;
	}
	public void setIdparceiro_in(Integer idparceiro_in) {
		this.idparceiro_in = idparceiro_in;
	}
	public Integer getIdparceiro_fi() {
		return idparceiro_fi;
	}
	public void setIdparceiro_fi(Integer idparceiro_fi) {
		this.idparceiro_fi = idparceiro_fi;
	}
	public Timestamp getDt_in() {
		return dt_in;
	}
	public void setDt_in(Timestamp dt_in) {
		this.dt_in = dt_in;
	}
	public Timestamp getDt_fi() {
		return dt_fi;
	}
	public void setDt_fi(Timestamp dt_fi) {
		this.dt_fi = dt_fi;
	}	
	
	

}
