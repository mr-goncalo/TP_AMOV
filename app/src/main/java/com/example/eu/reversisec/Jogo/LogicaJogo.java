package com.example.eu.reversisec.Jogo;

import android.app.Application;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogicaJogo extends Application {

    Utilizador utilizador1;
    Utilizador utilizador2;

    Tabuleiro tab;
    Jogador j1;
    Jogador j2;
    Jogador jAtual;
    int gameType;
    int turnJ1;
    int turnJ2;
    int pontosJ1;
    int pontosJ2;

    boolean joga2Vezes;
    boolean passaTurno;

    boolean fimJogo;

    TextView tvDadosJ1;
    TextView tvDadosJ2;

    public  ArrayList<Historico> historicos;

    BaseAdapter adapter;

    @Override
    public void onCreate(){
        super.onCreate();
        utilizador1 = new Utilizador();
        utilizador2 = new Utilizador();
        this.historicos = new ArrayList<>();
        tab = new Tabuleiro();
    }

    public void resetDadosJogo(){
        j1= null;
        j2= null;
        tab = new Tabuleiro();
        turnJ2 = 0;
        turnJ1 = 0;
        pontosJ2 = 0;
        pontosJ1 = 0;
    }

    public void inicio(){
        jAtual = j1;
        setBlocosV();
        turnJ1 = 1;
        turnJ2 = 0;
        pontosJ1 = 0;
        pontosJ2 = 0;
        tvDadosJ1.setText("Turn: "+getTurnJ1()+"\nScore: 2");
        tvDadosJ2.setText("Turn: "+getTurnJ2()+"\nScore: 2");
    }

    public BaseAdapter getAdapter(){
        return adapter;
    }

     public void setAdapter(BaseAdapter adapter){
        this.adapter = adapter;
    }
    public int getGameType() {
        return gameType;
    }

    public void setGameType(int gameType) {
        this.gameType = gameType;
    }

    public Tabuleiro getTab(){return tab;}

    public void setTab (Tabuleiro tab){this.tab=tab;}

    public void validaDirecao(Bloco bl, int dir){
        Bloco blocoAtual;
        HashMap<Integer, Bloco> blocoAdj = bl.getPosAdjacentes();
        blocoAtual = blocoAdj.get(dir);
        int enimigo;
        if(jAtual == j1)
            enimigo = j2.getImg();
        else
            enimigo = j1.getImg();

        if (blocoAtual == null ||blocoAtual.getImagem() == Constantes.FUNDO || blocoAtual.getImagem() == Constantes.VALIDA ||
            blocoAtual.getImagem()==jAtual.getImg() || bl.getImagem() == enimigo || bl.getImagem() == jAtual.getImg()){
            return;
        }



        while (blocoAtual != null && blocoAtual.getImagem() == enimigo){
            blocoAtual = blocoAtual.getPosAdjacentes().get(dir);
        }
        if(blocoAtual != null) {
            if (blocoAtual.getImagem() == jAtual.getImg())
                bl.getDirecoes().add(dir);
        }
    }

    public void setBlocosV(){
        Bloco blocoAtual;
        boolean flag = false;

        for(Bloco bl : tab.getBlocos()){
            bl.getDirecoes().clear();

            HashMap<Integer, Bloco> blocoAdj = bl.getPosAdjacentes();
            validaDirecao(bl, Constantes.LEFT);
            validaDirecao(bl, Constantes.UPPER_LEFT);
            validaDirecao(bl, Constantes.UPPER);
            validaDirecao(bl, Constantes.UPPER_RIGHT);
            validaDirecao(bl, Constantes.RIGHT);
            validaDirecao(bl, Constantes.BOTTOM_RIGHT);
            validaDirecao(bl, Constantes.BOTTOM);
            validaDirecao(bl, Constantes.BOTTOM_LEFT);

            if (bl.getDirecoes().size()>0)
                bl.setPosValida(true);
            else
                bl.setPosValida(false);
        }
    }

    public void fimDeTurno(){
        if(!isJoga2Vezes()){
            mudaDeJogador();
        }

        reset();


        if(jAtual instanceof MaqJogador){
            adapter.notifyDataSetChanged();

            int eval = jogadaInteligente();
            if(eval >=0) {
                jAtual.setPos(eval);
                jAtual.joga();
            }

            fimDeTurno();
            adapter.notifyDataSetChanged();
        }
        joga2Vezes = false;
    }

    public void fazJogadaAutomatica(){
        adapter.notifyDataSetChanged();

        int eval = jogadaInteligente();
        if(eval >=0)
            jAtual.setPos(eval);
        jAtual.joga();

        fimDeTurno();
        adapter.notifyDataSetChanged();
    }

    public ArrayList<Historico> getHistoricos() {
        return historicos;
    }

    public void mudaDeJogador(){

        if(jAtual == j1){
            j1.setJogadorAtual(false);
            j2.setJogadorAtual(true);
            jAtual = j2;
        }
        else{
            j1.setJogadorAtual(true);
            j2.setJogadorAtual(false);
            jAtual = j1;
        }
    }

    public void reset(){
        resetBlocosV();

        if(jAtual == j1){
            turnJ1++;
        }
        else
            turnJ2++;
        j1.setTurnos(turnJ1);
        j2.setTurnos(turnJ2);

        atualizaDados();
        setBlocosV();

        if(!hasPosvalidas()){
            fimJogo = true;
            //falta uma atividade para acabar o jogo
        }
    }

    public void atualizaDados(){
        int pontosJ1=0;
        int pontosJ2=0;
        for(Bloco b: tab.getBlocos()){
            if(b.getImagem() == j1.getImg()){
                pontosJ1 ++;

            }
            if(b.getImagem() == j2.getImg()){
                pontosJ2 ++;

            }
        }
        setPontosJ1(pontosJ1);
        setPontosJ2(pontosJ2);

        tvDadosJ1.setText("Turn: "+getTurnJ1()+"\nScore: "+getPontosJ1());
        tvDadosJ2.setText("Turn: "+getTurnJ2()+"\nScore: "+getPontosJ2());
    }

    public void resetBlocosV(){
        for (Bloco bl : tab.getBlocos())
            bl.setPosValida(false);
    }

    public Utilizador getUtilizador1() {
        return utilizador1;
    }

    public Utilizador getUtilizador2() {
        return utilizador2;
    }

    public void setUtilizador2(Utilizador utilizador2) {
        this.utilizador2 = utilizador2;
    }

    public void setUtilizador1(Utilizador utilizador1) {
        this.utilizador1 = utilizador1;
    }

    public void setJ1(Jogador j1) {
        this.j1 = j1;
    }

    public Jogador getJ1() {
        return j1;
    }

    public Jogador getJ2() {
        return j2;
    }

    public void setJ2(Jogador j2) {
        this.j2 = j2;
    }

    public Jogador getjAtual() {
        return jAtual;
    }

    public void setjAtual(Jogador jAtual) {
        this.jAtual = jAtual;
    }

    public boolean isPassaTurno() {
        return passaTurno;
    }

    public boolean isJoga2Vezes() {
        return joga2Vezes;
    }



    public int getTurnJ1() {
        return turnJ1;
    }

    public int getTurnJ2() {
        return turnJ2;
    }

    public void setTurnJ1(int turnJ1) {
        this.turnJ1 = turnJ1;
    }

    public void setTurnJ2(int turnJ2) {
        this.turnJ2 = turnJ2;
    }

    public int getPontosJ1() {
        return pontosJ1;
    }

    public int getPontosJ2() {
        return pontosJ2;
    }

    public void setPontosJ1(int pontosJ1) {
        this.pontosJ1 = pontosJ1;
    }

    public void setPontosJ2(int pontosJ2) {
        this.pontosJ2 = pontosJ2;
    }

    public TextView getTvDadosJ1() {
        return tvDadosJ1;
    }

    public TextView getTvDadosJ2() {
        return tvDadosJ2;
    }

    public void setTvDadosJ1(TextView tvDadosJ1) {
        this.tvDadosJ1 = tvDadosJ1;
    }

    public void setTvDadosJ2(TextView tvDadosJ2) {
        this.tvDadosJ2 = tvDadosJ2;
    }

    private boolean hasPosvalidas(){
        for(Bloco bl : tab.getBlocos()){
            if(bl.isPosValida())
                return true;
        }
        return false;
    }

    public int jogadaInteligente(){
        List<Bloco> blocos = tab.getBlocos();

        Map<Bloco, Integer> avalia = new HashMap<>();

        for(Bloco bl: blocos) {
            if(!bl.isPosValida())
                continue;

            ArrayList<Integer> direcaovalida = bl.getDirecoes();
            HashMap<Integer, Bloco> posAdjacentes = bl.getPosAdjacentes();

            int eval = 0;

            for (int dv : direcaovalida){
                Bloco blocoAtual = posAdjacentes.get(dv);
                if(blocoAtual != null){
                    while(blocoAtual != null && blocoAtual.getImagem() != bl.getImagem()){
                        eval++;
                        blocoAtual = blocoAtual.getPosAdjacentes().get(dv);

                    }
                }

            }
            avalia.put(bl, eval);
        }
        Map.Entry<Bloco, Integer> max = null;

        for ( Map.Entry<Bloco, Integer> entry : avalia.entrySet()){
            if(max == null || entry.getValue().compareTo(max.getValue())>0){
                max = entry;
            }
        }
        return max !=null ? max.getKey().getPosicao() : -1;
    }

    public void joga2Vezes(){
        if(jAtual.isJoga2Vezes()){
            this.joga2Vezes = true;
            jAtual.setJoga2Vezes(false);
        }
    }

    public void PassaTurno(){
        if(jAtual.isPassaTurno() && !joga2Vezes){
            jAtual.setPassaTurno(false);
            fimDeTurno();
            adapter.notifyDataSetChanged();
        }
    }



    public void setJoga2Vezes(boolean joga2Vezes) {
        this.joga2Vezes = joga2Vezes;
    }

    public void setPassaTurno(boolean passaTurno) {
        this.passaTurno = passaTurno;
    }
}
