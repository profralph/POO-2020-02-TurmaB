
import java.util.Scanner;
import java.text.DecimalFormat;

public class SaqueAniversario {

    public static void main(String[] args) {
                
        Scanner s = new Scanner(System.in);

        System.out.print("Saldo FGTS: ");

        Double saldo = s.nextDouble();

        // Constante
        final Double faixa1 = 500d;
        final Double faixa2 = 1000d;
        final Double faixa3 = 5000d;
        final Double faixa4 = 10000d;
        final Double faixa5 = 15000d;
        final Double faixa6 = 20000d;

        double valorSaque;

        if (saldo < faixa1){

            valorSaque = saldo * 0.5;

        } else if (saldo >= faixa1 && saldo < faixa2){

            valorSaque = saldo * 0.4 + 50;

        } else if (saldo >= faixa2 && saldo < faixa3){

            valorSaque = saldo * 0.3 + 150;

        } else if (saldo >= faixa3 && saldo < faixa4){

            valorSaque = saldo * 0.2 + 650;
            
        } else if (saldo >= faixa4 && saldo < faixa5){

            valorSaque = saldo * 0.15 + 1150;
            
        } else if (saldo >= faixa5 && saldo < faixa6){

            valorSaque = saldo * 0.1 + 1900;
            
        } else {

            valorSaque = saldo * 0.05 + 2900;
        }

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Saque aniversário: "+df.format(valorSaque));
    }
    
}