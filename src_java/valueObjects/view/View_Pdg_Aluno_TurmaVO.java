package valueObjects.view;

import java.io.Serializable;

import annotations.Select;

public class View_Pdg_Aluno_TurmaVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6224288049463383934L;
	@Select
	Integer id_aluno;
	@Select
	String nome;
	@Select
	Integer id_turma;
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
	public Integer getId_turma() {
		return id_turma;
	}
	public void setId_turma(Integer id_turma) {
		this.id_turma = id_turma;
	}
}

