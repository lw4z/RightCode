package br.fafica.pi1.rightcode.filtro;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.factory.ConnectionFactoryOracle;

public class RepositorioFiltroOracle implements IRepositorioFiltro {
	
	private ConnectionFactoryOracle con;
	private Statement entrada;
	
	public RepositorioFiltroOracle(ConnectionFactoryOracle oracle){
		this.con = oracle;
	}
	
	private int getCodigoIncrement() throws SQLException{
		ArrayList<Filtro> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Filtro f;
		int codigo = 0;
		int contador; //auto incrementação reaproveitando numeros
		
		try {
			String sql1="select * from filtro";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Filtro>();
		    while ( resultado.next() ) {
		    	f = new Filtro(resultado.getInt("codigo_filtro"),resultado.getString("nome_filtro"),resultado.getString("conteudo_filtro"),resultado.getInt("codigo_usuario"));
		    	
		    	lista.add(f);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		
		while(true){ //auto incrementação reaproveitando numeros
			codigo++;
			contador = 0;
			for(Filtro obj : lista){
				if(obj.getCodigo() == codigo){
					contador++;
				}
			}
			if(contador == 0) break;
		}
		
		System.out.println("Filtro getCondigoIncrement esta com valor "+codigo);
		return codigo;
		
	}
	
	@Override
	public void TesteFiltro()throws SQLException{
		Connection con=null;
		con=this.con.getConexao();
		System.out.println("Conexão aberta. Testes temporários");
		con.close();
	}

	@Override
	public void InstalarFiltro() throws SQLException{
		Connection con = null;
		try {
		    String sql1 = "create table if not exists filtro" +
	                   "(codigo_filtro int(5) primary key ,"
	                   + "nome_filtro varchar(100) not null,"
	                   + "conteudo_filtro varchar(1000) not null,"
	                   + "codigo_usuario int(5),"
	                   + "foreign key(codigo_usuario) references usuario(codigo_usuario) on delete cascade)";
		   
			con = this.con.getConexao();
			entrada = con.createStatement();
		    entrada.execute(sql1);
		
		} finally{
		    entrada.close();
			con.close();
		}
	}

	@Override
	public void AdicionarFiltro(Filtro filtro)throws SQLException{
		Connection con = null;
		
		if(filtro.getCodigo() == 0) filtro.setCodigo(getCodigoIncrement());
		
		try {
			con = this.con.getConexao();
		    String sql = "insert into filtro (codigo_filtro, nome_filtro, conteudo_filtro, codigo_usuario) values (" +
		                   filtro.getCodigo() + ", " +"'"+filtro.getNome()+"',"+ 
		                   "'"+filtro.getConteudo()+"'," + filtro.getCodigo_usuario() + ")"; 
			entrada = con.createStatement();
			entrada.executeUpdate(sql);
			
			
		} finally {
			System.out.println("Filtro inserido na tabela"); // linha Temporaria
			entrada.close();
			con.close();
		}
		
	}

	@Override
	public ArrayList<Filtro> ListaFiltro() throws SQLException, FiltrolistaVaziaException {
		
		ArrayList<Filtro> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Filtro f;
		try {
			String sql1="select * from filtro";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Filtro>();
		    while ( resultado.next() ) {
		    	f = new Filtro(resultado.getInt("codigo_filtro"),resultado.getString("nome_filtro"),resultado.getString("conteudo_filtro"),resultado.getInt("codigo_usuario"));
		    	
		    	lista.add(f);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		if(lista.isEmpty()) throw new FiltrolistaVaziaException();
		return lista;
	}

	@Override
	public void RemoverFiltro(Filtro filtro)throws SQLException{
		Connection con=null;
		try {
			con = this.con.getConexao();
		    String sql = "delete from filtro where codigo_filtro=" +
		                   filtro.getCodigo();
		   	entrada = con.createStatement();
			entrada.executeUpdate(sql);
		}finally{
			
			System.out.println("Filtro "+filtro.getNome()+" Removido"); //Linha temporaria
			entrada.close();
			con.close();
		}
	}
		
	@Override
	public Filtro BuscarFiltro(int codigo)throws SQLException,FiltroNaoEncontradoException {
		Connection con=null;
		ResultSet resultado = null;
		Filtro f=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery( "select * from filtro where codigo_filtro=" + codigo);
			
		    while ( resultado.next() ) {
		    	
		    	int retornoCodigo = resultado.getInt("codigo_filtro");
		    	
		    	if(retornoCodigo>0)
		    		f = new Filtro(resultado.getInt("codigo_filtro"),resultado.getString("nome_filtro"),resultado.getString("conteudo_filtro"),resultado.getInt("codigo_usuario"));
		    	
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		if(f==null)
			throw new FiltroNaoEncontradoException();
			
			return f;
		
	}

	@Override
	public void EditarFiltro(Filtro filtro) throws SQLException, FiltroNaoEncontradoException {
		Connection con=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();

		    String sql = "update filtro SET " +
		    				"nome_filtro='"+ filtro.getNome()+"',"+
		    				"conteudo_filtro='"+ filtro.getConteudo()+"',"+
		    				"WHERE codigo_filtro=" + filtro.getCodigo(); 
			entrada.executeUpdate(sql);
			con.commit();
		    
		}finally{
			
			System.out.println("Filtro "+filtro.getNome()+" Editado"); //Linha temporaria
			entrada.close();
			con.close();
		}
	}
		
}
