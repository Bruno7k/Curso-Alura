package br.com.alura;

import java.io.IOException;

public interface Command {

    public void execute() throws IOException, InterruptedException;
}
