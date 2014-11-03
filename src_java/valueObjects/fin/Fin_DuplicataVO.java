package valueObjects.fin;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fin_DuplicataVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2899544102392089759L;

	@Sequence
	String fin_duplicata_id_duplicata;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_duplicata;
	@Select	@Insert	@Update	@Delete
	Integer id_contrato;
	@Select	@Insert	@Update	@Delete
	Integer id_aluno;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_pagamento;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_vencimento;
	@Select	@Insert	@Update	@Delete
	Integer id_formapgt;
	@Select	@Insert	@Update	@Delete
	Double valor;
	@Select	@Insert	@Update	@Delete
	Double saldo;
	@Select	@Insert	@Update	@Delete
	Integer id_situacao;
	@Select	@Insert	@Update	@Delete
	String parcela;
	@Select	@Insert	@Update	@Delete
	Integer ordem;
	@Select	@Insert	@Update	@Delete
	Double desconto;
	@Select	@Insert	@Update	@Delete
	Integer id_tiporec;
	@Select	@Insert	@Update	@Delete
	String atualizado;
	@Select	@Insert	@Update	@Delete
	Integer imp;
	@Select	@Insert	@Update	@Delete
	Integer selec;
	@Select	@Insert	@Update	@Delete
	Double subtotal;
	@Select	@Insert	@Update	@Delete
	Double vr_juro;
	@Select	@Insert	@Update	@Delete
	Integer id_modulo;
	@Select	@Insert	@Update	@Delete
	Integer id_tabvalores;
	@Select	@Insert	@Update	@Delete
	Integer imp_boleto;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_cancelamento;
	@Select	@Insert	@Update	@Delete
	Integer gera_juro;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_vencimento_base;
	@Select	@Insert	@Update	@Delete
	Integer renegociar;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	
	public Integer getId_duplicata() {
		return id_duplicata;
	}
	public void setId_duplicata(Integer id_duplicata) {
		this.id_duplicata = id_duplicata;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public Timestamp getDt_pagamento() {
		return dt_pagamento;
	}
	public void setDt_pagamento(Timestamp dt_pagamento) {
		this.dt_pagamento = dt_pagamento;
	}
	public Timestamp getDt_vencimento() {
		return dt_vencimento;
	}
	public void setDt_vencimento(Timestamp dt_vencimento) {
		this.dt_vencimento = dt_vencimento;
	}
	public Integer getId_formapgt() {
		return id_formapgt;
	}
	public void setId_formapgt(Integer id_formapgt) {
		this.id_formapgt = id_formapgt;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getSaldo() {
		return saldo;
	}
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	public Integer getId_situacao() {
		return id_situacao;
	}
	public void setId_situacao(Integer id_situacao) {
		this.id_situacao = id_situacao;
	}
	public String getParcela() {
		return parcela;
	}
	public void setParcela(String parcela) {
		this.parcela = parcela;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Integer getId_tiporec() {
		return id_tiporec;
	}
	public void setId_tiporec(Integer id_tiporec) {
		this.id_tiporec = id_tiporec;
	}
	public String getAtualizado() {
		return atualizado;
	}
	public void setAtualizado(String atualizado) {
		this.atualizado = atualizado;
	}
	public Integer getImp() {
		return imp;
	}
	public void setImp(Integer imp) {
		this.imp = imp;
	}
	public Integer getSelec() {
		return selec;
	}
	public void setSelec(Integer selec) {
		this.selec = selec;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Double getVr_juro() {
		return vr_juro;
	}
	public void setVr_juro(Double vr_juro) {
		this.vr_juro = vr_juro;
	}
	public Integer getId_modulo() {
		return id_modulo;
	}
	public void setId_modulo(Integer id_modulo) {
		this.id_modulo = id_modulo;
	}
	public Integer getId_tabvalores() {
		return id_tabvalores;
	}
	public void setId_tabvalores(Integer id_tabvalores) {
		this.id_tabvalores = id_tabvalores;
	}
	public Integer getImp_boleto() {
		return imp_boleto;
	}
	public void setImp_boleto(Integer imp_boleto) {
		this.imp_boleto = imp_boleto;
	}
	public Timestamp getDt_cancelamento() {
		return dt_cancelamento;
	}
	public void setDt_cancelamento(Timestamp dt_cancelamento) {
		this.dt_cancelamento = dt_cancelamento;
	}
	public Integer getGera_juro() {
		return gera_juro;
	}
	public void setGera_juro(Integer gera_juro) {
		this.gera_juro = gera_juro;
	}
	public Timestamp getDt_vencimento_base() {
		return dt_vencimento_base;
	}
	public void setDt_vencimento_base(Timestamp dt_vencimento_base) {
		this.dt_vencimento_base = dt_vencimento_base;
	}
	public Integer getRenegociar() {
		return renegociar;
	}
	public void setRenegociar(Integer renegociar) {
		this.renegociar = renegociar;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}

}
