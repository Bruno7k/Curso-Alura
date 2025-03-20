package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioEmArquivo;

import java.time.LocalDate;

public class UtilizaUsuariosComArquivo {
    public static void main(String[] args) {
        RepositorioDeUsuarioEmArquivo repositorio = new RepositorioDeUsuarioEmArquivo();
        repositorio.cadastrarUsuario(new Usuario(LocalDate.parse("1990-09-09"), "Joaquim", "123.456.789-00", "joaquim.alterdata@gmail.com"));
        repositorio.cadastrarUsuario(new Usuario(LocalDate.parse("1990-09-09"), "Maria", "123.456.789-00", "joaquim.alterdata@gmail.com"));
        repositorio.cadastrarUsuario(new Usuario(LocalDate.parse("1990-09-09"), "Jonas", "123.456.789-00", "joaquim.alterdata@gmail.com"));
        repositorio.cadastrarUsuario(new Usuario(LocalDate.parse("1990-09-09"), "Brothers", "123.456.789-00", "joaquim.alterdata@gmail.com"));
        //System.out.println(repositorio.listarTodos());
        repositorio.gravaEmArquivo("usuarios.txt");
    }
}
