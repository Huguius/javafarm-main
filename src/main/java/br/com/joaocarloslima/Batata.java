package br.com.joaocarloslima;

public class Batata extends Planta {

    public Batata() {

        super("batata", 3);
    }

    @Override
    public void armazenar(Celeiro celeiro) {
        celeiro.armazenarBatata();
    }
}