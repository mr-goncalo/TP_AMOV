package com.example.eu.reversisec.Jogo;

import android.graphics.Bitmap;

public abstract class Jogador {

    LogicaJogo jogo;
    int img;
    String nome;
    Bitmap foto;
    int pos;
    int pontos;
    int turnos;

    boolean joga2Vezes;
    boolean passaTurno;

    boolean jogadorAtual = false;

    public void joga(){
        jogo.getTab().getBlocos().get(pos).jogar(img);
    }




    //============GET============

    public int getImg() {
        return img;
    }


    public int getTurnos() {
        return turnos;
    }

    public String getNome() {
        return nome;
    }



    //============SET============
    public abstract void setPos(int pos);



    public void setJogadorAtual(boolean jogadorAtual) {
        this.jogadorAtual = jogadorAtual;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }
    public void setPassaTurno(boolean passaTurno){
        this.passaTurno = passaTurno;
    }

    public void setJoga2Vezes(boolean joga2Vezes){
        this.joga2Vezes = joga2Vezes;
    }

    //============Outros============
    public Jogador (LogicaJogo jogo, int img, String nome){ //confirmado
        this.jogo = jogo;
        this.img = img;
        this.nome = nome;
        joga2Vezes = true;
        passaTurno = true;

    }



    public boolean isJoga2Vezes() {
        return joga2Vezes;
    }



    public boolean isPassaTurno() {
        return passaTurno;
    }

}
