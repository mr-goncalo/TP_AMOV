package com.example.eu.reversisec.Perfil;



public class PerfilActual
{

    public static int pecasJog1, pecasJog2;
    public static String nomeJog2, fotoJog2, nomeJog1, fotoJog1;
    public static String fotoJogTemp;
    public PerfilActual()
    {
        nomeJog1="Jogador 1";
        nomeJog2="Jogador 2";
        fotoJog1=null;
        fotoJog2=null;
        pecasJog1 =2;
        pecasJog2 =2;
        fotoJogTemp=null;
    }

    public void setPerfilJogador1(String nome, String foto)
    {
        nomeJog1=nome;
        fotoJog1=foto;
    }

    public String getNomeJogador1()
    {
        return nomeJog1;
    }

    public String getFotoJogador1()
    {
        return fotoJog1;
    }

    public void setPerfilJogador2(String nome, String foto)
    {
        nomeJog2=nome;
        fotoJog2=foto;
    }

    public String getNomeJogador2()
    {
        return nomeJog2;
    }

    public String getFotoJogador2()
    {
        return fotoJog2;
    }
}
