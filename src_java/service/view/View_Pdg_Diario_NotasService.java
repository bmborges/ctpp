package service.view;

import java.util.List;

import service.AbstractService;
import service.procedure.Pdg_Diario_Falta_AlunosService;
import service.procedure.Pdg_Diario_Novos_AlunosService;
import valueObjects.procedure.Pdg_Diario_Falta_AlunosVO;
import valueObjects.procedure.Pdg_Diario_Novos_AlunosVO;
import valueObjects.view.View_Pdg_Diario_NotasVO;


public class View_Pdg_Diario_NotasService extends AbstractService<View_Pdg_Diario_NotasVO>{

	public View_Pdg_Diario_NotasService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public List select(View_Pdg_Diario_NotasVO t, Object[] where,
			Object[] order) throws Exception {
		// TODO Auto-generated method stub
		
		Pdg_Diario_Novos_AlunosService s = new Pdg_Diario_Novos_AlunosService();
		Pdg_Diario_Novos_AlunosVO vo = new Pdg_Diario_Novos_AlunosVO();
		vo.setId_diario(t.getId_diario());
		s.Procedure(vo);
		
		
		Pdg_Diario_Falta_AlunosService fa = new Pdg_Diario_Falta_AlunosService();
		Pdg_Diario_Falta_AlunosVO faVO = new Pdg_Diario_Falta_AlunosVO();
		faVO.setId_diario(t.getId_diario());
		fa.Procedure(faVO);
		
		return super.select(t, where, order);
	}

}
