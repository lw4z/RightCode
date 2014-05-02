package br.fafica.pi1.rightcode.compilador;

import br.fafica.pi1.rightcode.aluno.Aluno;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
/*import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;*/
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

import br.fafica.pi1.rightcode.exception.NenhumArquivoCompiladoException;
import br.fafica.pi1.rightcode.filtro.Filtro;
import java.io.FileOutputStream;

public class CompilerFerramentas {

	private RepositorioResultado repositorioResultado;
	private ArrayList <Filtro> filtros;
	private Resultado resultado;
	private boolean nenhumaClasseCompilada;
	private Charset utf8 = StandardCharsets.UTF_8;
    private Aluno aluno;
	
	public CompilerFerramentas (ArrayList <Filtro> filtros,Aluno aluno){
            this.aluno=aluno;
            this.filtros = filtros;
            nenhumaClasseCompilada = true;
            repositorioResultado = new RepositorioResultado();
	}
	
	public CompilerFerramentas (){
		nenhumaClasseCompilada = true;
		repositorioResultado = new RepositorioResultado();
	}
	
	
			
	public boolean setArquivo(String caminho) throws IOException{
		//System.setProperty("java.home", "C:\\Program Files\\Java\\jdk1.7.0_40");
		String teste = "C:\\Program Files\\Java\\jdk"+System.getProperty("java.runtime.version").replaceAll("-b[0-9]{2}","");	
		String sistema = System.getProperty("os.name");  
	   
		if(!sistema.equals("Linux")){
			System.setProperty("java.home", teste);
		}
		
		JavaCompiler compilador = ToolProvider.getSystemJavaCompiler();
		File file = new File("Resultados/ErroCompilerFile.txt");
        file.createNewFile();
        FileOutputStream out=new FileOutputStream(file);
                
		int resposta = compilador.run(null, null, out, caminho);
		
		//Parte que pega o erro resultante
		Path path1 = Paths.get("Resultados/ErroCompilerFile.txt");
		BufferedReader r1 = Files.newBufferedReader(path1, utf8);
		String erro = "\n";
		String line = "";
		while((line = r1.readLine()) != null ){
			erro += line+"\n";
		}
		
		//parte que pega o arquivo completo e joga para uma String
		String arquivoCompleto = "";
		String linha;
		Path path2 = Paths.get(caminho);;
		BufferedReader r2 = Files.newBufferedReader(path2, utf8);
		while((linha = r2.readLine())!= null){
			linha = linha.trim();
			if(!linha.equals(""))
				arquivoCompleto += linha+" ";
		}
		arquivoCompleto = arquivoCompleto.trim();
		System.out.println(arquivoCompleto); //Linha temporaria
		
		
		if(resposta == 0){
			System.out.println(caminho+"Retornou True e o arquivo foi Compilado");
			resultado = new Resultado(caminho,true,erro,aluno);
			
			if(!filtros.isEmpty()){
				
				BuscaFiltro busca;
				
				for(Filtro filtro : filtros){
					
					busca = new BuscaFiltro();
					busca.setFiltro(filtro.getNome());
					
					busca.setBusca(arquivoCompleto.matches(filtro.getConteudo()));
					
					resultado.setBuscaFiltro(busca);
					
					
						/*numLinha +=1;
						if(linha.contains(filtro.getConteudo())){
							quant.setNumLinha(numLinha);
							System.out.println("Filtro "+filtro.getNome()+" encontrado na linha "+numLinha);
						}
					resultado.setArrayQuant(quant);
					System.out.println();*/
				}
			}
			System.err.println(resultado);
			repositorioResultado.setArquivoResultado(resultado);
			file.deleteOnExit();
			return true;
		}else{
			//System.out.println(caminho+"Retornou False e o arquivo não foi Compilado");
			resultado = new Resultado(caminho,false,erro,aluno);
			System.err.println(resultado);
			repositorioResultado.setArquivoResultado(resultado);
			file.deleteOnExit();
			return false;
		}
	}
	
	public void setDiretorio(String caminho) throws IOException{
		
		File diretorio = new File(caminho);
		
		String[] lista = diretorio.list();
		
		for(String arq : lista){
			
			File dir = new File(caminho+"/"+arq);
			if (dir.isDirectory())
				this.setDiretorio(caminho+"/"+arq);
			
			boolean resultado = (diretorio.getAbsolutePath()+"/"+arq).endsWith(".java");
			
			if(resultado == true){
				if(setArquivo(diretorio.getAbsolutePath()+"/"+arq)){
					nenhumaClasseCompilada = false;
				}
			}
		}
		
	}
	
	public void exceptionCompiler() throws NenhumArquivoCompiladoException{
		if(nenhumaClasseCompilada){
			throw new NenhumArquivoCompiladoException();
		}
	}
	
/*	public void getArquivo() throws IOException{
	String linha;
	
	Path path = Paths.get(c_arquivo);
	BufferedReader r = Files.newBufferedReader(path, utf8);
	while((linha = r.readLine())!= null){
		for(String filtro : filtros){
			if(linha.contains(filtro)){
				System.out.println("Filtro encontrado");
			}
		}
	}
}*/
	
	
/*	public void getDiretorio() throws IOException, NenhumArquivoCompiladoException{
		
		String linha;
		if(c_compilados != null){
			for(String arq : c_compilados){
				Path path = Paths.get(arq);
				BufferedReader r = Files.newBufferedReader(path, utf8);
				while((linha = r.readLine())!= null){
					for(String filtro : filtros){
						if(linha.contains(filtro)){
							System.out.println("Filtro '"+filtro+"' encontrado no arquivo:  "+arq);
						}
					}
				}
			}
		}else{
			throw new NenhumArquivoCompiladoException();
		}
	}*/
	
	
	
	
	
	
	
	
	
/*	public void getDiretorio() throws IOException{
		File diretorio = new File(c_diretorio);
		
		String linha;
		String[] lista = diretorio.list();
		
		
		for(String arq : lista){
			boolean resultado = (diretorio.getAbsolutePath()+"/"+arq).endsWith(".java");
			
			if(resultado == true){
				Path path = Paths.get(diretorio.getAbsolutePath()+"/"+arq);
				BufferedReader r = Files.newBufferedReader(path, utf8);
				while((linha = r.readLine())!= null){
					for(String filtro : filtros){
						if(linha.contains(filtro)){
							System.out.println("encontrado");
						}
					}
				}
			}
			
		}
		
	}*/
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
			/*public static void Compiler(String caminho){
				System.setProperty("Java.home","C:\\Program Files\\Java\\jdk.1.7.0_06");
				
				JavaCompiler compilador = ToolProvider.getSystemJavaCompiler();
				
				int resultado = compilador.run(null, null, null,caminho);
				
				if(resultado == 0){
					System.out.println("Compilação ocorrida com sucesso!");
				}else{
					System.out.println("Compilação falhou!");
				}
			}
			
			public static void BuscaMetodo(String caminho) throws MalformedURLException, ReflectiveOperationException{
				filtro.setConteudo(conteudo);
				
				Path path = Paths.get(caminho);
				
				URL[] urls = new URL[]{ new URL("file://"+caminho)};
				
				URLClassLoader ucl = new URLClassLoader(urls);
				
				String resultado = path.getParent()+"."+ path.getFileName();
				
				
						
				///Precisamos resolver o problema quanto a esse método
				
				System.out.println(caminho.getClass());
				
				resultado.endsWith(".java");
                String className = resultado.replace("src/", "").replace("/", ".").replace(".java", "");

            			
				Class clazz = ucl.loadClass(className);
				
				System.out.println("Class has been successfully loaded");
				
				Method method = clazz.getDeclaredMethod(filtro.getConteudo(), null);
				Object object = clazz.newInstance();
				method.invoke(object, null);
				
				System.out.println("Método encontrado!");
			}
*/
		
			
		


	}


