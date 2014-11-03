/**
 * 
 */
package valueObjects.alu;

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
public class Alu_AlunoTelVO implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5023937064587385199L;
	
	@Sequence
	String alu_alunotel_id_alunotel;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_alunotel;
	@Select	@Insert	@Update	@Delete
	String descricao;
	@Select	@Insert	@Update	@Delete
	String ddd;
	@Select	@Insert	@Update	@Delete
	String numero;
	@Select	@Insert	@Update	@Delete
	Integer id_aluno;
	@Select	@Insert	@Update	@Delete
	Integer imp;
	@Select	@Insert	@Update	@Delete
	Integer id_tipotel;
	@Select	@Insert	@Update	@Delete
	Integer id_ativo;
	
	public Integer getId_alunotel() {
		return id_alunotel;
	}
	public void setId_alunotel(Integer id_alunotel) {
		this.id_alunotel = id_alunotel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDdd() {
		return ddd;
	}
	public void setDdd(String ddd) {
		this.ddd = ddd;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Integer getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(Integer id_aluno) {
		this.id_aluno = id_aluno;
	}
	public Integer getImp() {
		return imp;
	}
	public void setImp(Integer imp) {
		this.imp = imp;
	}
	public Integer getId_tipotel() {
		return id_tipotel;
	}
	public void setId_tipotel(Integer id_tipotel) {
		this.id_tipotel = id_tipotel;
	}
	public Integer getId_ativo() {
		return id_ativo;
	}
	public void setId_ativo(Integer id_ativo) {
		this.id_ativo = id_ativo;
	}
	  
	
}
