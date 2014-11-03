package service.view;

import service.AbstractService;
import valueObjects.view.View_Pto_PontoVO;

public class View_Pto_PontoService extends AbstractService<View_Pto_PontoVO>{

	public View_Pto_PontoService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		View_Pto_PontoVO v = new View_Pto_PontoVO();
		View_Pto_PontoService s = new View_Pto_PontoService();
		
		v.setId_parceiro(28);
		
		Object where[] = {"dt_sistema1 >= '2013-08-01'::timestamp"}; 
		
		s.select(v, where, null);
		
		
	}

}
