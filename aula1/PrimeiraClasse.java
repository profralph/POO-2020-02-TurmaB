
/***

== Obs gerais
Todo programa em Java tem ao menos uma classe.
A classe tem o mesmo nome do arquivo em que ela está contida. 
O método "main" é acionado automaticamente.
Compilação do fonte .java e a execução é do resultado (bytecode) sem extensão (.java).
    javac PrimeiraClasse.java
    java PrimeiraClasse

== Obs sintaxe
As chaves { } delimitam bloco.
Ponto-e-vírgula delimita comando.
Aspas duplas é para strings ("exemplo"), aspas simples é caractere ('a').
*/

public class PrimeiraClasse {

    /**
    Método acionado automaticamente quando a classe é executada.
     */
    public static void main(String args[]){

        //System.out.print("Primeiro Sw Java.");

        // Declaração de variável primitiva: ocupa um espaço previsível na memória
        int abc;
        int y = 3;

        float f = 1.2f;
        double d = 5.4;

        // Primeira letra minúscula = primitivo
        boolean ab = true;

        String c = "Minha String";      

        // Atribuição de valor à variável já declarada.
        abc = 1 + y;
                
        if (ab == true){

            System.out.println(d+" ----- "+c);

        } else if (ab == false) {

            System.out.println("Else If");

        } else {

            System.out.println("Ok");
        }
    }    
}