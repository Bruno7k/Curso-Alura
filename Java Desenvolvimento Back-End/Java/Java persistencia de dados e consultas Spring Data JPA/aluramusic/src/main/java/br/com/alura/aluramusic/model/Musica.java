package br.com.alura.aluramusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String album;
    @ManyToOne
    private Artista artista;

    public Musica() {

    }

    public Musica(String nomeMusica, String album, Artista artista) {
        this.nome = nomeMusica;
        this.album = album;
        this.artista = artista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return
                "nome='" + nome + '\'' +
                ", album='" + album + '\'' +
                ", artista=" + artista.getNome();
    }
}
