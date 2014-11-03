package service;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperRunManager;

import org.springframework.web.util.WebUtils;

import util.Database;

public class ReportService {
	Connection conn = null;
	List lista = null;

	public ReportService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	
	public static void main(String[] args) throws Exception {
		ReportService s = new ReportService();
		HashMap obj = new HashMap();
		obj.put("p_idturmaini",25);
		obj.put("p_idturmafin",25);
		obj.put("p_idctrstatus",2);
		obj.put("nmoperador","bruno");
		
		
		s.Report(obj, "PDF", "Rpt_AlunoTurma", "pdg");
		
	}
	
	
	public List Report(HashMap parametros, String p_retorno, String relatorio, String pasta) throws Exception{
		lista = new ArrayList();
		Date data = new Date();
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/"+pasta+"/") + "/";
        
        String random = String.valueOf(Math.random()*1000);
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+relatorio+random+".pdf");
		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/"+pasta+"/"+relatorio+".jasper");
		String destinationUrl = "/ctpp/temp/"+relatorio+random+".pdf";
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
		parametros.put("data", data);
		
		

        
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
