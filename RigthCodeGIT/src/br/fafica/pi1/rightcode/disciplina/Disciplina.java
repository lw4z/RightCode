package br.fafica.pi1.rightcode.disciplina;

import java.util.ArrayList;

import br.fafica.pi1.rightcode.aluno.Aluno;

public class Disciplina {
	private int codigo;
	private String nome;
	private String descricao;
	private int codigo_usuario;
	private ArrayList <Aluno> alunos;
	
	
	public Disciplina(String nome,String descricao, int codigo_usuario){
		this.codigo = 0;
		this.nome = nome;
		this.descricao = descricao;
		this.codigo_usuario = codigo_usuario;
		this.alunos = null;
		
	}
	
	protected Disciplina(int codigo,String nome,String descricao, int codigo_usuario){
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.codigo_usuario = codigo_usuario;
		this.alunos = null;
		
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome(){
		return this.nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public ArrayList<Aluno> getAlunos(){
		return alunos;
	}
	
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	public void setAluno(Aluno aluno){
		if(alunos==null) alunos = new ArrayList<Aluno>();
		this.alunos.add(aluno);
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}

/*	private String listarAlunos(){
		String guardar="";
		for (Aluno element : alunos) {
			guardar += element;
		}
		return guardar;
	}*/
	
	public String toString(){
		//if(alunos==null){
			return "Codigo_Disciplina: "+this.codigo+", Nome_Disciplina: "+this.nome+"\nDescriÃ§Ã£o_Disciplina: "+this.descricao+"\n";
/*		}else{
			return "Codigo_Disciplina: "+this.codigo+" Nome_Disciplina: "+this.nome+"\nDescriÃ§Ã£o_Disciplina: "+this.descricao+"\n[Alunos]\n"+listarAlunos()+"\n";
		}*/
	}
	

}
