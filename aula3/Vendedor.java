/**
 * Classe: um modelo para criação de objetos
 * 
 */
public class VendedorVersao2 {

    // Atributos: variáveis criadas no escopo da classe
    // armazenam o que se precisa saber sobre a classe
    String nome;
    Double salarioBase = 0d;
    String endereco;
    String dataAdmissao; // Objeto sem valor é nulo
    Double valorVenda = 0d;
    int identificador; // Primitiva sem valor (inteiro é zero)

    /**
     * Métodos: tipo de retorno, nome e a área de parâmetros
     * void: não há retorno
     */
    public void vender(Double valor, Produto itens[]){

        valorVenda += valor;
    }

    public Double receberSalario(){

        return salarioBase;
    }

    public void definirSalario(Double valor){

        salarioBase = valor;
    }

    public Double calcularSalarioLiquido(){

        Double comissao = 1.1;

        if (valorVenda > 10000 && valorVenda < 20000){
            
            comissao = 1.15;

        } else if (valorVenda > 20000){

            comissao = 1.2;
        }

        return salarioBase * comissao;
    }
}