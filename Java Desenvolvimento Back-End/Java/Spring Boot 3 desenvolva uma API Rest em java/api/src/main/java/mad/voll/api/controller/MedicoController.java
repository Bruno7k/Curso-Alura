package mad.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import mad.voll.api.medico.DadosCadastroMedico;
import mad.voll.api.medico.Medico;
import mad.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));
    }
}
