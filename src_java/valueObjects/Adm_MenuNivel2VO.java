/**
 * 
 */
package valueObjects;

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

public class Adm_MenuNivel2VO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -984441277251284788L;

	@Sequence
	String adm_menunivel2_id_menunivel2;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_menunivel2;
	@Select	@Insert	@Update	@Delete
	Integer id_menunivel1;
	@Select	@Insert	@Update	@Delete
	String label;
	@Select	@Insert	@Update	@Delete
	String tipo;
	@Select	@Insert	@Update	@Delete
	String icon;
	@Select	@Insert	@Update	@Delete
	Integer ordem;
	@Select
	Integer id_itemmenu;
	@Select	@Insert	@Update	@Delete
	String nome;
	
	public Integer getId_menunivel2() {
		return id_menunivel2;
	}
	public void setId_menunivel2(Integer id_menunivel2) {
		this.id_menunivel2 = id_menunivel2;
	}
	public Integer getId_menunivel1() {
		return id_menunivel1;
	}
	public void setId_menunivel1(Integer id_menunivel1) {
		this.id_menunivel1 = id_menunivel1;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getOrdem() {
		return ordem;
	}
	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	public Integer getId_itemmenu() {
		return id_itemmenu;
	}
	public void setId_itemmenu(Integer id_itemmenu) {
		this.id_itemmenu = id_itemmenu;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

	
	

}
