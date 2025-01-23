package br.com.alura.frases.service;

import br.com.alura.frases.dto.FraseDTO;
import br.com.alura.frases.model.Frase;
import br.com.alura.frases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repository;

    public FraseDTO getFrase() {
        Frase frase = repository.buscaFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }
}
