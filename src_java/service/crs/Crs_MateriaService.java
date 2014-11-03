package service.crs;

import java.util.ArrayList;
import java.util.List;

import service.AbstractService;
import valueObjects.crs.Crs_MateriaVO;

public class Crs_MateriaService extends AbstractService<Crs_MateriaVO>{
	
	String retorno = "";
	List lista = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

	public Crs_MateriaService() throws Exception {
	}
	
	@Override
	public int inserir(Crs_MateriaVO t) throws Exception {
		// TODO Auto-generated method stub
		super.inserir(t);
		
		return t.getId_materia();
	}
	
 
}
