package valueObjects.cdc;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Cdc_CentroCustoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4376260581557004756L;


	@Sequence
	String cdc_centrocusto_id_centrocusto;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_centrocusto;
	@Select	@Insert	@Update	@Delete
	Integer id_nivel4;
	@Select	@Insert	@Update	@Delete
	Integer id_nivel3;
	@Select	@Insert	@Update	@Delete
	Integer id_nivel2;
	@Select	@Insert	@Update	@Delete
	Integer id_empresa;
	@Select	@Insert	@Update	@Delete
	Integer id_nivel1;
	@Select	@Insert	@Update	@Delete
	String nmcentrocusto;
	@Select	@Insert	@Update	@Delete
	String divisao;
	@Select	@Insert	@Update	@Delete
	Integer sequencia;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_inicio;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_encerramento;
	@Select	@Insert	@Update	@Delete
	String tiporateio;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	@Select	@Insert	@Update	@Delete
	Double percentual_comissao;
	
	
	public Integer getId_centrocusto() {
		return id_centrocusto;
	}
	public void setId_centrocusto(Integer id_centrocusto) {
		this.id_centrocusto = id_centrocusto;
	}
	public Integer getId_nivel4() {
		return id_nivel4;
	}
	public void setId_nivel4(Integer id_nivel4) {
		this.id_nivel4 = id_nivel4;
	}
	public Integer getId_nivel3() {
		return id_nivel3;
	}
	public void setId_nivel3(Integer id_nivel3) {
		this.id_nivel3 = id_nivel3;
	}
	public Integer getId_nivel2() {
		return id_nivel2;
	}
	public void setId_nivel2(Integer id_nivel2) {
		this.id_nivel2 = id_nivel2;
	}
	public Integer getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public Integer getId_nivel1() {
		return id_nivel1;
	}
	public void setId_nivel1(Integer id_nivel1) {
		this.id_nivel1 = id_nivel1;
	}
	public String getNmcentrocusto() {
		return nmcentrocusto;
	}
	public void setNmcentrocusto(String nmcentrocusto) {
		this.nmcentrocusto = nmcentrocusto;
	}
	public String getDivisao() {
		return divisao;
	}
	public void setDivisao(String divisao) {
		this.divisao = divisao;
	}
	public Integer getSequencia() {
		return sequencia;
	}
	public void setSequencia(Integer sequencia) {
		this.sequencia = sequencia;
	}
	public Timestamp getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Timestamp dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Timestamp getDt_encerramento() {
		return dt_encerramento;
	}
	public void setDt_encerramento(Timestamp dt_encerramento) {
		this.dt_encerramento = dt_encerramento;
	}
	public String getTiporateio() {
		return tiporateio;
	}
	public void setTiporateio(String tiporateio) {
		this.tiporateio = tiporateio;
	}
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
	public Double getPercentual_comissao() {
		return percentual_comissao;
	}
	public void setPercentual_comissao(Double percentual_comissao) {
		this.percentual_comissao = percentual_comissao;
	}
	
	
	
}

