package br.fafica.pi1.rightcode.fachada;

import java.sql.SQLException;
import java.util.ArrayList;

import br.fafica.pi1.rightcode.aluno.Aluno;
import br.fafica.pi1.rightcode.aluno.ControladorAluno;
import br.fafica.pi1.rightcode.disciplina.ControladorDisciplina;
import br.fafica.pi1.rightcode.disciplina.Disciplina;
import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunoTurmaInvalidaException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
import br.fafica.pi1.rightcode.exception.CodigoInvalidoException;
import br.fafica.pi1.rightcode.exception.DisciplinaListaVaziaException;
import br.fafica.pi1.rightcode.exception.DisciplinaNaoEncontradaException;
import br.fafica.pi1.rightcode.exception.FiltroConteudoInvalidoException;
import br.fafica.pi1.rightcode.exception.FiltroNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.FiltrolistaVaziaException;
import br.fafica.pi1.rightcode.exception.NomeInvalidoException;
import br.fafica.pi1.rightcode.exception.UsuarioNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.UsuariolistaVaziaException;
import br.fafica.pi1.rightcode.factory.DataSourceType;
import br.fafica.pi1.rightcode.filtro.ControladorFiltro;
import br.fafica.pi1.rightcode.filtro.Filtro;
import br.fafica.pi1.rightcode.usuario.ControladorUsuario;
import br.fafica.pi1.rightcode.usuario.Usuario;

public class Fachada{
		
	//private static final String controladorFiltro = null;
	private static Fachada instancia;
	private ControladorFiltro controleFiltro;
	private ControladorUsuario controleUsuario;
	private ControladorDisciplina controleDisciplina;
	private ControladorAluno controleAluno;
	
	private Fachada(){
		controleUsuario = new ControladorUsuario();
		controleDisciplina = new ControladorDisciplina();
		controleFiltro = new ControladorFiltro();
		controleAluno = new ControladorAluno();
	}
	
	public static Fachada getInstancia(){
		if(instancia == null) instancia = new Fachada();
		return instancia;
	}
	
	public void TestConnectOracle() throws SQLException{
		this.controleUsuario.TesteUsuario();
		this.controleFiltro.TesteFiltro();
		this.controleDisciplina.TesteDisciplina();
		this.controleAluno.TesteAluno();
	}
	
	public void selectDataSource(DataSourceType type) {
		controleUsuario.selectDataSourceUsuario(type);
		controleDisciplina.selectDataSourceDisciplina(type);
		controleFiltro.selectDataSourceFiltro(type);
		controleAluno.selectDataSourceAluno(type);
		
	}
	
	public void installDataSource() throws SQLException{
		this.controleUsuario.InstalarUsuario();
		this.controleDisciplina.InstalarDisciplina();
		this.controleFiltro.InstalarFiltro();
		this.controleAluno.InstalarAluno();
	}

	public void InstalarAluno() throws SQLException {
		this.controleAluno.InstalarAluno();
	}

	public void AdicionarAluno(Aluno aluno) throws SQLException, CodigoInvalidoException, NomeInvalidoException, AlunoTurmaInvalidaException {
		this.controleAluno.AdicionarAluno(aluno);
		
	}

	public ArrayList<Aluno> ListaAluno() throws AlunolistaVaziaException, SQLException {
		return this.controleAluno.ListaAluno();
	}

	public void RemoverAluno(Aluno aluno) throws SQLException, AlunoNaoEncontradoException, CodigoInvalidoException {
		this.controleAluno.RemoverAluno(aluno);
	}

	public Aluno BuscarAluno(int codigo) throws AlunoNaoEncontradoException, SQLException, CodigoInvalidoException {
		return this.controleAluno.BuscarAluno(codigo);
	}

	public void EditarAluno(Aluno aluno) throws AlunoNaoEncontradoException, SQLException, CodigoInvalidoException {
		this.controleAluno.RemoverAluno(aluno);
	}

	public void InstalarFiltro() throws SQLException {
		this.controleFiltro.InstalarFiltro();
		
	}

	public void AdicionarFiltro(Filtro filtro) throws SQLException, CodigoInvalidoException, FiltroConteudoInvalidoException, NomeInvalidoException {
		this.controleFiltro.AdicionarFiltro(filtro);
		
	}

	public ArrayList<Filtro> ListaFiltro() throws SQLException, FiltrolistaVaziaException {
		return this.controleFiltro.ListaFiltro();
	}

	public void RemoverFiltro(Filtro filtro) throws SQLException, FiltroNaoEncontradoException, CodigoInvalidoException {
		this.controleFiltro.RemoverFiltro(filtro);
		
	}

	public Filtro BuscarFiltro(int codigo) throws SQLException, FiltroNaoEncontradoException, CodigoInvalidoException {
		return this.controleFiltro.BuscarFiltro(codigo);
	}

	public void EditarFiltro(Filtro filtro) throws FiltroNaoEncontradoException, SQLException, CodigoInvalidoException, FiltroConteudoInvalidoException, NomeInvalidoException {
		this.controleFiltro.EditarFiltro(filtro);
		
	}

	public void InstalarUsuario() throws SQLException {
		this.controleUsuario.InstalarUsuario();
	}

	public void AdicionarUsuario(Usuario usuario) throws SQLException, CodigoInvalidoException, NomeInvalidoException {
		this.controleUsuario.AdicionarUsuario(usuario);
		
	}

	public ArrayList<Usuario> ListaUsuario() throws SQLException, UsuariolistaVaziaException {
		return this.controleUsuario.ListaUsuario();
	}

	public void RemoverUsuario(Usuario usuario) throws SQLException, UsuarioNaoEncontradoException, CodigoInvalidoException {
		this.controleUsuario.RemoverUsuario(usuario);
		
	}

	public Usuario BuscarUsuario(int codigo) throws SQLException, UsuarioNaoEncontradoException, CodigoInvalidoException {
		return this.controleUsuario.BuscarUsuario(codigo);
	}

	public void EditarUsuario(Usuario usuario)throws SQLException, UsuarioNaoEncontradoException, NomeInvalidoException, CodigoInvalidoException {
		this.controleUsuario.EditarUsuario(usuario);
	}

	public void InstalarDisciplina() throws SQLException {
		this.controleDisciplina.InstalarDisciplina();
		
	}

	public void AdicionarDisciplina(Disciplina disciplina) throws SQLException, CodigoInvalidoException, NomeInvalidoException {
		this.controleDisciplina.AdicionarDisciplina(disciplina);
		
	}

	public void RemoverDisciplina(Disciplina disciplina) throws SQLException, DisciplinaNaoEncontradaException, CodigoInvalidoException {
		this.controleDisciplina.RemoverDisciplina(disciplina);
		
	}

	public Disciplina BuscarDisciplina(int codigo) throws SQLException, DisciplinaNaoEncontradaException, CodigoInvalidoException {
		return this.controleDisciplina.BuscarDisciplina(codigo);
	}

	public ArrayList<Disciplina> ListaDisciplina() throws DisciplinaListaVaziaException, SQLException {
		return this.controleDisciplina.ListaDisciplina();
	}

	public void EditarDisciplinas(Disciplina disciplina)
			throws DisciplinaNaoEncontradaException, SQLException, NomeInvalidoException, CodigoInvalidoException {
		this.controleDisciplina.EditarDisciplina(disciplina);
		
	}
	
}
