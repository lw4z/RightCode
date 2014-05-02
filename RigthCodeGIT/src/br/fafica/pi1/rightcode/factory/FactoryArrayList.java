package br.fafica.pi1.rightcode.factory;

import br.fafica.pi1.rightcode.aluno.IRepositorioAluno;
import br.fafica.pi1.rightcode.aluno.RepositorioAlunoArrayList;
import br.fafica.pi1.rightcode.disciplina.IRepositorioDisciplina;
import br.fafica.pi1.rightcode.disciplina.RepositorioDisciplinaArrayList;
import br.fafica.pi1.rightcode.filtro.IRepositorioFiltro;
import br.fafica.pi1.rightcode.filtro.RepositorioFiltroArrayList;
import br.fafica.pi1.rightcode.usuario.IRepositorioUsuario;
import br.fafica.pi1.rightcode.usuario.RepositorioUsuarioArrayList;


public class FactoryArrayList implements IFactory {
	
	private IRepositorioUsuario repositorioUsuario;
	private IRepositorioDisciplina repositorioDisciplina;
	private IRepositorioAluno repositorioAluno;
	private IRepositorioFiltro repositorioFiltro;

	@Override
	public IRepositorioUsuario getRepositorioUsuario() {
		if(this.repositorioUsuario == null)
			this.repositorioUsuario=new RepositorioUsuarioArrayList();
		return this.repositorioUsuario;
	}

	@Override
	public IRepositorioDisciplina getRepositorioDisciplina() {
		if(this.repositorioDisciplina == null)
			this.repositorioDisciplina=new RepositorioDisciplinaArrayList();
		return this.repositorioDisciplina;
	}

	@Override
	public IRepositorioAluno getRepositorioAluno() {
		if(this.repositorioAluno == null)
			this.repositorioAluno=new RepositorioAlunoArrayList();
		return this.repositorioAluno;
	}

	@Override
	public IRepositorioFiltro getRepositorioFiltro() {
		if(this.repositorioFiltro == null)
			this.repositorioFiltro=new RepositorioFiltroArrayList();
		return this.repositorioFiltro;
	}
}