package br.com.joaocarloslima;

public abstract class Planta {

    protected int tamanho;
    protected int tempoDeVida;
    protected int tempoDeCrescimento;
    protected String nome;

    public Planta(String nome, int tempoDeCrescimento) {
        this.nome = nome;
        this.tempoDeCrescimento = tempoDeCrescimento;
        this.tamanho = 1;
        this.tempoDeVida = 1;
    }

    public void crescer() {
        tempoDeVida++;
        if (tempoDeVida == tempoDeCrescimento ||
                tempoDeVida == tempoDeCrescimento * 2 ||
                tempoDeVida == tempoDeCrescimento * 3) {
            tamanho++;
        }
    }

    public boolean podeColher() {
        return tamanho == 4;
    }

    public String getImagem() {
        return "images/" + this.nome + this.tamanho + ".png";
    }

    public abstract void armazenar(Celeiro celeiro);
}