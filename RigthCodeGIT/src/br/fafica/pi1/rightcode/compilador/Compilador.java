package br.fafica.pi1.rightcode.compilador;

import br.fafica.pi1.rightcode.aluno.Aluno;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.CaminhoNaoEncontraException;
import br.fafica.pi1.rightcode.exception.JavaException;
import br.fafica.pi1.rightcode.exception.NaoCompiladoException;
import br.fafica.pi1.rightcode.exception.NenhumArquivoCompiladoException;
import br.fafica.pi1.rightcode.filtro.Filtro;

public class Compilador {
	
	private ArrayList <Filtro> filtros = null;
	private CompilerFerramentas compiler;
	private File file;
        private Aluno aluno;
	
	public Compilador(ArrayList <Filtro> filtros,Aluno aluno){
		if(filtros == null){
			 compiler = new CompilerFerramentas(filtros,aluno);
		}else{
                    this.aluno=aluno;
                    this.filtros = filtros;
                    compiler = new CompilerFerramentas(filtros,aluno);
		}
	}
	
	public void Compilar(String caminho) throws CaminhoNaoEncontraException, JavaException, IOException {
		
		file = new File(caminho);
		if(file.exists()){
			System.out.println("Caminho localizado");
			if(file.isDirectory()){
				compiler.setDiretorio(caminho);
			}else{
				if(caminho.endsWith(".java")){
					compiler.setArquivo(caminho);
				}else{
					throw new JavaException();
				}
			}
		}else{
			throw new CaminhoNaoEncontraException();
		}
	}
	
	
}
