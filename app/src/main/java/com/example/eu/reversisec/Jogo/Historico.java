package com.example.eu.reversisec.Jogo;

import com.example.eu.reversisec.Jogo.Jogador;
import com.example.eu.reversisec.Jogo.Utilizador;

import java.io.Serializable;


public class Historico implements Serializable {
    private static final long serialVersionUID = -33318182028391L;
    Jogador winner;
    Jogador loser;
    int player1Turnos;
    int player2Turnos;
    public Historico(Jogador player1, Jogador player2) {
        this.winner = player1;
        this.loser = player2;
        this.player1Turnos = player1.getTurnos();
        this.player2Turnos = player2.getTurnos();
    }

    public Jogador getWinner() {
        return winner;
    }

    public void setWinner(Jogador winner) {
        this.winner = winner;
    }

    public Jogador getLoser() {
        return loser;
    }

    public void setLoser(Jogador loser) {
        this.loser = loser;
    }

    public int getPlayer1Moves() {
        return player1Turnos;
    }

    public int getPlayer2Moves() {
        return player2Turnos;
    }
}
