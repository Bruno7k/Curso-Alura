public class Main {
    public static void main(String[] args) {
        System.out.println("Esse e o Screen Match");
        System.out.println("Filme: Top Gun: Maverick");
        int ano = 2022;
        System.out.println("Ano de lancamento "+ ano);
        boolean incluidoNoPlano = true;
        double media = (9.8 + 6.3 + 8.0) /3;
        System.out.println("Nota do filme: " + media);
        String sinopse = """
                        Filme: Top Gun: Maverick
                        Filme de aventura com gala dos anos 80
                        Ano lancamento
                        """ + ano;
        System.out.println(sinopse);

        int classificacao = (int)(media/2);
        System.out.println(classificacao);
    }
}