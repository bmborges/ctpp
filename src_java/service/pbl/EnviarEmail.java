package service.pbl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.activation.DataSource;
import javax.activation.FileDataSource;

import util.Database;

public class EnviarEmail {
    
    String msg = "";
    Integer id_publicmsg = 0;
    private Connection conn = null;
    DataSource fds = null;
    
    public static void main(String[] args) throws Exception {
        EnviarEmail e = new EnviarEmail();
        e.Enviar();
    }

    public EnviarEmail() throws Exception {
        conn = Database.getConnection();

      if (conn == null) {
         throw new Exception(getClass().getName() + ": null connection passed.");
      }
         this.conn = conn;
         
    }
    
    

  public void Enviar() throws Exception{
     
      int i = 0;
      SendMail mail = new SendMail();

      String titulo = "Publicidade";
     
      AtualizaEnviado(null);
      GetMsg(null);
      
      String qry = "select email from pbl_publicemail where enviado = 'N' and ativo = 1";

      PreparedStatement stmt = conn.prepareStatement(qry);
      
      ResultSet rs = stmt.executeQuery();
        
      while (rs.next()){
        if (i == 100){
            Thread.sleep(1000 * 15);
        }  
        mail.sendMail(rs.getString(1), titulo, msg, fds);
        AtualizaEnviado(rs.getString(1));
        i++;
      }
//        mail.sendMail("brunomborges@gmail.com", titulo, msg, null);
//        mail.sendMail("marciompc@hotmail.com", titulo, msg, null);
      GetMsg(id_publicmsg);

  }
  private void GetMsg(Integer id_publicmsg) throws SQLException{
      
        String qry = "";
        if (id_publicmsg == null){
            qry = "select id_publicmsg, msg from pbl_publicmsg where enviado = 'N' limit 1";
        } else {
            qry = "update pbl_publicmsg set enviado = 'S' where id_publicmsg = ?";
        }

        PreparedStatement stmt = conn.prepareStatement(qry);
        ResultSet rs = null;
        if (id_publicmsg == null){
            rs = stmt.executeQuery();
            if (rs.next()){
                id_publicmsg = rs.getInt(1);
                msg = rs.getString(2);
            }
        } else {
            stmt.setInt(1, id_publicmsg);
            stmt.executeUpdate();
        }
        
        if (id_publicmsg == null){
        	qry = "select msg_padrao from adm_param where id_modulo = 5";
        	stmt = conn.prepareStatement(qry);
        	rs = stmt.executeQuery();
        	if (rs.next()){
        		msg += "\n" + rs.getString(1);
        	}
        }
        
        fds = new FileDataSource("C:\\Users\\bruno\\workspace\\VoeLonge-quebrado.jpg");
  }
  private void AtualizaEnviado(String email) throws SQLException{
      String qry = "";
      if (email == null){
        qry = "update pbl_publicemail set enviado = 'N' where ativo = 1";
      } else {
        qry = "update pbl_publicemail set enviado = 'S' where email = ?";
      }

      PreparedStatement stmt = conn.prepareStatement(qry);
      if (email != null){
          stmt.setString(1, email);
          System.out.println(stmt);
      }
      stmt.executeUpdate();

  }
          
 
}
