package com.example.eu.reversisec.Jogo;

import android.graphics.Bitmap;

public class Utilizador {
    String nome;
    Bitmap foto;
    String imgFile;

    public String getNome() {
        return nome;
    }

    public void setImgFile(String imgFile) {
        this.imgFile = imgFile;
    }

    public String getImgFile() {
        return imgFile;
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
