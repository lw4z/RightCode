package br.fafica.pi1.rightcode.disciplina;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;
import br.fafica.pi1.rightcode.factory.ConnectionFactoryOracle;


public class RepositorioDisciplinaOracle implements IRepositorioDisciplina{
	
	private ConnectionFactoryOracle con;
	private Statement entrada;
	
	public RepositorioDisciplinaOracle(ConnectionFactoryOracle oracle){
		this.con = oracle;
	}
	
	private int getCodigoIncrement() throws SQLException{
		ArrayList<Disciplina> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Disciplina d;
		int codigo = 0;
		int contador; //auto incrementação reaproveitando numeros
		
		try {
			String sql1="select * from disciplina";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Disciplina>();
		    while ( resultado.next() ) {
		    	d = new Disciplina(resultado.getInt("codigo_disciplina"),resultado.getString("nome_disciplina"),resultado.getString("descricao_disciplina"),resultado.getInt("codigo_usuario"));
		    	
		    	lista.add(d);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		
		while(true){ //auto incrementação reaproveitando numeros
			codigo++;
			contador = 0;
			for(Disciplina obj : lista){
				if(obj.getCodigo() == codigo){
					contador++;
				}
			}
			if(contador == 0) break;
		}
		
		
		System.out.println("Disciplina getCondigoIncrement esta com valor "+codigo);
		return codigo;
		
	}

	@Override
	public void TesteDisciplina() throws SQLException {
		Connection con=null;
		try {
			con = this.con.getConexao();
			System.out.println("Conexão aberta. testes temporario");//Excluir esse testes depois pois a exibi��o n�o pode ser aqui
			
		//} catch (SQLException e) {
		//	throw new SQLException();
		}finally{
			con.close();
		}
	}

	@Override
	public void InstalarDisciplina() throws SQLException {
			Connection con = null;
			try {
			    String sql1 = "create table disciplina" +
		                   "(codigo_disciplina number(5) primary key ," +
		                   "nome_disciplina varchar2(50) not null," +
		                   "descricao_disciplina varchar2(100),"
		                   + "codigo_usuario number(5),"
		                   + "foreign key(codigo_usuario) references usuario(codigo_usuario) on delete cascade)";
			    
			    
				con = this.con.getConexao();
				entrada = con.createStatement();
			    entrada.execute(sql1);
			    System.out.println("Tabela Disciplina Criada");
			    
			   /* con = this.con.getConexao();
				entrada = con.createStatement();
			    entrada.execute(sql2);
			    System.out.println("Tabela disciplina_possue_alunos Criada");*/
			} finally{
			    entrada.close();
				con.close();
			}
		
	}

	@Override
	public void AdicionarDisciplina(Disciplina disciplina) throws SQLException {
		Connection con = null;
		
		if(disciplina.getCodigo() == 0) disciplina.setCodigo(getCodigoIncrement());
		
		try {
			con = this.con.getConexao();
		    String sql = "insert into disciplina (codigo_disciplina, nome_disciplina, descricao_disciplina, codigo_usuario) values (" +
		                   disciplina.getCodigo() + ", " +
		                   "'" + disciplina.getNome()+"','"+ disciplina.getDescricao() +"',"+ disciplina.getCodigo_usuario() +")"; 
			entrada = con.createStatement();
			entrada.executeUpdate(sql);
			
			
		} finally {
			System.out.println("Aluno inserido na tabela"); // linha Temporaria
			entrada.close();
			con.close();
		}
		
	}

	@Override
	public void RemoverDisciplina(Disciplina disciplina) throws SQLException,DisciplinaNaoEncontradaException {
		Connection con=null;
		try {
			con = this.con.getConexao();
		    String sql = "delete from disciplina where codigo_disciplina=" +
		                   disciplina.getCodigo();
		    //LEMBRETE.: Verificar alguma maneira para se deletar o usuario deletado da tabela disciplina_possue_alunos
			entrada = con.createStatement();
			entrada.executeUpdate(sql);
		}finally{
			System.out.println("Disciplina "+disciplina.getNome()+" Removida"); //Linha temporaria
			entrada.close();
			con.close();
		}
		
	}

	@Override
	public Disciplina BuscarDisciplina(int codigo) throws SQLException, DisciplinaNaoEncontradaException {
		Connection con=null;
		ResultSet resultado = null;
		Disciplina d=null;
		try {
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery( "select * from disciplina where codigo_disciplina=" + codigo);
			//LEMBRETE. Organizar para retornar os usuarios tambem
		    while ( resultado.next() ) {
		    	int retornoCodigo = resultado.getInt("codigo_disciplina");
		    	
		    	if(retornoCodigo>0)
		    	d = new Disciplina(retornoCodigo,resultado.getString("nome_disciplina"),resultado.getString("descricao_disciplina"),resultado.getInt("codigo_usuario"));
		    }
		}finally{
			System.out.println("Busca Disciplina Ativa"); //Linha temporaria
			resultado.close();
			entrada.close();
			con.close();
		}
		if(d==null)
			throw new DisciplinaNaoEncontradaException();

			return d;
	}

	@Override
	public ArrayList<Disciplina> ListaDisciplina() throws DisciplinaListaVaziaException, SQLException {
		ArrayList<Disciplina> lista = null;
		Connection con=null;
		ResultSet resultado = null;
		Disciplina d;
		try {
			String sql1="select * from disciplina";
			con = this.con.getConexao();
			con.setAutoCommit(false);
			entrada = con.createStatement();
			
			resultado = entrada.executeQuery(sql1);
			
			lista= new ArrayList<Disciplina>();
		    while ( resultado.next() ) {
		    	d = new Disciplina(resultado.getInt("codigo_disciplina"),resultado.getString("nome_disciplina"),resultado.getString("descricao_disciplina"),resultado.getInt("codigo_usuario"));
		    	
		    	lista.add(d);
		    }
		}finally{
			resultado.close();
			entrada.close();
			con.close();
		}
		if(lista.isEmpty()) throw new DisciplinaListaVaziaException();
			
		return lista;
		
	}

	@Override
	public void EditarDisciplinas(Disciplina disciplina)
			throws DisciplinaNaoEncontradaException, SQLException {
				Connection con=null;
				try {
					con = this.con.getConexao();
					con.setAutoCommit(false);
					entrada = con.createStatement();

				    String sql = "update disciplina SET " +
				    				"nome_disciplina='" + disciplina.getNome() + "'," +
				    				"descricao_disciplina='" + disciplina.getDescricao() + "',"+
				    				"codigo_usuario='" + disciplina.getCodigo_usuario() + "'"+
				    				"WHERE codigo_disciplina=" + disciplina.getCodigo(); 
					entrada.executeUpdate(sql);
					con.commit();
				    
				}finally{
					System.out.println("Disciplina "+disciplina.getNome()+" Editado"); //Linha temporaria
					entrada.close();
					con.close();
				}
	}
}
