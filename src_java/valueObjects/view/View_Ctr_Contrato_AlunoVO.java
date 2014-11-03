package valueObjects.view;

import java.io.Serializable;
import annotations.PrimaryKey;
import annotations.Select;

public class View_Ctr_Contrato_AlunoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6643420099703513907L;
	@PrimaryKey
	@Select 
	Integer id_contrato;
	@Select 
	Integer id_aluno;
	@Select 
	String nome;
	@Select 
	String nmcurso;
	@Select
	Integer id_ctrstatus;
	@Select
	String nmstatus;
	@Select
	String nome_pai;
	@Select
	String nome_mae;
	@Select
	String cpf;	
	
	
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNmcurso() {
		return nmcurso;
	}
	public void setNmcurso(String nmcurso) {
		this.nmcurso = nmcurso;
	}
	public Integer getId_ctrstatus() {
		return id_ctrstatus;
	}
	public void setId_ctrstatus(Integer id_ctrstatus) {
		this.id_ctrstatus = id_ctrstatus;
	}
	public String getNmstatus() {
		return nmstatus;
	}
	public void setNmstatus(String nmstatus) {
		this.nmstatus = nmstatus;
	}
	public String getNome_pai() {
		return nome_pai;
	}
	public void setNome_pai(String nome_pai) {
		this.nome_pai = nome_pai;
	}
	public String getNome_mae() {
		return nome_mae;
	}
	public void setNome_mae(String nome_mae) {
		this.nome_mae = nome_mae;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
}
