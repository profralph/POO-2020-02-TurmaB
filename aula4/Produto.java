package br.edu.imed;

/**
 * 
 * Classe de negócio (representa um conceito do mundo real para resolver um problema)
 *
 */
public class Produto {

	/* 
	 * Atributos: o que sabemos sobre a classe (objeto)
	 * 
	 * */
	String descricao;
	Double preco = 0d;
	String fabricante;
	// Integer: Wrapper para int
	Integer quantidadeEstoque = 0;
	
	/* 
	 * Métodos: o que a classe (objeto) faz
	 * 
	 * */
	public void adicionarItem(Integer quantidade) {
		
		quantidadeEstoque += quantidade;
	}
	
	public void removerItem(Integer quantidade) {
		
		quantidadeEstoque -= quantidade;
	}
	
	public Integer obterSaldoEstoque() {
		
		return quantidadeEstoque; 
	}
}
