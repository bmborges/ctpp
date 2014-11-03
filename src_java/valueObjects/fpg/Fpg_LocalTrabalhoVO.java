package valueObjects.fpg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_LocalTrabalhoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7104638133559519855L;

	@Sequence
	String fpg_localtrabalho_id_localtrabalho;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_localtrabalho;
	@Select	@Insert	@Update	@Delete
	Integer id_admissao;
	@Select	@Insert	@Update	@Delete
	Integer id_centrocusto;
	@Select	@Insert	@Update	@Delete
	Integer id_funcao;
	@Select	@Insert	@Update	@Delete
	String ie_tomador;
	@Select	@Insert	@Update	@Delete
	Integer id_cargo;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_inicio;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_final;
	@Select	@Insert	@Update	@Delete
	String obs;
	public Integer getId_localtrabalho() {
		return id_localtrabalho;
	}
	public void setId_localtrabalho(Integer id_localtrabalho) {
		this.id_localtrabalho = id_localtrabalho;
	}
	public Integer getId_admissao() {
		return id_admissao;
	}
	public void setId_admissao(Integer id_admissao) {
		this.id_admissao = id_admissao;
	}
	public Integer getId_centrocusto() {
		return id_centrocusto;
	}
	public void setId_centrocusto(Integer id_centrocusto) {
		this.id_centrocusto = id_centrocusto;
	}
	public Integer getId_funcao() {
		return id_funcao;
	}
	public void setId_funcao(Integer id_funcao) {
		this.id_funcao = id_funcao;
	}
	public String getIe_tomador() {
		return ie_tomador;
	}
	public void setIe_tomador(String ie_tomador) {
		this.ie_tomador = ie_tomador;
	}
	public Integer getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}
	public Timestamp getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Timestamp dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Timestamp getDt_final() {
		return dt_final;
	}
	public void setDt_final(Timestamp dt_final) {
		this.dt_final = dt_final;
	}
	public String getObs() {
		return obs;
	}
	public void setObs(String obs) {
		this.obs = obs;
	}
}

