package valueObjects.bco;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Bco_BancoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 279397985553126766L;


	@Sequence
	String bco_banco_cdbanco;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer cdbanco;
	@Select	@Insert	@Update	@Delete
	String nmbanco;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	public Integer getCdbanco() {
		return cdbanco;
	}
	public void setCdbanco(Integer cdbanco) {
		this.cdbanco = cdbanco;
	}
	public String getNmbanco() {
		return nmbanco;
	}
	public void setNmbanco(String nmbanco) {
		this.nmbanco = nmbanco;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
}

