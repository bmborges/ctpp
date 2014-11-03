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
public class Alu_RespVO implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2613851727049440735L;
	
	@Sequence
	String alu_resp_id_resp;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_resp;
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
	String cnpj;
	@Select	@Insert	@Update	@Delete
	String email;
	@Select	@Insert	@Update	@Delete
	String local_trabalho;
	
	
	public Integer getId_resp() {
		return id_resp;
	}
	public void setId_resp(Integer id_resp) {
		this.id_resp = id_resp;
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
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	
	
	  
	
}
