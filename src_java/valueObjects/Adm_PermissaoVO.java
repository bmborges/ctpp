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
public class Adm_PermissaoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7656550908927543578L;
	
	@Sequence
	String adm_permissao_id_permissao;
	
	@PrimaryKey
	@Select @Insert	@Delete
	int id_permissao;
	@Select	@Insert	@Update	@Delete
	int id_operador;
	@Select	@Insert	@Update	@Delete
	int id_itemmenu;
	
	public int getId_permissao() {
		return id_permissao;
	}
	public void setId_permissao(int id_permissao) {
		this.id_permissao = id_permissao;
	}
	public int getId_operador() {
		return id_operador;
	}
	public void setId_operador(int id_operador) {
		this.id_operador = id_operador;
	}
	public int getId_itemmenu() {
		return id_itemmenu;
	}
	public void setId_itemmenu(int id_itemmenu) {
		this.id_itemmenu = id_itemmenu;
	}
	
	
}
