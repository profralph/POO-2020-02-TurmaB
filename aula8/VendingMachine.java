package vending;

import java.util.List;

public interface VendingMachine {

	public long selecionarItemEObterPreco(Item item);
	public void inserirMoeda(Moeda moeda);
	public List<Moeda> resgatar();
	public void reiniciar();
}
