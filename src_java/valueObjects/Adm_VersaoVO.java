package valueObjects;

import java.io.Serializable;

import annotations.Select;

public class Adm_VersaoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7413404003183835079L;
	@Select
	Integer id_versao;
	@Select
	String v_sistema;
	@Select
	String v_banco;
	
	public Integer getId_versao() {
		return id_versao;
	}
	public void setId_versao(Integer id_versao) {
		this.id_versao = id_versao;
	}
	public String getV_sistema() {
		return v_sistema;
	}
	public void setV_sistema(String v_sistema) {
		this.v_sistema = v_sistema;
	}
	public String getV_banco() {
		return v_banco;
	}
	public void setV_banco(String v_banco) {
		this.v_banco = v_banco;
	}
	
}
