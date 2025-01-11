package br.com.alura.screenmatch.modelos;

public record TituloOmdb(String title, String year, String runtime) {
    public TituloOmdb(TituloOmdb meuTituloOmdb) {
        this(meuTituloOmdb.title(), meuTituloOmdb.year(), meuTituloOmdb.runtime());
    }
}
