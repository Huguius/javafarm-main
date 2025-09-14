
package br.com.joaocarloslima;

public class Morango {
    private int tamanho;
    private int tempoDeVida;
    private int tempodeCrescimento;

    public Morango() {
        this.tamanho = 1;
        this.tempoDeVida = 0;
        this.tempodeCrescimento = 4;
    }

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
        return "images/morango" + tamanho + ".png";
    }
        
}

