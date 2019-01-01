package com.example.eu.reversisec.Jogo;

import java.util.ArrayList;
import java.util.HashMap;

public class Bloco {
    private int posX;
    private int posY;
    private int imagem;
    private int posicao;

    private HashMap<Integer, Bloco> PosAdjacentes;

    private boolean PosValida;

    private ArrayList<Integer> Direcoes;





    public void addPosAdjacentes(Bloco PosAdjacentes, int AdjKey) {
        this.PosAdjacentes.put(AdjKey, PosAdjacentes);
    }



    //============GET============
    public ArrayList<Integer> getDirecoes() {
        return Direcoes;
    }


    public int getPosX(){
        return posX;}


    public int getPosY(){

        return posY;
    }


    public int getImagem(){
        if(PosValida)
            return Constantes.VALIDA;

        return imagem;
    }

    public int getPosicao() {
        return posicao;
    }

    public HashMap<Integer, Bloco> getPosAdjacentes() {
        return PosAdjacentes;
    }

    //============SET============
    public void setImagem(int BlocoImg){
        this.imagem = BlocoImg;
    }

    public void setPosValida(boolean PosValida) {
        this.PosValida = PosValida;
    }
    //============Outros============

    public Bloco(int posicao, int posX, int posY){
        this.posX = posX;
        this.posY = posY;

        this.posicao = posicao;

        PosValida = false;

        this.imagem = Constantes.FUNDO;
        this.PosAdjacentes = new HashMap<>();
        Direcoes = new ArrayList<>();
    }


    public void jogar(int img){
        this.imagem = img;

        for (int d: Direcoes){
            Bloco bloco = PosAdjacentes.get(d);
            if(bloco != null){
                while(bloco != null && bloco.getImagem()!= img){
                    bloco.vira();
                    bloco = bloco.getPosAdjacentes().get(d);
                }
            }
        }
    }

    public void vira(){
        if(imagem == Constantes.PRETA) {
            imagem = Constantes.BRANCA; }
        else if(imagem == Constantes.BRANCA) {
            imagem = Constantes.BRANCA;
        }

    }

    public boolean isPosValida() {
        return PosValida;
    }


}
