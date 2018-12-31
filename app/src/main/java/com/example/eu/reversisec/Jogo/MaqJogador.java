package com.example.eu.reversisec.Jogo;

public class MaqJogador extends Jogador {
    public MaqJogador(LogicaJogo jogo, int img){
        super(jogo, img);
    }

    public MaqJogador(Jogador j){
        super(j);
    }

    @Override
    public void setPos(int pos) {
        this.pos = pos;
    }
}
