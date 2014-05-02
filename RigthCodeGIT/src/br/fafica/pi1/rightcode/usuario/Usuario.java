package br.fafica.pi1.rightcode.usuario;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.disciplina.Disciplina;
import br.fafica.pi1.rightcode.filtro.Filtro;
public class Usuario {
	private int codigo;
	private String nome;
	private ArrayList <Disciplina> disciplinas ;
	private ArrayList <Filtro> filtros ;

	public Usuario(String nome){
		this.codigo=0;
		this.nome=nome;
		this.disciplinas = null;
		this.filtros = null;
		
	}
	
	protected Usuario(int codigo,String nome){
		this.codigo=codigo;
		this.nome=nome;
		this.disciplinas = null;
		this.filtros = null;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public void setDisciplina(Disciplina disciplina){
		if(disciplinas==null) disciplinas=new ArrayList<Disciplina>();
		this.disciplinas.add(disciplina);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public ArrayList<Filtro> getFiltros() {
		return filtros;
	}
	
	public void setFiltro(Filtro filtro) {
		if(filtros==null) filtros= new ArrayList<Filtro>();
		this.filtros.add(filtro);
	}

	public void setFiltros(ArrayList<Filtro> filtros) {
		this.filtros = filtros;
	}
	
/*	private String listarDisciplinas(){
		String guardar="";
		for (Disciplina element : disciplinas) {
			guardar += element;
		}
		return guardar;
	}
	
	private String listarFiltros(){
		String guardar="";
		for (Filtro element : filtros) {
			guardar += element;
		}
		return guardar;
	}*/
	
	public String toString() {
		//if(disciplinas==null && filtros==null){
			return  "\nCodigo: "+this.codigo+", Nome: " + this.nome;
/*		}else if(disciplinas!=null && filtros==null){
			return "Codigo_Usuario: "+this.codigo+" Nome_Usuario: " + this.nome+ "\n[Disciplinas] \n"+listarDisciplinas()+ "\n[Filtros] 'NÃ£o ha Filtros Cadrastrados'\n" ;
		}else if(disciplinas==null && filtros!=null){
			return "Codigo_Usuario: "+this.codigo+" Nome_Usuario: " + this.nome+ "\n[Disciplinas] 'NÃ£o ha Disciplinas Cadastradas'\n[Filtros] \n"+listarFiltros()+"\n";
		}else{
			return "Codigo_Usuario: "+this.codigo+" Nome_Usuario: " + this.nome+ "\n[Disciplinas] \n"+listarDisciplinas()+ "\n[Filtros] \n"+listarFiltros()+"\n";
		}*/
	}
	
	
}
