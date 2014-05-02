package br.fafica.pi1.rightcode.exception;

public class FiltroNaoEncontradoException extends Exception{

	public FiltroNaoEncontradoException(){
		super("Filtro não encontrado!");
	}
	public FiltroNaoEncontradoException(int codigo){
		super("Filtro de código "+ codigo + " não encontrado!");
	}
	
}
