package service.pdg;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperRunManager;

import org.springframework.web.util.WebUtils;

import util.Database;

public class Pdg_ReportService {
	Connection conn = null;
	List lista = null;

	public Pdg_ReportService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public List ReportDiario(int p_iddiarioini, int p_iddiariofin, int p_idturmaini, int p_idturmafin, int p_imprimir, String p_retorno) throws Exception{
		lista = new ArrayList();
		
		
		if(p_idturmaini <= 0){
			p_idturmaini = 0;
		}
		if(p_idturmafin <= 0){
			p_idturmafin = 99999;
		}
		
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/pdg/") + "/";
        
        String random = String.valueOf(Math.random()*1000);
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/Rpt_Diario"+random+".pdf");
		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/pdg/Rpt_Diario.jasper");
		String destinationUrl = "/ctpp/temp/Rpt_Diario"+random+".pdf";
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		HashMap parametros = new HashMap();
        
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
        
        parametros.put("p_iddiarioini", p_iddiarioini);
        parametros.put("p_iddiariofin", p_iddiariofin);
        parametros.put("p_idturmaini", p_idturmaini);
        parametros.put("p_idturmafin", p_idturmafin);
        parametros.put("p_imprimir", p_imprimir);

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

	public List ReportDiarioAssinatura(int p_iddiarioini, int p_iddiariofin, int p_idoperadorini, int p_idoperadorfin, String p_retorno) throws Exception{
		lista = new ArrayList();
		
		
		if(p_idoperadorini <= 0){
			p_idoperadorini = 0;
		}
		if(p_idoperadorfin <= 0){
			p_idoperadorfin = 99999;
		}
		
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/pdg/") + "/";
        
        String random = String.valueOf(Math.random()*1000);
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/Rpt_DiarioAssinatura"+random+".pdf");
		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/pdg/Rpt_DiarioAssinatura.jasper");
		String destinationUrl = "/ctpp/temp/Rpt_DiarioAssinatura"+random+".pdf";
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		HashMap parametros = new HashMap();
        
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
        
        parametros.put("p_iddiarioini", p_iddiarioini);
        parametros.put("p_iddiariofin", p_iddiariofin);
        parametros.put("p_idoperadorini", p_idoperadorini);
        parametros.put("p_idoperadorfin", p_idoperadorfin);

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
	public List Report(HashMap parametros, String p_retorno, String relatorio) throws Exception{
		lista = new ArrayList();
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/pdg/") + "/";
        
        String random = String.valueOf(Math.random()*1000);
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+relatorio+random+".pdf");
		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/pdg/"+relatorio+".jasper");
		String destinationUrl = "/ctpp/temp/"+relatorio+random+".pdf";
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
        
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
