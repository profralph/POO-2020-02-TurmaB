package br.edu.imed;

public class Cliente extends Pessoa {

	public static String arquivo = "cliente.txt";
	
	String rg;
	String endereco;
	Double salario;
	
	@Override
	public String toString() {
		
		return nome + ManipularArquivos.SEP + cpf + ManipularArquivos.SEP + rg + ManipularArquivos.SEP + endereco 
				+ ManipularArquivos.SEP + salario;  
	}
}
