package service.ctr;

import java.util.ArrayList;
import java.util.List;

import service.AbstractService;
import valueObjects.Ctr_TxtContratoVO;

public class Ctr_TxtContratoService extends AbstractService<Ctr_TxtContratoVO> {
	List lista = null;
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

	public Ctr_TxtContratoService() throws Exception {
		// TODO Auto-generated method stub
	}
	
	@Override
	public int inserir(Ctr_TxtContratoVO t) throws Exception {
		// TODO Auto-generated method stub
		super.inserir(t);
		
		return t.getId_txtcontrato();
	}
	
 
}
