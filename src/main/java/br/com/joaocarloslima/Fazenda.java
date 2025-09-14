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
        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 13; y++) {
                terrenos.add(new Terreno(x, y));
            }
        }
    }

    public Terreno getTerreno(int x, int y) {
        for (Terreno t : terrenos) {
            if (t.getX() == x && t.getY() == y) {
                return t;
            }
        }
        return null;
    }

    public Celeiro getCeleiro() {
        return celeiro;
    }

    public void plantarBatata(int x, int y) {
        Terreno terreno = getTerreno(x, y);
        if (terreno != null) {
            if (celeiro.getQtdeBatatas() > 0) {
                if (!terreno.estaOcupado()) {
                    terreno.plantar(new Batata());
                    celeiro.consumirBatata();
                } else {
                    throw new IllegalStateException("Terreno ocupado!");
                }
            } else {
                throw new IllegalStateException("Não há batatas no celeiro!");
            }
        }
    }

    public void plantarCenoura(int x, int y) {
        Terreno terreno = getTerreno(x, y);
        if (terreno != null) {
            if (celeiro.getQtdeCenouras() > 0) {
                if (!terreno.estaOcupado()) {
                    terreno.plantar(new Cenoura());
                    celeiro.consumirCenoura();
                } else {
                    throw new IllegalStateException("Terreno ocupado!");
                }
            } else {
                throw new IllegalStateException("Não há cenouras no celeiro!");
            }
        }
    }

    public void plantarMorango(int x, int y) {
        Terreno terreno = getTerreno(x, y);
        if (terreno != null) {
            if (celeiro.getQtdeMorangos() > 0) {
                if (!terreno.estaOcupado()) {
                    terreno.plantar(new Morango());
                    celeiro.consumirMorango();
                } else {
                    throw new IllegalStateException("Terreno ocupado!");
                }
            } else {
                throw new IllegalStateException("Não há morangos no celeiro!");
            }
        }
    }

    public void colher(int x, int y) {
        Terreno terreno = getTerreno(x, y);
        if (terreno != null) {
            terreno.colher(celeiro);
        }
    }
}
