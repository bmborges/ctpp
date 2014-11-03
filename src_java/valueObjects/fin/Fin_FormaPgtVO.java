package valueObjects.fin;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_FormaPgtVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2334263240409574701L;

	@Sequence
	String fin_formapgt_id_formapgt;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_formapgt;
	@Select	@Insert	@Update	@Delete
	String nmformapgt;
	@Select	@Insert	@Update	@Delete  
	Integer prorrogar;
	@Select	@Insert	@Update	@Delete
	Integer cad_cheque;
	@Select	@Insert	@Update	@Delete
	Integer cad_cartao;	
	
	public Integer getId_formapgt() {
		return id_formapgt;
	}
	public void setId_formapgt(Integer id_formapgt) {
		this.id_formapgt = id_formapgt;
	}
	public String getNmformapgt() {
		return nmformapgt;
	}
	public void setNmformapgt(String nmformapgt) {
		this.nmformapgt = nmformapgt;
	}
	public Integer getProrrogar() {
		return prorrogar;
	}
	public void setProrrogar(Integer prorrogar) {
		this.prorrogar = prorrogar;
	}
	public Integer getCad_cheque() {
		return cad_cheque;
	}
	public void setCad_cheque(Integer cad_cheque) {
		this.cad_cheque = cad_cheque;
	}
	public Integer getCad_cartao() {
		return cad_cartao;
	}
	public void setCad_cartao(Integer cad_cartao) {
		this.cad_cartao = cad_cartao;
	}
}
