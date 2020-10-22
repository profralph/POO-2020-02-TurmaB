package vending;

public class PagamentoIncompletoException extends RuntimeException {

	private String message;
	private int valorFaltante;
	
	public PagamentoIncompletoException(String message, int valorFaltante) {
		
		this.message = message;
		this.valorFaltante = valorFaltante;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public int getValorFaltante() {
		return valorFaltante;
	}
}
