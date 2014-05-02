package br.fafica.pi1.rightcode.aluno;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunoTurmaInvalidaException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.factory.DataSourceFactory;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import br.fafica.pi1.rightcode.factory.IFactory;

public class ControladorAluno {
	
	private DataSourceFactory dataSourceFactory;
	private IFactory dataSource;
	
	public ControladorAluno(){
		this.dataSourceFactory = new DataSourceFactory();
		this.dataSource = this.dataSourceFactory.getDataSource();
	}

	public void selectDataSourceAluno(DataSourceType type){
		dataSourceFactory.setType(type);
		dataSource = dataSourceFactory.getDataSource();
	}
	public void TesteAluno() throws SQLException {
		this.dataSource.getRepositorioAluno().TesteAluno();
		
	}

	public void InstalarAluno() throws SQLException {
		this.dataSource.getRepositorioAluno().InstalarAluno();
		
	}

	public void AdicionarAluno(Aluno aluno) throws SQLException, CodigoInvalidoException, NomeInvalidoException, AlunoTurmaInvalidaException {
		if(aluno.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else if(aluno.getNome()==null || aluno.getNome().equals("")){
			throw new NomeInvalidoException();
		}else if(aluno.getTurma()==null || aluno.getTurma().equals("")){
			throw new AlunoTurmaInvalidaException();
		}else{
			this.dataSource.getRepositorioAluno().AdicionarAluno(aluno);
		}
		
		
	}

	public ArrayList<Aluno> ListaAluno() throws SQLException,
			AlunolistaVaziaException {
		return this.dataSource.getRepositorioAluno().ListaAluno();
	}

	public void RemoverAluno(Aluno aluno) throws SQLException,
			AlunoNaoEncontradoException, CodigoInvalidoException {
		if(aluno.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else{
			this.dataSource.getRepositorioAluno().RemoverAluno(aluno);
		}
		
		
	}

	public Aluno BuscarAluno(int codigo) throws SQLException,
			AlunoNaoEncontradoException, CodigoInvalidoException {
		if(codigo<0){
			throw new CodigoInvalidoException();
		}else{
			return this.dataSource.getRepositorioAluno().BuscarAluno(codigo);
		}
	}

	public void EditarAluno(Aluno aluno)
			throws AlunoNaoEncontradoException, SQLException, NomeInvalidoException, CodigoInvalidoException, AlunoTurmaInvalidaException {
		if(aluno.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else if(aluno.getNome()==null || aluno.getNome().equals("")){
			throw new NomeInvalidoException();
		}else if(aluno.getTurma()==null || aluno.getTurma().equals("")){
			throw new AlunoTurmaInvalidaException();
		}else{
			this.dataSource.getRepositorioAluno().EditarAluno(aluno);
		}
		
	}

}

