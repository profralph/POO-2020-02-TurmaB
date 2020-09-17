package br.edu.imed;

public class ContaCorrente extends Conta {
	
	Double saldoLimite = 100d;
	Double valorJuros = 0d;
	Double taxaJuros = 1.015;
	
	
	public void cobrarJuros() {
		
		valorJuros += saldoLimite * taxaJuros;
	}
	
	/*
	 * Sobrescrita de método: mesma assinatura de um método da classe pai
	 * */
	public void sacar(Double valor) {
		
		historico.add("Saque de "+valor);
		
		if (valor > saldo) {
			
			if (valor > (saldoLimite + saldo)) {
				
				System.out.println("Valor solicitado ultrapassa o limite disponível.");
				
			} else {
			
				Double valorRestante = valor - saldo;
				saldoLimite -= valorRestante;
			}
		}
		
		if (saldo > 0) {
			
			saldo -= valor;
		}
	}
}
