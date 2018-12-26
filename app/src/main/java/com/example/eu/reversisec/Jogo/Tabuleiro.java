package com.example.eu.reversisec.Jogo;

import com.example.eu.reversisec.R;

import java.util.ArrayList;

public class Tabuleiro {
    ArrayList<Bloco> blocos;

    public Tabuleiro(){
        blocos = new ArrayList<>();
        novoTabuleiro();
    }

    public void novoTabuleiro(){
        int posX = 0;
        int posY = 0;

        for(int i = 0; i <64; i++){
            blocos.add(new Bloco(i, posX, posY));

            posX++;

            if(i==7){
                posY = 1;
                posX = 0;
            } else if(i==15){
                posY = 2;
                posX = 0;
            } else if(i==23){
                posY = 3;
                posX = 0;
            } else if(i==31){
                posY = 4;
                posX = 0;
            } else if(i==39){
                posY = 5;
                posX = 0;
            } else if(i==47){
                posY = 6;
                posX = 0;
            } else if(i==55){
                posY = 7;
                posX = 0;
            }
        }
        for (int j = 0; j<64; j++){
                    setBlocosAdj(this.blocos.get(j));
            }

            blocos.get(8*3+3).setBlogoImg(R.drawable.branca);
            blocos.get(8*4+4).setBlogoImg(R.drawable.branca);
            blocos.get(8*3+3).setBlogoImg(R.drawable.preta);
            blocos.get(8*4+4).setBlogoImg(R.drawable.preta);
    }

    public ArrayList<Bloco> getBlocos(){
        return blocos;
    }

    public void setBlocos(ArrayList<Bloco> blocos) {
        this.blocos = blocos;
    }

    private void setBlocosAdj(Bloco bloco){
        switch (bloco.getPosX()){
            case 0: // coluna 0
                if (bloco.getPosY() == 0) {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 9), Constantes.BOTTOM_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 8), Constantes.BOTTOM);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 1), Constantes.RIGHT);
                } else if (bloco.getPosY() == 7) {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 7), Constantes.UPPER_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 8), Constantes.UPPPER);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 1), Constantes.RIGHT);
                } else {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 9), Constantes.BOTTOM_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 8), Constantes.BOTTOM);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 1), Constantes.RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 7), Constantes.UPPER_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 8), Constantes.UPPPER);

                }
                break;


            case 7:
                if (bloco.getPosY() == 0) {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 8), Constantes.BOTTOM);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 7), Constantes.BOTTOM_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 1), Constantes.LEFT);
                } else if (bloco.getPosY() == 7) {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 9), Constantes.UPPER_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 8), Constantes.UPPPER);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 1), Constantes.LEFT);
                } else {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 9), Constantes.UPPER_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 1), Constantes.LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 8), Constantes.UPPPER);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 7), Constantes.BOTTOM_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 8), Constantes.BOTTOM);

                }
                break;

            default:
                if (bloco.getPosY() == 0) {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 9), Constantes.BOTTOM_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 7), Constantes.BOTTOM_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 8), Constantes.BOTTOM);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 1), Constantes.LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 1), Constantes.RIGHT);
                } else if (bloco.getPosY() == 7) {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 9), Constantes.UPPER_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 7), Constantes.UPPER_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 8), Constantes.UPPPER);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 1), Constantes.LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 1), Constantes.RIGHT);
                } else {
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 9), Constantes.BOTTOM_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 7), Constantes.BOTTOM_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 9), Constantes.UPPER_LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 7), Constantes.UPPER_RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 1), Constantes.LEFT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 1), Constantes.RIGHT);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() - 8), Constantes.UPPPER);
                    bloco.addPosAdjacentes(this.blocos.get(bloco.getPosicao() + 8), Constantes.BOTTOM);

                }
                break;

        }
    }
}