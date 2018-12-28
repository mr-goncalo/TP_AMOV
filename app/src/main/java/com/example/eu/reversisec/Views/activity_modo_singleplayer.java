package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.eu.reversisec.Jogo.Constantes;
import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.Adpters.SPAdapter;
import com.example.eu.reversisec.Jogo.MeuJogador;
import com.example.eu.reversisec.R;

 import java.io.File;

public class activity_modo_singleplayer extends Activity {
    LogicaJogo jogo;
    GridView tabuleiroV;
    SPAdapter spAdapter;
    File fileJogador1, fileJogador2;
    ImageView iv1, iv2;
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_singleplayer);
        jogo = (LogicaJogo) getApplication();

        tv1 = findViewById(R.id.tvNomeJogador1);
        tv2 = findViewById(R.id.tvNomeJogador2);

        tv1.setText(getResources().getString(R.string.jogador1)+": "+jogo.getUtilizador1().getNome());
        tv2.setText(getResources().getString(R.string.jogador2)+": "+getResources().getString(R.string.pc));

        if(jogo.getUtilizador1().getImgFile()!=null)
        {
             fileJogador1 = new File(Environment.getExternalStorageDirectory()+"/"+jogo.getUtilizador1().getNome()+".jpg");
            Bitmap myBitmap = BitmapFactory.decodeFile(fileJogador1.getAbsolutePath());
            iv1 = (ImageView) findViewById(R.id.ivFotoJogador1);
            iv1.setImageBitmap(myBitmap);
        }

        ImageView iv2 = (ImageView) findViewById(R.id.ivFotoJogador2);
        iv2.setImageDrawable(getResources().getDrawable(R.drawable.img_robot));

        tabuleiroV = (GridView) findViewById(R.id.tabuleiro);
        tabuleiroV.setNumColumns(8);
        tabuleiroV.setEnabled(false);
        spAdapter = new SPAdapter(this, tabuleiroV, jogo);
        tabuleiroV.setAdapter(spAdapter);
        jogo.setJ1(new MeuJogador(jogo, Constantes.PRETA));
        jogo.setJ2(new MeuJogador(jogo, Constantes.BRANCA));

        jogo.inicio();
    }
}
