package br.fafica.pi1.rightcode.compilador;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RepositorioResultado {
	private Path path = Paths.get("Resultados/ArquivoResultado.txt");
	//private File file = new File("Resultados/ArquivoResultado.txt");
	//private Resultado resultado;
	private Charset utf8 = StandardCharsets.UTF_8;
	
	
	public RepositorioResultado(){
/*		if(!file.exists()){
			try{
				BufferedWriter criar = Files.newBufferedWriter(path, utf8);
			}catch(IOException e){
				e.printStackTrace();
			}
		}*/
	}
	
	public void setArquivoResultado(Resultado resultado) throws IOException{
		
			try{
				BufferedWriter gravar = Files.newBufferedWriter(path, utf8, StandardOpenOption.APPEND); 
					
				gravar.write("\n"+resultado.toString());
				gravar.flush();
				gravar.close();
				
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	
	/*public void getArquivoResultado(File file) throws IOException{
		Path path = Paths.get(resultado.getCaminho());
		BufferedReader r = Files.newBufferedReader(path, utf8);
		String linha;
		
		}*/
}
