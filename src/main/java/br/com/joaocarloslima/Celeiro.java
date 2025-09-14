package br.com.joaocarloslima;

public class Celeiro {
    private int capacidade = 100;
    private int qtdeBatatas=1;
    private int qtdeCenouras=1;
    private int qtdeMorangos=1;


    public void armazenarBatata() {
    if (capacidade < 2) {
        throw new IllegalStateException("Celeiro cheio! Não é possível armazenar mais batatas.");
    }
    qtdeBatatas += 2;

}


    public void armazenarCenoura(){
    
       if (capacidade < 2) {
        throw new IllegalStateException("Celeiro cheio! Não é possível armazenar mais batatas.");
    }
    qtdeCenouras += 2;

}

    public void armazenarMorango(){

       if (capacidade < 2) {
        throw new IllegalStateException("Celeiro cheio! Não é possível armazenar mais batatas.");
    }
    qtdeMorangos += 2;

}

    public void consumirBatata(){
        qtdeBatatas -= 1;
        if(qtdeBatatas==0){
            throw new IllegalStateException("Não há batatas, colha antes para consumir.");
        }
    }

    public void consumirCenoura(){
        qtdeCenouras -= 1;
        if(qtdeCenouras==0){
            throw new IllegalStateException("Não há cenouras, colha antes para consumir.");
        }
    }

    public void consumirMorango(){
        qtdeMorangos -= 1;
        if(qtdeMorangos==0){
            throw new IllegalStateException("Não há morangos, colha antes para consumir.");
        }
    }

    public int getEspacoDisponivel(){
        int espaco = capacidade - (qtdeBatatas+qtdeCenouras+qtdeMorangos);
        return espaco;
    }

    public int getOcupacao(){
        int ocupacao;
        int espaco = capacidade - (qtdeBatatas+qtdeCenouras+qtdeMorangos);
        ocupacao = (espaco*100) / capacidade;

        return ocupacao;

    }

    public boolean celeiroCheio(){
        return capacidade ==0;
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
