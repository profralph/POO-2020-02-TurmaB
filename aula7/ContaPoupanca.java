package br.edu.imed;

public class ContaPoupanca extends Conta {

	Double taxaReferenciaRendimento = 1.02;
	
	
	public void render() {
		
		saldo = saldo * taxaReferenciaRendimento;
	}
}
