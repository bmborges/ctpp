package valueObjects.view;

import java.io.Serializable;

import annotations.Select;

public class View_Ctr_RestricaoVO implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 172002297029778895L;
@Select
Integer id_contrato;
@Select
Integer id_tiporestricao;
@Select
String nmtiporestricao;
@Select
Integer com_restricao;
}
