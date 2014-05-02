package br.fafica.pi1.rightcode.disciplina;
import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;
public interface IRepositorioDisciplina {
	
	public void TesteDisciplina() throws SQLException;
	public void InstalarDisciplina() throws SQLException;
	public void AdicionarDisciplina(Disciplina disciplina) throws SQLException;
	public void RemoverDisciplina(Disciplina disciplina) throws SQLException, DisciplinaNaoEncontradaException;
	public Disciplina BuscarDisciplina(int codigo) throws SQLException, DisciplinaNaoEncontradaException;
	public ArrayList <Disciplina> ListaDisciplina() throws DisciplinaListaVaziaException, SQLException;
	public void EditarDisciplinas(Disciplina disciplina)throws DisciplinaNaoEncontradaException, SQLException;
	
}
