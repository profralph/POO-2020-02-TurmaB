package vending;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.EstoqueZeradoException;
import exception.PagamentoIncompletoException;
import exception.TrocoInsuficienteException;

public class VendingMachineImpl implements VendingMachine {

	private Inventario<Moeda> inventarioMoeda = new Inventario<Moeda>();
	private Inventario<Item> inventarioItem = new Inventario<Item>();
	private Item itemCorrente;
	private int balancoAtual;
	
	public static void main(String[] args) {
		
		VendingMachineImpl v = new VendingMachineImpl();
	}
	
	public VendingMachineImpl() {
		init();
	}
	
	private void init() {
		
		for (Moeda m : Moeda.values()) {
			
			inventarioMoeda.put(m, 10);
		}
		
		for (Item i : Item.values()) {
			
			inventarioItem.put(i, 5);
		}
	}
	
	@Override
	public long selecionarItemEObterPreco(Item item) {

		if (inventarioItem.temQuantidade(item)) {
			
			itemCorrente = item;
			return itemCorrente.getPreco();
		}
		
		throw new EstoqueZeradoException("O item selecionado está sem unidades no momento.");
	}

	@Override
	public void inserirMoeda(Moeda moeda) {
		
		balancoAtual = balancoAtual + moeda.getDescricao();
		inventarioMoeda.adicionar(moeda);
	}

	@Override
	public List<Moeda> resgatar() {

		List<Moeda> resgate = obterTroco(balancoAtual);
		atualizarInventarioMoeda(resgate);
		balancoAtual = 0;
		itemCorrente = null;
		
		return resgate;
	}
	
	@Override
	public Map<Item, List<Moeda>> obterItemETroco(){
		
		Item item = coletarItem();
		List<Moeda> troco = coletarTroco();
		
		balancoAtual = 0;
		itemCorrente = null;
		
		Map<Item, List<Moeda>> pedido = new HashMap<Item, List<Moeda>>();
		pedido.put(item, troco);
		
		return pedido;
	}
	
	private List<Moeda> coletarTroco(){
		
		int quantiaTroco = balancoAtual - itemCorrente.getPreco();
		List<Moeda> troco = obterTroco(quantiaTroco);
		atualizarInventarioMoeda(troco);
		
		return troco;
	}
	
	private Item coletarItem() {
		
		if (estaPago()) {
			
			if (temTrocoSuficiente()) {
				
				inventarioItem.reduzir(itemCorrente);
				
				return itemCorrente;
			}
			
			throw new TrocoInsuficienteException("Sem troco para o resgate do item");
		}
		
		int balancoRestante = itemCorrente.getPreco() - balancoAtual;
		throw new PagamentoIncompletoException("Faltou o seguinte valor para resgatar o item.", balancoRestante);
	}
	
	private boolean temTrocoSuficiente() {
		
		boolean temTroco = true;
		
		try {
			
			int quantiaAtual = balancoAtual - itemCorrente.getPreco();
			
			obterTroco(quantiaAtual);
			
		} catch (TrocoInsuficienteException e) {
			
			temTroco = false;
		}
		
		return temTroco;
	}
	
	private boolean estaPago() {
		
		if (balancoAtual >= itemCorrente.getPreco()) {
			return true;
		}
		
		return false;
	}
	
	private List<Moeda> obterTroco(int quantia){
		
		List<Moeda> troco = Collections.emptyList();
		
		if (quantia > 0) {
			
			troco = new ArrayList<Moeda>();
			
			int balanco = quantia;
			
			while (balanco > 0) {
				
				if (balanco >= Moeda.QUARTO.getDescricao() 
						&& inventarioMoeda.temQuantidade(Moeda.QUARTO)) {
					
					troco.add(Moeda.QUARTO);
					balanco = balanco - Moeda.QUARTO.getDescricao();
					
					continue;
					
				} else if (balanco >= Moeda.DEZ.getDescricao() 
						&& inventarioMoeda.temQuantidade(Moeda.DEZ)) {
					
					troco.add(Moeda.DEZ);
					balanco = balanco - Moeda.DEZ.getDescricao();
					
					continue;
					
				} else if (balanco >= Moeda.CINCO.getDescricao() 
						&& inventarioMoeda.temQuantidade(Moeda.CINCO)) {
					
					troco.add(Moeda.CINCO);
					balanco = balanco - Moeda.CINCO.getDescricao();
					
					continue;
					
				} else if (balanco >= Moeda.CENTAVO.getDescricao() 
						&& inventarioMoeda.temQuantidade(Moeda.CENTAVO)) {
					
					troco.add(Moeda.CENTAVO);
					balanco = balanco - Moeda.CENTAVO.getDescricao();
					
					continue;
					
				} else {
					
					throw new TrocoInsuficienteException("Não há troco suficiente para o retorno.");
				}
			}			
		}
		
		return troco;
	}
	
	private void atualizarInventarioMoeda(List<Moeda> moedas) {
		
		for (Moeda m : moedas) {
			
			inventarioMoeda.reduzir(m);
		}
	}

	@Override
	public void reiniciar() {
		
		inventarioItem.limpar();
		inventarioMoeda.limpar();
		itemCorrente = null;
		balancoAtual = 0;
	}

	
}
