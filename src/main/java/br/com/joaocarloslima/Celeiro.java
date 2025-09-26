package br.com.joaocarloslima;

public class Celeiro {
    private int capacidade = 100;
    private int qtdeBatatas = 10;
    private int qtdeCenouras = 10;
    private int qtdeMorangos = 10;

    private int getTotalItens() {
        return qtdeBatatas + qtdeCenouras + qtdeMorangos;
    }

    public void armazenarBatata() {
        if (getEspacoDisponivel() < 2) {
            throw new IllegalStateException("Celeiro cheio! Não é possível armazenar.");
        }
        qtdeBatatas += 2;
    }

    public void armazenarCenoura() {
        if (getEspacoDisponivel() < 2) {
            throw new IllegalStateException("Celeiro cheio! Não é possível armazenar.");
        }
        qtdeCenouras += 2;
    }

    public void armazenarMorango() {
        if (getEspacoDisponivel() < 2) {
            throw new IllegalStateException("Celeiro cheio! Não é possível armazenar.");
        }
        qtdeMorangos += 2;
    }

    public void consumirBatata() {

        if (qtdeBatatas <= 0) {
            throw new IllegalStateException("Não há batatas para plantar.");
        }
        qtdeBatatas--;
    }

    public void consumirCenoura() {
        if (qtdeCenouras <= 0) {
            throw new IllegalStateException("Não há cenouras para plantar.");
        }
        qtdeCenouras--;
    }

    public void consumirMorango() {
        if (qtdeMorangos <= 0) {
            throw new IllegalStateException("Não há morangos para plantar.");
        }
        qtdeMorangos--;
    }

    public int getEspacoDisponivel() {
        return capacidade - getTotalItens();
    }

    public double getOcupacao() {
        return (double) getTotalItens() / capacidade;
    }

    public boolean celeiroCheio() {
        return getTotalItens() >= capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public int getQtdeBatatas() {
        return qtdeBatatas;
    }

    public int getQtdeCenouras() {
        return qtdeCenouras;
    }

    public int getQtdeMorangos() {
        return qtdeMorangos;
    }
}