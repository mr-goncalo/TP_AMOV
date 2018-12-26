package com.example.eu.reversisec.Jogo;

import android.graphics.Bitmap;

public class Jogador {
    String nome;
    Bitmap foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bitmap getFoto(){
        return foto;
    }

    public void setFoto(Bitmap foto){
        this.foto = foto;
    }
}
