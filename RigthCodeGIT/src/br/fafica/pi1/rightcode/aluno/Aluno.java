package br.fafica.pi1.rightcode.aluno;

public class Aluno {
	
	private int codigo;
	private String nome;
	private String turma;
	private int codigo_disciplina;
	
	public Aluno(String nome, String turma,int codigo_disciplina){
		this.codigo = 0;
		this.nome = nome;
		this.turma = turma;
		this.codigo_disciplina = codigo_disciplina;
	}
	
	protected Aluno(int codigo,String nome, String turma,int codigo_disciplina){
		this.codigo = codigo;
		this.nome = nome;
		this.turma = turma;
		this.codigo_disciplina = codigo_disciplina;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public int getCodigo_disciplina() {
		return codigo_disciplina;
	}

	public void setCodigo_disciplina(int codigo_disciplina) {
		this.codigo_disciplina = codigo_disciplina;
	}

	public String toString(){
			return "Codigo_Aluno: "+this.codigo+", Nome_Aluno: "+this.nome+", Turma_Aluno: "+this.turma+"\n";
	}
}
