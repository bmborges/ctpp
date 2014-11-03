package service;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JExcelApiExporterParameter;

import org.springframework.web.util.WebUtils;

import annotations.Insert;
import annotations.PrimaryKey;
import annotations.Select;
import annotations.Sequence;
import annotations.Update;

import util.Database;
import valueObjects.ComboBoxVO;

public class AbstractService<T> {
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	String tablename = "";
	public Field[] fields = null;
	Boolean fazer = false;
	
	protected Class<T> classVO = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}

	public AbstractService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
		
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.classVO = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
		fields = classVO.getDeclaredFields();
		
	}
	
	
	public int nextval() throws Exception{
		int retorno = 0;
		
		query = "select nextval(?);";
		
		stmt = conn.prepareStatement(query);
		
        for (Field field : fields) {
            if (field.isAnnotationPresent(Sequence.class)) {
                field.setAccessible(true);
                stmt.setString(1, field.getName());
                break;
            }
        }
		
        System.out.println(stmt);
		rs = stmt.executeQuery();
		
		if(rs.next()){
			retorno = rs.getInt(1);
		}
		
		stmt.close();
		rs.close();

		return retorno;
				
	}
	
	public List Procedure(T t) throws Exception{
		lista = new ArrayList();
		
		query = "select * from ";
				
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
		query += tablename + "(";
		
		for (Field field : fields) {
            if (field.isAnnotationPresent(Select.class)) {
                field.setAccessible(true);
                query += "?,";
            }
        }
		
		query += ");";
		query = query.replace(",);", ");");
		
		stmt = conn.prepareStatement(query);
		
		int i = 0;
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(Select.class)) {
            	if (field.get(t) == null){
    				i++;
					stmt.setNull(i, java.sql.Types.NULL);
            	} else {	
	    			if(field.getType().toString().equals("class java.lang.Integer")){
						i++;
						stmt.setInt(i, (Integer) field.get(t));
					}
					if(field.getType().toString().equals("class java.lang.String")){
						i++;
						stmt.setString(i, (String) field.get(t));
					}
					if(field.getType().toString().equals("class java.sql.Timestamp")){
						i++;
						stmt.setTimestamp(i, (Timestamp) field.get(t));
					}
					if(field.getType().toString().equals("class java.sql.Time")){
						i++;
						stmt.setTime(i, (Time) field.get(t));
					}
					if(field.getType().toString().equals("class java.lang.Double")){
						i++;
						stmt.setDouble(i,  (Double) field.get(t));
					}
            	}
				
            }
        }
        
        System.out.println(stmt);
		
        rs = stmt.executeQuery();
        
        HashMap map = new HashMap();
        if(rs.next()){
        	map.put("retorno", rs.getString(1));
        	lista.add(map);
        }
        System.out.println(lista);
		return lista;
	}
	
	public List Report(HashMap parametros, String p_retorno, String relatorio, String pasta) throws Exception{
		lista = new ArrayList();
		String destination = "";
		String destinationUrl = "";
		
		Date data = new Date();
		
        String pathJasper = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/"+pasta+"/") + "/";
        String random = String.valueOf(Math.random()*1000);
        

		String source = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "WEB-INF/reports/"+pasta+"/"+relatorio+".jasper");
		
		String logo = WebUtils.getRealPath(flex.messaging.FlexContext.getServletConfig().getServletContext(), "WEB-INF/img/logo.jpg");
		
		parametros.put("p_logo", logo);
		parametros.put("SUBREPORT_DIR",pathJasper);
		parametros.put("data", data);
		
		
		System.out.println("retorno: "+p_retorno+" source: " + source + " parametros: " + parametros);    
		

        if(p_retorno.toUpperCase().equals("PDF")) {
        	destinationUrl = "./temp/"+relatorio+random+".pdf";
        	destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+relatorio+random+".pdf");
    		try {
    			JasperRunManager.runReportToPdfFile(source, destination, parametros,conn);
    		} catch (Exception e) {
    			throw new Exception(e.getCause() + "\n"+e.getMessage());
    		}
        } else if (p_retorno.toUpperCase().equals("EXCEL")){
        	destinationUrl = "./temp/"+relatorio+random+".xls";
        	destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+relatorio+random+".xls");
        	try {
        		       		
        		 //Gera relatorio
                JasperPrint jasperPrint = JasperFillManager.fillReport(source, parametros, conn);

                // Exporta usando a API JRExcelAPI
                JRExporter exporter = new JExcelApiExporter();

                // Exporta usando a Apache POI
                //JRExporter exporter = new JRXlsExporter();


                /* Alguns parametros opcionais...
                 * Onde está JExcelApiExporterParameter pode ser trocado por JRXlsExporterParameter, no caso de usar a POI
                 */
                exporter.setParameter(JExcelApiExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_FONT_SIZE_FIX_ENABLED, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
                exporter.setParameter(JExcelApiExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
                exporter.setParameter(JExcelApiExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
                // etc..


                //Informar o objeto JasperPrint que será exportado para excel
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);

                //Informa o diretorio + nome do arquivo e gera o XLS
                exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destination);
                exporter.exportReport();
  
        		
    		} catch (Exception e) {
    			throw new Exception(e.getCause() + "\n"+e.getMessage());
    		}
        } else{
        	destinationUrl = "./temp/"+relatorio+random+".pdf";
        	destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/"+relatorio+random+".pdf");
    		try {
    			JasperRunManager.runReportToPdfFile(source, destination, parametros,conn);
    		} catch (Exception e) {
    			throw new Exception(e.getCause() + "\n"+e.getMessage());
    		}
        }

		
		
		
		lista = new ArrayList();
        File dir = null;
        Boolean bAchou = false;
        
        while(bAchou == false){
            dir = new File(destination);
            if (dir.exists()){
                bAchou = true;
            }

            System.out.println("Arquivo não encontrato");

            Thread.sleep(5000);
        }
        System.out.println("Arquivo encontrato");
        Thread.sleep(5000);
		
		HashMap dados = new HashMap();
		dados.put("destinationUrl", destinationUrl);
		lista.add(dados);
		
		return lista;
	}	
public List ComboBox(String label,String data) throws Exception{
		
		lista = new ArrayList();
		
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
	    query = "select "+ data +" as data, "+ label +" as label from "+ tablename +
	    		"	order by " + data;

	    stmt = conn.prepareStatement(query);
	    System.out.println(stmt);
	    
	    rs = stmt.executeQuery();
		
	    ComboBoxVO combo = new ComboBoxVO();
		combo.setData(null);
		combo.setLabel("Selecione...");
		lista.add(combo);
		
		while(rs.next()){
			combo = new ComboBoxVO();
			combo.setData(rs.getString("data"));
			combo.setLabel(rs.getString("label"));
			lista.add(combo);
		}

		stmt.close();
		rs.close();
		
        return lista;						

	}
	public List ComboBoxQuery(String query, String atributo) throws Exception{
		
		lista = new ArrayList();
		
	    stmt = conn.prepareStatement(query);
	    
	    if (atributo.length() > 0){
	    	stmt.setString(1, atributo);
	    }
	    System.out.println(stmt);
		rs = stmt.executeQuery();
		

	    ComboBoxVO combo = new ComboBoxVO();
		combo.setData(null);
		combo.setLabel("Selecione...");
		lista.add(combo);
		
		while(rs.next()){
			combo = new ComboBoxVO();
			combo.setData(rs.getString("data"));
			combo.setLabel(rs.getString("label"));
			lista.add(combo);
		}

		stmt.close();
		rs.close();
		
        return lista;						

	}
public List select (T t, Object[] where, Object[] order) throws Exception{
		
		lista = new ArrayList();
	
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		String tb[] = tablename.split("_");
		
		query = "select ";
        
        for (Field field : fields) {
            if (field.isAnnotationPresent(Select.class)) {
                field.setAccessible(true);
                query += field.getName() + ",";
            }
        }
        query = query.substring(0, query.length() - 1);
	
		query += " from ";
		query += tablename +" ";
	        for (Field field : fields) {
	        	field.setAccessible(true);
	//        	System.out.println(field.getName()+" "+field.get(t));
	            if (field.isAnnotationPresent(Select.class) && field.get(t) != null) {
	            	fazer = true;
					if(field.getType().toString().equals("class java.lang.String") ){
						if(!query.contains("where")){
							query += " where ";
						} 
						if (field.get(t).toString().contains("%")){
							query += "lower(remove_acento(" + field.getName() +")) ilike lower(remove_acento(?)) and ";
						} else {
							query += "lower(remove_acento(" + field.getName() +")) = lower(remove_acento(?)) and ";
						}
					} else {
						if(!query.contains("where")){
							query += " where ";
						} 
						query += field.getName() + " = ? and ";
					}
	            }
	        }
	        if (where != null){
				for (int i = 0; i < where.length; i++) {
					fazer = true;
					if(!query.contains("where")){
						query += " where ";
					} 
					
					query +=  where[i] + " and ";
				}
	        }
        if (fazer){
        	query = query.substring(0,query.length() - 4);
        }
        fazer = false;
        if (!tb[0].toLowerCase().equals("view")){
        	if (order != null){
    			for (int i = 0; i < order.length; i++) {
    				fazer = true;
    				if(!query.contains("order")){
    					query += " order by ";
    				} 
    				
    				query +=  order[i] + " , ";
    			}
            } else {
        		for (Field field : fields) {
                    if (field.isAnnotationPresent(PrimaryKey.class)) {
                        field.setAccessible(true);
                        query += " order by " + field.getName();
                        break;
                    }
                }
            }
        }
        if (fazer){
        	query = query.substring(0,query.length() - 2);
        }
	    
	    stmt = conn.prepareStatement(query);
	    
	    int i = 0;
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(Select.class) && field.get(t) != null) {
    			if(field.getType().toString().equals("class java.lang.Integer")){
					i++;
					stmt.setInt(i, (Integer) field.get(t));
				}
				if(field.getType().toString().equals("class java.lang.String")){
					i++;
					stmt.setString(i, (String) field.get(t));
				}
				if(field.getType().toString().equals("class java.sql.Timestamp")){
					i++;
					stmt.setTimestamp(i, (Timestamp) field.get(t));
				}
				if(field.getType().toString().equals("class java.sql.Time")){
					i++;
					stmt.setTime(i, (Time) field.get(t));
				}
				if(field.getType().toString().equals("class java.lang.Double")){
					i++;
					stmt.setDouble(i,  (Double) field.get(t));
				}
				
            }
        }

		System.out.println(stmt);
		
		rs = stmt.executeQuery();
		
		while(rs.next()){
			HashMap dados = new HashMap();
	        for (Field field : fields) {
	            if (field.isAnnotationPresent(Select.class)) {
	                field.setAccessible(true);
	                String type = field.getType().toString();
					if(type.equals("int") || type.equals("class java.lang.Integer")){
						dados.put(field.getName(), rs.getInt(field.getName()));
					} else if (type.equals("class java.sql.Timestamp")){
						dados.put(field.getName(), rs.getTimestamp(field.getName()));
					} else if (type.equals("class java.lang.Double")){
						dados.put(field.getName(), rs.getDouble(field.getName()));
					} else if (type.equals("class [B")){
						dados.put(field.getName(), rs.getBytes(field.getName()));
					} else {
						dados.put(field.getName(), rs.getString(field.getName()));
					}
	            }
	        }
			lista.add(dados);
		}
		
		stmt.close();
		rs.close();			

		System.out.println(lista);
		
		return lista;
	}
	
	public int inserir(T t) throws Exception{
		
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(PrimaryKey.class) && field.get(t) == null){
        		field.set(t, nextval());
        		break;
            }
        }
		
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
		query = "insert into " + tablename;
		query +=" (";
		
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(Insert.class) && field.get(t) != null) {
                query += field.getName() + ",";
            }
        }
        query = query.substring(0, query.length() - 1);
        
		query +=") values (";
		
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(Insert.class) && field.get(t) != null) {
                query += "?,";
            }
        }
        query = query.substring(0, query.length() - 1);
        query +=");";
        
		// prepara o statement
		
		stmt = conn.prepareStatement(query);
		
		int i = 0;
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(Insert.class) && field.get(t) != null) {
                i ++;
				String type = field.getType().toString();
//				System.out.println(type);
				if(type.equals("int") || type.equals("class java.lang.Integer")){
					stmt.setInt(i, Integer.parseInt(field.get(t).toString()));
				}
				if(type.equals("class java.lang.String")){
					stmt.setString(i, field.get(t).toString());
				}
				if(type.equals("class java.sql.Timestamp")){
					stmt.setTimestamp(i, (Timestamp) field.get(t));
				}
				if(type.equals("class java.sql.Time")){
					stmt.setTime(i, (Time) field.get(t));
				}
				if(type.equals("class [B")){
					stmt.setBytes(i, (byte[]) field.get(t));
				}
				if(type.equals("class java.lang.Double")){
					stmt.setDouble(i, (Double) field.get(t));
				}
            }
        }
		
		
		System.out.println(stmt);
		
		stmt.executeUpdate();
		
		stmt.close();
		
		int retorno = 0;
		
        for (Field field : fields) {
        	field.setAccessible(true);
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                retorno = Integer.parseInt(field.get(t).toString());
                break;
            }
        }
		
		return retorno; 
	}
 
	public void SqlAtualizar(String sql, String where) throws Exception{
		
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
		query = "update " + tablename;
		
		query +=" set ";
		
		query += sql;
		
		query += " where ";
		
		query += where;
		
		stmt = conn.prepareStatement(query);
		
		System.out.println(stmt);
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}
	
	public List atualizar(T t, Object[][] where) throws Exception{
		lista = new ArrayList();
		
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
		query = "update " + tablename;
		
		query +=" set ";
		
        for (Field field : fields) {
            if (field.isAnnotationPresent(Update.class)) {
                field.setAccessible(true);
                query += field.getName() + " = ? ,";
            }
        }
        query = query.substring(0, query.length() - 1);
        
        query +=" where ";
        
        if (where == null){
	        for (Field field : fields) {
	            if (field.isAnnotationPresent(PrimaryKey.class)) {
	                field.setAccessible(true);
	                query += field.getName() + " = ?;";
	                break;
	            }
	        }
        } else {
        	for (int i = 0; i < where.length; i++) {
    			Object[] objects = where[i];
				for (int j = 0; j < objects.length; j++) {
					query += objects[j] + " ";
				}
    		}
        }
		// prepara o statement
		
		stmt = conn.prepareStatement(query);
	    
		int i = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Update.class)) {
                field.setAccessible(true);
                i ++;
				String type = field.getType().toString();
				if (field.get(t) == null){
					stmt.setNull(i, java.sql.Types.NULL);
				} else {
					if(type.equals("int") || type.equals("class java.lang.Integer")){
						stmt.setInt(i, (Integer) field.get(t));
					} 
					if(type.equals("class java.lang.String")){
						stmt.setString(i, (String) field.get(t));
					}
					if(type.equals("class [B")){
						stmt.setBytes(i, (byte[]) field.get(t));
					}
					if(type.equals("class java.sql.Timestamp")){
						stmt.setTimestamp(i, (Timestamp) field.get(t));
					}
					if(type.equals("class java.sql.Time")){
						stmt.setTime(i, (Time) field.get(t));
					}
					if(type.equals("class java.lang.Number")){
						stmt.setFloat(i,  (Float) field.get(t));
					}
					if(type.equals("class java.lang.Double")){
						stmt.setDouble(i,  (Double) field.get(t));
					}
				}
            }
        }
		
        if (where == null){
	        for (Field field : fields) {
	        	field.setAccessible(true);
	            if (field.isAnnotationPresent(PrimaryKey.class)) {
	                i ++;
					stmt.setInt(i, (Integer) field.get(t));
					break;
	            }
	        }
        }
        
		System.out.println(stmt);
		
		stmt.executeUpdate();
		
		stmt.close();
		
		return select(t, null, null);
	}
	public List atualizar2(T t, Object[] where) throws Exception{
		System.out.println("atualizar2");
		lista = new ArrayList();
		
		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
		query = "update " + tablename;
		
		query +=" set ";
		
        for (Field field : fields) {
            if (field.isAnnotationPresent(Update.class)) {
                field.setAccessible(true);
                System.out.println(field.get(t));
        		if (field.get(t) != null){
        			if (field.get(t).toString().trim().length() <= 0 ){
        				query += field.getName() + " = null ,";
        			} else {
        				query += field.getName() + " = ? ,";
        			}
        		}
            }
        }
        query = query.substring(0, query.length() - 1);
        
        query +=" where ";
        
        if (where == null){
	        for (Field field : fields) {
	            if (field.isAnnotationPresent(PrimaryKey.class)) {
	                field.setAccessible(true);
	                query += field.getName() + " = ?;";
	                break;
	            }
	        }
        } else {
        	for (int i = 0; i < where.length; i++) {
        		query +=  where[i] + " and ";
    		}
        	query = query.substring(0, query.length() - 4);
        }
		// prepara o statement
		
		stmt = conn.prepareStatement(query);
	    
		int i = 0;
        for (Field field : fields) {
            if (field.isAnnotationPresent(Update.class)) {
                field.setAccessible(true);
				String type = field.getType().toString();
				 if (field.get(t) != null && field.get(t).toString().trim().length() > 0) {
					i ++;
					if(type.equals("int") || type.equals("class java.lang.Integer")){
						stmt.setInt(i, (Integer) field.get(t));
					} 
					if(type.equals("class java.lang.Long")){
						stmt.setLong(i, (Long) field.get(t));
					} 
					if(type.equals("class java.lang.String")){
						stmt.setString(i, (String) field.get(t));
					}
					if(type.equals("class [B")){
						stmt.setBytes(i, (byte[]) field.get(t));
					}
					if(type.equals("class java.sql.Timestamp")){
						stmt.setTimestamp(i, (Timestamp) field.get(t));
					}
					if(type.equals("class java.sql.Time")){
						stmt.setTime(i, (Time) field.get(t));
					}
					if(type.equals("class java.lang.Number")){
						stmt.setFloat(i,  (Float) field.get(t));
					}
					if(type.equals("class java.lang.Double")){
						stmt.setDouble(i,  (Double) field.get(t));
					}
				}
            }
        }
		
        if (where == null){
	        for (Field field : fields) {
	        	field.setAccessible(true);
	            if (field.isAnnotationPresent(PrimaryKey.class)) {
	                i ++;
	                String type = field.getType().toString();
	                if(type.equals("class java.lang.Long")){
						stmt.setLong(i, (Long) field.get(t));
					} else {
						stmt.setInt(i, (Integer) field.get(t));
					}
					break;
	            }
	        }
        }
        
		System.out.println(stmt);
		
		stmt.executeUpdate();
		
		stmt.close();
		
		return select(t, null, null);
	}	
	public void deletar(T t) throws Exception{

		tablename = classVO.getSimpleName();
		tablename = tablename.replace("VO", "");
		
		query = "delete from " + tablename;
		
		query +=" where ";
		
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                field.setAccessible(true);
                query += field.getName() + " = ?;";
                break;
            }
        }
		
		
		// prepara o statement
		
		stmt = conn.prepareStatement(query);
	    
        for (Field field : fields) {
            if (field.isAnnotationPresent(PrimaryKey.class)) {
                field.setAccessible(true);
                stmt.setInt(1, (Integer) field.get(t));
                break;
            }
        }
		
		System.out.println(stmt);
		
		stmt.executeUpdate();
		
		stmt.close();
		
	}
}
