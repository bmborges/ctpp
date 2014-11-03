package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Fin_Gera_Confissao_DividaVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3764375893903096147L;
	@Select
	Integer id_contrato;
	@Select
	Integer	id_operador;
	@Select
	Integer	operacao;
	@Select
	String $3;
	
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public Integer getOperacao() {
		return operacao;
	}
	public void setOperacao(Integer operacao) {
		this.operacao = operacao;
	}
	public String get$3() {
		return $3;
	}
	public void set$3(String $3) {
		this.$3 = $3;
	}	
}
