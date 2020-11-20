package app;

import dao.ManipulacaoGenericaConcreta;
import modelo.Usuario;

public class StartApp {

	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		String[] vals = new String[3];
		vals[0] = "1";
		vals[1] = "Fulano";
		vals[2] = "fulano@email.com";
		
		String[] campos = new String[3];
		campos[0] = "id";
		campos[1] = "nome";
		campos[2] = "email";
		
		ManipulacaoGenericaConcreta m = new ManipulacaoGenericaConcreta();
		m.inserir(u, "usuario", campos, vals);
		
	}
}
