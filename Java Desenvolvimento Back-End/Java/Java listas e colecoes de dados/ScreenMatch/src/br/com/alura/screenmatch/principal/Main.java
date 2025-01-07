package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefao", 1980);
        meuFilme.setDuracaoEmMinutos(165);
        System.out.println(meuFilme.getDuracaoEmMinutos());
        meuFilme.exibiFichaTecnica();
        meuFilme.avalia(10);
        meuFilme.avalia(8);
        meuFilme.avalia(9);
        System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getTotalDeAvaliacao());
        System.out.println(meuFilme.obterMediaDasAvaliacoes());

        Serie serie = new Serie("Game of Thrones",1980);
        serie.exibiFichaTecnica();
        serie.setTemporadas(6);
        serie.setMinutosPorEpisodio(50);
        serie.setEpisodiosPorTemporada(10);
        System.out.println("Duracao para ver a serie toda: " + serie.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("O poderoso chefao 2",1985);
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

        Filme maisFilme = new Filme("Star Wars", 1976);
        maisFilme.setDuracaoEmMinutos(200);
        maisFilme.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(maisFilme);
        listaDeFilmes.add(outroFilme);
        listaDeFilmes.add(meuFilme);
        System.out.println("Tamanho da lista " + listaDeFilmes.size());
        System.out.println("Primeiro filme " + listaDeFilmes.getFirst().getNome());
        System.out.println(listaDeFilmes);
        System.out.println("toString do filme " + listaDeFilmes.getFirst().toString());

    }
}