package br.com.alura;

import java.io.IOException;

public class ComandExecutor {

    public void execute(Command command) throws IOException, InterruptedException {
        command.execute();
    }
}
