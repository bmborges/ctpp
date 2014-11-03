package valueObjects.pbl;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Pbl_PublicMsgVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1291350387516139158L;


	@Sequence
	String pbl_publicmsg_id_publicmsg;
	
	
	@PrimaryKey
	@Select	@Insert	@Update	@Delete
	Integer id_publicmsg;
	@Select	@Insert	@Update	@Delete
	String msg;
	@Insert	@Update	@Delete
	byte[] img;
	@Select	@Insert	@Update	@Delete
	String enviado;
	@Select	@Insert	@Update	@Delete
	String nmoperador;
	
	public Integer getId_publicmsg() {
		return id_publicmsg;
	}
	public void setId_publicmsg(Integer id_publicmsg) {
		this.id_publicmsg = id_publicmsg;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public String getEnviado() {
		return enviado;
	}
	public void setEnviado(String enviado) {
		this.enviado = enviado;
	}
	public String getNmoperador() {
		return nmoperador;
	}
	public void setNmoperador(String nmoperador) {
		this.nmoperador = nmoperador;
	}
}

