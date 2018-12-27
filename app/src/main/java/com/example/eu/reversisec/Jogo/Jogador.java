package com.example.eu.reversisec.Jogo;

import android.graphics.Bitmap;

public abstract class Jogador {

    LogicaJogo jogo;
    int img;
    String nome;
    Bitmap foto;
    int pos;

    boolean jogadorAtual = false;

    public Jogador (LogicaJogo jogo, int img){
        this.jogo = jogo;
        this.img = img;
    }

    public void joga(){
        jogo.getTab().getBlocos().get(pos).jogar(img);
    }

    public abstract void setPos(int pos);

    public boolean isJogadorAtual() {
        return jogadorAtual;
    }

    public void setJogadorAtual(boolean jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
