package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fpg_Ponto_TrocadoVO implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3593383411886445667L;
	@Select
	Integer idponto;
	@Select
	Integer id1;
	@Select
	Integer id2;
	public Integer getIdponto() {
		return idponto;
	}
	public void setIdponto(Integer idponto) {
		this.idponto = idponto;
	}
	public Integer getId1() {
		return id1;
	}
	public void setId1(Integer id1) {
		this.id1 = id1;
	}
	public Integer getId2() {
		return id2;
	}
	public void setId2(Integer id2) {
		this.id2 = id2;
	}
	


}
