package br.com.alura.codechella.domain;

public class Endereco {
    private String cep;
    private Integer numero;
    private String complemento;

    public Endereco(String cep, String complemento, Integer numero) {
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
