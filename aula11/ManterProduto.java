package imed;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ManterProduto {

	public void inserirProduto(Connection con, Produto produto) {
		
		System.out.println("Inserindo...");
		
		String sqlInsert = "INSERT INTO produto(nome, preco) VALUES(?, ?) ";
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sqlInsert);
			pstmt.setString(1, produto.getNome());
			pstmt.setDouble(2, produto.getPreco());
			pstmt.executeUpdate();
		
		} catch (SQLException e ) {
			e.printStackTrace();
		}		
	}
	
	public void alterarProduto(Connection con, Produto produto) {
	
		String sqlUpdate = "UPDATE produto SET preco = ? WHERE id_produto = ?";
		
		try {
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlUpdate);
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}	
		
	}
	
	public void excluirProduto(Connection con, Produto produto) {
		
		String sqlDelete = "DELETE FROM produto WHERE id_produto = ?";
		
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlDelete);
		} catch (SQLException e ) {
			e.printStackTrace();
		}
	}
	
	public ResultSet selecionarProduto(Connection con) {
		
		String sql = "SELECT id_pedido, vl_total FROM pedido";
		
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			return rs;
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
		return null;
	}
}




