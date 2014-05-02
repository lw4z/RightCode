package br.fafica.pi1.rightcode.exception;

public class DisciplinaChaveEstrangeiraException extends Exception{

	public DisciplinaChaveEstrangeiraException(){
		super("Chave estrangeira da Disciplina = '0' (Invalido)!");
	}
}
