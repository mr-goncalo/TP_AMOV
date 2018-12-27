package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.Adpters.SPAdapter;
import com.example.eu.reversisec.Jogo.MeuJogador;
import com.example.eu.reversisec.R;

public class activity_modo_singleplayer extends Activity {
    LogicaJogo jogo;
    GridView tabuleiroV;
    SPAdapter spAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_singleplayer);

        jogo = (LogicaJogo) getApplication();

        tabuleiroV = (GridView) findViewById(R.id.tabuleiro);
        tabuleiroV.setNumColumns(8);
        tabuleiroV.setEnabled(false);
        spAdapter = new SPAdapter(this, tabuleiroV, jogo);
        tabuleiroV.setAdapter(spAdapter);
        jogo.setJ1(new MeuJogador(jogo, R.drawable.preta));
        jogo.setJ2(new MeuJogador(jogo, R.drawable.branca));

        jogo.inicio();
    }
}
