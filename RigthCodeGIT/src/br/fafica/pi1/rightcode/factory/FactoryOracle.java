package br.fafica.pi1.rightcode.factory;

import br.fafica.pi1.rightcode.aluno.IRepositorioAluno;
import br.fafica.pi1.rightcode.aluno.RepositorioAlunoOracle;
import br.fafica.pi1.rightcode.disciplina.IRepositorioDisciplina;
import br.fafica.pi1.rightcode.disciplina.RepositorioDisciplinaOracle;
import br.fafica.pi1.rightcode.filtro.IRepositorioFiltro;
import br.fafica.pi1.rightcode.filtro.RepositorioFiltroOracle;
import br.fafica.pi1.rightcode.usuario.IRepositorioUsuario;
import br.fafica.pi1.rightcode.usuario.RepositorioUsuarioOracle;

public class FactoryOracle implements IFactory {
	
	private ConnectionFactoryOracle conexao;
	private IRepositorioUsuario repositorioUsuario;
	private IRepositorioDisciplina repositorioDisciplina;
	private IRepositorioAluno repositorioAluno;
	private IRepositorioFiltro repositorioFiltro;
	
	public FactoryOracle(){
		this.conexao = new ConnectionFactoryOracle();
	}

	@Override
	public IRepositorioUsuario getRepositorioUsuario() {
		if(this.repositorioUsuario == null)
			this.repositorioUsuario=new RepositorioUsuarioOracle(conexao);
		return this.repositorioUsuario;
	}

	@Override
	public IRepositorioDisciplina getRepositorioDisciplina() {
		if(this.repositorioDisciplina == null)
			this.repositorioDisciplina=new RepositorioDisciplinaOracle(conexao);
		return this.repositorioDisciplina;
	}

	@Override
	public IRepositorioAluno getRepositorioAluno() {
		if(this.repositorioAluno == null)
			this.repositorioAluno=new RepositorioAlunoOracle(conexao);
		return this.repositorioAluno;
	}

	@Override
	public IRepositorioFiltro getRepositorioFiltro() {
		if(this.repositorioFiltro == null)
			this.repositorioFiltro=new RepositorioFiltroOracle(conexao);
		return this.repositorioFiltro;
	}
}