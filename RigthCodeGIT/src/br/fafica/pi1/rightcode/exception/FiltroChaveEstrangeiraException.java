package br.fafica.pi1.rightcode.exception;

public class FiltroChaveEstrangeiraException extends Exception{
	
	public FiltroChaveEstrangeiraException(){
		super("Chave estrangeira de Filtro = '0' (Invalido)!");
	}
	
}
