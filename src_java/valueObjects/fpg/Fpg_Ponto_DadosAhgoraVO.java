package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Update;

public class Fpg_Ponto_DadosAhgoraVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8531128304649360765L;
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_parceiro;
	@Select	@Insert	@Update	@Delete
	String biodados;
	@Select	@Insert	@Update	@Delete
	String mifare;
	@Select	@Insert	@Update	@Delete
	String passwd;
	@Select	@Insert	@Update	@Delete
	Integer tempo;
	@Select	@Insert	@Update	@Delete
	String codbarras;
	String nome;
	String pis;
	
	public Integer getId_parceiro() {
		return id_parceiro;
	}
	public void setId_parceiro(Integer id_parceiro) {
		this.id_parceiro = id_parceiro;
	}
	public String getBiodados() {
		return biodados;
	}
	public void setBiodados(String biodados) {
		this.biodados = biodados;
	}
	public String getMifare() {
		return mifare;
	}
	public void setMifare(String mifare) {
		this.mifare = mifare;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public Integer getTempo() {
		return tempo;
	}
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	public String getCodbarras() {
		return codbarras;
	}
	public void setCodbarras(String codbarras) {
		this.codbarras = codbarras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPis() {
		return pis;
	}
	public void setPis(String pis) {
		this.pis = pis;
	}
}