package br.edu.imed;

import java.util.ArrayList;

public class ContaPoupanca {

	Cliente titular;
	String agencia;
	String banco;
	String numero;
	Double saldo;
	String dataAbertura;
	String dataFechamento;
	Double taxaReferenciaRendimento = 1.02;
	ArrayList<String> historico = new ArrayList<String>();
		
	public void sacar() {
		
		historico.add("Tentativa de Saque ");
		System.out.println("O saque nesse tipo de conta não é permitido. ");
	}
	
	public void render() {
		
		saldo = saldo * taxaReferenciaRendimento;
	}
	
	public void depositar(Double valor) {
		
		saldo += valor;
		historico.add("Depósito de "+valor);
	}
	
	public void transferir(Double valorTransferencia, ContaCorrente contaDestino) {
		
		//sacar(valorTransferencia);
		contaDestino.depositar(valorTransferencia);
		//System.out.println("Transferência realizada.");
		historico.add("Transferência de "+valorTransferencia);
	}
	
	public void gerarExtrato() {
		
		System.out.println("======== Gerando Extrato ========= ");
		
		// For each (sem indexador)
		for (String registro : historico) {			
			System.out.println(registro);
		}
	}
	
	public Double obterSaldo() {
		
		return saldo;
	}
	
	public void abrirConta() {
		
		dataAbertura = "03.09.2020";
		historico.add("Conta aberta no dia "+dataAbertura);
	}
	
	public void fecharConta() {
		
		dataFechamento = "03.09.2020";
		historico.add("Conta fechada no dia "+dataAbertura);
	}
}
