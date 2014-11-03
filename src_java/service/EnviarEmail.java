package service;
import java.sql.SQLException;

public class EnviarEmail {
	
  public EnviarEmail() throws Exception {
	    
   }
  public void Enviar() throws SQLException{
      SendMail mail = new SendMail();
      String msg = "Backup Sistema CTPP";
      String titulo = "Email Backup Sistema CTPP";
		
      mail.sendMail("brunomborges@gmail.com", "brunomborges@gmail.com", titulo, msg);
      
  }
  
}
