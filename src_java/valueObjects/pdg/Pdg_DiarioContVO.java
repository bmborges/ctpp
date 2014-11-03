package valueObjects.pdg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pdg_DiarioContVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5300120860227430968L;
	
	@Sequence
	String pdg_diariocont_id_diariocont;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_diariocont;
	@Select	@Insert	@Update	@Delete
	Timestamp data;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Select	@Insert	@Update	@Delete
	Integer id_diario;
	@Select	@Insert	@Delete
	Integer nr_aula;
	
	public Integer getId_diariocont() {
		return id_diariocont;
	}
	public void setId_diariocont(Integer id_diariocont) {
		this.id_diariocont = id_diariocont;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId_diario() {
		return id_diario;
	}
	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}
	public Integer getNr_aula() {
		return nr_aula;
	}
	public void setNr_aula(Integer nr_aula) {
		this.nr_aula = nr_aula;
	}
	

}
