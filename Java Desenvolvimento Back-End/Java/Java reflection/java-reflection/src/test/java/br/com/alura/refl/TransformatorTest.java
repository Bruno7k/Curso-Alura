package br.com.alura.refl;

import br.com.alura.Endereco;
import br.com.alura.Pessoa;
import br.com.alura.PessoaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class TransformatorTest {

    Pessoa pessoa = new Pessoa(1, "João", "1234");
    Endereco endereco = new Endereco("Rua 10", 20);

    @Test
    public void shouldTransform() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Transformator transform = new Transformator();
        PessoaDTO pessoaDTO = transform.transform(pessoa);
        Assertions.assertInstanceOf(PessoaDTO.class, pessoaDTO);
        Assertions.assertEquals(pessoa.getNome(), pessoaDTO.getNome());
        Assertions.assertEquals(pessoa.getCpf(), pessoaDTO.getCpf());
    }

    @Test
    public void shouldNotTransform() {
        Assertions.assertThrows(ClassNotFoundException.class,()->
        {
            Transformator transform = new Transformator();
            transform.transform(endereco);
        });
    }

    @Test
    public void shouldTransformWhenSomeFieldIsNull() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Pessoa pessoaSemCPF = new Pessoa("joao");
        Transformator transformator = new Transformator();
        PessoaDTO pessoaDTOSemCPF = transformator.transform(pessoaSemCPF);
        Assertions.assertEquals(pessoaSemCPF.getNome(), pessoaDTOSemCPF.getNome());
        Assertions.assertNull(pessoaDTOSemCPF.getCpf());
    }


}