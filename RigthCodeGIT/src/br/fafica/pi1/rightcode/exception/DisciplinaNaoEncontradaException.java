package br.fafica.pi1.rightcode.exception;

public class DisciplinaNaoEncontradaException extends Exception {
	
	public DisciplinaNaoEncontradaException(){
		super("Disciplina não encontra!");
	}
	
	public DisciplinaNaoEncontradaException(int codigo){
		super("Disciplina de código: "+ codigo + " não encontrada!");
	}

}
