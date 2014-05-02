package br.fafica.pi1.rightcode.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UtilArquivo {
	private Path path = Paths.get("Resultados/ArquivoResultado.txt");
	private File file = new File("Resultados/ArquivoResultado.txt");
	private Charset utf8 = StandardCharsets.UTF_8;
	
	public UtilArquivo(){	
	}
	
	public void deletarCriarArquvo(){
		try{
			BufferedWriter criar = Files.newBufferedWriter(path, utf8);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
