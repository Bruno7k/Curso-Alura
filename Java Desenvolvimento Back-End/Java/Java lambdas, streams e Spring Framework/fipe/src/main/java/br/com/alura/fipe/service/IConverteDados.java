package br.com.alura.fipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
    <T> List<T> obterlista(String json, Class<T> classe) throws JsonProcessingException;

}

