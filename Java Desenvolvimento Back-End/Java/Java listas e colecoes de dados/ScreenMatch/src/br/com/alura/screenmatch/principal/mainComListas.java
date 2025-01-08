package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class mainComListas {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefao", 1980);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("O poderoso chefao 2",1985);
        outroFilme.avalia(7);
        Filme maisFilme = new Filme("Star Wars", 1976);
        maisFilme.avalia(8);
        Serie serie = new Serie("Game of Thrones",1980);


        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(maisFilme);
        lista.add(outroFilme);
        lista.add(meuFilme);
        lista.add(serie);

        for(Titulo item: lista){
            System.out.println(item.getNome());
            if(item instanceof Filme filme){
                System.out.println("Classificacao: " + filme.getClassificacao());
            }
        }

        ArrayList<String>buscarPorArtista = new ArrayList<>();
        buscarPorArtista.add("Adam Sandler");
        buscarPorArtista.add("Will Smith");
        buscarPorArtista.add("Dwani Jones");
        System.out.println(buscarPorArtista);

        Collections.sort(buscarPorArtista);
        System.out.println(buscarPorArtista);

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenado por ano de lancamento: " + lista);

    }
}
