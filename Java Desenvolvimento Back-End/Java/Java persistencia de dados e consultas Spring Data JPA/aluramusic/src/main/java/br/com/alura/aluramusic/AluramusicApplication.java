package br.com.alura.aluramusic;

import br.com.alura.aluramusic.principal.Principal;
import br.com.alura.aluramusic.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluramusicApplication implements CommandLineRunner{
	@Autowired
	private ArtistaRepository repositorio;
	public static void main(String[] args) {
		SpringApplication.run(AluramusicApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}
