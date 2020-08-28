/**
 * Classe: um modelo para criação de objetos
 * 
 */
public class VendedorVersao3 {

    // Atributos: variáveis criadas no escopo da classe
    // armazenam o que se precisa saber sobre a classe
    String nome;
    Double salarioBase = 0d;
    String endereco;
    String dataAdmissao; // Objeto sem valor é nulo
    Double valorVenda = 0d;
    int identificador; // Primitiva sem valor (inteiro é zero)
    Double salarios[] = new Double[1];
    int indiceAtual = 0;

    /**
     * Métodos: tipo de retorno, nome e a área de parâmetros
     * void: não há retorno
     */
    public void vender(Double valor){

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

    public Double consultarSalarioAtual(){

        Double salarioLiquido = calcularSalarioLiquido();

        if (indiceAtual == salarios.length){
            
            Double novoSalarios[] = new Double[indiceAtual+1];

            for (int i=0; i<salarios.length; i++){
                
                novoSalarios[i] = salarios[i];
            }

            salarios = novoSalarios;
        }

        salarios[indiceAtual] = salarioLiquido;
        indiceAtual++;

        return salarioLiquido;
    }

    public void listarSalarios(){

        for (Double salarioAtual : salarios){

            System.out.println("Salario atual: "+salarioAtual);
        }
    }

    public Double projetarSalario(){

        Double total = 0d;

        for (Double salarioAtual : salarios){
            total += salarioAtual;
        }

        return total / salarios.length;
    }
}