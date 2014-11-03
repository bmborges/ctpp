package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Fin_Dup_VencerVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7330368547654248172L;
	@Select
	Integer id_contrato;
	@Select
	String parcela;
	@Select
	Integer cod_parcela;
	@Select
	Timestamp dt_vencimento;
	@Select
	String valor;
	@Select
	String vrjuro;
	@Select
	String saldo;
	@Select
	Double subtotal;
	@Select
	String nmtiporec;
	@Select
	String nmformapgt;
	@Select
	String desconto;
	
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public Integer getCod_parcela() {
		return cod_parcela;
	}
	public void setCod_parcela(Integer cod_parcela) {
		this.cod_parcela = cod_parcela;
	}
	public Timestamp getDt_vencimento() {
		return dt_vencimento;
	}
	public void setDt_vencimento(Timestamp dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getVrjuro() {
		return vrjuro;
	}
	public void setVrjuro(String vrjuro) {
		this.vrjuro = vrjuro;
	}
	public String getSaldo() {
		return saldo;
	}
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public String getNmtiporec() {
		return nmtiporec;
	}
	public void setNmtiporec(String nmtiporec) {
		this.nmtiporec = nmtiporec;
	}
	public String getNmformapgt() {
		return nmformapgt;
	}
	public void setNmformapgt(String nmformapgt) {
		this.nmformapgt = nmformapgt;
	}
	public String getDesconto() {
		return desconto;
	}
	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}			
			

}
