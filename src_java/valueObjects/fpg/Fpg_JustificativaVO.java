package valueObjects.fpg;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Fpg_JustificativaVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6094580392117138378L;

	@Sequence
	String fpg_justificativa_id_justificativa;
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_justificativa;
	@Select	@Insert	@Update	@Delete
	String descricao;
//	@Select	@Insert	@Update	@Delete
//	interval abono;
	@Select	@Insert	@Update	@Delete
	Integer assiduidade;


}
