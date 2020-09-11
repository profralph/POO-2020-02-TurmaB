package br.edu.imed;

import java.util.ArrayList;

public class ContaCorrente {

	Cliente titular;
	String agencia;
	String banco;
	String numero;
	Double saldo;
	String dataAbertura;
	String dataFechamento;
	Double saldoLimite = 100d;
	// Vetor dinâmico em Java: não é necessário indicar o tamanho no momento da instância
	// À esquerda do sinal de "=" é a declaração, a variável passa a existir. 
	// À direita do sinal de "=" é a instância (materialização do objeto)
	ArrayList<String> historico = new ArrayList<String>();
	
	//Vetor estático em Java
	//String[] historicoEstatico = new String[100];
	
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
	
	public void depositar(Double valor) {
		
		saldo += valor;
		historico.add("Depósito de "+valor);
	}
	
	public void transferir(Double valorTransferencia, ContaCorrente contaDestino) {
		
		sacar(valorTransferencia);
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
		
		// For tradicional
		/*for (int i=0; i<historico.size(); i++) {
			
			String registro = historico.get(i);
			System.out.println(registro);
		}*/
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
