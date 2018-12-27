package com.example.eu.reversisec.Jogo;

import com.example.eu.reversisec.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Bloco {
    private int posX;
    private int posY;
    private int blogoImg;
    private int posicao;

    private HashMap<Integer, Bloco> PosAdjacentes;

    private boolean PosValida;

    private ArrayList<Integer> Direcoes;

    public Bloco(int posicao, int posX, int posY){
        this.posX = posX;
        this.posY = posY;

        this.posicao = posicao;

        PosValida = false;

        this.blogoImg = Constantes.BLOCO;
        this.PosAdjacentes = new HashMap<>();
        Direcoes = new ArrayList<>();
    }

    public int getPosX(){return posX;}

    public void setPosX(int posX){this.posX = posX;}

    public int getPosY(){return posY;}

    public void setPosY(int posY){this.posY = posY;}

    public int getBlogoImg(){
        if(PosValida) return R.drawable.posicao_valida;

        return blogoImg;
    }
    public void setBlogoImg(int BlocoImg){
        this.blogoImg = BlocoImg;
    }

    public void jogar(int img){
        this.blogoImg = img;

        for (int d: Direcoes){
            Bloco bloco = PosAdjacentes.get(d);
            if(bloco != null){
                while(bloco != null && bloco.getBlogoImg()!= img){
                    bloco.vira();
                    bloco = bloco.getPosAdjacentes().get(d);
                }
            }



        }
    }

    public void vira(){
        if(blogoImg == R.drawable.preta) blogoImg = R.drawable.branca; else
        if(blogoImg == R.drawable.branca) blogoImg = R.drawable.preta;

    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public HashMap<Integer, Bloco> getPosAdjacentes() {
        return PosAdjacentes;
    }

    public void setPosAdjacentes(HashMap<Integer, Bloco> PosAdjacentes) {
        this.PosAdjacentes = PosAdjacentes;
    }

    public boolean isPosValida() {
        return PosValida;
    }

    public void setPosValida(boolean PosValida) {
        this.PosValida = PosValida;
    }

    public void addPosAdjacentes(Bloco PosAdjacentes, int AdjKey) {
        this.PosAdjacentes.put(AdjKey, PosAdjacentes);
    }

    public ArrayList<Integer> getDirecoes() {
        return Direcoes;
    }

    public void setDirecoes(ArrayList<Integer> Direcoes) {
        this.Direcoes = Direcoes;
    }

}
