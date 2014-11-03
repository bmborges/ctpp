package valueObjects.crs;

import java.io.Serializable;

import annotations.Delete;
import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

public class Crs_TurmaStatusVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = -4363476385316145375L;


@Sequence
String crs_turmastatus_status;


@PrimaryKey
@Select	@Insert	@Update	@Delete
Integer status;
@Select	@Insert	@Update	@Delete
String nmstatus;
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getNmstatus() {
	return nmstatus;
}
public void setNmstatus(String nmstatus) {
	this.nmstatus = nmstatus;
}
}