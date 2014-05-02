package br.fafica.pi1.rightcode;

import java.io.IOException;
import java.sql.SQLException;

import br.fafica.pi1.rightcode.exception.AlunoNaoEncontradoException;
import br.fafica.pi1.rightcode.exception.AlunoTurmaInvalidaException;
import br.fafica.pi1.rightcode.exception.AlunolistaVaziaException;
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
import br.fafica.pi1.rightcode.telas.SplashRc;

public class Main {
	
	public static void main(String[] args) {

		SplashRc tela = new SplashRc();
        tela.setVisible(true);
/*		try {
                        Aplicacao app = new Aplicacao();
			app.iniciarAplicacao();
		} catch (SQLException | CodigoInvalidoException | NomeInvalidoException
				| AlunoNaoEncontradoException | FiltroConteudoInvalidoException
				| DisciplinaNaoEncontradaException
				| UsuarioNaoEncontradoException | DisciplinaListaVaziaException
				| AlunolistaVaziaException | UsuariolistaVaziaException
				| FiltrolistaVaziaException | FiltroNaoEncontradoException
				| JavaException | IOException | NaoCompiladoException
				| NenhumArquivoCompiladoException | AlunoTurmaInvalidaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
