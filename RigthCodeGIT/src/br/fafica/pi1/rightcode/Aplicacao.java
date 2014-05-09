package br.fafica.pi1.rightcode;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

//import br.fafica.pi1.rightcode.aluno.Aluno;
import br.fafica.pi1.rightcode.compilador.Compilador;
import br.fafica.pi1.rightcode.disciplina.Disciplina;
import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunoTurmaInvalidaException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
import br.fafica.pi1.rightcode.exception.CaminhoNaoEncontraException;
import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;
import br.fafica.pi1.rightcode.exception.FiltroConteudoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.exception.JavaException;
import br.fafica.pi1.rightcode.exception.NaoCompiladoException;
import br.fafica.pi1.rightcode.exception.NenhumArquivoCompiladoException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;
import br.fafica.pi1.rightcode.fachada.Fachada;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import br.fafica.pi1.rightcode.filtro.Filtro;
import br.fafica.pi1.rightcode.usuario.Usuario;

	public class Aplicacao {
		
		//Fachada
		private Fachada fachada;
		//Declaração de usuários
		private Usuario ADM;
		private Usuario usuario1;
		private Usuario usuario2;
		private Usuario usuario3;
		
		//Declara��o de disciplinas
		private Disciplina disciplina01;
		private Disciplina disciplina02;
		private Disciplina disciplina03;
		private Disciplina disciplina04;
		private Disciplina disciplina05;
		
		//Declaração de filtros
		private Filtro filtro1;
		private Filtro filtro2;
		private Filtro filtro3;
		private Filtro filtro4;
		
		//Declaração de Alunos
                /*private Aluno aluno1;
                private Aluno aluno2;
                private Aluno aluno3;
                private Aluno aluno4;
                private Aluno aluno5;
                private Aluno aluno6;
                private Aluno aluno7;
                private Aluno aluno8;
                private Aluno aluno9;
                private Aluno aluno10;
                private Aluno aluno11;
                private Aluno aluno;*/
		
		
		public Aplicacao(){
			fachada = Fachada.getInstancia();
			fachada.selectDataSource(DataSourceType.ORACLE);
		}
		
		//*****Metodo que sera Usado no main para iniciar a aplica��o******
		
		public void iniciarAplicacao() throws SQLException, CodigoInvalidoException, NomeInvalidoException, AlunoNaoEncontradoException, DisciplinaNaoEncontradaException, UsuarioNaoEncontradoException, DisciplinaListaVaziaException, AlunolistaVaziaException, UsuariolistaVaziaException, FiltrolistaVaziaException, FiltroNaoEncontradoException, JavaException, IOException, NaoCompiladoException, NenhumArquivoCompiladoException, AlunoTurmaInvalidaException, FiltroConteudoInvalidoException{
			
			//testeCompilador();
			//iniciar();

		}
	
		
		private void iniciar() throws SQLException, CodigoInvalidoException, NomeInvalidoException, AlunoNaoEncontradoException, 
		DisciplinaNaoEncontradaException, UsuarioNaoEncontradoException, DisciplinaListaVaziaException, AlunolistaVaziaException, UsuariolistaVaziaException, FiltrolistaVaziaException, FiltroNaoEncontradoException, AlunoTurmaInvalidaException, FiltroConteudoInvalidoException, JavaException, IOException, NaoCompiladoException, NenhumArquivoCompiladoException{
		
			//Instanciando a Fachada
			//******Selecionado o BD a ser utilizado atraves do metodo selectDataSoucer*********
			
			//"Teste de Conexão"
			
			fachada.TestConnectOracle();
			
			//*****instalar fonte de dados (ArrayList ou Oracle) "Iniciando com Valores Predefinicodos**************
			fachada.installDataSource();
			
			//Adicionar Objetos Usuario no seu Repositorio(Futuramente passando por controladores)
			this.ADM   = new Usuario("Administrador Padrão");
			this.usuario1 = new Usuario("Joao");
			this.usuario2 = new Usuario("Arnaldo");
			this.usuario3 = new Usuario("Carlos");
			fachada.AdicionarUsuario(ADM);
			fachada.AdicionarUsuario(usuario1);
			fachada.AdicionarUsuario(usuario2);
			fachada.AdicionarUsuario(usuario3);
			
			//BuscarUsuario para retornar o objeto Usuarios ja com codigo Incrementando
			this.ADM      = fachada.BuscarUsuario(1);
			this.usuario1 = fachada.BuscarUsuario(2);
			this.usuario2 = fachada.BuscarUsuario(3);
			this.usuario3 = fachada.BuscarUsuario(4);
			
			//Adicionar Objetos Filtro no seu Repositorio(Futuramente passando por controladores)
			this.filtro1 = new Filtro("main","main",ADM.getCodigo());
			this.filtro2 = new Filtro("Herança","extends",ADM.getCodigo());
			this.filtro3 = new Filtro("Abstato","abstract",ADM.getCodigo());
			this.filtro4 = new Filtro("Interface","interface",ADM.getCodigo());
			fachada.AdicionarFiltro(filtro1);
			fachada.AdicionarFiltro(filtro2);
			fachada.AdicionarFiltro(filtro3);
			fachada.AdicionarFiltro(filtro4);
			
			//Adicionar Objetos Disciplina no seu Repositorio(Futuramente passando por controladores)
			this.disciplina01 = new Disciplina("Programação 1","Introdução a Algoritmos",usuario1.getCodigo());
			this.disciplina02 = new Disciplina("Programação Orientada a Objetos 2","Introdução a Orientação a Objetos",usuario1.getCodigo());
			this.disciplina03 = new Disciplina("Programação 2", "Algoritmos Avançados",usuario2.getCodigo());
			this.disciplina04 = new Disciplina("Banco de Dados","Instru��es sobre banco de dados avançado",usuario3.getCodigo());
			this.disciplina05 = new Disciplina("Analise de Sistema","Instru��es de metodos para uma boa analise",usuario3.getCodigo());
			fachada.AdicionarDisciplina(disciplina01);
			fachada.AdicionarDisciplina(disciplina02);
			fachada.AdicionarDisciplina(disciplina03);
			fachada.AdicionarDisciplina(disciplina04);
			fachada.AdicionarDisciplina(disciplina05);
			
			//BuscarDisciplina para retornar o objeto Disciplina ja com codigo Incrementando
			this.disciplina01 = fachada.BuscarDisciplina(1);
			this.disciplina02 = fachada.BuscarDisciplina(2);
			this.disciplina03 = fachada.BuscarDisciplina(3);
			this.disciplina04 = fachada.BuscarDisciplina(4);
			this.disciplina05 = fachada.BuscarDisciplina(5);
			
			
			//Adicionar Objetos Aluno no seu Repositorio(Futuramente passando por controladores)
                        /*this.aluno1 = new Aluno("Jorge","1º período",disciplina01.getCodigo());
                        this.aluno2 = new Aluno("Maria","1º período",disciplina01.getCodigo());
                        this.aluno3 = new Aluno("Sebastião","2º período",disciplina02.getCodigo());
                        this.aluno4 = new Aluno("Manoel","2º período",disciplina02.getCodigo());
                        this.aluno5 = new Aluno("Carlos","4º Perído",disciplina04.getCodigo());
                        this.aluno6 = new Aluno("Jorge","6º Perído",disciplina05.getCodigo());
                        this.aluno7 = new Aluno("Regina","4º Perído",disciplina04.getCodigo());
                        this.aluno8 = new Aluno("Jackson","3º Perído",disciplina03.getCodigo());
                        this.aluno9 = new Aluno("Ivan","3º Perído",disciplina03.getCodigo());
                        this.aluno10 = new Aluno("Eduardo","3º Perído",disciplina03.getCodigo());
                        this.aluno11 = new Aluno("Guilherme","2º Perído",disciplina02.getCodigo());
                        fachada.AdicionarAluno(aluno1);
                        fachada.AdicionarAluno(aluno2);
                        fachada.AdicionarAluno(aluno3);
                        fachada.AdicionarAluno(aluno4);
                        fachada.AdicionarAluno(aluno5);
                        fachada.AdicionarAluno(aluno6);
                        fachada.AdicionarAluno(aluno7);
                        fachada.AdicionarAluno(aluno8);
                        fachada.AdicionarAluno(aluno9);
                        fachada.AdicionarAluno(aluno10);
                        fachada.AdicionarAluno(aluno11);*/
			
			
			//Remo��o dos Objetos dos Repositorios
			//Aluno a1 = fachada.BuscarAluno(5);
			//fachada.RemoverAluno(a1);
			Disciplina d1 = fachada.BuscarDisciplina(2);
			fachada.RemoverDisciplina(d1);
			Filtro f1 = fachada.BuscarFiltro(2);
			fachada.RemoverFiltro(f1);
			
			//Altera��o de Objetos
			
			Disciplina nova1 = fachada.BuscarDisciplina(4);
			nova1.setNome("Programacao Web");
			nova1.setDescricao("Metodo de programar para web");
			fachada.EditarDisciplinas(nova1);
			
			
			Usuario nova2 = fachada.BuscarUsuario(3);
			nova2.setNome("Gabriel Diniz");
			fachada.EditarUsuario(nova2);
			
			
			//Lista de todos os Objetos guardados em Repositorios
			
			for(Usuario u:fachada.ListaUsuario()){
				System.out.println(u+"\n");
			}
			
			for(Disciplina d:fachada.ListaDisciplina()){
				System.out.println(d+"\n");
			}
			
			for(Filtro f:fachada.ListaFiltro()){
				System.out.println(f+"\n");
			}
			
                        /*for(Aluno a:fachada.ListaAluno()){
                        System.out.println(a+"\n");
                        }*/
			
			
			
		}
                /*
                public void testeCompilador() throws JavaException, IOException{
                    ArrayList <Filtro> filtros = new ArrayList <>();
                    this.disicplina= disciplina;
                        this.filtro1 = new Filtro("main","main",0);
			this.filtro2 = new Filtro("Get","get",0);
			filtros.add(filtro1);
			filtros.add(filtro2);
			Compilador compiler = new Compilador(filtros, disciplina);
			try {
				compiler.Compilar("ProjectSingleton");
				//compiler.Compilar("ArquivosTeste");
			} catch (CaminhoNaoEncontraException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                }
                */
		
}

