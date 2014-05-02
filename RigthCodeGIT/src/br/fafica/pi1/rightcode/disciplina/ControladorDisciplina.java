package br.fafica.pi1.rightcode.disciplina;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.factory.DataSourceFactory;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import br.fafica.pi1.rightcode.factory.IFactory;

public class ControladorDisciplina {
	
	private DataSourceFactory dataSourceFactory;
	private IFactory dataSource;
	
	public ControladorDisciplina(){
		this.dataSourceFactory = new DataSourceFactory();
		this.dataSource = this.dataSourceFactory.getDataSource();
	}

	public void selectDataSourceDisciplina(DataSourceType type){
		dataSourceFactory.setType(type);
		dataSource = dataSourceFactory.getDataSource();
	}
	
	public void TesteDisciplina() throws SQLException {
		this.dataSource.getRepositorioDisciplina().TesteDisciplina();
		
	}

	public void InstalarDisciplina() throws SQLException {
		this.dataSource.getRepositorioDisciplina().InstalarDisciplina();
		
	}

	public void AdicionarDisciplina(Disciplina disciplina) throws SQLException, CodigoInvalidoException, NomeInvalidoException {
		if(disciplina.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else if(disciplina.getNome()==null || disciplina.getNome().equals("")){
			throw new NomeInvalidoException();
		}else{
			this.dataSource.getRepositorioDisciplina().AdicionarDisciplina(disciplina);
		}
		
		
	}

	public ArrayList<Disciplina> ListaDisciplina() throws SQLException,
			DisciplinaListaVaziaException {
		return this.dataSource.getRepositorioDisciplina().ListaDisciplina();
	}

	public void RemoverDisciplina(Disciplina disciplina) throws SQLException,
			DisciplinaNaoEncontradaException, CodigoInvalidoException {
		if(disciplina.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else{
			this.dataSource.getRepositorioDisciplina().RemoverDisciplina(disciplina);
		}
		
		
	}

	public Disciplina BuscarDisciplina(int codigo) throws SQLException,
			DisciplinaNaoEncontradaException, CodigoInvalidoException {
		if(codigo<0){
			throw new CodigoInvalidoException();
		}else{
			return this.dataSource.getRepositorioDisciplina().BuscarDisciplina(codigo);
		}
	}

	public void EditarDisciplina(Disciplina disciplina)
			throws DisciplinaNaoEncontradaException, SQLException, NomeInvalidoException, CodigoInvalidoException {
		if(disciplina.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else if(disciplina.getNome()==null || disciplina.getNome().equals("")){
			throw new NomeInvalidoException();
		}else{
			this.dataSource.getRepositorioDisciplina().EditarDisciplinas(disciplina);
		}
		
	}

}
