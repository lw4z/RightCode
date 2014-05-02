package br.fafica.pi1.rightcode.aluno;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
import br.fafica.pi1.rightcode.factory.ConnectionFactoryOracle;

public class RepositorioAlunoOracle implements IRepositorioAluno {
	
	private ConnectionFactoryOracle con;
	private Statement entrada;
		
	public RepositorioAlunoOracle(ConnectionFactoryOracle oracle){
		this.con = oracle;
	}
	
	private int getCodigoIncrement() throws SQLException{
		ArrayList<Aluno> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Aluno a;
		int codigo = 0;
		int contador; //auto incrementação reaproveitando numeros
		
		try {
			String sql1="select * from aluno";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Aluno>();
		    while ( resultado.next() ) {
		    	a = new Aluno(resultado.getInt("codigo_aluno"),resultado.getString("nome_aluno"),resultado.getString("turma"),resultado.getInt("codigo_disciplina"));
		    	lista.add(a);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		
		while(true){ //auto incrementação reaproveitando numeros
			codigo++;
			contador = 0;
			for(Aluno obj : lista){
				if(obj.getCodigo() == codigo){
					contador++;
				}
			}
			if(contador == 0) break;
		}
		
		System.out.println("Aluno getCondigoIncrement esta com valor "+codigo);
		return codigo;
		
		
	}

	@Override
	public void TesteAluno() throws SQLException {
		Connection con=null;
		try {
			con = this.con.getConexao();
			System.out.println("Conexão aberta. testes temporario");//Excluir esse testes depois pois a exibi��o n�o pode ser aqui
		}finally{
			con.close();
		}
		
		
	}

	@Override
	public void InstalarAluno() throws SQLException{
		Connection con = null;
		try {
		    String sql1 = "create table aluno" +
	                   "(codigo_aluno number(5) primary key ," +
	                   "nome_aluno varchar2(100) not null ,"+
	                   "turma varchar2(50) not null,"
	                   + "codigo_disciplina number(5),"
	                   + "foreign key(codigo_disciplina) references disciplina(codigo_disciplina) on delete cascade)";
		    
			con = this.con.getConexao();
			entrada = con.createStatement();
		    entrada.execute(sql1);
		    
		} finally{
		    entrada.close();
			con.close();
		}
		
	}

	@Override
	public void AdicionarAluno(Aluno aluno)throws SQLException {
		Connection con = null;
		
		if(aluno.getCodigo() == 0)
			aluno.setCodigo(getCodigoIncrement());
		
		try {
			String sql;
			con = this.con.getConexao();
			sql = "insert into aluno (codigo_aluno, nome_aluno, turma, codigo_disciplina) values (" +
		                aluno.getCodigo() + ", " +
		                "'" + aluno.getNome()+"', " + "'" + aluno.getTurma() + "'," + aluno.getCodigo_disciplina()+")";
			
			entrada = con.createStatement();
			entrada.executeUpdate(sql);
			System.out.println("Aluno inserido na tabela"); // linha Temporaria
		} finally {
			System.out.println("Aluno adicionado"); //Linha temporaria
			entrada.close();
			con.close();
		}
	}

	@Override
	public ArrayList<Aluno> ListaAluno() throws AlunolistaVaziaException, SQLException {
		ArrayList<Aluno> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Aluno a;
		try {
			String sql1="select * from aluno";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Aluno>();
		    while ( resultado.next() ) {
		    	a = new Aluno(resultado.getInt("codigo_aluno"),resultado.getString("nome_aluno"),resultado.getString("turma"),resultado.getInt("codigo_disciplina"));
		    	lista.add(a);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		if(lista.isEmpty()) throw new AlunolistaVaziaException();

		return lista;
		
	}

	@Override
	public void RemoverAluno(Aluno aluno) throws SQLException, AlunoNaoEncontradoException {
		Connection con=null;
		try {
			con = this.con.getConexao();
		    String sql = "delete from aluno where codigo_aluno=" +
		                   aluno.getCodigo();
		   	entrada = con.createStatement();
			entrada.executeUpdate(sql);
		}finally{
			System.out.println("Aluno "+aluno.getNome()+" Removido"); //Linha temporaria
			entrada.close();
			con.close();
		}
	}

	@Override
	public Aluno BuscarAluno(int codigo) throws AlunoNaoEncontradoException, SQLException {
		Connection con=null;
		ResultSet resultado = null;
		Aluno a=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery( "select * from aluno where codigo_aluno=" + codigo);
			
		    while ( resultado.next() ) {
		    	int retonoCodigo = resultado.getInt("codigo_aluno");
		    	if(retonoCodigo>0) a = new Aluno(retonoCodigo,resultado.getString("nome_aluno"),resultado.getString("turma"),resultado.getInt("codigo_disciplina"));
		    	
		    }
		}finally{
			System.out.println("Busca Aluno Ativa"); //Linha temporaria
			resultado.close();
			entrada.close();
			con.close();
		}
		if(a==null) throw new AlunoNaoEncontradoException();
		
		return a;
	}

	@Override
	public void EditarAluno(Aluno aluno) throws AlunoNaoEncontradoException, SQLException {
		Connection con=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();

		    String sql = "update aluno SET " +
		    				"nome_aluno='" + aluno.getNome() + "'," +
		    				"turma='"+ aluno.getTurma() +"',"+
		    				"codigo_disciplina='"+ aluno.getCodigo_disciplina()+ "'"+
		    				"WHERE codigo_aluno=" + aluno.getCodigo(); 
			entrada.executeUpdate(sql);
			con.commit();
		    
		}finally{
			System.out.println("Aluno "+aluno.getNome()+" Editado"); //Linha temporaria
			entrada.close();
			con.close();
		}
	}



}
