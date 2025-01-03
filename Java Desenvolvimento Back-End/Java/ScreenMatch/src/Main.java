import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefao");
        meuFilme.setAnoDeLancamento(1980);
        meuFilme.setDuracaoEmMinutos(165);
        System.out.println(meuFilme.getDuracaoEmMinutos());
        meuFilme.exibiFichaTecnica();
        meuFilme.avalia(10);
        meuFilme.avalia(8);
        meuFilme.avalia(9);
        System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getTotalDeAvaliacao());
        System.out.println(meuFilme.obterMediaDasAvaliacoes());

        Serie serie = new Serie();
        serie.setNome("Game of Thrones");
        serie.setAnoDeLancamento(1980);
        serie.exibiFichaTecnica();
        serie.setTemporadas(6);
        serie.setMinutosPorEpisodio(50);
        serie.setEpisodiosPorTemporada(10);
        System.out.println("Duracao para ver a serie toda: " + serie.getDuracaoEmMinutos());

        Filme outroFilme = new Filme();
        outroFilme.setNome("O poderoso chefao 2");
        outroFilme.setAnoDeLancamento(1985);
        outroFilme.setDuracaoEmMinutos(195);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(serie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(serie);
        episodio.setTotalVisualizacoes(500);
        filtro.filtra(episodio);
    }
}