package valueObjects.view;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class View_Ctr_GeraBoletoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6006085840155574174L;
	@Select
	Integer id_contrato;
	@Select
	Integer id_duplicata;
	@Select
	String nmtiporec;
	@Select
	Timestamp dt_vencimento;
	@Select
	String valor;
	@Select
	Integer imp_boleto;
	@Select
	String nmmodulo;
	@Select
	String parcela;
	@Select
	String nossonumero;
	@Select
	String nmcurso;
	
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Integer getId_duplicata() {
		return id_duplicata;
	}
	public void setId_duplicata(Integer id_duplicata) {
		this.id_duplicata = id_duplicata;
	}
	public String getNmtiporec() {
		return nmtiporec;
	}
	public void setNmtiporec(String nmtiporec) {
		this.nmtiporec = nmtiporec;
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
	public Integer getImp_boleto() {
		return imp_boleto;
	}
	public void setImp_boleto(Integer imp_boleto) {
		this.imp_boleto = imp_boleto;
	}
	public String getNmmodulo() {
		return nmmodulo;
	}
	public void setNmmodulo(String nmmodulo) {
		this.nmmodulo = nmmodulo;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public String getNossonumero() {
		return nossonumero;
	}
	public void setNossonumero(String nossonumero) {
		this.nossonumero = nossonumero;
	}
	public String getNmcurso() {
		return nmcurso;
	}
	public void setNmcurso(String nmcurso) {
		this.nmcurso = nmcurso;
	}			

}
