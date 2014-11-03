package valueObjects;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Adm_Permissao_CargoVO implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8271265068550276680L;
	
	@Sequence
	String adm_permissao_cargo_id_permissao_cargo;
	
	@PrimaryKey
	@Select @Insert	@Delete
	int id_permissaocargo;
	@Select	@Insert	@Update	@Delete
	int id_cargo;
	@Select
	int id_itemmenu;
	
	public int getId_permissaocargo() {
		return id_permissaocargo;
	}
	public void setId_permissaocargo(int id_permissaocargo) {
		this.id_permissaocargo = id_permissaocargo;
	}
	public int getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(int id_cargo) {
		this.id_cargo = id_cargo;
	}
	public int getId_itemmenu() {
		return id_itemmenu;
	}
	public void setId_itemmenu(int id_itemmenu) {
		this.id_itemmenu = id_itemmenu;
	}
	
	

}
