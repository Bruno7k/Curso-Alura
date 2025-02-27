package br.com.alura.adopetstore.service;

import br.com.alura.adopetstore.email.EmailRelatorioGerado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AgendamentoService {
    @Autowired
    private RelatorioService relatorioService;

    @Autowired
    private EmailRelatorioGerado enviador;

    @Scheduled(cron = "0 01 19 * * *")
    public void envioEmailAgendado(){
        var estoqueZerado = relatorioService.infoEstoque();
        var faturamento = relatorioService.faturamentoObtido();
        CompletableFuture.allOf(estoqueZerado, faturamento).join();
        try {
            enviador.enviar(estoqueZerado.get(), faturamento.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread do agendamento " + Thread.currentThread().getName());
    }
}
