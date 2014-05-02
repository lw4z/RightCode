package br.fafica.pi1.rightcode.exception;

public class AlunoChaveEstrangeiraException extends Exception{
	
	public AlunoChaveEstrangeiraException(){
		super("Chave estrangeira de Aluno = '0' (Invalido)!");
	}
}
