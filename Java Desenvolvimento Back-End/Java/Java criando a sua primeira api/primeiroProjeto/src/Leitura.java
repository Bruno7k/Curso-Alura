import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite seu filme favorito ");
        String filme= leitura.nextLine();
        System.out.println("Qual o ano de lancamento ");
        int ano= leitura.nextInt();
        System.out.println("Qual a sua avaliacao para o filme ");
        double avaliacao= leitura.nextDouble();

        System.out.println(filme);
        System.out.println(ano);
        System.out.println(avaliacao);
    }
}
