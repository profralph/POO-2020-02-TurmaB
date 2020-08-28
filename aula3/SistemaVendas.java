
public class SistemaVendas{

    public static void main(String[] args) {

        // Instância da classe Vendedor
        // Materialização da classe
        Vendedor v1 = new Vendedor();
        //v1.salario = 1000d;
        v1.definirSalario(1000d);
        v1.vender(10000d); // invocação de um método
        v1.vender(25000d);

        Double salarioLiquido = v1.calcularSalarioLiquido();

        System.out.println("Valor do salario liquido do vendedor 1: "+
            salarioLiquido+", e o salário base de "+v1.salarioBase+" e vendas de "+v1.valorVenda);
    }
}