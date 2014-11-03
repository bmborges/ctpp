package valueObjects.procedure;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class Fin_Dup_RecebimentoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1296042019960071611L;
	@Select
	Integer id_contrato;
	@Select
	Double vrpago;
	@Select
	Double vrdesconto;
	@Select
	Integer id_operador;
	@Select
	Timestamp dtpagamento;
	@Select
	Integer id_condpgto;
	
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Double getVrpago() {
		return vrpago;
	}
	public void setVrpago(Double vrpago) {
		this.vrpago = vrpago;
	}
	public Double getVrdesconto() {
		return vrdesconto;
	}
	public void setVrdesconto(Double vrdesconto) {
		this.vrdesconto = vrdesconto;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Timestamp getDtpagamento() {
		return dtpagamento;
	}
	public void setDtpagamento(Timestamp dtpagamento) {
		this.dtpagamento = dtpagamento;
	}
	public Integer getId_condpgto() {
		return id_condpgto;
	}
	public void setId_condpgto(Integer id_condpgto) {
		this.id_condpgto = id_condpgto;
	}
}
