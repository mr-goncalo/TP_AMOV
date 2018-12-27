package com.example.eu.reversisec.Perfil;
import android.app.Application;

import com.example.eu.reversisec.Historico.NovoHistorico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class DadosGuardados extends Application
{

    public novoPerfil savePerfil;
    ArrayList<novoPerfil> lstPerfis;
    private static DadosGuardados objPerfil;
    PerfilActual perfilActual;

    public NovoHistorico saveHistorico;
    ArrayList<NovoHistorico> lstJogada;
    private static DadosGuardados objHistorico;

    public DadosGuardados()
    {
        perfilActual = new PerfilActual();
        objPerfil=this;
        objHistorico=this;
        lstPerfis = new ArrayList<>();
        lstJogada = new ArrayList<>();
    }

    @Override
    public void onCreate()
    {
        super.onCreate();
        lerPerfil();
        lerHistorico();
    }

    public static ArrayList<novoPerfil> getListaPerfis()
    {
        return objPerfil.lstPerfis;
    }

    public static void addPerfil(novoPerfil np)
    {
        objPerfil.lstPerfis.add(np);
        gravarPerfil();
    }

    public static void gravarPerfil()
    {
        try
        {
            FileOutputStream fos=objPerfil.openFileOutput("perfis2.dat",MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objPerfil.lstPerfis);
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void lerPerfil()
    {
        objPerfil.lstPerfis=null;
        try {
            FileInputStream fis=objPerfil.openFileInput("perfis2.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<novoPerfil> lst = (ArrayList<novoPerfil>) ois.readObject();
            objPerfil.lstPerfis=lst;
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (objPerfil.lstPerfis == null)
            objPerfil.lstPerfis = new ArrayList<>();
    }

    public static ArrayList<NovoHistorico> getListaHistoricos()
    {
        return objHistorico.lstJogada;
    }

    public static NovoHistorico getHistorico(int n)
    {
        return objHistorico.lstJogada.get(n);
    }

    public static void addHistorico(NovoHistorico np)
    {
        objHistorico.lstJogada.add(np);
        gravarHistorico();
    }

    public static void eliminaJogada(int n)
    {
        objHistorico.lstJogada.remove(n);
        gravarHistorico();
    }

    public static void gravarHistorico()
    {
        try
        {
            FileOutputStream fos=objHistorico.openFileOutput("historico.dat",MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(objHistorico.lstJogada);
            fos.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public static void lerHistorico()
    {
        objHistorico.lstJogada=null;
        try {
            FileInputStream fis=objHistorico.openFileInput("historico.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<NovoHistorico> lst = (ArrayList<NovoHistorico>) ois.readObject();
            objHistorico.lstJogada=lst;
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (objHistorico.lstJogada == null)
            objHistorico.lstJogada = new ArrayList<>();
    }

}


