package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarPacienteSemOutraConsultaNoDia implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private ConsultaRepository consulta;
    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consulta.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if(pacientePossuiOutraConsultaNoDia) {
            throw new ValidacaoException("O paciente já possui uma consulta agendada no dia!");
        }
    }
}
