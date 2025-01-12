package br.com.alura.viaCep.modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;

public class GerarJson {
    public void gerar(CEP cep) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter escrita = new FileWriter("cep.json");
            escrita.write(gson.toJson(cep));
            escrita.close();
        }catch (Exception e) {
            System.out.println("falha ao tentar gerar o json");
        }
    }
}
