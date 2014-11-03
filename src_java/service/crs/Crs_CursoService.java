package service.crs;

import java.util.ArrayList;
import java.util.List;

import service.AbstractService;
import valueObjects.crs.Crs_CursoVO;

public class Crs_CursoService extends AbstractService<Crs_CursoVO>{
	
	String retorno = "";
	List lista = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

	public Crs_CursoService() throws Exception {
	}
	
	@Override
	public int inserir(Crs_CursoVO t) throws Exception {
		// TODO Auto-generated method stub
		super.inserir(t);
		
		return t.getId_curso();
	}
	
	
 
}
