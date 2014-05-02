package br.fafica.pi1.rightcode.exception;

public class AlunoNaoEncontradoException extends Exception{

	public AlunoNaoEncontradoException(){
		super("Aluno não encontrado!");
	}
	
	public AlunoNaoEncontradoException(int codigo){
		super("Aluno com código " + codigo + " não encontrado!");
	}
}
