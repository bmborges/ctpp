package valueObjects.procedure;

import java.io.Serializable;
import java.sql.Timestamp;

import annotations.Select;

public class Pdg_Gera_RequerimentoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 8370420131006862828L;
@Select
Integer $1;
@Select
Integer $2;
@Select
Integer $3;
@Select
Integer $4;
@Select
Timestamp $5;
@Select
Integer $6;
@Select
Integer $7;
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
public Integer get$4() {
	return $4;
}
public void set$4(Integer $4) {
	this.$4 = $4;
}
public Timestamp get$5() {
	return $5;
}
public void set$5(Timestamp $5) {
	this.$5 = $5;
}
public Integer get$6() {
	return $6;
}
public void set$6(Integer $6) {
	this.$6 = $6;
}
public Integer get$7() {
	return $7;
}
public void set$7(Integer $7) {
	this.$7 = $7;
}
}

