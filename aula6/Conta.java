package br.edu.imed;

import java.util.ArrayList;

/*
 * Classe que representa a generalização dos diferentes tipos de conta
 * abstract: recurso que impede a instanciação direta da classe (regra de negócio)
 * */
public abstract class Conta {

	Cliente titular;
	Gerente gerente;
	String agencia;
	String banco;
	String numero;
	Double saldo;
	String dataAbertura;
	String dataFechamento;
	ArrayList<String> historico = new ArrayList<String>();
	
	public void depositar(Double valor) {
		
		saldo += valor;
		historico.add("Depósito de "+valor);
	}
	
	public void sacar(Double valor) {
		
		System.out.println("Saque não autorizado.");
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
