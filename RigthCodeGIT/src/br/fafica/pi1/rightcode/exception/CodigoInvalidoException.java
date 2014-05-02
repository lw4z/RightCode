package br.fafica.pi1.rightcode.exception;

public class CodigoInvalidoException extends Exception{
	
	public CodigoInvalidoException(){
		super("Codigo Invalido!");
	}
	
	public CodigoInvalidoException(int codigo){
		super("Codigo "+codigo+" é Inválido!");
	}

}
