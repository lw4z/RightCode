package br.fafica.pi1.rightcode.filtro;

import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;

public class RepositorioFiltroArrayList implements IRepositorioFiltro{
	
	private ArrayList <Filtro> filtros;
	
	public RepositorioFiltroArrayList(){
		filtros = new ArrayList <Filtro>();
		System.err.println("CONTRUTOR DE ARRAYLIST FILTRO");
	}
	
	private int getCodigoIncrement(){
		System.out.println("Filtro getCondigoIncrement esta com valor "+(filtros.size()+1));
		return (filtros.size()+1);
	}

	@Override
	public void TesteFiltro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void InstalarFiltro() {
		// TODO Auto-generated method stub
	}

	@Override
	public void AdicionarFiltro(Filtro filtro) {
		if(filtro.getCodigo() == 0) filtro.setCodigo(getCodigoIncrement());
		filtros.add(filtro);
		
		System.out.println("Adicionando filtro"); //linha temporaria
		
	}

	@Override
	public ArrayList<Filtro> ListaFiltro() throws FiltrolistaVaziaException {
		if(filtros.isEmpty()) throw new FiltrolistaVaziaException();
		return filtros;
	}

	@Override
	public void RemoverFiltro(Filtro filtro) {
		filtros.remove(filtro);
		
		System.out.println("Filtro "+filtro.getNome()+" Removido"); //Linha temporaria
		
	}

	@Override
	public Filtro BuscarFiltro(int codigo) throws FiltroNaoEncontradoException {
		Filtro busca = null;
		for(Filtro f : filtros){
			if(f.getCodigo() == codigo){
				busca = f;
				break;
			}
		}
		
		System.out.println("Busca filtro Ativa"); //Linha temporaria
		if(busca == null)throw new FiltroNaoEncontradoException();
		return busca;
	}

	@Override
	public void EditarFiltro(Filtro filtro) throws FiltroNaoEncontradoException {
		Filtro novo = BuscarFiltro(filtro.getCodigo());
		novo.setConteudo(filtro.getConteudo());
		
		System.out.println("Filtro "+filtro.getNome()+" Editado"); //Linha temporaria
	}

	
	
}
