package service.adm;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.web.util.WebUtils;

import service.AbstractService;
import util.Database;
import valueObjects.adm.Adm_OperadorVO;

public class Adm_OperadorService extends AbstractService<Adm_OperadorVO>{
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		Adm_OperadorService o = new Adm_OperadorService();
		Adm_OperadorVO v = new Adm_OperadorVO();
		Object where[] = {"id_aluno is null"}; 
		o.select(v, where, null);
	}

	public Adm_OperadorService() throws Exception {
		// TODO Auto-generated method stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	
	public void GravaFoto(Adm_OperadorVO t) throws Exception {
		query = "update adm_operador set foto = ? where id_operador = ?";
		
		stmt = conn.prepareStatement(query);
		
		
//		stmt.setBytes(1, t.getFoto());
		stmt.setInt(2, t.getId_operador());
		
		System.out.println(stmt);
		
		stmt.executeUpdate();
		
	}
	
	public void updatesenha(Adm_OperadorVO operador) throws Exception{
		
		query = "select id_operador, senha from adm_operador where id_operador = ?";
		
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, operador.getId_operador());
		rs = stmt.executeQuery();
		
		if(rs.next()){
			if(rs.getString("senha").equals(operador.getSenha())){
				query = "update adm_operador set senha = ? where id_operador = ?";

				stmt = conn.prepareStatement(query);
				stmt.setString(1, operador.getSenha_nova());
				stmt.setInt(2, operador.getId_operador());
				
				stmt.executeUpdate();
				
			} else {
				throw new Exception("A senha atual não confere");
			}
		} else {
			throw new Exception("Esse usuario não esta Cadastrado");
		}
	}
	public List GravaFotoTemp(Adm_OperadorVO t) throws Exception{
		lista = new ArrayList();
		byte[] bytes = null;
		
//		bytes = t.getFoto();
		String nmarquivo = String.valueOf(Math.random()*1000);
		
		String destination = WebUtils.getRealPath(flex.messaging.FlexContext.getServletContext(), "temp/" + nmarquivo);
		
        File someFile = new File(destination);
        FileOutputStream fos = new FileOutputStream(someFile);
        fos.write(bytes);
        fos.flush();
        fos.close();
        
        File imagem = new File(destination);
		
        BufferedImage bufImagemLida =  ImageIO.read(imagem);
        //cria imagem para
        BufferedImage imagemRedimensionada = new BufferedImage(280,280 , BufferedImage.TYPE_INT_RGB);
        //realiza o redimensionamento da imagem
        Graphics2D graphisImagem = null;

        graphisImagem = imagemRedimensionada.createGraphics();
        graphisImagem.drawImage(bufImagemLida,0,0, 280, 280,null);
        
        ByteArrayOutputStream baos = null;

        baos = new ByteArrayOutputStream();
        //escreve a imagem no OutputStream
        ImageIO.write(imagemRedimensionada, "JPEG", baos);
        //transforma o OutputStream em array de bytes e retorna
        byte[] bytesImagem = null;

        bytesImagem = baos.toByteArray();

        fos = new FileOutputStream(destination);
        fos.write(bytesImagem);

        
		HashMap dados = new HashMap();
		dados.put("nmarquivo", nmarquivo);
		lista.add(dados);
		
		System.out.println(lista);
		
		return lista;

	}
	
}
