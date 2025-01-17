package br.com.alura.fipe.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public record Dados(
        String codigo,
        String nome
) {
}
