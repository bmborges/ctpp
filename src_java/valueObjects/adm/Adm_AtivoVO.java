package valueObjects.adm;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_AtivoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8019692217421079470L;


	@Sequence
	String adm_ativo_id_ativo;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	@Select	@Insert	@Update	@Delete
	String nmativo;
	@Select	@Insert	@Update	@Delete
	String nmsimnao;
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	public String getNmativo() {
		return nmativo;
	}
	public void setNmativo(String nmativo) {
		this.nmativo = nmativo;
	}
	public String getNmsimnao() {
		return nmsimnao;
	}
	public void setNmsimnao(String nmsimnao) {
		this.nmsimnao = nmsimnao;
	}
}

