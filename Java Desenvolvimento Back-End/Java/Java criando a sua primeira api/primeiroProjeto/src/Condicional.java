public class Condicional {
    public static void main(String[] args) {
        int anoDeLancamento = 1990;
        boolean incluidoNoPlano = true;
        double notaDoFilme = 8.1;
        String tipoPlano = "plus";

        if (anoDeLancamento >= 2022) {
            System.out.println("Lancamento que os clientes estao curtindo!");
        }else{
            System.out.println("Filme retro que vale a pena asssistir!");
        }

        if (incluidoNoPlano == true || tipoPlano.equals("plus")) {
            System.out.println("filme liberado");
        }else{
            System.out.println("Paga o plano");
        }
    }
}
