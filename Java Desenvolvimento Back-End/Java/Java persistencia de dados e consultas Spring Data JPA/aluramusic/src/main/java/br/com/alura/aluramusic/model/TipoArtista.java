package br.com.alura.aluramusic.model;

public enum TipoArtista {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");
    
    private String tipoPortugues;

    TipoArtista(String tipoPortugues) {
        this.tipoPortugues = tipoPortugues;
    }

    public static TipoArtista fromPortugues(String text) {
        for (TipoArtista categoria : TipoArtista.values()) {
            if (categoria.tipoPortugues.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }
}
