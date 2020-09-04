package br.edu.imed;

public class SistemaBancario {

	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente();
		cc.agencia = "123";
		cc.banco = "ACME";
		cc.saldo = 0d;
		cc.titular = "Fulano";
		
		cc.sacar(100d);
		cc.depositar(1200d);
		
		ContaCorrente cc2 = new ContaCorrente();
		cc2.agencia = "321";
		cc2.banco = "ACME";
		cc2.saldo = 0d;
		cc.titular = "Ana";
		
		cc.transferir(200d, cc2);
		
		System.out.println("Saldo da CC 1: "+cc.saldo+" e o saldo da CC 2: "+cc2.saldo);
		
		cc.gerarExtrato();
		
		int x = 0;
		
		switch(x) {
			
			case 1: 
				cc.sacar(10d);
				break;
			case 2: 
				cc.depositar(20d);
				break;
			case 3: 
				cc.transferir(30d, cc2);
				break;
			default:
				System.out.println("Saindo...");
		}
	}
}
