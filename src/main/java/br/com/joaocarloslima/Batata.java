package br.com.joaocarloslima;

public class Batata {
    private int tamanho = 1;
    private int tempoDeVida = 1;
    private int tempodeCrescimento = 3;

    public void crescer(){
        tempoDeVida++;
        if (tempoDeVida == tempodeCrescimento || 
        tempoDeVida == tempodeCrescimento * 2 || 
        tempoDeVida == tempodeCrescimento * 3) {
        tamanho++; 
    }
    }


    public boolean podeColher() {
        return tamanho == 4;
    }

    public String getImagem(){
        return "images/batata" + tamanho + ".png";
    }
        
}
