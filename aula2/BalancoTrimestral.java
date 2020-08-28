
public class BalancoTrimestral {

    public static void main(String[] args) {
        
        // Declaração
        double mesBalanco[];

        // Instância
        mesBalanco = new double[3];

        mesBalanco[0] = 17000;
        mesBalanco[1] = 23000;
        mesBalanco[2] = 15500;

        // Primitiva: letra minúscula        
        // Declaração + inicialização
        double valorTotal = 0;

        // Loop tradicional: 3 blocos (inicialização; condição; incremento)
        // Escopo das variáveis permance dentro da estrutura do loop { }
        for (int i=0; i<mesBalanco.length; i++){

            // valorTotal = valorTotal + mesBalanco[i];
            valorTotal += mesBalanco[i];
        }

        //System.out.println("Valor Total: "+valorTotal);

        valorTotal = 0;

        // For each: declara uma variável para cada iteração
        for (double d : mesBalanco){

            valorTotal += d;
        }

        System.out.println("Valor Total: "+valorTotal);
    }
}