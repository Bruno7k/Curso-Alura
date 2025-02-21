package br.com.alura.adopet.api.validacoes;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.exception.ValidacaoException;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ValidacaoPetComAdocaoEmAndamentoTest {

    @InjectMocks
    private ValidacaoPetComAdocaoEmAndamento validacao;

    @Mock
    private AdocaoRepository adocaoRepository;


    private SolicitacaoAdocaoDto dto;

    @Test
    @DisplayName("Permite a adocao de um pet sem adocao em andamento")
    public void deveriaPermitirDoacaoPetSemAdocaoEmAndamento() {
        //arrange
        this.dto = new SolicitacaoAdocaoDto(10l, 20l, "motivo qualquer");
        given(adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(false);
        //act
        //assert
        Assertions.assertDoesNotThrow(() -> validacao.validar(dto));
    }
    @Test
    @DisplayName("Não permite a adocao de um pet com adocao em andamento")
    public void naoDeveriaPermitirDoacaoPetComAdocaoEmAndamento() {
        //arrange
        this.dto = new SolicitacaoAdocaoDto(10l, 20l, "motivo qualquer");
        given(adocaoRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO)).willReturn(true);
        //act
        //assert
        Assertions.assertThrows(ValidacaoException.class,() -> validacao.validar(dto));
    }

}