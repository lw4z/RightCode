package br.fafica.pi1.rightcode.exception;

public class CaminhoNaoEncontraException extends Exception{
	
	public CaminhoNaoEncontraException(){
		super("Local de arquivo ou diretorio não existe!");
	}

}
