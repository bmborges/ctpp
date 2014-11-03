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

public class Adm_MenuVO implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8166039996166706613L;
	/**
	 * 
	 */
	
	@Sequence
	String adm_menu_id_menu;
	
	@PrimaryKey
	@Select @Insert	@Delete
	Integer id_menu;
	@Select	@Insert	@Update	@Delete
	String label;
	@Select	@Insert	@Update	@Delete
	String tipo;
	@Select	@Insert	@Update	@Delete
	String icon;
	@Select	@Insert	@Update	@Delete
	Integer ordem;
	@Select	@Insert	@Update	@Delete
	String ativo;
	@Select
	Integer id_itemmenu;
	@Select	@Insert	@Update	@Delete
	String nome;
	
	
	public Integer getId_menu() {
		return id_menu;
	}
	public void setId_menu(Integer id_menu) {
		this.id_menu = id_menu;
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
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
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
