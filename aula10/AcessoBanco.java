package imed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AcessoBanco {

	public static void main(String[] args) {
		
		Connection con;
		
		try {
			
			String url = "jdbc:sqlite:C:\\TEMP\\imed.db";
			con = DriverManager.getConnection(url);
			System.out.println("Ok!");
			
			String sql = "SELECT nome, preco FROM produto";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				System.out.print(rs.getString("nome"));
				System.out.print(" ");
				System.out.println(rs.getDouble("preco"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
