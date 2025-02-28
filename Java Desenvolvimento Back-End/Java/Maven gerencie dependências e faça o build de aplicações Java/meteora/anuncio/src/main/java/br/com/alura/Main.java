package br.com.alura;


import br.com.alura.model.Anuncio;
import br.com.alura.model.Produto;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        var produto = new Produto(1, "TV", "4K", new BigDecimal(400), "Eletrodoméstico");
        var anuncio = new Anuncio(produto, new BigDecimal(100), 20);

        System.out.println(anuncio.toString());
    }
}