import br.com.alura.desafiomusica.modelos.Musica;
import br.com.alura.desafiomusica.modelos.Podcast;
import br.com.alura.desafiomusica.modelos.Preferidas;

public class Main {
    public static void main(String[] args) {

        Musica musica = new Musica();
        musica.setTitulo("NEW MAGIC HAND");
        musica.setCantor("Tyler, The Creator");
        for (int i = 0; i < 100; i++) {
            musica.curtir();
        }
        for (int i = 0; i < 5000; i++) {
            musica.reproduz();
        }

        Podcast podcast = new Podcast();
        podcast.setTitulo("NEW PODCAST");
        podcast.setApresentador("Bruno");
        for (int i = 0; i < 100; i++) {
            podcast.reproduz();
        }
        for (int i = 0; i < 1000; i++) {
            podcast.curtir();
        }

        Preferidas preferidas = new Preferidas();
        preferidas.inclui(podcast);
        preferidas.inclui(musica);
    }
}