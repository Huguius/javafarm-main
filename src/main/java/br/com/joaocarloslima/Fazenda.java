package br.com.joaocarloslima;

import java.util.ArrayList;
import java.util.List;

public class Fazenda {
    private List<Terreno> terrenos;
    private Celeiro celeiro;

    public Fazenda() {
        terrenos = new ArrayList<>();
        celeiro = new Celeiro();

        // Criar todos os terrenos (13 x 13)
        for (int i = 0; i < 13 * 13; i++) {
            terrenos.add(new Terreno(i / 13, i % 13));
        }
    }

    public Terreno getTerreno(int x, int y) {
        return terrenos.get(x * 13 + y);
    }

    public Celeiro getCeleiro() {
        return celeiro;
    }

    private void plantar(int x, int y, Planta planta) {
        Terreno terreno = getTerreno(x, y);
        if (terreno != null) {
            if (terreno.estaOcupado()) {
                throw new IllegalStateException("Este terreno já está ocupado!");
            }

            if (planta instanceof Batata)
                celeiro.consumirBatata();
            else if (planta instanceof Cenoura)
                celeiro.consumirCenoura();
            else if (planta instanceof Morango)
                celeiro.consumirMorango();

            terreno.plantar(planta);
        }
    }

    public void plantarBatata(int x, int y) {
        plantar(x, y, new Batata());
    }

    public void plantarCenoura(int x, int y) {
        plantar(x, y, new Cenoura());
    }

    public void plantarMorango(int x, int y) {
        plantar(x, y, new Morango());
    }

    public void colher(int x, int y) {
        Terreno terreno = getTerreno(x, y);
        if (terreno != null) {
            terreno.colher(celeiro);
        }
    }
}