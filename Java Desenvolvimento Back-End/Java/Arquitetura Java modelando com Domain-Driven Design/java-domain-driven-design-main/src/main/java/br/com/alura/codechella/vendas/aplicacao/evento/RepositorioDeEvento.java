package br.com.alura.codechella.vendas.aplicacao.evento;

import br.com.alura.codechella.vendas.dominio.Evento.Endereco;
import br.com.alura.codechella.vendas.dominio.Evento.Evento;

public interface RepositorioDeEvento {
    Evento buscarEventoPorCidade(Endereco cep);
}
