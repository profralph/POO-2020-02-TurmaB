package imed;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AcessoBanco {

	public static void main(String[] args) {
		
		Connection con;
		
		try {
			
			String url = "jdbc:sqlite:C:\\TEMP\\imed.db";
			con = DriverManager.getConnection(url);
			System.out.println("Ok!");
			
			String sql = "SELECT id_produto, nome, preco FROM produto";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			List<Produto> produtos = new ArrayList<>();
			
			while (rs.next()) {
				
				Produto p = new Produto(rs.getInt("id_produto"), rs.getString("nome"), rs.getDouble("preco"));
				//p.setId(rs.getInt("id_produto"));
				//p.setNome(rs.getString("nome"));
				//p.setPreco(rs.getDouble("preco"));
				
				produtos.add(p);
			}
			
			//System.out.println(produtos.get(0));
			
			sql = "SELECT id_pedido, vl_total FROM pedido";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Pedido p = new Pedido();
				p.setId(rs.getInt("id_pedido"));
				p.setValorTotal(rs.getDouble("vl_total"));
			}
			
			// ? => Placeholders (neles vamos inserir valores)
			String sqlInsert = "INSERT INTO produto(nome, preco) VALUES(?, ?) ";
			
			/*PreparedStatement pstmt = con.prepareStatement(sqlInsert);
			pstmt.setString(1, "Quadro");
			pstmt.setDouble(2, 99.2);
			pstmt.executeUpdate();
			System.out.println("Inserindo...");*/
			
			String sqlUpdate = "UPDATE produto SET preco = 12.5 WHERE id_produto = 3";
			stmt = con.createStatement();
			stmt.executeUpdate(sqlUpdate);
			
			String sqlDelete = "DELETE FROM produto WHERE id_produto = 4";
			stmt = con.createStatement();
			stmt.executeUpdate(sqlDelete);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}





