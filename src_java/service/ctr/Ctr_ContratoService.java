package service.ctr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JasperRunManager;

import org.springframework.web.util.WebUtils;

import service.AbstractService;
import util.Database;
import valueObjects.ctr.Ctr_ContratoVO;

public class Ctr_ContratoService extends AbstractService<Ctr_ContratoVO>{

	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	
	public Ctr_ContratoService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	@Override
	public List Report(HashMap parametros, String p_retorno, String relatorio,
			String pasta) throws Exception {
		// TODO Auto-generated method stub
		
		query = "select relatorio from ctr_contrato" +
				"	inner join crs_curso using (id_curso)" +
				"	inner join crs_tipocurso using (id_tipocurso)" +
				"	where id_contrato =  ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, Integer.parseInt((String) parametros.get("p_idcontrato")));
		
		System.out.println(stmt);
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			relatorio = rs.getString("relatorio");
		}
		
		return super.Report(parametros, p_retorno, relatorio, pasta);
	}
	public List ReportContratoBranco(int id_tipocurso, String p_retorno) throws Exception{
		
		query = "select relatorio from crs_tipocurso where id_tipocurso = ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_tipocurso);
		rs = stmt.executeQuery();
		if(rs.next()){
			retorno = rs.getString("relatorio");
		}
		
		HashMap parametros = new HashMap();
        
		parametros.put("p_idcontrato","0");
        
		return super.Report(parametros, p_retorno, retorno, "ctr");		
	}

}
