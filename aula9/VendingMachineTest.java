package vending;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exception.EstoqueZeradoException;
import exception.TrocoInsuficienteException;

public class VendingMachineTest {

	private VendingMachine vm;
	
	@Before
	public void setUp() {
		
		vm = new VendingMachineImpl();
	}

	@After
	public void tearDown() {
		
		vm = null;
	}
		
	@Test
	public void comprarItemComPrecoExato() {
		
		//Seleciona o preço do item na máquina
		long preco = vm.selecionarItemEObterPreco(Item.SODA);
		
		//O preço é o mesmo da lista enumerada
		assertEquals(preco, Item.SODA.getPreco());
		
		vm.inserirMoeda(Moeda.QUARTO);
		vm.inserirMoeda(Moeda.DEZ);
		vm.inserirMoeda(Moeda.DEZ);
		Map<Item, List<Moeda>> troco = vm.obterItemETroco();
		Item item = (Item)troco.keySet().toArray()[0];
		List<Moeda> moedas = (List<Moeda>)troco.get(item);
		
		assertEquals(Item.SODA, item);
		assertTrue(moedas.isEmpty());	
	}
	
	@Test
	public void comprarItemComPrecoMaior() {
		
		//Seleciona o preço do item na máquina
		long preco = vm.selecionarItemEObterPreco(Item.SODA);
		
		//O preço é o mesmo da lista enumerada
		assertEquals(preco, Item.SODA.getPreco());
		
		vm.inserirMoeda(Moeda.QUARTO);
		vm.inserirMoeda(Moeda.QUARTO);
		vm.inserirMoeda(Moeda.QUARTO);
		
		Map<Item, List<Moeda>> troco = vm.obterItemETroco();
		Item item = (Item)troco.keySet().toArray()[0];
		List<Moeda> moedas = (List<Moeda>)troco.get(item);
		
		assertEquals(Item.SODA, item);
		assertTrue(!moedas.isEmpty());
		long esperado = 75 - Item.SODA.getPreco();
		long obtido = getValorTotal(moedas);
		assertEquals(esperado, obtido);
	}
	
	@Test
	public void testarDevolucao() {
		
		long preco = vm.selecionarItemEObterPreco(Item.PEPSI);
		assertEquals(preco, Item.PEPSI.getPreco());
		vm.inserirMoeda(Moeda.QUARTO);
		vm.inserirMoeda(Moeda.DEZ);
		vm.inserirMoeda(Moeda.CINCO);
		vm.inserirMoeda(Moeda.CENTAVO);
		assertEquals(41, getValorTotal(vm.resgatar()));
	}
	
	@Test(expected = EstoqueZeradoException.class)
	public void testarSemEstoque() {
		
		for (int i = 0; i < 6; i++) {
			vm.selecionarItemEObterPreco(Item.COCA);
			vm.inserirMoeda(Moeda.QUARTO);
			vm.obterItemETroco();
		}
	}
	
	@Test(expected = TrocoInsuficienteException.class)
	public void testarTrocoInsuficiente() {
		
		for (int i = 0; i < 5; i++) {
			vm.selecionarItemEObterPreco(Item.SODA);
			vm.inserirMoeda(Moeda.QUARTO);
			vm.inserirMoeda(Moeda.QUARTO);
			vm.obterItemETroco();
			vm.selecionarItemEObterPreco(Item.PEPSI);
			vm.inserirMoeda(Moeda.QUARTO);
			vm.inserirMoeda(Moeda.QUARTO);
			vm.obterItemETroco();
		}
	}
	
	private long getValorTotal(List<Moeda> moedas) {
		
		long total = 0;
		
		for (Moeda m : moedas) {
			total += m.getDescricao();
		}
		
		return total;
	}
}
