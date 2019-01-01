package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eu.reversisec.Jogo.Constantes;
import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.Adpters.SPAdapter;
import com.example.eu.reversisec.Jogo.MaqJogador;
import com.example.eu.reversisec.Jogo.MeuJogador;
import com.example.eu.reversisec.Jogo.Utilizador;
import com.example.eu.reversisec.R;

 import java.io.File;

public class activity_modo_singleplayer extends Activity {
    LogicaJogo jogo;
    GridView tabuleiroV;
    SPAdapter spAdapter;
    File fileJogador1, fileJogador2;
    ImageView iv1, iv2;
    TextView tv1,tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_singleplayer);
        jogo = (LogicaJogo) getApplication();

        jogo.setGameType(1);
        tv1 = findViewById(R.id.tvNomeJogador1);
        tv2 = findViewById(R.id.tvNomeJogador2);
        tv3 = findViewById(R.id.tvPecasJ1);
        tv4 = findViewById(R.id.tvPecasJ2);

        tv1.setText(getResources().getString(R.string.jogador1)+": "+jogo.getUtilizador1().getNome());
        tv2.setText(getResources().getString(R.string.jogador2)+": "+getResources().getString(R.string.pc));



        jogo.setTvDadosJ1(tv3);
        jogo.setTvDadosJ2(tv4);



        if(jogo.getUtilizador1().getImgFile()!=null)
        {
             fileJogador1 = new File(Environment.getExternalStorageDirectory()+"/"+jogo.getUtilizador1().getNome()+".jpg");
            Bitmap myBitmap = BitmapFactory.decodeFile(fileJogador1.getAbsolutePath());
            iv1 =   findViewById(R.id.ivFotoJogador1);
            iv1.setImageBitmap(myBitmap);
        }

        ImageView iv2 =  findViewById(R.id.ivFotoJogador2);
        iv2.setImageDrawable(getResources().getDrawable(R.drawable.img_robot));

        tabuleiroV =   findViewById(R.id.tabuleiro);
        tabuleiroV.setNumColumns(8);
        tabuleiroV.setEnabled(false);
        spAdapter = new SPAdapter(this, tabuleiroV, jogo);
        tabuleiroV.setAdapter(spAdapter);
        jogo.setAdapter(spAdapter);
        jogo.setJ1(new MeuJogador(jogo, Constantes.PRETA, jogo.getUtilizador1().getNome()));
        jogo.setJ2(new MaqJogador(jogo, Constantes.BRANCA, "Computador"));


        jogo.inicio();
    }

    @Override
    public void onBackPressed() {

        changeGameMode();
    }

    private void changeGameMode() {
        FragmentBackButton setupTanksDialogFragment = new FragmentBackButton();

        setupTanksDialogFragment.show(getFragmentManager(), "setup");
    }


    public void onPassturn(View view) {
        if (jogo.getjAtual().getTurnos() <= 5)
            Toast.makeText(activity_modo_singleplayer.this, "Só disponível a partir do turno 5", Toast.LENGTH_SHORT).show();
        else
            jogo.PassaTurno();
    }

    public void onPlayAgain(View view) {
        if (jogo.getjAtual().getTurnos() <= 5)
            Toast.makeText(activity_modo_singleplayer.this, "Só disponível a partir do turno 5", Toast.LENGTH_SHORT).show();
        else
            jogo.joga2Vezes();
    }
}
