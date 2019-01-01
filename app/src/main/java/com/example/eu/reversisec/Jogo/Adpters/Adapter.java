package com.example.eu.reversisec.Jogo.Adpters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.eu.reversisec.Jogo.Jogador;
import com.example.eu.reversisec.Jogo.LogicaJogo;

public class Adapter extends BaseAdapter {
    Jogador jogador;
    Context contexto;
    GridView gridView;
    LogicaJogo jogo;

    public Adapter(Context contexto, GridView gridView, LogicaJogo jogo){
        this.contexto = contexto;
        this.gridView = gridView;
        this.jogo = jogo;
    }


    @Override
    public void notifyDataSetChanged() {
        gridView.setAdapter(this);
    }

    @Override
    public int getCount(){
        return jogo.getTab().getBlocos().size();
    }

    @Override
    public Object getItem(int pos){
        return jogo.getTab().getBlocos().size();
    }

    @Override
    public long getItemId(int pos){
        return pos;
    }

    @Override
    public View getView(final int pos, View cojnvertView, ViewGroup parents){
        final ImageView img = new ImageView(contexto);

        jogador = jogo.getjAtual();
        img.setImageResource(this.jogo.getTab().getBlocos().get(pos).getImagem());
        img.setAdjustViewBounds(true);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(!jogo.getTab().getBlocos().get(pos).isPosValida()){
                   Log.d("ReversISEC", "onClick: Posição Inválida");
                   return;
               }
               jogador.setPos(pos);
               jogador.joga();
               jogo.fimDeTurno();
               notifyDataSetChanged();
            }
        });

        return img;
    }




}
