package br.fafica.pi1.rightcode.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactoryOracle {

	public Connection getConexao() throws SQLException{
		//Acrescentar password na String senha para acesso ao oracle
		//String senha = "linuxuser";
		//"jdbc:oracle:thin:@localhost:1521:xe", "lw4z","linuxuser"
			return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "lw4z","linuxuser");
			
		
		
		/*Connection conexao = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", senha);

		System.out.println("Conectado ao BD!");
		conexao.close();
		System.out.println("Desconectado do BD!");*/
	}

}

