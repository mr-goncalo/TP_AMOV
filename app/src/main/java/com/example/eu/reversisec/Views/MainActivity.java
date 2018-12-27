package com.example.eu.reversisec.Views;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
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
        /*Typeface font = Typeface.createFromAsset(getAssets(),"fonts/AmaticSC.ttf");
        btn1.setTypeface(font);
        btn2.setTypeface(font);
        btn3.setTypeface(font);
        btn4.setTypeface(font);
        btn1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        btn2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        btn3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        btn4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);*/
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
      /*  Intent intent = new Intent(this,TemporizadorActivity.class);
        boolean rede = false;
        intent.putExtra("rede", rede);
        startActivity(intent); */
    }

    public void onJogarEmRede(View v)
    {
       /* Intent intent = new Intent(this,TemporizadorActivity.class);
        boolean rede = true;
        intent.putExtra("rede", rede);
        startActivity(intent); */
    }

    public void onHistorico(View v){
         Intent intent = new Intent(this,ConsultaHistoricoActivity.class);
        startActivity(intent);
    }

    public void onSobre(MenuItem item)
    {/*
        Intent intent = new Intent(this,SobreActivity.class);
        startActivity(intent); */
        Intent intent = new Intent(this,PerfilActivity.class);
        startActivity(intent);
    }

    public void onPerfil(MenuItem item)
    {
        Intent intent = new Intent(this,PerfilActivity.class);
        startActivity(intent);
    }
    public void onLinguagem(MenuItem item)
    {
        Intent intent = new Intent(this,PerfilActivity.class);
        startActivity(intent);
    }
}
