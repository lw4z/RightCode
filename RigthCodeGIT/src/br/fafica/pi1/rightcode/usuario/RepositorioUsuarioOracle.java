
package br.fafica.pi1.rightcode.usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;
import br.fafica.pi1.rightcode.factory.ConnectionFactoryOracle;

public class RepositorioUsuarioOracle implements IRepositorioUsuario {
	
	static ConnectionFactoryOracle con;
	static Statement entrada;
	
	public RepositorioUsuarioOracle(ConnectionFactoryOracle oracle){
		this.con=oracle;
	}
	
	private int getCodigoIncrement() throws SQLException{
		ArrayList<Usuario> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Usuario u; 
		int codigo = 0;
		int contador; //auto incrementação reaproveitando numeros
		
		try {
			String sql1="select * from usuario";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Usuario>();
		    while ( resultado.next() ) {
		    	u = new Usuario(resultado.getInt("codigo_usuario"),resultado.getString("nome_usuario"));
		    	
		    	lista.add(u);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		
		
		while(true){ //auto incrementação reaproveitando numeros
			codigo++;
			contador = 0;
			for(Usuario obj : lista){
				if(obj.getCodigo() == codigo){
					contador++;
				}
			}
			if(contador == 0) break;
		}
		
/*		if(lista.size() == 0) codigo = 1; //segunda tentativa de auto incremento de codigo
		
		else{
			codigo = (lista.get(lista.size() - 1).getCodigo() + 1);
		}*/
		
		System.out.println("Usuario getCondigoIncrement esta com valor "+codigo);
		
		return codigo;
	}

	@Override
	public void TesteUsuario() throws SQLException {
		Connection con=null;
		try {
			con = this.con.getConexao();
			System.out.println("Conexão aberta. testes temporario");//Excluir esse testes depois pois a exibi��o n�o pode ser aqui
		}finally{
			con.close();
		}
		
	}

	@Override
	public void InstalarUsuario() throws SQLException {
		Connection con = null;
		try {
                   
		    String sql1 = "create table if not exists usuario" +
	                   "(codigo_usuario int(5) primary key ," +
	                   "nome_usuario varchar(100) not null)";
		    			
			con = this.con.getConexao();
			entrada = con.createStatement();
		    entrada.execute(sql1);
		    
		} finally{
		    entrada.close();
			con.close();
		}
		
	}

	@Override
	public void AdicionarUsuario(Usuario usuario) throws SQLException {
		Connection con = null;
		
		if(usuario.getCodigo() == 0) usuario.setCodigo(getCodigoIncrement());
		
		try {
			con = this.con.getConexao();
		    String sql = "insert into usuario (codigo_usuario, nome_usuario) values (" +
		                   usuario.getCodigo() + ", " +
		                   "'" + usuario.getNome()+"')"; 
			entrada = con.createStatement();
			entrada.executeUpdate(sql);

		} finally {
			System.out.println("Usuario inserido na tabela"); // linha Temporaria
			entrada.close();
			con.close();
		}
		
	}
	
	@Override
	public ArrayList<Usuario> ListaUsuario() throws SQLException, UsuariolistaVaziaException {
		ArrayList<Usuario> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Usuario u;
		try {
			String sql1="select * from usuario";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Usuario>();
		    while ( resultado.next() ) {
		    	u = new Usuario(resultado.getInt("codigo_usuario"),resultado.getString("nome_usuario"));
		    	lista.add(u);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		if(lista.isEmpty()) throw new UsuariolistaVaziaException();
		
		return lista;
	}

	@Override
	public void RemoverUsuario(Usuario usuario) throws SQLException, UsuarioNaoEncontradoException {
		Connection con=null;
		try {
			con = this.con.getConexao();
		    String sql = "delete from usuario where codigo_usuario=" +
		                   usuario.getCodigo();
		    
			entrada = con.createStatement();
			entrada.executeUpdate(sql);
		}finally{
			System.out.println("Usuario "+usuario.getNome()+" Removido"); //Linha temporaria
			
			entrada.close();
			con.close();
		}
		
	}

	@Override
	public Usuario BuscarUsuario(int codigo) throws SQLException, UsuarioNaoEncontradoException {
		Connection con=null;
		ResultSet resultado = null;
		Usuario u=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery( "select * from usuario where codigo_usuario=" + codigo);
		    while ( resultado.next() ) {
		    	
		    	int retornoCodigo = resultado.getInt("codigo_usuario");
		    	if(retornoCodigo > 0) u = new Usuario(retornoCodigo, resultado.getString("nome_usuario"));
		    }
		}finally{
			System.out.println("Busca de usuario Ativada"); //Linha temporaria
			
			resultado.close();
			entrada.close();
			con.close();
		}
		
		if(u==null) throw new UsuarioNaoEncontradoException();
		
		return u;
	}

	@Override
	public void EditarUsuario(Usuario usuario)
			throws UsuarioNaoEncontradoException, SQLException {
		Connection con=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();

		    String sql = "update usuario SET " +
		    				"nome_usuario='" + usuario.getNome() + "'" +
		    				"WHERE codigo_usuario=" + usuario.getCodigo(); 
			entrada.executeUpdate(sql);
			con.commit();
			
		    
		}finally{
			System.out.println("Usuario "+usuario.getNome()+" 'Editado'"); //Linha temporaria
			entrada.close();
			con.close();
		}
		
	}

}
