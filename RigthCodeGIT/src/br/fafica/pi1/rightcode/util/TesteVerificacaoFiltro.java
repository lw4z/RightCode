package br.fafica.pi1.rightcode.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TesteVerificacaoFiltro {
	
	private String caminho = "ArquivosTeste/Projeto_Teste_Singleton_1/src/br/edu/fafica/alunoum/Launch.java";
	private static String filtro = "if   , ( ,==  ,  null , )    ";
	private ArrayList <String> filtrosSeparados = new ArrayList<>();
	private Charset utf8 = StandardCharsets.UTF_8;
	private Path path = Paths.get(caminho);
	private static String arquivoString;
	private ArrayList <String> copiaArray = new ArrayList<>();
	//private static ArrayList <String> linhasArquivo = new ArrayList<>();

	public static void main(String[] args) {
		TesteVerificacaoFiltro t = new TesteVerificacaoFiltro();
		t.separarFiltro(filtro);
		try {
			t.preencherArquivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//por palavras
		//ArrayList <String> resultado = t.tokenPalavras(arquivoString);
		//por linha
		//ArrayList <String> resultado = t.tokenPalavras(linhasArquivo);
		
		
		
		
	}
	
	public void teste01(){
		
	}
	
	//Metodo Principal Para verificar (PRINCIPAL)
	public void verificacao(ArrayList <String> frases){
		
		for(String linha : frases){
				
		}
		
		//return false;
	}
	
	public void separarFiltro(String filtros){
		String[] array = filtros.split(",");
		for(String tirarEspaco : array){
			filtrosSeparados.add(tirarEspaco.trim());
			System.out.println("1� Ajustando Filtro: "+tirarEspaco.trim());
		}
	}
	

	

	public void preencherArquivo() throws IOException{
		BufferedReader r = Files.newBufferedReader(path, utf8);
		String linha = "";
		while((linha = r.readLine())!= null){
			arquivoString += linha;
		}
		
	}
	
	public ArrayList <String> tokenPalavras(String texto){
		ArrayList<String> tokin = new ArrayList<String>();
		ArrayList<String> retorno = new ArrayList<>();
		
		
		tokin.add("\\(");
		tokin.add("\\)");
		tokin.add("==");
		tokin.add("\\[");
		tokin.add("\\]");
		tokin.add("\\{");
		tokin.add("\\}");
		tokin.add("\\>");
		tokin.add("\\<");
		tokin.add("\\.");
		tokin.add("\\+");
		tokin.add("\\;");
		
		for(String t: tokin){
			texto= texto.replaceAll(t, " " + t + " ");
		}
		String [] arg = texto.split(" ");
		for(String p : arg){
			System.out.println("2� Teste PalavrasArquivo: "+p.trim());
			retorno.add(p.trim());
		}
		
		return retorno;
	}
	
	
	/*	public ArrayList <String> tokenLinhas(ArrayList <String> linhasArquivo){
	ArrayList<String> tokin = new ArrayList<String>();
	ArrayList<String> retorno = new ArrayList<>();
	
	
	tokin.add("\\(");
	tokin.add("\\)");
	tokin.add("==");
	tokin.add("\\[");
	tokin.add("\\]");
	tokin.add("\\{");
	tokin.add("\\}");
	tokin.add("\\>");
	tokin.add("\\<");
	tokin.add("\\.");
	tokin.add("\\+");
	tokin.add("\\;");
	
	for(String texto : linhasArquivo){
		for(String t: tokin){
			texto= texto.replaceAll(t, " " + t + " ");
		}
		retorno.add(texto.trim());
		System.out.println("2� Teste PalavrasArquivo: "+texto.trim());
	}
	
	
	String [] arg = texto.split(" ");
	for(String p : arg){
		System.out.println("2� Teste PalavrasArquivo: "+p.trim());
		retorno.add(p.trim());
	}
	
	return retorno;
}

public void preencherArquivo() throws IOException{
	BufferedReader r = Files.newBufferedReader(path, utf8);
	String linha = "";
	while((linha = r.readLine())!= null){
		linhasArquivo.add(linha);
	}
	
}*/
		

}
