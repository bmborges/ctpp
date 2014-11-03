package service.procedure;

import service.AbstractService;
import valueObjects.procedure.Fpg_Ponto_TrocadoVO;

public class Fpg_Ponto_TrocadoService extends AbstractService<Fpg_Ponto_TrocadoVO>{

	public Fpg_Ponto_TrocadoService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		Fpg_Ponto_TrocadoVO v = new Fpg_Ponto_TrocadoVO();
		Fpg_Ponto_TrocadoService s = new Fpg_Ponto_TrocadoService();
		
		v.setIdponto(22);
		v.setId1(1);
		v.setId2(4);
		
		s.Procedure(v);
	}
}
