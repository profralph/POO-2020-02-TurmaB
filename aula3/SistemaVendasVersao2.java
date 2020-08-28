
public class SistemaVendasVersao2 {

    public static void main(String[] args) {

        // Instância da classe Vendedor
        // Materialização da classe
        VendedorVersao3 v1 = new VendedorVersao3();
        //v1.salario = 1000d;
        v1.definirSalario(1000d);
        v1.vender(10000d); // invocação de um método        
        v1.consultarSalarioAtual();
        v1.vender(25000d);
        v1.consultarSalarioAtual();
        v1.consultarSalarioAtual();

        v1.listarSalarios();

        //System.out.println("Valor do salario liquido do vendedor 1: "+salario);

        System.out.println("Valor do salario projetado do vendedor 1: "+v1.projetarSalario());
    }
}