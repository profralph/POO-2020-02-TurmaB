package exception;

public class EstoqueZeradoException extends RuntimeException {

	private String message;

	public EstoqueZeradoException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
