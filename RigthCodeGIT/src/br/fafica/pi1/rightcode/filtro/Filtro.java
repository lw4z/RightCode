package br.fafica.pi1.rightcode.filtro;

public class Filtro {
	
	private int codigo;
	private String nome;
	private String conteudo;
	private int codigo_usuario;
	
	public Filtro(String nome, String conteudo, int codigo_usuario){
		this.codigo = 0;
		this.nome = nome;
		this.conteudo = conteudo;
		this.codigo_usuario = codigo_usuario;
	}
	
	protected Filtro(int codigo, String nome, String conteudo, int codigo_usuario){
		this.codigo = codigo;
		this.nome = nome;
		this.conteudo = conteudo;
		this.codigo_usuario = codigo_usuario;
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

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getCodigo_usuario() {
		return codigo_usuario;
	}

	public void setCodigo_usuario(int codigo_usuario) {
		this.codigo_usuario = codigo_usuario;
	}
	
	public String toString(){
		return "Codigo_Filtro: "+this.codigo+"\nNome_Filtro: "+this.nome+"\nConteudo: "+this.conteudo+"\n";
	}
}
