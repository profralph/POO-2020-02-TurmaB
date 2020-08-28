
import java.util.Scanner;

public class IMC {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        System.out.println("Peso (Kg): ");
        Double peso = s.nextDouble();
        
        System.out.println("Altura (m2): ");
        Double altura = s.nextDouble();

        Double imc = peso / (Math.pow(altura, 2));

        System.out.println("IMC "+imc);

        if (imc < 18.9){

            System.out.println("Abaixo do peso");

        } else if (imc > 18.9 && imc < 24.9){

            System.out.println("Normal");

        } else if (imc > 24.9 && imc < 29.9){

            System.out.println("Acima do peso");

        } else {

            System.out.println("Obesidade");
        }
    }
}