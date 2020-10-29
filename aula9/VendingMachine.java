package vending;

import java.util.List;
import java.util.Map;

public interface VendingMachine {

	public long selecionarItemEObterPreco(Item item);
	public void inserirMoeda(Moeda moeda);
	public List<Moeda> resgatar();
	public void reiniciar();
	public Map<Item, List<Moeda>> obterItemETroco();
}
