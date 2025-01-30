package mad.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import mad.voll.api.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
