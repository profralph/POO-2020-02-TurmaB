package br.edu.imed;

public class ControleEstoque {
	

	// O método "main" é o método procurado pela JRE para iniciar a aplicação
	public static void main(String[] args) {
		
		Produto prod = new Produto();
		
		prod.descricao = "Mouse de Computador";
		//prod.preco = 99.9;
		prod.fabricante = "ACME";
		
		prod.adicionarItem(1);
		//prod.adicionarItem(null);
		
		System.out.println("O produto "+prod.descricao + " tem "+prod.quantidadeEstoque+ " unidade(s) no estoque e custa "+prod.preco);
	}
	
}
 