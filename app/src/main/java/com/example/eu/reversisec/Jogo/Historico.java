package com.example.eu.reversisec.Jogo;

import com.example.eu.reversisec.Jogo.Jogador;
import com.example.eu.reversisec.Jogo.Utilizador;

import java.io.Serializable;


public class Historico implements Serializable {
    private static final long serialVersionUID = -33318182028391L;
    String Vencedor, Perdedor;
    String TVencedor, TPerdedor;

    public String getVencedor() {
        return Vencedor;
    }

    public void setVencedor(String Vencedor) {
        this.Vencedor = Vencedor;
    }

    public String getPerdedor() {
        return Perdedor;
    }

    public void setPerdedor(String Perdedor) {
        this.Perdedor = Perdedor;
    }

    public void turnosVencedor(String turno){
        this.TVencedor = turno;
    }

    public void turnosPerdedor(String TPerdedor) {
        this.TPerdedor = TPerdedor;
    }

    public String getTPerdedor() {
        return TPerdedor;
    }

    public String getTVencedor() {
        return TVencedor;
    }
}
