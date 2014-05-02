package br.fafica.pi1.rightcode.disciplina;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;


public class RepositorioDisciplinaArrayList  implements IRepositorioDisciplina{
	private ArrayList <Disciplina> disciplinas;


	public RepositorioDisciplinaArrayList(){
		disciplinas = new ArrayList <> ();
		System.err.println("CONTRUTOR DE ARRAYLIST DISCIPLINA");
	}
	
	private int getCodigoIncrement(){
		System.out.println("Disciplina getCondigoIncrement esta com valor "+(disciplinas.size()+1));
		return (disciplinas.size()+1);
	}


	@Override
	public void TesteDisciplina() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void InstalarDisciplina() {
		// TODO Auto-generated method stub
	}


	@Override
	public void AdicionarDisciplina(Disciplina disciplina) {
		if(disciplina.getCodigo() == 0) disciplina.setCodigo(getCodigoIncrement());
		disciplinas.add(disciplina);
		
		System.out.println("Disciplina Adicionada");
		
	}


	@Override
	public void RemoverDisciplina(Disciplina disciplina) {
		disciplinas.remove(disciplina);
		
		System.out.println("Disciplina "+disciplina.getNome()+" Removida"); //Linha temporaria
	}


	@Override
	public Disciplina BuscarDisciplina(int codigo) throws DisciplinaNaoEncontradaException {
		Disciplina busca = null;
		for(Disciplina d : disciplinas){
			if(d.getCodigo() == codigo){ 
				busca = d;
				break;
			}
		}
		System.out.println("Busca Disciplina Ativa");
		if(busca == null)throw new DisciplinaNaoEncontradaException();
		return busca;
	}


	@Override
	public ArrayList<Disciplina> ListaDisciplina() throws DisciplinaListaVaziaException {
		if(disciplinas.isEmpty()) throw new DisciplinaListaVaziaException();
		return disciplinas;
	}

	//é necessário melhorias...
	@Override
	public void EditarDisciplinas(Disciplina disciplina)throws DisciplinaNaoEncontradaException{
			Disciplina novo = BuscarDisciplina(disciplina.getCodigo());
			novo.setNome(disciplina.getNome());
			novo.setDescricao(disciplina.getDescricao());
			
			System.out.println("Disciplina "+disciplina.getNome()+" Editada"); //Linha temporaria
		
	}

	


}
