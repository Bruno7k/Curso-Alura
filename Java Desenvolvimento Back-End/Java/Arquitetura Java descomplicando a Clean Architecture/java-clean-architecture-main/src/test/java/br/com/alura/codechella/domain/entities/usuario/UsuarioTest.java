package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfInvalido() {
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(LocalDate.parse("2000-01-01"), "Bruno", "123456789-99", "bruno@email.com"));
        assertThrows(IllegalArgumentException.class,
                () -> new Usuario(LocalDate.parse("2000-01-01"), "Bruno", "", "bruno@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario() {
        FabricaDeUsuario fabrica = new FabricaDeUsuario();
        Usuario usuario = fabrica.comNomeCpfNascimento("Bruno", "123.456.789-99", LocalDate.parse("2000-01-01"));
        assertEquals("123.456.789-99", usuario.getCpf());
        usuario = fabrica.incluiEndereco("12345-678", 1, "Casa");
        assertEquals("12345-678", usuario.getEndereco().getCep());
    }

}