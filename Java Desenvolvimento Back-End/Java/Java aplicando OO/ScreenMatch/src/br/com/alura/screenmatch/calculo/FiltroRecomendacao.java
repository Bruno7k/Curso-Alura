package br.com.alura.screenmatch.calculo;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel) {
        if(classificavel.getClassificacao()>=4){
            System.out.println("Esta entre os preferidos");
        } else if (classificavel.getClassificacao()>=2) {
            System.out.println("Muito bem avaliado");
        }else{
            System.out.println("Coloque na lista para ver depois");
        }
    }
}
