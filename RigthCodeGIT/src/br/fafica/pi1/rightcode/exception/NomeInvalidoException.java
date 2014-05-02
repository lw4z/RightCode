package br.fafica.pi1.rightcode.exception;

public class NomeInvalidoException extends Exception{
	
	public NomeInvalidoException(){
		super("Nome inválido!");
	}
	
	public NomeInvalidoException(String nome){
		super("Nome "+nome+" é inválido!");
	}
}
