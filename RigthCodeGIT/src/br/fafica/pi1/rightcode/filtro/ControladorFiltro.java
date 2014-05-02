package br.fafica.pi1.rightcode.filtro;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltroConteudoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.factory.DataSourceFactory;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import br.fafica.pi1.rightcode.factory.IFactory;

public class ControladorFiltro {
	
	private DataSourceFactory dataSourceFactory;
	private IFactory dataSource;
	
	public ControladorFiltro(){
		this.dataSourceFactory = new DataSourceFactory();
		this.dataSource = this.dataSourceFactory.getDataSource();
	}

	public void selectDataSourceFiltro(DataSourceType type){
		dataSourceFactory.setType(type);
		dataSource = dataSourceFactory.getDataSource();
	}
	
	public void TesteFiltro() throws SQLException {
		this.dataSource.getRepositorioFiltro().TesteFiltro();
		
	}

	public void InstalarFiltro() throws SQLException {
		this.dataSource.getRepositorioFiltro().InstalarFiltro();
		
	}

	public void AdicionarFiltro(Filtro filtro) throws SQLException, CodigoInvalidoException, FiltroConteudoInvalidoException, NomeInvalidoException {
		if(filtro.getCodigo()<0){
			throw new CodigoInvalidoException();
		}if(filtro.getNome() == null || filtro.getNome().equals("")){
			throw new NomeInvalidoException();
		}if(filtro.getConteudo()==null || filtro.getConteudo().equals("")){
			throw new FiltroConteudoInvalidoException();
		}else{
			this.dataSource.getRepositorioFiltro().AdicionarFiltro(filtro);
		}
		
		
	}

	public ArrayList<Filtro> ListaFiltro() throws SQLException,
			FiltrolistaVaziaException {
		return this.dataSource.getRepositorioFiltro().ListaFiltro();
	}

	public void RemoverFiltro(Filtro filtro) throws SQLException,
			FiltroNaoEncontradoException, CodigoInvalidoException {
		if(filtro.getCodigo()<0){
			throw new CodigoInvalidoException();
		}else{
			this.dataSource.getRepositorioFiltro().RemoverFiltro(filtro);
		}
		
		
	}

	public Filtro BuscarFiltro(int codigo) throws SQLException,
			FiltroNaoEncontradoException, CodigoInvalidoException {
		if(codigo<0){
			throw new CodigoInvalidoException();
		}else{
			return this.dataSource.getRepositorioFiltro().BuscarFiltro(codigo);
		}
	}

	public void EditarFiltro(Filtro filtro)
			throws FiltroNaoEncontradoException, SQLException, CodigoInvalidoException, FiltroConteudoInvalidoException, NomeInvalidoException {
		if(filtro.getCodigo()<0){
			throw new CodigoInvalidoException();
		}if(filtro.getNome() == null || filtro.getNome().equals("")){
			throw new NomeInvalidoException();
		}if(filtro.getConteudo()==null || filtro.getConteudo().equals("")){
			throw new FiltroConteudoInvalidoException();
		}else{
			this.dataSource.getRepositorioFiltro().EditarFiltro(filtro);
		}
		
	}

}

