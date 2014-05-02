package br.fafica.pi1.rightcode.compilador;

import java.util.ArrayList;

public class BuscaFiltro {
	private String filtro;
	private boolean busca;
	
	public BuscaFiltro(){
		
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	

	public boolean isBusca() {
		return busca;
	}

	public void setBusca(boolean busca) {
		this.busca = busca;
	}

	public String toString(){
		if(busca) return "Filtro '"+this.filtro+"' ENCONTRADO";
		
		else return "Filtro '"+this.filtro+"' NÃO ENCONTRADO";
	}
}
