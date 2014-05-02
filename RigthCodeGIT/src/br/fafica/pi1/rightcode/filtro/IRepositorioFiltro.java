package br.fafica.pi1.rightcode.filtro;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;

public interface IRepositorioFiltro {
		
	public void TesteFiltro()throws SQLException;
	public void InstalarFiltro()throws SQLException;
	public void AdicionarFiltro(Filtro filtro)throws SQLException;
	public ArrayList<Filtro> ListaFiltro()throws SQLException, FiltrolistaVaziaException;
	public void RemoverFiltro(Filtro filtro)throws SQLException;
	public Filtro BuscarFiltro(int codigo)throws SQLException, FiltroNaoEncontradoException;
	public void EditarFiltro(Filtro filtro)throws FiltroNaoEncontradoException,SQLException;
	
}
