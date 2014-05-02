package br.fafica.pi1.rightcode.usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;

public interface IRepositorioUsuario {
	
	public void TesteUsuario() throws SQLException;
	public void InstalarUsuario() throws SQLException;
	public void AdicionarUsuario(Usuario usuario) throws SQLException;
	public ArrayList<Usuario> ListaUsuario() throws SQLException, UsuariolistaVaziaException;
	public void RemoverUsuario(Usuario usuario) throws SQLException, UsuarioNaoEncontradoException;
	public Usuario BuscarUsuario(int codigo) throws SQLException, UsuarioNaoEncontradoException;
	public void EditarUsuario(Usuario usuario) throws UsuarioNaoEncontradoException, SQLException;
}
