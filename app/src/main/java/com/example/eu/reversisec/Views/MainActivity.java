package com.example.eu.reversisec.Views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
 import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.eu.reversisec.Jogo.LogicaJogo;
 import com.example.eu.reversisec.R;

public class MainActivity extends AppCompatActivity {


    LogicaJogo jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jogo = (LogicaJogo) getApplication();
        
        Button btn1 =  findViewById(R.id.btnUmJogador);
        Button btn2 =  findViewById(R.id.btnMultiplayer);
        Button btn3 = findViewById(R.id.btnJogarEmRede);
        Button btn4 = findViewById(R.id.btnHistorico);

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_principal,menu);
        return true;
    }

    public void onUmJogador(View v)
    {

        Intent intent = new Intent(this,activity_modo_singleplayer.class);
        boolean pc = true;
        String tempo="0";
     /*   intent.putExtra("computador", pc);
        intent.putExtra("tempo", tempo);
        intent.putExtra("tempoextra", "0");
       */ startActivity(intent);
    }

    public void onDoisJogadores(View v){
         Intent intent = new Intent(this,MultiplayerLocalSetup.class);

        startActivity(intent);
    }

    public void onJogarEmRede(View v)
    {

    }

    public void onHistorico(View v){
       Intent intent = new Intent(this,HistoticoActivity.class);
        startActivity(intent);
    }

    public void onSobre(MenuItem item)
    {
        Intent intent = new Intent(this,SobreActivity.class);
        startActivity(intent);
    }

}
