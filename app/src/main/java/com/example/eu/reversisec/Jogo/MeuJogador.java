package com.example.eu.reversisec.Jogo;

public class MeuJogador extends Jogador {

    public MeuJogador(LogicaJogo jogo, int img){
        super(jogo, img);
    }

    @Override
    public void setPos(int posicao) {
        pos = posicao;
    }

    public MeuJogador(Jogador j){
        super(j);
    }
}
