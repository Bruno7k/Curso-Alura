import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        String nomeDoCliente = "Bruno Firmino";
        String tipoDeConta = "Corrente";
        double saldoInicial = 1500.00;

        System.out.printf("Dados iniciais do cliente:%n");
        System.out.printf("%-15s %s%n", "Nome:", nomeDoCliente);
        System.out.printf("%-15s %s%n", "Tipo de Conta:", tipoDeConta);
        System.out.printf("%-15s R$ %.2f%n", "Saldo Inicial:", saldoInicial);

        int operacoes = 0;
        String menu = """
                Operacoes:
                1- Consultar saldos
                2- Receber valor
                3- Transferir saldo
                4- Sair
                """;

        while (operacoes != 4) {
            System.out.println(menu);
            System.out.print("Digite a opcao desejada: ");
            operacoes = leitura.nextInt();
            switch (operacoes) {
                case 1:
                    System.out.println("O seu saldo é: R$ " + saldoInicial);
                    break; 
                case 2:
                    System.out.println("Digite o valor que vai ser recebido:");
                    saldoInicial += leitura.nextDouble();
                    System.out.println("Valor recebido com sucesso. Saldo atual: R$ " + saldoInicial);
                    break;
                case 3:
                    System.out.println("Digite o valor que deseja transferir:");
                    double valor = leitura.nextDouble();
                    if (valor > saldoInicial) {
                        System.out.println("Não é possível realizar a transferência. Saldo insuficiente.");
                    } else {
                        saldoInicial -= valor;
                        System.out.println("Transferência realizada com sucesso. Saldo atual: R$ " + saldoInicial);
                    }
                    break;
                case 4:
                    System.out.println("Saindo do sistema. Obrigado!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

    }
}
