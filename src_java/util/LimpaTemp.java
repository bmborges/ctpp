package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LimpaTemp implements ServletContextListener{
	
	Timer timer = null;
	String dir = null;
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		dir = event.getServletContext().getRealPath("temp");
		timer = new Timer();
		System.out.println("Iniciado LimpaTemp>>>>>>>");
		java.util.Date agora = Calendar.getInstance().getTime();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR,1);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.AM_PM,Calendar.PM);
		java.util.Date horaAgendada = c.getTime();
		if (!agora.after(horaAgendada)){
			long delay = horaAgendada.getTime() - agora.getTime();
			long period = 86400000;
			timer.scheduleAtFixedRate(new TimerTask(){
				public void run(){
					try {
						deletar();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}, delay, period);
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		if (timer != null){
			timer.cancel();
		}
	}
	
	public void deletar() throws FileNotFoundException{
	      File diretorio;  
	      File [] arquivos;
	      
          diretorio = new File(dir);
	      arquivos = diretorio.listFiles();
	      
	      for (int i = 0; i < arquivos.length; i++) {
    		  arquivos[i].delete();
	      }
	}
	
}
