/**
 * 
 */
package valueObjects.alu;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

/**
 * @author bruno
 *
 */
public class Alu_AlunoVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4624041712728417597L;
	
	@Sequence
	String alu_aluno_id_aluno;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_aluno;
	@Select	@Insert	@Update	@Delete
	String nome;
	@Select	@Insert	@Update	@Delete
	String rg;
	@Select	@Insert	@Update	@Delete
	String cpf;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_nascimento;
	@Select	@Insert	@Update	@Delete
	Integer id_estadocivil;
	@Select	@Insert	@Update	@Delete
	String profissao;
	@Select	@Insert	@Update	@Delete
	Integer id_sexo;
	@Select	@Insert	@Update	@Delete
	String email;
	@Select	@Insert	@Update	@Delete
	String local_trabalho;
	@Select	@Insert	@Update	@Delete
	String nome_pai;
	@Select	@Insert	@Update	@Delete
	String nome_mae;
	@Select	@Insert	@Update	@Delete
	Integer id_nacionalidade;
	@Select	@Insert	@Update	@Delete
	Integer id_cidade;
	@Select	@Insert	@Update	@Delete
	Integer id_racacor;
	
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
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Timestamp getDt_nascimento() {
		return dt_nascimento;
	}
	public void setDt_nascimento(Timestamp dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}
	public Integer getId_estadocivil() {
		return id_estadocivil;
	}
	public void setId_estadocivil(Integer id_estadocivil) {
		this.id_estadocivil = id_estadocivil;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	public Integer getId_sexo() {
		return id_sexo;
	}
	public void setId_sexo(Integer id_sexo) {
		this.id_sexo = id_sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocal_trabalho() {
		return local_trabalho;
	}
	public void setLocal_trabalho(String local_trabalho) {
		this.local_trabalho = local_trabalho;
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
	public Integer getId_nacionalidade() {
		return id_nacionalidade;
	}
	public void setId_nacionalidade(Integer id_nacionalidade) {
		this.id_nacionalidade = id_nacionalidade;
	}
	public Integer getId_cidade() {
		return id_cidade;
	}
	public void setId_cidade(Integer id_cidade) {
		this.id_cidade = id_cidade;
	}
	public Integer getId_racacor() {
		return id_racacor;
	}
	public void setId_racacor(Integer id_racacor) {
		this.id_racacor = id_racacor;
	}
	
	  
	
}
