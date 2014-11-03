package service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import flex.messaging.FlexContext;
import flex.messaging.FlexSession;


import util.Database;
import valueObjects.adm.Adm_OperadorVO;
import valueObjects.Adm_PermissaoVO;
import valueObjects.Pdg_DiarioArquivosVO;
import valueObjects.pdg.Pdg_DiarioContVO;

public class SystemService {
	
	Connection conn = null;
	String query = "";
	String retorno = "";
	PreparedStatement stmt = null;
	ResultSet rs = null;
	List lista = null;
	FlexSession session = FlexContext.getFlexSession(); //Recupera o FlexSession
	
	public SystemService() throws Exception {
		// TODO Auto-generated constructor stub
		conn = Database.getConnection();
		if (conn == null){
			throw new Exception(getClass().getName() + ": null connection.");
		}
		this.conn = conn;
		
	}
	public static void main(String[] args) throws Exception {
		SystemService ss = new SystemService();
		ss.select_permissao(2);
		ss.monta_menu(2);
	}
	public boolean VerificaSession(){
		System.out.println(">>>ChamouVerificaSession");
		return session.isValid();
	}
	public List select_permissao(int id_operador) throws Exception{
		
		lista = new ArrayList();
		
		query = "select id_permissao, id_operador, id_itemmenu from adm_permissao where id_operador = ?";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_operador);
		
//		System.out.println("select_permissao>>>>> "+stmt);
		
		rs = stmt.executeQuery();

		while(rs.next()){
			HashMap dados = new HashMap();
			dados.put("id_itemmenu", rs.getInt("id_itemmenu"));
			lista.add(dados);
		}
		
//		System.out.println("select_permissao lista >>>>> "+ lista);
		stmt.close();
		rs.close();
		
        return lista;
		
	}
	
	public String monta_menu(int id_operador) throws Exception{
		
		query = "select monta_menu(?)";
		stmt = conn.prepareStatement(query);
		stmt.setInt(1, id_operador);
		rs = stmt.executeQuery();
		if(rs.next()){
			retorno = rs.getString("monta_menu");
		}
		
//		System.out.println(retorno);
		
		stmt.close();
		rs.close();
		
   		return retorno;
	}	
	public List authlogin(String nickname, String senha) throws Exception{
		
		
//		public void validar(String login, String senha) throws ServicoException{
//	        UsuarioVO vo = dao.buscarPorLogin(login);
//	        if( vo == null ||
//	                !login.equals(vo.getLogin()) ||
//	                    senha.equals(new String(vo.getSenha()))){
//	            throw new ServicoException("Usuário e/ou senha inválida.");
//	        }
//	        FlexSession session = FlexContext.getFlexSession(); //Recupera o FlexSession
//	        session.setAttribute("usuarioLogado", vo); //Adiciona o usuario na sessão
//	    }
//
//	    public UsuarioVO recuperarUsuarioLogado(){
//	        FlexSession session = FlexContext.getFlexSession();
//	        UsuarioVO usuarioLogado = (UsuarioVO) session.getAttribute("usuarioLogado"); //Recupera o usuário da sessão
//	        return usuarioLogado;
//	    }
		
		
		lista = new ArrayList();
		
		Adm_OperadorVO operador = new Adm_OperadorVO();
		operador.setId_operador(0);
		operador.setNickname(nickname);
		operador.setSenha(senha);
		
		query = "select adm_login(?, ?);";
		stmt = conn.prepareStatement(query);
		stmt.setString(1, operador.getNickname());
		stmt.setString(2, operador.getSenha());
		rs = stmt.executeQuery();
		if(rs.next()){
				query = "SELECT id_operador, nickname, id_cargo, id_aluno, nmoperador FROM adm_operador WHERE id_operador = ?";
				stmt = conn.prepareStatement(query);
				stmt.setInt(1, rs.getInt(1));
				
				rs = stmt.executeQuery();
				
				if(rs.next()){
					operador.setId_operador(rs.getInt("id_operador"));
					operador.setNickname(rs.getString("nickname"));
					operador.setId_cargo(rs.getInt("id_cargo"));
					operador.setId_aluno(rs.getInt("id_aluno"));
					operador.setNmoperador(rs.getString("nmoperador"));
					
			        session.setAttribute("usuarioLogado", rs.getString("nmoperador")); //Adiciona o usuario na sessão
					
				}
		}
		
		stmt.close();
		rs.close();

		lista.add(operador);
		
		return lista;
		
	}
	public void ImportArquivo(String caminho, Pdg_DiarioArquivosVO arquivos) throws FileNotFoundException{
		
		File file = new File(caminho);
		 
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
		
	}
public void ExportArquivo(String caminho, Pdg_DiarioContVO conteudo) throws IOException{
	ByteArrayOutputStream bos = new ByteArrayOutputStream();	
	byte[] bytes = bos.toByteArray();
	 
    //below is the different part
    File someFile = new File(caminho);
    FileOutputStream fos = new FileOutputStream(someFile);
    fos.write(bytes);
    fos.flush();
    fos.close();
		
		
	}

}
