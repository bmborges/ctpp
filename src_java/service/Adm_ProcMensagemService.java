package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import util.Database;

public class Adm_ProcMensagemService implements ServletContextListener{
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	
	ResultSet rs = null;
	List lista = null;
	Timer timer = null;
	
	public static void main(String[] args) throws Exception {
		Adm_ProcMensagemService s = new Adm_ProcMensagemService();
		s.procedures_mensagem();
	}
	
	public Adm_ProcMensagemService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if (timer != null){
			timer.cancel();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		timer = new Timer();
		System.out.println("Iniciado Adm_ProcMensagemService>>>>>>>");
		java.util.Date agora = Calendar.getInstance().getTime();
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR,2);
		c.set(Calendar.MINUTE,0);
		c.set(Calendar.SECOND,0);
		c.set(Calendar.AM_PM,Calendar.AM);
		java.util.Date horaAgendada = c.getTime();
		if (!agora.after(horaAgendada)){
			long delay = horaAgendada.getTime() - agora.getTime();
			long period = 86400000;
			timer.scheduleAtFixedRate(new TimerTask(){
				public void run(){
					try {
						procedures_mensagem();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}, delay, period);
		}
	}
	
	public void procedures_mensagem() throws Exception{
		query = "select id_procmensagem, procedimento from adm_proc_mensagem where id_ativo = 1";
		
	    stmt = conn.prepareStatement(query);
	    
	    rs = stmt.executeQuery();
	    String retorno = "";
	    PreparedStatement stmt1 = null;
		while(rs.next()){
			retorno = "select " + rs.getString(2) + ";";
			stmt1 = conn.prepareStatement(retorno);
			System.out.println(stmt1);
			try {
				stmt1.execute();
				String querye= "update adm_proc_mensagem set dt_ultima_execucao = now(), erro = null where id_procmensagem = ?";
				PreparedStatement stmte = conn.prepareStatement(querye);
				stmte.setInt(1, rs.getInt(1));
				stmte.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
				String querye= "update adm_proc_mensagem set dt_ultima_execucao = now(), erro = ? where id_procmensagem = ?";
				PreparedStatement stmte = conn.prepareStatement(querye);
				stmte.setString(1, e.getMessage());
				stmte.setInt(2, rs.getInt(1));
				stmte.executeUpdate();
			}
		}
		
		
		
		stmt1.close();
		stmt.close();
		rs.close();
	}

}
