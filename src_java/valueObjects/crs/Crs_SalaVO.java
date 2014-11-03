package valueObjects.crs;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Crs_SalaVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4237303635389125629L;

	@Sequence
	String crs_sala_id_sala;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_sala;
	@Select	@Insert	@Update	@Delete
	String nmsala;
	@Select	@Insert	@Update	@Delete
	Integer capacidade;
	@Select	@Insert	@Update	@Delete
	Integer qtde_micros;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	
	public Integer getId_sala() {
		return id_sala;
	}
	public void setId_sala(Integer id_sala) {
		this.id_sala = id_sala;
	}
	public String getNmsala() {
		return nmsala;
	}
	public void setNmsala(String nmsala) {
		this.nmsala = nmsala;
	}
	public Integer getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Integer getQtde_micros() {
		return qtde_micros;
	}
	public void setQtde_micros(Integer qtde_micros) {
		this.qtde_micros = qtde_micros;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
}

