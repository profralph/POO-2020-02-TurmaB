package br.edu.imed;

//import java.util.*;

public class SistemaBancario {

	public static void main(String[] args) {
		
		//Scanner sc = new Scanner(System.in);
		
		Cliente titularConta = new Cliente();
		titularConta.nome = "Ana Maria";
		titularConta.cpf = "0129393";
		titularConta.rg = "323232";
		titularConta.endereco = "Rua A, Nr 0";
		
		ContaCorrente cc = new ContaCorrente();
		cc.numero = "001";
		cc.agencia = "123";
		cc.banco = "ACME";
		cc.saldo = 0d;
		cc.titular = titularConta;
		
		cc.sacar(80d);
		
		cc.titular.nome = "Ana Maria 2";
				
		System.out.println("O titular da conta nro: "+cc.numero+ " é: "+titularConta.nome);
		
		System.out.println("Saldo: "+cc.obterSaldo()+", saldo do cheque especial (limite): "+cc.saldoLimite);
		
		ContaCorrente cc2 = new ContaCorrente();
		cc2.agencia = "321";
		cc2.banco = "ACME";
		cc2.saldo = 0d;
		cc.titular = titularConta;
		
		//cc.transferir(200d, cc2);
		
		//System.out.println("Saldo da CC 1: "+cc.saldo+" e o saldo da CC 2: "+cc2.saldo);
		
		//cc.gerarExtrato();
		
		//Double saldoConta = cc.obterSaldo();
		
		//System.out.println("Saldo da conta "+saldoConta);
		
		ContaPoupanca cp = new ContaPoupanca();
		cp.agencia = "123";
		cp.banco = "ACME";
		cp.saldo = 0d;
		
		cp.depositar(10d);
		cp.depositar(20d);
		
		cp.render();
		
		//cp.sacar();
		
		//System.out.println("O saldo da conta poupança é de R$ "+cp.obterSaldo());
		
		/*int x = 0;
		
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
		}*/
	}
}
