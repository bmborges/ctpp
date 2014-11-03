package service.adm;

import service.AbstractService;
import valueObjects.adm.Adm_RelatorioVO;

public class Adm_RelatorioService extends AbstractService<Adm_RelatorioVO>{

	public Adm_RelatorioService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		Adm_RelatorioService s = new Adm_RelatorioService();
		s.Report(null, null, "Rpt_TitulosAbertoMensagem", null);
	}

}
