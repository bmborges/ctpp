package valueObjects.fpg;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_AdmissaoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -3074673222808519684L;

	@Sequence
	String fpg_admissao_id_admissao;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_admissao;
	@Select	@Insert	@Update	@Delete
	Integer id_parceiro;
	@Select	@Insert	@Update	@Delete
	Integer idsindicato;
	@Select	@Insert	@Update	@Delete
	Integer idcategoria;
	@Select	@Insert	@Update	@Delete
	Integer idocorrencia;
	@Select	@Insert	@Update	@Delete
	Integer vinculo;
	@Select	@Insert	@Update	@Delete
	Integer idtipopgto;
	@Select	@Insert	@Update	@Delete
	Integer idctrl_admissao;
	@Select	@Insert	@Update	@Delete
	Integer idhorario;
	@Select	@Insert	@Update	@Delete
	Integer idfaixasalario;
	@Select	@Insert	@Update	@Delete
	Integer nr_registro;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_admissao;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_demissao;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_aviso;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_desligamento;
	@Select	@Insert	@Update	@Delete
	String opcaofgts;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_opcaofgts;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_retratacao;
	@Select	@Insert	@Update	@Delete
	String ativo;
	@Select	@Insert	@Update	@Delete
	Integer nr_banco;
	@Select	@Insert	@Update	@Delete
	Integer nr_agencia;
	@Select	@Insert	@Update	@Delete
	String nr_conta_bco;
	@Select	@Insert	@Update	@Delete
	Integer nr_chapa;
	@Select	@Insert	@Update	@Delete
	Integer hora_semana;
	@Select	@Insert	@Update	@Delete
	Integer situacao_func;
	@Select	@Insert	@Update	@Delete
	Integer bco_fgts;
	@Select	@Insert	@Update	@Delete
	Integer agencia_fgts;
	@Select	@Insert	@Update	@Delete
	Integer conta_fgts;
	@Select	@Insert	@Update	@Delete
	Integer cd_cef;
	@Select	@Insert	@Update	@Delete
	Integer dissidio;
	@Select	@Insert	@Update	@Delete
	Integer aviso;
	@Select	@Insert	@Update	@Delete
	Double salario;
	@Select	@Insert	@Update	@Delete
	Double salarioinicio;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_inaquisicao;
	@Select	@Insert	@Update	@Delete
	Double vr_base;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_ref_admissao;
	@Select	@Insert	@Update	@Delete
	String aprendiz;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_sistema;
	@Select	@Insert	@Update	@Delete
	Integer tipo_ato_nom;
	@Select	@Insert	@Update	@Delete
	String nm_ato_nom;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_ato_nom;
	@Select	@Insert	@Update	@Delete
	Integer cdretencao;
	@Select	@Insert	@Update	@Delete
	String reposicaovaga;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_homologacao;
	@Select	@Insert	@Update	@Delete
	Double vr_dissidio;
	@Select	@Insert	@Update	@Delete
	String ind_pensaoalimenticia;
	@Select	@Insert	@Update	@Delete
	Double saldo_rescisorio;
	@Select	@Insert	@Update	@Delete
	String contribuicao_sindical;
	@Select	@Insert	@Update	@Delete
	Double percpensaoalimenticia;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	@Select	@Insert	@Update	@Delete
	Double vr_multa_rescisoria;
	@Select	@Insert	@Update	@Delete
	String filiado_sind;
	@Select	@Insert	@Update	@Delete
	Integer operacao_conta;
	@Select	@Insert	@Update	@Delete
	String horario_livre;
	@Select	@Insert	@Update	@Delete
	Integer beneficio_cesta;
	public Integer getId_admissao() {
		return id_admissao;
	}
	public void setId_admissao(Integer id_admissao) {
		this.id_admissao = id_admissao;
	}
	public Integer getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Integer id_parceiro) {
		this.id_parceiro = id_parceiro;
	}
	public Integer getIdsindicato() {
		return idsindicato;
	}
	public void setIdsindicato(Integer idsindicato) {
		this.idsindicato = idsindicato;
	}
	public Integer getIdcategoria() {
		return idcategoria;
	}
	public void setIdcategoria(Integer idcategoria) {
		this.idcategoria = idcategoria;
	}
	public Integer getIdocorrencia() {
		return idocorrencia;
	}
	public void setIdocorrencia(Integer idocorrencia) {
		this.idocorrencia = idocorrencia;
	}
	public Integer getVinculo() {
		return vinculo;
	}
	public void setVinculo(Integer vinculo) {
		this.vinculo = vinculo;
	}
	public Integer getIdtipopgto() {
		return idtipopgto;
	}
	public void setIdtipopgto(Integer idtipopgto) {
		this.idtipopgto = idtipopgto;
	}
	public Integer getIdctrl_admissao() {
		return idctrl_admissao;
	}
	public void setIdctrl_admissao(Integer idctrl_admissao) {
		this.idctrl_admissao = idctrl_admissao;
	}
	public Integer getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(Integer idhorario) {
		this.idhorario = idhorario;
	}
	public Integer getIdfaixasalario() {
		return idfaixasalario;
	}
	public void setIdfaixasalario(Integer idfaixasalario) {
		this.idfaixasalario = idfaixasalario;
	}
	public Integer getNr_registro() {
		return nr_registro;
	}
	public void setNr_registro(Integer nr_registro) {
		this.nr_registro = nr_registro;
	}
	public Timestamp getDt_admissao() {
		return dt_admissao;
	}
	public void setDt_admissao(Timestamp dt_admissao) {
		this.dt_admissao = dt_admissao;
	}
	public Timestamp getDt_demissao() {
		return dt_demissao;
	}
	public void setDt_demissao(Timestamp dt_demissao) {
		this.dt_demissao = dt_demissao;
	}
	public Timestamp getDt_aviso() {
		return dt_aviso;
	}
	public void setDt_aviso(Timestamp dt_aviso) {
		this.dt_aviso = dt_aviso;
	}
	public Timestamp getDt_desligamento() {
		return dt_desligamento;
	}
	public void setDt_desligamento(Timestamp dt_desligamento) {
		this.dt_desligamento = dt_desligamento;
	}
	public String getOpcaofgts() {
		return opcaofgts;
	}
	public void setOpcaofgts(String opcaofgts) {
		this.opcaofgts = opcaofgts;
	}
	public Timestamp getDt_opcaofgts() {
		return dt_opcaofgts;
	}
	public void setDt_opcaofgts(Timestamp dt_opcaofgts) {
		this.dt_opcaofgts = dt_opcaofgts;
	}
	public Timestamp getDt_retratacao() {
		return dt_retratacao;
	}
	public void setDt_retratacao(Timestamp dt_retratacao) {
		this.dt_retratacao = dt_retratacao;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public Integer getNr_banco() {
		return nr_banco;
	}
	public void setNr_banco(Integer nr_banco) {
		this.nr_banco = nr_banco;
	}
	public Integer getNr_agencia() {
		return nr_agencia;
	}
	public void setNr_agencia(Integer nr_agencia) {
		this.nr_agencia = nr_agencia;
	}
	public String getNr_conta_bco() {
		return nr_conta_bco;
	}
	public void setNr_conta_bco(String nr_conta_bco) {
		this.nr_conta_bco = nr_conta_bco;
	}
	public Integer getNr_chapa() {
		return nr_chapa;
	}
	public void setNr_chapa(Integer nr_chapa) {
		this.nr_chapa = nr_chapa;
	}
	public Integer getHora_semana() {
		return hora_semana;
	}
	public void setHora_semana(Integer hora_semana) {
		this.hora_semana = hora_semana;
	}
	public Integer getSituacao_func() {
		return situacao_func;
	}
	public void setSituacao_func(Integer situacao_func) {
		this.situacao_func = situacao_func;
	}
	public Integer getBco_fgts() {
		return bco_fgts;
	}
	public void setBco_fgts(Integer bco_fgts) {
		this.bco_fgts = bco_fgts;
	}
	public Integer getAgencia_fgts() {
		return agencia_fgts;
	}
	public void setAgencia_fgts(Integer agencia_fgts) {
		this.agencia_fgts = agencia_fgts;
	}
	public Integer getConta_fgts() {
		return conta_fgts;
	}
	public void setConta_fgts(Integer conta_fgts) {
		this.conta_fgts = conta_fgts;
	}
	public Integer getCd_cef() {
		return cd_cef;
	}
	public void setCd_cef(Integer cd_cef) {
		this.cd_cef = cd_cef;
	}
	public Integer getDissidio() {
		return dissidio;
	}
	public void setDissidio(Integer dissidio) {
		this.dissidio = dissidio;
	}
	public Integer getAviso() {
		return aviso;
	}
	public void setAviso(Integer aviso) {
		this.aviso = aviso;
	}
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	public Double getSalarioinicio() {
		return salarioinicio;
	}
	public void setSalarioinicio(Double salarioinicio) {
		this.salarioinicio = salarioinicio;
	}
	public Timestamp getDt_inaquisicao() {
		return dt_inaquisicao;
	}
	public void setDt_inaquisicao(Timestamp dt_inaquisicao) {
		this.dt_inaquisicao = dt_inaquisicao;
	}
	public Double getVr_base() {
		return vr_base;
	}
	public void setVr_base(Double vr_base) {
		this.vr_base = vr_base;
	}
	public Timestamp getDt_ref_admissao() {
		return dt_ref_admissao;
	}
	public void setDt_ref_admissao(Timestamp dt_ref_admissao) {
		this.dt_ref_admissao = dt_ref_admissao;
	}
	public String getAprendiz() {
		return aprendiz;
	}
	public void setAprendiz(String aprendiz) {
		this.aprendiz = aprendiz;
	}
	public Timestamp getDt_sistema() {
		return dt_sistema;
	}
	public void setDt_sistema(Timestamp dt_sistema) {
		this.dt_sistema = dt_sistema;
	}
	public Integer getTipo_ato_nom() {
		return tipo_ato_nom;
	}
	public void setTipo_ato_nom(Integer tipo_ato_nom) {
		this.tipo_ato_nom = tipo_ato_nom;
	}
	public String getNm_ato_nom() {
		return nm_ato_nom;
	}
	public void setNm_ato_nom(String nm_ato_nom) {
		this.nm_ato_nom = nm_ato_nom;
	}
	public Timestamp getDt_ato_nom() {
		return dt_ato_nom;
	}
	public void setDt_ato_nom(Timestamp dt_ato_nom) {
		this.dt_ato_nom = dt_ato_nom;
	}
	public Integer getCdretencao() {
		return cdretencao;
	}
	public void setCdretencao(Integer cdretencao) {
		this.cdretencao = cdretencao;
	}
	public String getReposicaovaga() {
		return reposicaovaga;
	}
	public void setReposicaovaga(String reposicaovaga) {
		this.reposicaovaga = reposicaovaga;
	}
	public Timestamp getDt_homologacao() {
		return dt_homologacao;
	}
	public void setDt_homologacao(Timestamp dt_homologacao) {
		this.dt_homologacao = dt_homologacao;
	}
	public Double getVr_dissidio() {
		return vr_dissidio;
	}
	public void setVr_dissidio(Double vr_dissidio) {
		this.vr_dissidio = vr_dissidio;
	}
	public String getInd_pensaoalimenticia() {
		return ind_pensaoalimenticia;
	}
	public void setInd_pensaoalimenticia(String ind_pensaoalimenticia) {
		this.ind_pensaoalimenticia = ind_pensaoalimenticia;
	}
	public Double getSaldo_rescisorio() {
		return saldo_rescisorio;
	}
	public void setSaldo_rescisorio(Double saldo_rescisorio) {
		this.saldo_rescisorio = saldo_rescisorio;
	}
	public String getContribuicao_sindical() {
		return contribuicao_sindical;
	}
	public void setContribuicao_sindical(String contribuicao_sindical) {
		this.contribuicao_sindical = contribuicao_sindical;
	}
	public Double getPercpensaoalimenticia() {
		return percpensaoalimenticia;
	}
	public void setPercpensaoalimenticia(Double percpensaoalimenticia) {
		this.percpensaoalimenticia = percpensaoalimenticia;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
	public Double getVr_multa_rescisoria() {
		return vr_multa_rescisoria;
	}
	public void setVr_multa_rescisoria(Double vr_multa_rescisoria) {
		this.vr_multa_rescisoria = vr_multa_rescisoria;
	}
	public String getFiliado_sind() {
		return filiado_sind;
	}
	public void setFiliado_sind(String filiado_sind) {
		this.filiado_sind = filiado_sind;
	}
	public Integer getOperacao_conta() {
		return operacao_conta;
	}
	public void setOperacao_conta(Integer operacao_conta) {
		this.operacao_conta = operacao_conta;
	}
	public String getHorario_livre() {
		return horario_livre;
	}
	public void setHorario_livre(String horario_livre) {
		this.horario_livre = horario_livre;
	}
	public Integer getBeneficio_cesta() {
		return beneficio_cesta;
	}
	public void setBeneficio_cesta(Integer beneficio_cesta) {
		this.beneficio_cesta = beneficio_cesta;
	}
}

