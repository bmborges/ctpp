/**
 * 
 */
package valueObjects.adm;

import java.io.Serializable;

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

public class Adm_EmpresaVO implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4566558937677694524L;
	
	@Sequence
	String adm_empresa_id_empresa;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_empresa;
	@Select	@Insert	@Update	@Delete
	String nome;
	@Select	@Insert	@Update	@Delete
	String cnpj;
	@Select	@Insert	@Update	@Delete
	String inscr_estadual;
	@Select	@Insert	@Update	@Delete
	String inscr_municipal;
	@Select	@Insert	@Update	@Delete
	String telefone1;
	@Select	@Insert	@Update	@Delete
	String telefone2;
	@Select	@Insert	@Update	@Delete
	String endereco;
	@Select	@Insert	@Update	@Delete
	String complemento;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	String bairro;
	@Select	@Insert	@Update	@Delete
	String cidade;
	@Select	@Insert	@Update	@Delete
	String email;
	@Insert	@Update	@Delete
	byte[] logotipo;
	@Select	@Insert	@Update	@Delete
	String responsavel;
	@Select	@Insert	@Update	@Delete
	String webdesigner;
	@Select	@Insert	@Update	@Delete
	String website;
	@Select	@Insert	@Update	@Delete
	String cep;
	@Select	@Insert	@Update	@Delete
	Integer id_estado;
	@Select	@Insert	@Update	@Delete
	String nmfantasia;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	@Select	@Insert	@Update	@Delete
	String aut_funcionamento;
	
	
	public Integer getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(Integer id_empresa) {
		this.id_empresa = id_empresa;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getInscr_estadual() {
		return inscr_estadual;
	}
	public void setInscr_estadual(String inscr_estadual) {
		this.inscr_estadual = inscr_estadual;
	}
	public String getInscr_municipal() {
		return inscr_municipal;
	}
	public void setInscr_municipal(String inscr_municipal) {
		this.inscr_municipal = inscr_municipal;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public byte[] getLogotipo() {
		return logotipo;
	}
	public void setLogotipo(byte[] logotipo) {
		this.logotipo = logotipo;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getWebdesigner() {
		return webdesigner;
	}
	public void setWebdesigner(String webdesigner) {
		this.webdesigner = webdesigner;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getId_estado() {
		return id_estado;
	}
	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}
	public String getNmfantasia() {
		return nmfantasia;
	}
	public void setNmfantasia(String nmfantasia) {
		this.nmfantasia = nmfantasia;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	public String getAut_funcionamento() {
		return aut_funcionamento;
	}
	public void setAut_funcionamento(String aut_funcionamento) {
		this.aut_funcionamento = aut_funcionamento;
	}
	
	
	

}
