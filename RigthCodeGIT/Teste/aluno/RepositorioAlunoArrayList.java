package br.fafica.pi1.rightcode.aluno;

import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;

public class RepositorioAlunoArrayList implements IRepositorioAluno{

	private ArrayList<Aluno> alunos;
	
	public RepositorioAlunoArrayList(){
		alunos = new ArrayList<Aluno>();
		System.err.println("CONTRUTOR DE ARRAYLIST ALUNO");
	}
	
	private int getCodigoIncrement(){
		System.out.println("Aluno getCondigoIncrement esta com valor "+(alunos.size()+1));
		return (alunos.size()+1);
	}

	@Override
	public void TesteAluno() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void InstalarAluno() {
		// TODO Auto-generated method stub
	}


	@Override
	public void AdicionarAluno(Aluno aluno) {
		if(aluno.getCodigo() == 0) aluno.setCodigo(getCodigoIncrement());
		alunos.add(aluno);
		
		System.out.println("Aluno adicionado"); //Linha temporaria
	}


	@Override
	public ArrayList<Aluno> ListaAluno() throws AlunolistaVaziaException{
		if(alunos.isEmpty())
			throw new AlunolistaVaziaException();
		return alunos;
	}


	@Override
	public void RemoverAluno(Aluno aluno) {
		alunos.remove(aluno);
		
		System.out.println("Aluno "+aluno.getNome()+" Removido"); //Linha temporaria
	}

	@Override
	public void EditarAluno(Aluno aluno) throws AlunoNaoEncontradoException {
		Aluno novo = BuscarAluno(aluno.getCodigo());
		novo.setNome(aluno.getNome());
		novo.setTurma(aluno.getTurma());
		
		System.out.println("Aluno "+aluno.getNome()+" Editado"); //Linha temporaria
	}
	
	@Override
	public Aluno BuscarAluno(int codigo) throws AlunoNaoEncontradoException {
		Aluno busca= null;
		for(Aluno a : alunos){
			if(a.getCodigo() == codigo){
				busca = a;
				break;
			}
		}
		
		System.out.println("Busca Aluno Ativa"); //Linha temporaria
		
		if(busca == null) throw new AlunoNaoEncontradoException();
		return busca;
	}

}
