package br.edu.imed;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ManipularArquivos {

	private String dir;
	String caminhoAbsoluto;
	public static String SEP = ",";
	
	public ManipularArquivos() {
		
		dir = System.getProperty("user.home");
		caminhoAbsoluto = dir + File.separator;
	}
	
	public void gravar(String arquivo, Object obj) {
		
		String caminho = caminhoAbsoluto + arquivo;
		
		try (FileWriter fw = new FileWriter(caminho + arquivo, true);
			 BufferedWriter bw = new BufferedWriter(fw);
			 PrintWriter out = new PrintWriter(bw)){
			
			out.println(obj);
			
		} catch (IOException e) { // checked exception: obrigatório tratar no código
			
			e.printStackTrace();
		}
	}
	
	public void ler(String arquivo) {
		
		String caminho = caminhoAbsoluto + arquivo;
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			
			String line = br.readLine();
			
			while (line != null) {
				
				System.out.println(line);
												
				line = br.readLine();
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
