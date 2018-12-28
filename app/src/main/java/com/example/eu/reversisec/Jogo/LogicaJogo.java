package com.example.eu.reversisec.Jogo;

import android.app.Application;

import com.example.eu.reversisec.R;

import java.util.HashMap;

public class LogicaJogo extends Application {
    Utilizador utilizador1;
    Utilizador utilizador2;
    Tabuleiro tab;
    Jogador j1;
    Jogador j2;
    Jogador jAtual;

    @Override
    public void onCreate(){
        super.onCreate();
        utilizador1 = new Utilizador();
        utilizador2 = new Utilizador();
        tab = new Tabuleiro();
    }

    public void inicio(){
        jAtual = j1;
        setBlocosV();
    }

    public Tabuleiro getTab(){return tab;}

    public void setTab (Tabuleiro tab){this.tab=tab;}

    public void validaDirecao(Bloco bl, int dir){
        Bloco blocoAtual;
        HashMap<Integer, Bloco> blocoAdj = bl.getPosAdjacentes();
        blocoAtual = blocoAdj.get(dir);
        int enimigo;
        if(jAtual == j1)
            enimigo = j2.getImg();
        else
            enimigo = j1.getImg();

        if (blocoAtual == null ||blocoAtual.getBlogoImg() == Constantes.FUNDO || blocoAtual.getBlogoImg() == Constantes.VALIDA ||
            blocoAtual.getBlogoImg()==jAtual.getImg() || bl.getBlogoImg() == enimigo || bl.getBlogoImg() == jAtual.getImg()){
            return;
        }



        while (blocoAtual != null && blocoAtual.getBlogoImg() == enimigo){
            blocoAtual = blocoAtual.getPosAdjacentes().get(dir);
        }

        if(blocoAtual.getBlogoImg() == jAtual.getImg())
            bl.getDirecoes().add(dir);
    }

    public void setBlocosV(){
        Bloco blocoAtual;
        boolean flag = false;

        for(Bloco bl : tab.getBlocos()){
            bl.getDirecoes();

            HashMap<Integer, Bloco> blocoAdj = bl.getPosAdjacentes();
            validaDirecao(bl, Constantes.LEFT);
            validaDirecao(bl, Constantes.UPPER_LEFT);
            validaDirecao(bl, Constantes.UPPER);
            validaDirecao(bl, Constantes.UPPER_RIGHT);
            validaDirecao(bl, Constantes.RIGHT);
            validaDirecao(bl, Constantes.BOTTOM_RIGHT);
            validaDirecao(bl, Constantes.BOTTOM);
            validaDirecao(bl, Constantes.BOTTOM_LEFT);

            if (bl.getDirecoes().size()>0)
                bl.setPosValida(true);
            else
                bl.setPosValida(false);
        }
    }

    public void fimDeTurno(){
        mudaDeJogador();
        reset();
    }

    public void mudaDeJogador(){

        if(jAtual == j1){
            j1.setJogadorAtual(false);
            j2.setJogadorAtual(true);
            jAtual = j2;
        }
        else{
            j1.setJogadorAtual(true);
            j2.setJogadorAtual(false);
            jAtual = j1;
        }
    }

    public void reset(){
        resetBlocosV();
        setBlocosV();
    }

    public void resetBlocosV(){
        for (Bloco bl : tab.getBlocos())
            bl.setPosValida(false);
    }

    public Utilizador getUtilizador1() {
        return utilizador1;
    }

    public Utilizador getUtilizador2() {
        return utilizador2;
    }

    public void setUtilizador2(Utilizador utilizador2) {
        this.utilizador2 = utilizador2;
    }

    public void setUtilizador1(Utilizador utilizador1) {
        this.utilizador1 = utilizador1;
    }

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }

    public Jogador getJ1() {
        return j1;
    }

    public Jogador getJ2() {
        return j2;
    }

    public void setJ2(Jogador j2) {
        this.j2 = j2;
    }

    public Jogador getjAtual() {
        return jAtual;
    }

    public void setjAtual(Jogador jAtual) {
        this.jAtual = jAtual;
    }


}
