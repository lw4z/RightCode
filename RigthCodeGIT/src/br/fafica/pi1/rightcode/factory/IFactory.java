package br.fafica.pi1.rightcode.factory;

//import br.fafica.pi1.rightcode.aluno.IRepositorioAluno;
import br.fafica.pi1.rightcode.disciplina.IRepositorioDisciplina;
import br.fafica.pi1.rightcode.filtro.IRepositorioFiltro;
import br.fafica.pi1.rightcode.usuario.IRepositorioUsuario;


public interface IFactory {

	public abstract IRepositorioUsuario getRepositorioUsuario();
	public abstract IRepositorioDisciplina getRepositorioDisciplina();
	//public abstract IRepositorioAluno getRepositorioAluno();
	public abstract IRepositorioFiltro getRepositorioFiltro();

}