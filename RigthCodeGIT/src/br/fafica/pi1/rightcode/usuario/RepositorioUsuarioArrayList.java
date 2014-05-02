package br.fafica.pi1.rightcode.usuario;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;

public class RepositorioUsuarioArrayList implements IRepositorioUsuario {

	private ArrayList <Usuario>  usuarios;


	public RepositorioUsuarioArrayList(){
		usuarios = new ArrayList <Usuario> ();
		System.err.println("CONTRUTOR DE ARRAYLIST USUARIO");// Linha temporaria
	}
	
	private int getCodigoIncrement(){
		System.out.println("Usuario getCondigoIncrement esta com valor "+(usuarios.size()+1));
		return (usuarios.size()+1);
	}
	
	@Override
	public void TesteUsuario() {
		// Lembrete, N�o ha teste para ArrayList
		
	}

	@Override
	public void InstalarUsuario() {
		
	}
	@Override
	public void AdicionarUsuario(Usuario usuario) {
		if(usuario.getCodigo() == 0) usuario.setCodigo(getCodigoIncrement());
		usuarios.add(usuario);
		
		System.out.println("Usuario Adicionado no ArrayList"); //Linha temporaria
	}
	
	@Override
	public ArrayList<Usuario> ListaUsuario() throws UsuariolistaVaziaException {
		if(usuarios.isEmpty()) throw new UsuariolistaVaziaException(); 
		return usuarios;
	}

	@Override
	public void RemoverUsuario(Usuario usuario) {
		usuarios.remove(usuario);
		System.out.println("Usuario "+usuario.getNome()+" Removido"); //Linha temporaria
	}

	@Override
	public void EditarUsuario(Usuario usuario) throws UsuarioNaoEncontradoException {
		Usuario novo=BuscarUsuario(usuario.getCodigo());
		novo.setNome(usuario.getNome());
		novo.setDisciplinas(usuario.getDisciplinas());
		
		System.out.println("Usuario "+usuario.getNome()+" Editado"); //Linha temporaria
	}

	public Usuario BuscarUsuario(int codigo) throws UsuarioNaoEncontradoException {
		Usuario busca= null;
		for(Usuario u : usuarios){
			if(u.getCodigo() == codigo){
				busca = u;
				break;
			}
		}
		
		System.out.println("Busca Usuario Ativada"); //Linha temporaria
		
		if(busca == null) throw new UsuarioNaoEncontradoException();
		return busca;
	}
}