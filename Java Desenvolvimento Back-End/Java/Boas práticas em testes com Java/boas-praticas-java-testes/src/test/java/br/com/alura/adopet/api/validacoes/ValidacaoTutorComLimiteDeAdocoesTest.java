package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;


@ExtendWith(MockitoExtension.class)
class ValidacaoTutorComLimiteDeAdocoesTest {

    @Mock
    private AdocaoRepository adocaoRepository;

    @InjectMocks
    private ValidacaoTutorComLimiteDeAdocoes validacao;

    @Mock
    private SolicitacaoAdocaoDto dto;

    @Test
    @DisplayName("Nao deveria permitir doacao tutor com limite de adocoes")
    void naoDeveriaPermitirDoacaoTutorComLimiteDeAdocoes() {
        //arrange
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(5);
        //act
        //assert
        assertThrows(ValidacaoException.class,() -> validacao.validar(dto));
    }

    @Test
    @DisplayName("Deveria permitir doacao ")
    void deveriaPermitirDoacaoTutorSemLimiteDeAdocoes() {
        //arrange
        given(adocaoRepository.countByTutorIdAndStatus(dto.idTutor(), StatusAdocao.APROVADO)).willReturn(3);
        //act
        //assert
        assertDoesNotThrow(() -> validacao.validar(dto));
    }

}