package br.edu.imed;

import java.util.ArrayList;

public class ContaCorrente {

	String agencia;
	String banco;
	String numero;
	Double saldo;
	String titular;
	String dataAbertura;
	String dataFechamento;
	// Vetor dinâmico em Java: não é necessário indicar o tamanho no momento da instância
	ArrayList<String> historico = new ArrayList<String>();
		
	public void sacar(Double valor) {
		
		historico.add("Saque de "+valor);
		saldo -= valor;		
	}
	
	public void depositar(Double valor) {
		
		saldo += valor;
		historico.add("Depósito de "+valor);
	}
	
	public void transferir(Double valorTransferencia, ContaCorrente contaDestino) {
		
		sacar(valorTransferencia);
		contaDestino.depositar(valorTransferencia);
		System.out.println("Transferência realizada.");
		historico.add("Transferência de "+valorTransferencia);
	}
	
	public void gerarExtrato() {
		
		for (String registro : historico) {
			if (registro != null) {
				System.out.println(registro);
			}
		}
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
