package com.example.eu.reversisec.Perfil;

import android.app.Activity;
import android.os.Bundle;

import com.example.eu.reversisec.R;

import java.io.Serializable;
import java.util.Date;

public class NovoPerfilActivity extends Activity {

    novoPerfil perfil;
    String nome, foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        nome = getIntent().getStringExtra("Nome");
        if(nome==null)
            nome="Desconhecido";
        foto = getIntent().getStringExtra("Foto");
        if(foto!=null)
            perfil = new novoPerfil(nome, foto);

      //  DadosGuardados.addPerfil(perfil);
        finish();
    }
}

class novoPerfil implements Serializable
{
    String nome, foto;
    Date dataCriacao;
    public novoPerfil(String nome, String foto)
    {
        this.nome = nome;
        this.foto = foto;
        dataCriacao = new Date();
    }
}
