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

    public Jogador (LogicaJogo jogo, int img, String nome){ //confirmado
        this.jogo = jogo;
        this.img = img;
        this.nome = nome;
        joga2Vezes = true;
        passaTurno = true;

    }

    public Jogador(Jogador j){
        this.jogo = j.jogo;
        this.pontos = j.pontos;
        this.passaTurno = j.passaTurno;
        this.joga2Vezes = j.joga2Vezes;
        this.nome = j.nome;
        this.foto = j.foto;
        this.pos = j.pos;
        this.img = j. img;
        this.jogadorAtual = j.jogadorAtual;
    }

    public boolean isJoga2Vezes() {
        return joga2Vezes;
    }

    public void setJoga2Vezes(boolean joga2Vezes){
        this.joga2Vezes = joga2Vezes;
    }

    public boolean isPassaTurno() {
        return passaTurno;
    }

    public void setPassaTurno(boolean passaTurno){
        this.passaTurno = passaTurno;
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
