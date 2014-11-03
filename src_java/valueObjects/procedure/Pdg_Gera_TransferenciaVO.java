package valueObjects.procedure;

import java.io.Serializable;

import annotations.Select;

public class Pdg_Gera_TransferenciaVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 3297111962541567971L;
@Select
Integer $1;
@Select
Integer $2;
@Select
Integer $3;
@Select
String $4;

public Integer get$1() {
	return $1;
}
public void set$1(Integer $1) {
	this.$1 = $1;
}
public Integer get$2() {
	return $2;
}
public void set$2(Integer $2) {
	this.$2 = $2;
}
public Integer get$3() {
	return $3;
}
public void set$3(Integer $3) {
	this.$3 = $3;
}
public String get$4() {
	return $4;
}
public void set$4(String $4) {
	this.$4 = $4;
}
}

