package br.fafica.pi1.rightcode.exception;

public class NaoCompiladoException extends Exception{
	public NaoCompiladoException(){
		super("Arquivo não compilado!");
	}
}
