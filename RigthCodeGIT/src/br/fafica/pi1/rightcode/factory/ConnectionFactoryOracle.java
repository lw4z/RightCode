package br.fafica.pi1.rightcode.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactoryOracle {

    private Connection connection = null;
   Statement statement = null;
    
	public Connection getConexao() throws SQLException{
		//Acrescentar password na String senha para acesso ao oracle
		//String senha = "linuxuser";
		//"jdbc:oracle:thin:@localhost:1521:xe", "lw4z","linuxuser"
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/TESTE", "root","");
		
                      
            /* boolean canConnect = false;
            Connection connection = null;
            Connection connection2 = null;
            try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RIGHTCODE", "root","");
            canConnect = true;
            }catch(Exception ex){
            canConnect = false;
            }
            
            if (!canConnect){
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root", "");
            statement = connection.createStatement();
            String sql = "CREATE DATABASE IF NOT EXISTS RIGHTCODE";
            //To delete database: sql = "DROP DATABASE DBNAME";
            statement.executeUpdate(sql);
            System.out.println("Database created!");
            connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/RIGHTCODE", "root","");
            return connection2;
            }else{
            return connection;
            }*/
                        
                        
                        
                      
		
		/*Connection conexao = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:xe", "system", senha);

		System.out.println("Conectado ao BD!");
		conexao.close();
		System.out.println("Desconectado do BD!");*/
	}

}

