package br.fafica.pi1.rightcode.aluno;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;

public interface IRepositorioAluno {
	
	public void TesteAluno() throws SQLException;
	public void InstalarAluno() throws SQLException;
	public void AdicionarAluno(Aluno aluno) throws SQLException;
	public void RemoverAluno(Aluno aluno) throws SQLException, AlunoNaoEncontradoException;
	public ArrayList<Aluno> ListaAluno() throws AlunolistaVaziaException, SQLException;
	public Aluno BuscarAluno(int codigo) throws AlunoNaoEncontradoException, SQLException;
	public void EditarAluno(Aluno aluno) throws AlunoNaoEncontradoException, SQLException;

}
