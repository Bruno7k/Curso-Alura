package br.com.alura.aluramusic.principal;

import br.com.alura.aluramusic.model.Artista;
import br.com.alura.aluramusic.model.Musica;
import br.com.alura.aluramusic.model.TipoArtista;
import br.com.alura.aluramusic.repository.ArtistaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);
    private ArtistaRepository repositorio;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }
    public void exibeMenu(){
        var opcao = -1;
        while (opcao != 0) {
            var menu = """
                    1 - Cadastrar artista
                    2 - Cadastrar musica
                    3 - Listar musicas
                    4 - Buscar musica por artista 
                    0 - Sair                                 
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarArtista();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicaPorArtista();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private void cadastrarArtista() {
        String opcao = "S";
        while (opcao.equalsIgnoreCase("S")) {
            System.out.println("Digite o nome do artista: ");
            var nome = leitura.nextLine();
            System.out.println("Digite o tipo do artista: (solo, dupla, banda)");
            var tipo = leitura.nextLine();
            var artista = new Artista(nome, TipoArtista.fromPortugues(tipo));
            repositorio.save(artista);
            System.out.println("Artista cadastrado com sucesso!");
            System.out.println("Deseja cadastrar outro artista? (S/N)");
            opcao = leitura.nextLine();
        }
    }

    private void cadastrarMusica() {
        String opcao = "S";
        while (opcao.equalsIgnoreCase("S")) {
            System.out.println("Cadastrar musica de qual artista? ");
            var nomeArtista = leitura.nextLine();
            Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);
            if(artista.isPresent()) {
                System.out.println("Digite o nome da musica: ");
                var nomeMusica = leitura.nextLine();
                System.out.println("Digite o album da musica: ");
                var album = leitura.nextLine();
                Musica musica = new Musica(nomeMusica, album, artista.get());
                artista.get().getMusicas().add(musica);
                repositorio.save(artista.get());
                System.out.println("Musica cadastrada com sucesso!");
            }else {
                System.out.println("Artista nao encontrado!");
            }
            System.out.println("Deseja cadastrar outra musica? (S/N)");
            opcao = leitura.nextLine();
        }
    }

    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void buscarMusicaPorArtista() {
        System.out.println("Digite o nome do artista: ");
        var nomeArtista = leitura.nextLine();
        Optional<Artista> artista = repositorio.findByNomeContainingIgnoreCase(nomeArtista);
        if(artista.isPresent()) {
            List<Musica> musicas = artista.get().getMusicas();
            musicas.forEach(System.out::println);
        }
    }
}
