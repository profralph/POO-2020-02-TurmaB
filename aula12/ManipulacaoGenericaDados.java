package dao;

public interface ManipulacaoGenericaDados {

	void inserir(Object t, String nomeTabela, String[] campos, String[] vals);
	
	void excluir(Object id);
	
	Object buscar(Object id);
	
	void atualizar(Object t);
}
