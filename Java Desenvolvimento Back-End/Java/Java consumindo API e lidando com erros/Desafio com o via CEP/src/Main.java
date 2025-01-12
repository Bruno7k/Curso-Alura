import br.com.alura.viaCep.modelos.CEP;
import br.com.alura.viaCep.modelos.ConsultaCep;
import br.com.alura.viaCep.modelos.GerarJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaCep consulta = new ConsultaCep();
        GerarJson gerarJson = new GerarJson();
        System.out.println("Digite seu cep:");
        Scanner leitor = new Scanner(System.in);
        var busca = leitor.nextLine();
        try {
             gerarJson.gerar(consulta.buscaEndereco(busca));
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}