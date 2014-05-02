package br.fafica.pi1.rightcode.usuario;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;
import br.fafica.pi1.rightcode.factory.DataSourceFactory;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import br.fafica.pi1.rightcode.factory.IFactory;

public class ControladorUsuario{
	
	private DataSourceFactory dataSourceFactory;
	private IFactory dataSource;
	
	public ControladorUsuario(){
		//iniciando com o Fabrica (Factory) de ArrayList
		this.dataSourceFactory = new DataSourceFactory();
		this.dataSource = this.dataSourceFactory.getDataSource();
	}
	
	public void selectDataSourceUsuario(DataSourceType type) {
		dataSourceFactory.setType(type);
		dataSource = dataSourceFactory.getDataSource();
	}

	public void TesteUsuario() throws SQLException {
		this.dataSource.getRepositorioUsuario().TesteUsuario();
		
	}


	public void InstalarUsuario() throws SQLException {
		this.dataSource.getRepositorioUsuario().InstalarUsuario();
		
	}


	public void AdicionarUsuario(Usuario usuario) throws SQLException, CodigoInvalidoException, NomeInvalidoException {
		if(usuario.getCodigo()<0){
			throw new CodigoInvalidoException();
		}if(usuario.getNome()==null || usuario.getNome().equals("")){
			throw new NomeInvalidoException();
		}else{
			this.dataSource.getRepositorioUsuario().AdicionarUsuario(usuario);
		}
		
	}


	public ArrayList<Usuario> ListaUsuario() throws SQLException,
			UsuariolistaVaziaException {
		return this.dataSource.getRepositorioUsuario().ListaUsuario();
	}


	public void RemoverUsuario(Usuario usuario) throws SQLException,
			UsuarioNaoEncontradoException, CodigoInvalidoException {
		if(usuario.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else{
			this.dataSource.getRepositorioUsuario().RemoverUsuario(usuario);
		}
		
	}


	public Usuario BuscarUsuario(int codigo) throws SQLException,
			UsuarioNaoEncontradoException, CodigoInvalidoException {
		if(codigo<0){
			throw new CodigoInvalidoException();
		}else{
			return this.dataSource.getRepositorioUsuario().BuscarUsuario(codigo);
		}
	}


	public void EditarUsuario(Usuario usuario)
			throws UsuarioNaoEncontradoException, SQLException, NomeInvalidoException, CodigoInvalidoException {
		if(usuario.getCodigo()<0){
			throw new CodigoInvalidoException();
		}if(usuario.getNome()==null || usuario.getNome().equals("")){
			throw new NomeInvalidoException();
		}else{
			this.dataSource.getRepositorioUsuario().EditarUsuario(usuario);
		}
		
	}
	
	
	
	
	
/*	public ControladorUsuario(DataSourceType tipo,ConnectionFactoryOracle conexao){
		
	}

	public void TesteUsuario() throws SQLException {
		this.repositorioUsuario.TesteUsuario();
		
	}

	public void InstalarUsuario(boolean samples) throws SQLException {
		this.repositorioUsuario.InstalarUsuario(samples);
		
	}

	public void AdicionarUsuario(Usuario usuario) throws SQLException, CodigoInvalidoException, NomeInvalidoException {
		if(usuario.getCodigo()<1){
			throw new CodigoInvalidoException();
		}if(usuario.getNome()==null){
			throw new NomeInvalidoException();
		}else{
			this.repositorioUsuario.AdicionarUsuario(usuario);
		}
		
		
	}

	public ArrayList<Usuario> ListaUsuario() throws SQLException,
			listaUsuarioVaziaException {
		return this.repositorioUsuario.ListaUsuario();
	}

	public void RemoverUsuario(Usuario usuario) throws SQLException,
			UsuarioNaoEncontradoException, CodigoInvalidoException {
		if(usuario.getCodigo()<1){
			throw new CodigoInvalidoException();
		}else{
			this.repositorioUsuario.RemoverUsuario(usuario);
		}
		
		
	}

	public Usuario BuscarUsuario(int codigo) throws SQLException,
			UsuarioNaoEncontradoException, CodigoInvalidoException {
		if(codigo<1){
			throw new CodigoInvalidoException();
		}else{
			return this.repositorioUsuario.BuscarUsuario(codigo);
		}
	}

	public void EditarUsuario(Usuario usuario)
			throws UsuarioNaoEncontradoException, SQLException, NomeInvalidoException, CodigoInvalidoException {
		if(usuario.getCodigo()<1){
			throw new CodigoInvalidoException();
		}if(usuario.getNome()==null){
			throw new NomeInvalidoException();
		}else{
			this.repositorioUsuario.EditarUsuario(usuario);
		}
		
	}*/

}
