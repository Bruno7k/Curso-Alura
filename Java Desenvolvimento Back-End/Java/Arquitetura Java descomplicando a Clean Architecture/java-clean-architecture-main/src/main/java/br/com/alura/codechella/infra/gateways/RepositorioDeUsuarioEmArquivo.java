package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistence.UsuarioEntity;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.IntStream;

public class RepositorioDeUsuarioEmArquivo implements RepositorioDeUsuario {
    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
       this.usuarios.add(usuario);
       return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    @Override
    public Usuario alteraUsuario(String cpf, Usuario usuario) {
        int index = IntStream.range(0, usuarios.size())
                .filter(i -> usuarios.get(i).getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Usuário com CPF " + cpf + " não encontrado."));

        usuarios.set(index, usuario);
        return usuario;
    }

    @Override
    public void excluiUsuario(String cpf) {
        usuarios.removeIf(u -> u.getCpf().equals(cpf));
    }
    public void gravaEmArquivo(String nomeArquivo) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(nomeArquivo);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.write(this.usuarios.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
