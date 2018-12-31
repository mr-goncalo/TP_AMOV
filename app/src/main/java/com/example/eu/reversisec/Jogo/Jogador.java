package com.example.eu.reversisec.Jogo;

import android.graphics.Bitmap;

public abstract class Jogador {

    LogicaJogo jogo;
    int img;
    String nome;
    Bitmap foto;
    int pos;
    int turnos;

    boolean jogadorAtual = false;

    public Jogador (LogicaJogo jogo, int img){
        this.jogo = jogo;
        this.img = img;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
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

    public int getTurnos() {
    return turnos;
    }
}
