package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.R;

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

    private void onCapturarImg(View view){

    }

    private void onStart(View view){

    }
}
