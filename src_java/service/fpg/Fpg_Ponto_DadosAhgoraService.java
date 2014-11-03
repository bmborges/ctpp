package service.fpg;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import service.AbstractService;
import valueObjects.fpg.Fpg_Ponto_DadosAhgoraVO;

public class Fpg_Ponto_DadosAhgoraService extends AbstractService<Fpg_Ponto_DadosAhgoraVO>{

	public Fpg_Ponto_DadosAhgoraService() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		Fpg_Ponto_DadosAhgoraService s = new Fpg_Ponto_DadosAhgoraService();
		String linha = null;
		String sJson = "";
		
		try {
		      FileReader arq = new FileReader("C:\\Users\\bruno\\Desktop\\SistemaCtpp\\AFD00010000280001540.txt");
		      BufferedReader lerArq = new BufferedReader(arq);
		 
		      linha = lerArq.readLine();
		      while (linha != null) {
		    	sJson += linha;  
		        linha = lerArq.readLine();
		        
		      }
		 
		      arq.close();
		    } catch (IOException e) {
		        System.err.printf("Erro na abertura do arquivo: %s.\n",
		          e.getMessage());
		    }
		
		s.StringJson(sJson);
	}
	
	public void StringJson(String sJson) throws Exception{

		List lista = new ArrayList();
		
		  Object obj = JSONValue.parse(sJson);
		  JSONArray array=(JSONArray) obj;
		  if (array == null){
			  throw new Exception("Arquivo Inválido");
		  }
		  for (int i = 0; i < array.size(); i++) {
			  Fpg_Ponto_DadosAhgoraVO vo = new Fpg_Ponto_DadosAhgoraVO();
			  JSONObject obj2=(JSONObject)array.get(i);
			  System.out.println("Esse é o elemento número " + (i + 1));
			  System.out.println("Nome " +obj2.get("Nome"));
			  System.out.println("PIS " +obj2.get("PIS"));
			  System.out.println("Passwd " +obj2.get("Passwd"));
			  System.out.println("ID " +obj2.get("ID"));
			  System.out.println("CodBarras" +obj2.get("CodBarras"));
			  System.out.println("MiFareDado " +obj2.get("MiFareDado"));
			  System.out.println("BioDados " +obj2.get("BioDados"));
			  
			  vo.setId_parceiro(Integer.parseInt(obj2.get("ID").toString()));
			  
			  lista = this.select(vo, null, null);
			  vo.setBiodados(obj2.get("BioDados").toString());
			  vo.setPasswd(obj2.get("Passwd").toString());
			  vo.setCodbarras(obj2.get("CodBarras").toString());
			  vo.setMifare(obj2.get("MiFareDado").toString());
			  
			  if(lista.size() > 0){
				  this.atualizar(vo, null);
			  } else {
				  this.inserir(vo);
			  }
			
		  }
		  
		
	}
	
}
