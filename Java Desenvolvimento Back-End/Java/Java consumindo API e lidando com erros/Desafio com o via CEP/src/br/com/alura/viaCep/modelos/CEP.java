package br.com.alura.viaCep.modelos;

public record CEP(String cep, String logradouro, String bairro, String localidade, String uf, String ddd) {
    public CEP(CEP cep) {
        this(cep.cep(), cep.logradouro(), cep.bairro(), cep.localidade(), cep.uf(), cep.ddd());
    }
}
