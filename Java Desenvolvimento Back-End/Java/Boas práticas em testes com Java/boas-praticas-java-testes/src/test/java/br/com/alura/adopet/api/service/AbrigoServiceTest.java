package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.CadastroAbrigoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class AbrigoServiceTest {

    @InjectMocks
    private AbrigoService abrigoService;

    @Mock
    private AbrigoRepository abrigoRepository;

    @Mock
    private CadastroAbrigoDto dto;

    @Captor
    private ArgumentCaptor<Abrigo> abrigoCaptor;

    @Mock
    private Abrigo abrigo;

    @Mock
    private PetRepository petRepository;

    @Test
    @DisplayName("O abrigo deve ser cadastrado caso nao exista um abrigo com o mesmo nome")
    void deveriaCadastrarAbrigoNaoExistente(){
        //arrange
        given(abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email())).willReturn(false);
        //act
        abrigoService.cadatrar(dto);
        //assert
        then(abrigoRepository).should().save(abrigoCaptor.capture());
        Abrigo abrigoSalvo = abrigoCaptor.getValue();
        Assertions.assertEquals(dto.nome(), abrigoSalvo.getNome());
        Assertions.assertEquals(dto.telefone(), abrigoSalvo.getTelefone());
        Assertions.assertEquals(dto.email(), abrigoSalvo.getEmail());
    }

    @Test
    @DisplayName("O abrigo nao deve ser cadastrado caso exista um abrigo com o mesmo nome")
    void naoDeveriaCadastrarAbrigoJaExistente(){
        //arrange
        given(abrigoRepository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email())).willReturn(true);
        //assert
        Assertions.assertThrows(ValidacaoException.class,() -> abrigoService.cadatrar(dto));
    }

    @Test
    @DisplayName("Deveria chamar o repositorio para listar todos os abrigos")
    void deveriaChamarListaDeTodosOsAbrigos() {
        //Act
        abrigoService.listar();

        //Assert
        then(abrigoRepository).should().findAll();
    }

    @Test
    @DisplayName("Deveria chamar o repositorio para listar todos os pets do abrigo atraves do nome")
    void deveriaChamarListaDePetsDoAbrigoAtravesDoNome() {
        //Arrange
        String nome = "Miau";
        given(abrigoRepository.findByNome(nome)).willReturn(Optional.of(abrigo));

        //Act
        abrigoService.listarPetsDoAbrigo(nome);

        //Assert
        then(petRepository).should().findByAbrigo(abrigo);
    }

}