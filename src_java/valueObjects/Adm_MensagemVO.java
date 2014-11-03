/**
 * 
 */
package valueObjects;

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
public class Adm_MensagemVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5816640903150560696L;
	
	@Sequence
	String adm_mensagem_id_mensagem;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_mensagem;
	@Select	@Insert	@Update	@Delete
	Integer id_operador;
	@Select	@Insert	@Update	@Delete
	String mensagem;
	@Select	@Insert	@Update	@Delete
	String assunto;
	@Select	@Insert	@Update	@Delete
	Integer id_situacao;
	@Select	@Insert	@Update	@Delete
	Timestamp dt_mensagem;
	@Select	@Insert	@Update	@Delete
	Integer id_remetente;
	
	
	public Integer getId_mensagem() {
		return id_mensagem;
	}
	public void setId_mensagem(Integer id_mensagem) {
		this.id_mensagem = id_mensagem;
	}
	public Integer getId_operador() {
		return id_operador;
	}
	public void setId_operador(Integer id_operador) {
		this.id_operador = id_operador;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public Integer getId_situacao() {
		return id_situacao;
	}
	public void setId_situacao(Integer id_situacao) {
		this.id_situacao = id_situacao;
	}
	public Timestamp getDt_mensagem() {
		return dt_mensagem;
	}
	public void setDt_mensagem(Timestamp dt_mensagem) {
		this.dt_mensagem = dt_mensagem;
	}
	public Integer getId_remetente() {
		return id_remetente;
	}
	public void setId_remetente(Integer id_remetente) {
		this.id_remetente = id_remetente;
	}	
	

}
