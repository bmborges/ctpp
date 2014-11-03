package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BackupDataBase implements ServletContextListener{
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	
	public BackupDataBase() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
	}
	
	
	public static void main(String[] args) throws Exception {
		BackupDataBase b = new BackupDataBase();
		b.criaBackup();
	}
	
	private void criaBackup() throws Exception{
		
//		set PGUSER=usuario  
//				set PGPASSWORD=minhasenha  
//				    
//				for /f "tokens=1,2,3,4 delims=/ " %%a in ('DATE /T') do set Date=%%b-%%c-%%d    
//				    
//				C:\Arquiv~1\Postgr~1\8.3\bin\pg_dump.exe -i -h localhost -p 5432 -U postgres -F c -b -o -v -f "D:\backup Postgresql\superAdmin\superAdminBackup%Date%.backup" superAdmin 
		
//		
//		String cmd = "C:\\Program Files (x86)\\PostgreSQL\\9.0\\bin\\pg_dump.exe --host localhost --port 5573 --username \"postgres\" --format custom --blobs --verbose --file \"C:\\Users\\bruno\\Desktop\\ctpp.backup\" \"ctpp\"";
//		Process p = Runtime.getRuntime().exec(cmd);
//		p.waitFor();
		
		
//		try{  
//			ProcessBuilder pb;  
//			Process p;  
//			pb = new ProcessBuilder("C:\\Program Files (x86)\\PostgreSQL\\9.0\\bin\\pg_dump.exe ", "-i", "-h", "localhost", "-p", "5573","-U", "postgres", "-F", "c", "-b", "-v" ,"-f", "C:\\Users\\bruno\\Desktop\\ctpp.backup", "ctpp");  
//			pb.environment().put("PGPASSWORD", "123");  
//			pb.redirectErrorStream(true);  
//			p = pb.start();   
//			}catch(Exception ex){
//				System.out.println(ex);
//			}

		final List<String> baseCmds = new ArrayList<String>();
	    baseCmds.add("C:\\Program Files (x86)\\PostgreSQL\\9.0\\bin\\pg_dump.exe");
	    baseCmds.add("-h");
	    baseCmds.add("177.0.37.55");
	    baseCmds.add("-p");
	    baseCmds.add("5573");
	    baseCmds.add("-U");
	    baseCmds.add("postgres");
	    baseCmds.add("-b");
	    baseCmds.add("-v");
	    baseCmds.add("-f");
	    baseCmds.add("C:\\Users\\bruno\\Desktop\\ctpp.backup");
	    baseCmds.add("ctpp");
	    final ProcessBuilder pb = new ProcessBuilder(baseCmds);

	    // Set the password
	    final Map<String, String> env = pb.environment();
	    env.put("PGPASSWORD", "123");

	    try {
	        final Process process = pb.start();

	        final BufferedReader r = new BufferedReader(
	                  new InputStreamReader(process.getErrorStream()));
	        String line = r.readLine();
	        while (line != null) {
	            System.err.println(line);
	            line = r.readLine();
	        }
	        r.close();

	        final int dcertExitCode = process.waitFor();

	     } catch (IOException e) {
	        e.printStackTrace();
	     } catch (InterruptedException ie) {
	        ie.printStackTrace();
	     }
			
		
		
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
