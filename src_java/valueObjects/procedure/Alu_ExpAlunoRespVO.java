package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Alu_ExpAlunoRespVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5961953598183298358L;
	
	
	@Select
	Integer id_aluno;

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

}
