package service.pbl;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;

import service.AbstractService;
import util.Database;
import valueObjects.pbl.Pbl_PublicMsgVO;

public class Pbl_PublicMsgService extends AbstractService<Pbl_PublicMsgVO>{

	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public Pbl_PublicMsgService() throws Exception {
		super();
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	public static void main(String[] args) throws Exception {
		Pbl_PublicMsgService s = new Pbl_PublicMsgService();
		Pbl_PublicMsgVO vo = new Pbl_PublicMsgVO();
		vo.setId_publicmsg(1);
		
		s.SelectImg(vo);
	}
	
	public List SelectImg(Pbl_PublicMsgVO t)throws Exception {
		// TODO Auto-generated method stub
		lista = new ArrayList();
		
		query = "select img from pbl_publicmsg where id_publicmsg = ?";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, t.getId_publicmsg());
		
		System.out.println(stmt);
		
		rs = stmt.executeQuery();
		
		if(rs.next()){
			HashMap dados = new HashMap();
			dados.put("img", rs.getBytes("img"));
			lista.add(dados);
		}
		
		stmt.close();
		rs.close();
		
		System.out.println(lista);
		
		return lista;
		
	}
	@Override
	public int inserir(Pbl_PublicMsgVO t) throws Exception {
		// TODO Auto-generated method stub
		
		t.setImg(resize(t.getImg(), "jpg", 250, 250));
		
		return super.inserir(t);
	}
	@Override
	public List atualizar(Pbl_PublicMsgVO t, Object[][] where) throws Exception {
		// TODO Auto-generated method stub
		
		t.setImg(resize(t.getImg(), "jpg", 250, 250));
		
		return super.atualizar(t, where);
	}
	
	public static byte[] resize(byte[] imgByte, String imageType, int newW, int newH) throws IOException {  
        BufferedImage img = ImageIO.read(new ByteArrayInputStream(imgByte));  
                  
        int w = img.getWidth();    
        int h = img.getHeight();    
        BufferedImage dimg = new BufferedImage(newW, newH, img.getType());    
        Graphics2D g = dimg.createGraphics();    
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);    
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);    
        g.dispose();  
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();  
        ImageIO.write(dimg, imageType, buffer);  
        return buffer.toByteArray();  
    }

}
