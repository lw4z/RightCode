package br.fafica.pi1.rightcode.exception;

public class UsuarioNaoEncontradoException extends Exception {
	
	public UsuarioNaoEncontradoException(){
		super("Usuario não encontrado!");
	}
	
	public UsuarioNaoEncontradoException(int codigo){
		super("Usuario com Codigo "+codigo+" não encontrado!");
	}
}
