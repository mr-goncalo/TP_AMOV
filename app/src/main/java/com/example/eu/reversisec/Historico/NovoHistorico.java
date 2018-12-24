package com.example.eu.reversisec.Historico;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by joaopedrojaneiro on 31/12/17.
 */

public class NovoHistorico implements Serializable
{

    ArrayList<Integer> pos1 = new ArrayList<Integer>();
    ArrayList<Integer> pos2 = new ArrayList<Integer>();
    ArrayList<String> jogador = new ArrayList<String>();
    String vencedor;
    Integer tempo;
    Date dataCriacao;

    public NovoHistorico(){}

    public void setTempo(int tempo)
    {
        this.tempo=tempo;
    }

    public void setVencedor(String vencedor)
    {
        this.vencedor=vencedor;
        dataCriacao = new Date();
     //   DadosGuardados.addHistorico(this);
    }

    public Integer getPos1(int n)
    {
        return pos1.get(n);
    }

    public Integer getPos2(int n)
    {
        return pos2.get(n);
    }

    public ArrayList<Integer> getPos1()
    {
        return pos1;
    }

    public ArrayList<Integer> getPos2()
    {
        return pos2;
    }

    public ArrayList<String> getJogador()
    {
        return jogador;
    }

    public int getTamanho()
    {
        return pos1.size();
    }

    public String getVencedor()
    {
        return vencedor;
    }

    public Date getDataCriancao()
    {
        return dataCriacao;
    }

    public void setJogada(int pos1, int pos2, String jogador)
    {
        this.jogador.add(jogador);
        this.pos1.add(pos1);
        this.pos2.add(pos2);
    }

}
