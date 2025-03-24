package br.com.alura.codechella.vendas.aplicacao.ingresso;

import br.com.alura.codechella.vendas.dominio.Ingresso.Definicao;
import br.com.alura.codechella.vendas.dominio.Ingresso.Setor;

public record DadosTipoIngresso(
        Integer codigo,
        Setor setor,
        Definicao definicao
) {
}
