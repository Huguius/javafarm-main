package br.com.joaocarloslima;

public class Morango extends Planta {

    public Morango() {

        super("morango", 4);
    }

    @Override
    public void armazenar(Celeiro celeiro) {
        celeiro.armazenarMorango();
    }
}