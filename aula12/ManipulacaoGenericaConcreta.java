package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManipulacaoGenericaConcreta implements ManipulacaoGenericaDados {

	private static final String localizacao = "C:\\TEMP\\imed.db";
	private Connection con;
	
	public ManipulacaoGenericaConcreta() {
		
		con = ManterConexao.criarConexaoBanco(Drivers.SQLITE, localizacao);
	}
	
	@Override
	public void inserir(Object t, String nomeTabela, String[] campos, String[] vals) {
		
		String sqlInsert = "INSERT INTO "+nomeTabela+"( ";
						
		for (int i=0; i<campos.length-1; i++) {
			
			sqlInsert += campos[i]+", ";
		}
		
		sqlInsert += campos[campos.length-1]+") ";
		sqlInsert += " VALUES( ";
		
		for (int i=0; i<vals.length-1; i++) {
			
			sqlInsert += "?, ";
		}
		
		sqlInsert += "? )";

		try {
									
			PreparedStatement pstmt = con.prepareStatement(sqlInsert);
			
			for (int i=0; i<vals.length; i++) {
								
				pstmt.setString(i+1, vals[i]);
			}
			
			pstmt.executeUpdate();
						
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Inserindo...");
		ManterConexao.fecharConexao(con);
	}

	@Override
	public void excluir(Object id) {
		
		String sqlDelete = "DELETE FROM ? WHERE ? ";
		
		try {
			
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sqlDelete);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
					
		ManterConexao.fecharConexao(con);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object buscar(Object id) {
		
		Object o = null;
		
		try {
			
			ManterConexao.fecharConexao(con);

			String sql = "SELECT ? FROM ? ";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				
				o = new Object();
				//Pedido p = new Pedido();
				//p.setId(rs.getInt("id_pedido"));
				//p.setValorTotal(rs.getDouble("vl_total"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
					
		ManterConexao.fecharConexao(con);
		
		return o;
	}

	@Override
	public void atualizar(Object t) {
		
		try {
			
			String sqlUpdate = "UPDATE ? SET ? WHERE ? ";
			Statement stmt = con.createStatement();
			//stmt.executeUpdate(sqlUpdate);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
					
		ManterConexao.fecharConexao(con);
	}

	
}
