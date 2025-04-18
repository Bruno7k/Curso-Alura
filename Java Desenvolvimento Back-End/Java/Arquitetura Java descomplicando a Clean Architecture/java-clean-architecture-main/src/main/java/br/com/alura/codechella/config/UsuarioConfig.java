package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AlterarUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {
    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repository) {
        return new CriarUsuario(repository);
    }
    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repository) {
        return new ListarUsuarios(repository);
    }
    @Bean
    RepositorioDeUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioEntityMapper mapper) {
        return new RepositorioDeUsuarioJpa(repositorio, mapper);
    }
    @Bean
    UsuarioEntityMapper retornaMapper(){
        return new UsuarioEntityMapper();
    }

    @Bean
    AlterarUsuario alteraUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new AlterarUsuario(repositorioDeUsuario);
    }

    @Bean
    ExcluirUsuario excluiUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new ExcluirUsuario(repositorioDeUsuario);
    }

}
