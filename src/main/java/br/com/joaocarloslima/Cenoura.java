package br.com.joaocarloslima;

public class Cenoura extends Planta {

    public Cenoura() {

        super("cenoura", 2);
    }

    @Override
    public void armazenar(Celeiro celeiro) {
        celeiro.armazenarCenoura();
    }
}