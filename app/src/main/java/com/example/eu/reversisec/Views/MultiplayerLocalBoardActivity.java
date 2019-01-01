package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eu.reversisec.Jogo.Adpters.SPAdapter;
import com.example.eu.reversisec.Jogo.Constantes;
import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.MeuJogador;
import com.example.eu.reversisec.R;

import java.io.File;

public class MultiplayerLocalBoardActivity extends Activity {

    LogicaJogo jogo;
    GridView tabuleiroV;
    SPAdapter spAdapter;
    File fileJogador1, fileJogador2;
    ImageView iv1, iv2;
    TextView tv1,tv2, tv3, tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_multiplayer_local_board);

        jogo = (LogicaJogo) getApplication();

        jogo.setGameType(2);
        tv1 = findViewById(R.id.tvNomeJogador1);
        tv2 = findViewById(R.id.tvNomeJogador2);
        tv3 = findViewById(R.id.tvPecasJ1);
        tv4 = findViewById(R.id.tvPecasJ2);

        tv1.setText(getResources().getString(R.string.jogador1)+": "+jogo.getUtilizador1().getNome());
        tv2.setText(getResources().getString(R.string.jogador2)+": "+jogo.getUtilizador2().getNome());
        jogo.setTvDadosJ1(tv3);
        jogo.setTvDadosJ2(tv4);

        Bitmap myBitmap = null;
        if(jogo.getUtilizador1().getImgFile()!=null)
        {
            fileJogador1 = new File(Environment.getExternalStorageDirectory()+"/"+jogo.getUtilizador1().getNome()+".jpg");
              myBitmap = BitmapFactory.decodeFile(fileJogador1.getAbsolutePath());
            iv1 =   findViewById(R.id.ivFotoJogador1);
            iv1.setImageBitmap(myBitmap);
        }
        if(jogo.getUtilizador1().getImgFile()!=null)
        {
            fileJogador2 = new File(Environment.getExternalStorageDirectory()+"/"+jogo.getUtilizador2().getNome()+".jpg");
            myBitmap = BitmapFactory.decodeFile(fileJogador2.getAbsolutePath());
            iv2 =   findViewById(R.id.ivFotoJogador2);
            iv2.setImageBitmap(myBitmap);
        }else {
            iv2 =   findViewById(R.id.ivFotoJogador2);
            iv2.setImageDrawable(getResources().getDrawable(R.drawable.img_robot));
        }

        tabuleiroV =   findViewById(R.id.tabuleiro);
        tabuleiroV.setNumColumns(8);
        tabuleiroV.setEnabled(false);
        spAdapter = new SPAdapter(this, tabuleiroV, jogo);
        tabuleiroV.setAdapter(spAdapter);

       jogo.setJ1(new MeuJogador(jogo, Constantes.PRETA, jogo.getUtilizador1().getNome()));
       jogo.setJ2(new MeuJogador(jogo, Constantes.BRANCA, jogo.getUtilizador2().getNome()));

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


    public void onPlayAgainMPJ2(View view) {
        if (jogo.getjAtual().getTurnos() <= 5)
            Toast.makeText(MultiplayerLocalBoardActivity.this, "Só disponível a partir do turno 5", Toast.LENGTH_SHORT).show();
        else
            jogo.joga2Vezes();
    }

    public void onpassturnMPJ2(View view) {
        if (jogo.getjAtual().getTurnos() <= 5)
            Toast.makeText(MultiplayerLocalBoardActivity.this, "Só disponível a partir do turno 5", Toast.LENGTH_SHORT).show();
        else
            jogo.PassaTurno();
    }

    public void onpassturnMPJ1(View view) {
        if (jogo.getjAtual().getTurnos() <= 5)
            Toast.makeText(MultiplayerLocalBoardActivity.this, "Só disponível a partir do turno 5", Toast.LENGTH_SHORT).show();
        else
            jogo.PassaTurno();
    }

    public void onPlayAgainMPJ1(View view) {
        if (jogo.getjAtual().getTurnos() <= 5)
            Toast.makeText(MultiplayerLocalBoardActivity.this, "Só disponível a partir do turno 5", Toast.LENGTH_SHORT).show();
        else
            jogo.joga2Vezes();
    }
}
