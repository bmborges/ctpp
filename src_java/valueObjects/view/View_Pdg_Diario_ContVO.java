package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class View_Pdg_Diario_ContVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4860501834746033637L;
	@Select 
	Integer id_diariocont;
	@Select 
	Timestamp data;
	@Select 
	String descricao;
	@Select 
	Integer id_diario;
	@Select 
	Integer nr_aula;
	@Select 
	Integer qtd_arq;
	
	
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
	public Integer getQtd_arq() {
		return qtd_arq;
	}
	public void setQtd_arq(Integer qtd_arq) {
		this.qtd_arq = qtd_arq;
	}
	
	

}
