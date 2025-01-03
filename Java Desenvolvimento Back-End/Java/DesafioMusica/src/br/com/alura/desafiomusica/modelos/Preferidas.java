package br.com.alura.desafiomusica.modelos;

public class Preferidas {

    public void inclui(Audio audio) {
        if(audio.getClassificacao()>=8){
            System.out.println(audio.getTitulo() + " sucesso");
        }else {
            System.out.println(audio.getTitulo() + " uma boa opcao");
        }
    }
}
