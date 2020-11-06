package imed;

import java.sql.Connection;
import java.sql.DriverManager;
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
				
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome"));
				p.setPreco(rs.getDouble("preco"));
				
				produtos.add(p);
			}
			
			//System.out.println(produtos.get(0).getNome());
			
			sql = "SELECT id_pedido, vl_total FROM pedido";
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				Pedido p = new Pedido();
				p.setId(rs.getInt("id_pedido"));
				p.setValorTotal(rs.getDouble("vl_total"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
