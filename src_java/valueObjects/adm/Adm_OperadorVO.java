/**
 * 
 */
package valueObjects.adm;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class Adm_OperadorVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2490399643337283241L;
	
	@Sequence
	String adm_operador_id_operador;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	String email;
	@Select	@Insert	@Update	@Delete
	String nickname;
	@Select	@Insert	@Update	@Delete
	String senha;
	@Select	@Insert	@Delete
	Timestamp dt_acesso;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_nascimento;
	@Select	@Insert	@Update	@Delete
	String cpf;
	@Select	@Insert	@Update	@Delete
	String rg;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_admissao;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_demissao;
	@Select	@Insert	@Update	@Delete
	Integer id_escolaridade;
	@Select	@Insert	@Update	@Delete
	Integer id_cargo;
	@Select	@Insert	@Update	@Delete
	Number salario;
	@Select	@Insert	@Update	@Delete
	String obs;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	@Select	@Insert	@Update	@Delete
	Integer id_empresa;
	@Select	@Insert	@Update	@Delete
	Integer id_aluno;
	
	String senha_nova;
	
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		
		if (senha.length() > 20) {
			this.senha = senha;
		} else {
			String sen = "";  
		     MessageDigest md = null;  
		     try {  
		        md = MessageDigest.getInstance("MD5");  
		        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
		        sen = hash.toString(16);           
		     } catch (NoSuchAlgorithmException e) {  
		        e.printStackTrace();  
		     }       
		this.senha = sen;
		}
	}

	public String getSenha_nova() {
		return senha_nova;
	}

	public void setSenha_nova(String senha_nova) {
		
		if (senha_nova.length() > 20) {
			this.senha_nova = senha_nova;
		} else {
			String sen = "";  
		     MessageDigest md = null;  
		     try {  
		        md = MessageDigest.getInstance("MD5");  
		        BigInteger hash = new BigInteger(1, md.digest(senha_nova.getBytes()));  
		        sen = hash.toString(16);           
		     } catch (NoSuchAlgorithmException e) {  
		        e.printStackTrace();  
		     }       
		this.senha_nova = sen;
		}
	}

	
	public Integer getId_operador() {
		return id_operador;
	}

	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Timestamp getDt_acesso() {
		return dt_acesso;
	}

	public void setDt_acesso(Timestamp dt_acesso) {
		this.dt_acesso = dt_acesso;
	}

	public String getNmoperador() {
		return nmoperador;
	}

	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}

	public Timestamp getDt_nascimento() {
		return dt_nascimento;
	}

	public void setDt_nascimento(Timestamp dt_nascimento) {
		this.dt_nascimento = dt_nascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
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

	public Integer getId_escolaridade() {
		return id_escolaridade;
	}

	public void setId_escolaridade(Integer id_escolaridade) {
		this.id_escolaridade = id_escolaridade;
	}

	public Integer getId_cargo() {
		return id_cargo;
	}

	public void setId_cargo(Integer id_cargo) {
		this.id_cargo = id_cargo;
	}

	public Number getSalario() {
		return salario;
	}

	public void setSalario(Number salario) {
		this.salario = salario;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Integer getId_ativo() {
		return id_ativo;
	}

	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}

	public Integer getId_empresa() {
		return id_empresa;
	}

	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Integer getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
