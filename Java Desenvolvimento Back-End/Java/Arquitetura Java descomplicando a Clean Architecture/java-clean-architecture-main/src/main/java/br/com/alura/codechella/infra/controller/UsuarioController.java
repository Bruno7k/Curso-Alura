package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.AlterarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.config.UsuarioConfig;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;
    private final AlterarUsuario alteraUsuario;

    private final ExcluirUsuario excluiUsuario;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios, AlterarUsuario alteraUsuario, ExcluirUsuario excluiUsuario) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.alteraUsuario = alteraUsuario;
        this.excluiUsuario = excluiUsuario;
    }

    @PostMapping
    public UsuarioDto cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
        System.out.println(usuarioDto.cpf() + " " + usuarioDto.nascimento() + " " + usuarioDto.email()+ " " + usuarioDto.nome());
        Usuario salvo = criarUsuario.cadastrarUsuario(new Usuario(usuarioDto.nascimento(), usuarioDto.nome(), usuarioDto.cpf(), usuarioDto.email()));
        return new UsuarioDto(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDto> listarUsuarios() {
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(usuario -> new UsuarioDto(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail()))
                .collect(Collectors.toList());
    }

    @PutMapping("/{cpf}")
    public UsuarioDto atualizarUsuario(@PathVariable String cpf, @RequestBody UsuarioDto dto) {
        Usuario atualizado = alteraUsuario.alteraDadosUsuario(cpf,
                new Usuario(dto.nascimento(), dto.nome(), dto.cpf(), dto.email()));
        return new UsuarioDto(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        excluiUsuario.excluirUsuario(cpf);
    }
}
