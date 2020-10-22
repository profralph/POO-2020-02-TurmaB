package vending;

import java.util.HashMap;
import java.util.Map;

//Generics
public class Inventario<T> {
	
	// "chave" => "valor"
	// A chave é um item (moeda, item da máquina, etc.).
	// O valor é a quantidade presente na máquina em dado momento.
	private Map<T, Integer> inventario = new HashMap<T, Integer>();
	
	public int obterQuantidade(T item) {
		
		Integer valor = inventario.get(item);
		
		if (valor == null) {
			
			return 0;	
		}
		
		return valor;
	}
	
	public void adicionar(T item) {
		
		int contagemAtual = inventario.get(item);
		inventario.put(item, contagemAtual+1);
	}
	
	public void reduzir(T item) {
		
		if (temQuantidade(item)) {
			
			int contagemAtual = inventario.get(item);
			inventario.put(item, contagemAtual-1);			
		}
	}
	
	
	public boolean temQuantidade(T item) {
		
		if (obterQuantidade(item) > 0) {
			return true;
		} 
		
		return false;
	}
	
	public void limpar() {
		
		inventario.clear();
	}
	
	public void put(T item, int quantidade) {
		
		inventario.put(item, quantidade);
	}
}
