package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    CRIME("Crime"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    ROMANCE("Romance");

    private String categoriaOmdb;

    Categoria(String categoriaOmdb) {
        this.categoriaOmdb = categoriaOmdb;
    }
    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
