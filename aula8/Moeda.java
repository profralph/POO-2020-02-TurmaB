package vending;

public enum Moeda {

	CENTAVO(1),
	CINCO(5),
	DEZ(10),
	QUARTO(25);
	
	private int descricao;
	
	private Moeda(int desc) {
		this.descricao = desc;
	}

	public int getDescricao() {
		return descricao;
	}
}
