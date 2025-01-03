package br.com.alura.desafiomusica.modelos;

public class Audio {
    private String titulo;
    private int totalDeReproducoes;
    private int curtidas;
    private int classificacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public void reproduz() {
        this.totalDeReproducoes ++;
    }

    public int getCurtidas() {
        return curtidas;
    }

    public void curtir() {
        this.curtidas ++;
    }

    public int getClassificacao() {
        return classificacao;
    }
}
