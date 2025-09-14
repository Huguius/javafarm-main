
package br.com.joaocarloslima;

public class Cenoura {
    private int tamanho = 1;
    private int tempoDeVida = 1;
    private int tempodeCrescimento = 2;

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
        return "images/cenoura" + tamanho + ".png";
    }
        
}

