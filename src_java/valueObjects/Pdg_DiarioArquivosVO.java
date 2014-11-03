package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_DiarioArquivosVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9222242629557483825L;
	
	@Sequence
	String pdg_diarioarquivos_id_diarioarquivos;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_diarioarquivos;
	@Select	@Insert	@Update	@Delete
	Integer id_diariocont;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Insert	@Delete
	byte[] arquivo;
	@Select	@Insert	@Update	@Delete
	String nmarquivo;
	
	public Integer getId_diarioarquivos() {
		return id_diarioarquivos;
	}
	public void setId_diarioarquivos(Integer id_diarioarquivos) {
		this.id_diarioarquivos = id_diarioarquivos;
	}
	public Integer getId_diariocont() {
		return id_diariocont;
	}
	public void setId_diariocont(Integer id_diariocont) {
		this.id_diariocont = id_diariocont;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte[] getArquivo() {
		return arquivo;
	}
	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}
	public String getNmarquivo() {
		return nmarquivo;
	}
	public void setNmarquivo(String nmarquivo) {
		this.nmarquivo = nmarquivo;
	}
	
	

}
