package service.alu;

import service.AbstractService;
import valueObjects.alu.Alu_DeficienciaVO;

public class Alu_DeficienciaService extends AbstractService<Alu_DeficienciaVO>{
	
	public Alu_DeficienciaService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Alu_DeficienciaService s = new Alu_DeficienciaService();
		Alu_DeficienciaVO v = new Alu_DeficienciaVO();
		v.setId_aluno(3);
		v.setCddeficiencia(1);
		v.setId_deficiencia(0);
		
		s.inserir(v);
		
		
	}

	
	
}
