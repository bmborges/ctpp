package valueObjects.view;

import java.io.Serializable;

import annotations.Select;

public class View_Pdg_Diario_NotasVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 985148241992308260L;
	
	@Select
	Integer id_diario;
	@Select
	Integer id_turma;
	@Select
	Integer id_materia;
	@Select
	String nmmateria;
	@Select
	Double max_nota1;
	@Select
	Double min_nota1;
	@Select
	Double max_nota2;
	@Select
	Double min_nota2;
	@Select
	Double nota1;
	@Select
	Double nota2;
	@Select
	Double nota_recup;
	@Select
	Double nota_cons;
	@Select
	Integer id_aluno;
	@Select
	String nome;
	@Select
	Double atividades;
	@Select
	Double perc_faltas;
	@Select
	Double media;
	@Select
	String nmsituacao;
	@Select
	String estilo;
	@Select
	Integer id_diarionotas;
	@Select
	String nmmodulo;
	@Select
	Integer id_avaliacao;
	@Select
	Integer id_contrato;	
	
	public Integer getId_diario() {
		return id_diario;
	}
	public void setId_diario(Integer id_diario) {
		this.id_diario = id_diario;
	}
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
	public Integer getId_materia() {
		return id_materia;
	}
	public void setId_materia(Integer id_materia) {
		this.id_materia = id_materia;
	}
	public String getNmmateria() {
		return nmmateria;
	}
	public void setNmmateria(String nmmateria) {
		this.nmmateria = nmmateria;
	}
	public Double getMax_nota1() {
		return max_nota1;
	}
	public void setMax_nota1(Double max_nota1) {
		this.max_nota1 = max_nota1;
	}
	public Double getMin_nota1() {
		return min_nota1;
	}
	public void setMin_nota1(Double min_nota1) {
		this.min_nota1 = min_nota1;
	}
	public Double getMax_nota2() {
		return max_nota2;
	}
	public void setMax_nota2(Double max_nota2) {
		this.max_nota2 = max_nota2;
	}
	public Double getMin_nota2() {
		return min_nota2;
	}
	public void setMin_nota2(Double min_nota2) {
		this.min_nota2 = min_nota2;
	}
	public Double getNota1() {
		return nota1;
	}
	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}
	public Double getNota2() {
		return nota2;
	}
	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}
	public Double getNota_recup() {
		return nota_recup;
	}
	public void setNota_recup(Double nota_recup) {
		this.nota_recup = nota_recup;
	}
	public Double getNota_cons() {
		return nota_cons;
	}
	public void setNota_cons(Double nota_cons) {
		this.nota_cons = nota_cons;
	}
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getAtividades() {
		return atividades;
	}
	public void setAtividades(Double atividades) {
		this.atividades = atividades;
	}
	public Double getPerc_faltas() {
		return perc_faltas;
	}
	public void setPerc_faltas(Double perc_faltas) {
		this.perc_faltas = perc_faltas;
	}
	public Double getMedia() {
		return media;
	}
	public void setMedia(Double media) {
		this.media = media;
	}
	public String getNmsituacao() {
		return nmsituacao;
	}
	public void setNmsituacao(String nmsituacao) {
		this.nmsituacao = nmsituacao;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public Integer getId_diarionotas() {
		return id_diarionotas;
	}
	public void setId_diarionotas(Integer id_diarionotas) {
		this.id_diarionotas = id_diarionotas;
	}
	public String getNmmodulo() {
		return nmmodulo;
	}
	public void setNmmodulo(String nmmodulo) {
		this.nmmodulo = nmmodulo;
	}
	public Integer getId_avaliacao() {
		return id_avaliacao;
	}
	public void setId_avaliacao(Integer id_avaliacao) {
		this.id_avaliacao = id_avaliacao;
	}
	public Integer getId_contrato() {
		return id_contrato;
	}
	public void setId_contrato(Integer id_contrato) {
		this.id_contrato = id_contrato;
	}

	
}
