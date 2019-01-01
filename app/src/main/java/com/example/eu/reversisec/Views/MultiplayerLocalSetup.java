package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.eu.reversisec.Jogo.Constantes;
import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.MeuJogador;
import com.example.eu.reversisec.R;

import java.lang.reflect.Method;

public class MultiplayerLocalSetup extends Activity {
    RadioButton rb_player1_black, rb_player2_black, rb_player1_white, rb_player2_white;
    LogicaJogo gameData;
    EditText p2Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_local_multiplayer);

        gameData = (LogicaJogo) getApplication();
        p2Name = findViewById(R.id.edT_player2_name);

        rb_player1_black = findViewById(R.id.radioButton_p1_black);
        rb_player2_black = findViewById(R.id.radioButton_p2_black);
        rb_player1_white = findViewById(R.id.radioButton_p1_white);
        rb_player2_white = findViewById(R.id.radioButton_p2_white);


        rb_player1_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                rb_player2_black.setChecked(false);
                rb_player2_white.setChecked(true);
                rb_player1_white.setChecked(false);
                rb_player1_black.setChecked(true);

            }
        });
        rb_player2_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rb_player1_black.setChecked(true);
                rb_player1_white.setChecked(false);
                rb_player2_white.setChecked(true);
                rb_player2_black.setChecked(false);

            }
        });
        rb_player2_black.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rb_player1_black.setChecked(false);
                rb_player1_white.setChecked(true);
                rb_player2_white.setChecked(false);
                rb_player2_black.setChecked(true);

            }
        });
        rb_player1_white.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rb_player2_black.setChecked(true);
                rb_player2_white.setChecked(false);
                rb_player1_white.setChecked(true);
                rb_player1_black.setChecked(false);

            }
        });
    }

    public void onCapturarImg(View view){
         if (p2Name.getText().toString().isEmpty())
        {
            Toast.makeText(this, "É necessário preencher o nome!", Toast.LENGTH_SHORT).show();

            return;
        }
        if(Build.VERSION.SDK_INT>=24)
        {
            try
            {
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

        Intent intent = new Intent(this,CamaraActivity.class);
        intent.putExtra("Nome", p2Name.getText().toString());
        intent.putExtra("player", "2");
        startActivity(intent);
    }

    public void onStart(View view){

        //meter as configs para o jogo e começar a jogar
        if (rb_player1_black.isChecked()) {
            gameData.setJ1(new MeuJogador(gameData, Constantes.PRETA, gameData.getUtilizador1().getNome()));
            gameData.setJ2(new MeuJogador(gameData, Constantes.BRANCA, p2Name.getText().toString()));
        } else {
            gameData.setJ1(new MeuJogador(gameData, Constantes.PRETA, gameData.getUtilizador1().getNome()));
            gameData.setJ2(new MeuJogador(gameData, Constantes.BRANCA, p2Name.getText().toString()));

        }

        if(p2Name.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(), "Introduzir Nome do Jogador", Toast.LENGTH_SHORT).show();
            return;
        }else{
            gameData.getUtilizador2().setNome(p2Name.getText().toString());
            Intent intent = new Intent(this,MultiplayerLocalBoardActivity.class);
            startActivity(intent);
        }

    }
}
