package service.procedure;

import service.AbstractService;
import valueObjects.procedure.Fin_AjusteDup_RecebimentoVO;

public class Fin_AjusteDup_RecebimentoService extends AbstractService<Fin_AjusteDup_RecebimentoVO>{

	public Fin_AjusteDup_RecebimentoService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		Fin_AjusteDup_RecebimentoService s = new Fin_AjusteDup_RecebimentoService();
		Fin_AjusteDup_RecebimentoVO v = new Fin_AjusteDup_RecebimentoVO();
		v.setId_contrato(235);
		v.setDthj(null);
		s.Procedure(v);
		
	}

}
