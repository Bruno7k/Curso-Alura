package br.com.alura.service;

import br.com.alura.model.Produto;
import space.dynomake.libretranslate.Language;
import space.dynomake.libretranslate.Translator;

public class TraduzProdutoService {
    public void traduzir(Produto produto) {
        String nome = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getName());
        String categoria = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getCategory());
        String descricao = Translator.translate(Language.ENGLISH, Language.PORTUGUESE, produto.getDescription());
        produto.setName(nome);
        produto.setCategory(categoria);
        produto.setDescription(descricao);
    }
}
