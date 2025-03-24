package br.com.alura.codechella.vendas.dominio.Evento;

import br.com.alura.codechella.vendas.dominio.Ingresso.TipoIngresso;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Evento {
    private UUID uuid;
    private Categoria categoria;
    private String descricao;
    private Endereco endereco;
    private LocalDateTime data;
    private List<TipoIngresso> tipoIngressos = new ArrayList<>();

    private Evento() {
        // Construtor privado para garantir a construção apenas através do Builder
    }

    public static class Builder {
        private Evento evento;

        public Builder() {
            evento = new Evento();
        }

        public Builder comCategoria(Categoria categoria) {
            evento.categoria = categoria;
            return this;
        }

        public Builder comDescricao(String descricao) {
            evento.descricao = descricao;
            return this;
        }

        public Builder comEndereco(String cep, Integer numero, String complemento) {
            Endereco endereco = new Endereco(cep, numero, complemento);
            evento.endereco = endereco;
            return this;
        }

        public Builder comData(LocalDateTime data) {
            evento.data = data;
            return this;
        }

        public Evento build() {
            evento.gerarIdentificadorUnico();
            return evento;
        }
    }

    private void gerarIdentificadorUnico() {
        this.uuid = UUID.randomUUID();
    }

    public void incluiNovoTipoDeIngressoAoEvento(TipoIngresso tipoIngresso){
        this.tipoIngressos.add(tipoIngresso);
    }

    public void aumentaNumeroDeIngressosPorTipo() {
        //implementar aqui
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDateTime getData() {
        return data;
    }

    public List<TipoIngresso> getTipoIngressos() {
        return tipoIngressos;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "categoria=" + categoria +
                ", descricao='" + descricao + '\'' +
                ", endereco=" + endereco +
                ", data=" + data +
                '}';
    }
}