package imed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ManterConexao {

	public static Connection criarConexaoBanco(Drivers d, String localizacao) {
		
		try {
			
			String url = d.getDriverName()+localizacao;
			Connection con = DriverManager.getConnection(url);
			System.out.println("Ok!");
			
			return con;
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void fecharConexao(Connection con) {
		
		try {
			
			con.close();
			
		} catch (SQLException e ) {
			
			e.printStackTrace();
		}
	}
}
