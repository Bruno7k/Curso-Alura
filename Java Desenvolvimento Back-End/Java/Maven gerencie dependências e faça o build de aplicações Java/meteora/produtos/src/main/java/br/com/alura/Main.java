package br.com.alura;

import br.com.alura.model.Produto;
import br.com.alura.service.TraduzProdutoService;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        List<Produto> produtos = new CsvToBeanBuilder<Produto>(
                new FileReader(Paths.get("src/main/resources/products.csv").toFile()))
                .withType(Produto.class).build().parse();;

        produtos.forEach(System.out::println);

        TraduzProdutoService traduzProdutoService = new TraduzProdutoService();

        for(Produto produto : produtos) {
            traduzProdutoService.traduzir(produto);
            System.out.println(produto);
        }
    }
}