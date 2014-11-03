package service.pdg;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.util.WebUtils;

import service.AbstractService;
import service.SystemService;
import util.Database;
import valueObjects.Pdg_DiarioArquivosVO;

public class Pdg_DiarioArquivosService extends AbstractService<Pdg_DiarioArquivosVO>{
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public Pdg_DiarioArquivosService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public static void main(String[] args) throws Exception {
		Pdg_DiarioArquivosService s = new Pdg_DiarioArquivosService();
		
		
	}
	public byte[] ImportArquivo() throws FileNotFoundException{
		
		File file = new File("C:\\Users\\bruno\\Documents\\Material Uniube\\ED_04.pdf");
		 
        FileInputStream fis = new FileInputStream(file);
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
            }
        } catch (IOException ex) {
            Logger.getLogger(SystemService.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytes = bos.toByteArray();
        
        return bytes;
	}
	
	public List baixar_arquivo(Pdg_DiarioArquivosVO t) throws Exception{
		lista = new ArrayList();
		byte[] bytes = null;
		String nmarquivo = "";
		query = "select arquivo, remove_acento(nmarquivo) as nmarquivo" +
				"	from pdg_diarioarquivos where id_diarioarquivos = ?";

		stmt = conn.prepareStatement(query);
		stmt.setInt(1, t.getId_diarioarquivos());
		rs = stmt.executeQuery();
		
		
		if(rs.next()){
			bytes = rs.getBytes("arquivo");
			nmarquivo = rs.getString("nmarquivo");
		}
		
		System.out.println(stmt);
		
        //below is the different part
		
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/" + nmarquivo);
		String destinationUrl = "/ctpp/temp/"+ nmarquivo;
		
        File someFile = new File(destination);
        FileOutputStream fos = new FileOutputStream(someFile);
        fos.write(bytes);
        fos.flush();
        fos.close();
		
		stmt.close();
		rs.close();
		
		HashMap dados = new HashMap();
		dados.put("destinationUrl", destinationUrl);
		lista.add(dados);
		
		System.out.println(lista);
		
		return lista;

	}
	
		   	
		
}
