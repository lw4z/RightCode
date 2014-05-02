package br.fafica.pi1.rightcode.exception;

public class AlunoTurmaInvalidaException extends Exception{
	
	public AlunoTurmaInvalidaException(){
		super("Nome ou codigo da 'Turma' não foram informados corretamente!");
	}

}
