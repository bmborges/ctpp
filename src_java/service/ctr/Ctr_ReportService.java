package service.ctr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperRunManager;

import org.springframework.web.util.WebUtils;

import util.Database;
import valueObjects.ctr.Ctr_ContratoVO;

public class Ctr_ReportService {
	Connection conn = null;
	List lista = null;
	String query = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	String retorno = "";

	public Ctr_ReportService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public List ReportContratoBranco(int id_tipocurso, String p_retorno) throws Exception{
		lista = new ArrayList();
		
		query = "select relatorio from crs_tipocurso where id_tipocurso = ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_tipocurso);
		rs = stmt.executeQuery();
		if(rs.next()){
			retorno = rs.getString("relatorio");
		}
		
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/ctr/") + "/";
        
        String random = String.valueOf(Math.random()*1000);
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+retorno+random+".pdf");
		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/ctr/"+retorno+".jasper");
		String destinationUrl = "/ctpp/temp/"+retorno+random+".pdf";
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		HashMap parametros = new HashMap();
        
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
		parametros.put("p_idcontrato",0);
		
        
		try {
			JasperRunManager.runReportToPdfFile(source, destination, parametros,conn);
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		HashMap dados = new HashMap();
		dados.put("destinationUrl", destinationUrl);
		lista.add(dados);
		
		return lista;
	}
	
	public List ReportContrato(Ctr_ContratoVO contrato, String p_retorno) throws Exception{
		lista = new ArrayList();
		
		query = "select relatorio from ctr_contrato" +
				" inner join crs_turma using (id_turma)" +
				" inner join crs_curso using (id_curso)" +
				" inner join crs_tipocurso using (id_tipocurso)" +
				" where id_contrato = ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, contrato.getId_contrato());
		rs = stmt.executeQuery();
		if(rs.next()){
			retorno = rs.getString("relatorio");
		}
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/ctr/") + "/";
        
        String random = String.valueOf(Math.random()*1000);
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+retorno+random+".pdf");
		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/ctr/"+retorno+".jasper");
		String destinationUrl = "/ctpp/temp/"+retorno+random+".pdf";
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		HashMap parametros = new HashMap();
        
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
		parametros.put("p_idcontrato",contrato.getId_contrato());
		
        
		try {
			JasperRunManager.runReportToPdfFile(source, destination, parametros,conn);
		} catch (Exception e) {
			throw new Exception(e);
		}
		
		HashMap dados = new HashMap();
		dados.put("destinationUrl", destinationUrl);
		lista.add(dados);
		
		return lista;
	}
}
