package br.edu.imed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManipulaArquivos {
	
	public static void main(String[] args) {
		
		String dir = System.getProperty("user.home");		
		//System.out.println(dir);
		
		String arquivo = "meuarquivo.txt";
		String caminhoAbsoluto = dir + File.separator + arquivo;
		
		Cliente c1 = new Cliente();
		c1.setId(1);
		c1.setNome("Ana Maria");
		c1.setEndereco("Av 123, Nr 456");
		Cliente c2 = new Cliente(2, "Bruno Silva");
		c2.setEndereco("Av ABC, Nr 789");
		
		try (FileWriter fw = new FileWriter(caminhoAbsoluto, false);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw)){
			
			out.println(c1);
			out.println(c2);
			
		} catch (IOException e) { // checked exception: obrigatório tratar no código
			
			e.printStackTrace();
		}
		
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminhoAbsoluto))){
			
			String line = br.readLine();
			
			while (line != null) {
				
				//Cliente c = new Cliente(line);
				
				String[] s = line.split(",");
				
				Cliente cli = new Cliente(s);
				
				line = br.readLine();
				
				System.out.println(cli);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
}

class Cliente { 
	
	private static final String SEPARADOR = ";";
	
	private int id;
	private String nome;
	private String endereco;
	
	@Override
	public String toString() {
		
		return id + SEPARADOR + nome + SEPARADOR + endereco;
	}
	
	public Cliente() { }
	
	public Cliente(String[] l) { 
		this(Integer.parseInt(l[0]), l[1]);
		this.endereco = l[2];
	}
	
	public Cliente(String l) { 
		
		String[] s = l.split(",");
		
		this.setId(Integer.parseInt(s[0]));
		this.setNome(s[1]);
	}
	
	public Cliente(int i, String n) { 
		this.setId(i);
		this.setNome(n);
	}	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
}


