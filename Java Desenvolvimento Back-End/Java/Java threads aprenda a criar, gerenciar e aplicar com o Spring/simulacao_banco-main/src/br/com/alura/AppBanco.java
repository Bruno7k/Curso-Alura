package br.com.alura;

import java.math.BigDecimal;

public class AppBanco {
    public static void main(String[] args) {
        var cliente = new Cliente("Guilherme");
        var conta = new Conta(cliente, new BigDecimal("150"));
        var operacaoSaque = new OperacaoSaque(conta, new BigDecimal("150"));
        Thread saqueGuilherme = new Thread(operacaoSaque);
        Thread saqueMaria = new Thread(operacaoSaque);
        saqueGuilherme.start();
        saqueMaria.start();
        try {
            saqueGuilherme.join();
            saqueMaria.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName());
        System.out.println("Saldo final: " + conta.getSaldo());
    }
}
