package com.example.eu.reversisec.Perfil;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eu.reversisec.R;

import java.util.ArrayList;
import java.util.List;


public class EscolherPerfilActivity extends Activity
{
    public void escolherPerfil(final novoPerfil perfilSelecionado)
    {
        final PerfilActual perfilActual;
        perfilActual = new PerfilActual();
        final AlertDialog.Builder builder1 = new AlertDialog.Builder(EscolherPerfilActivity.this);
        builder1.setMessage("Seleciona este perfil para o jogador:");
        builder1.setCancelable(true);

        builder1.setPositiveButton("Jogador 2", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                perfilActual.setPerfilJogador2(perfilSelecionado.nome, perfilSelecionado.foto);
                finish();
            }
        });
        builder1.setNegativeButton("Jogador 1", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {

                perfilActual.setPerfilJogador1(perfilSelecionado.nome, perfilSelecionado.foto);
                finish();
            }
        });
        builder1.setNeutralButton("Cancelar", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
                finish();
            }
        });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    ListView lstView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escolher_perfil);

        lstView = (ListView) findViewById(R.id.lstPerfis);
        Perfis pfs = new Perfis(DadosGuardados.getListaPerfis());
        lstView.setAdapter(pfs);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                novoPerfil perfilSelecionado = DadosGuardados.getListaPerfis().get(position);
                escolherPerfil(perfilSelecionado);
            }
        });
    }

    class Perfis extends BaseAdapter
    {

        List<novoPerfil> lstPerfis;
        public Perfis(ArrayList<novoPerfil> listaPerfis)
        {
            lstPerfis=listaPerfis;
        }

        @Override
        public int getCount()
        {
            return lstPerfis.size();
        }

        @Override
        public Object getItem(int position)
        {
            return lstPerfis.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }


        public View getView(int position, View convertView, ViewGroup parent)
        {
            View layout = getLayoutInflater().inflate(R.layout.item_lista,null);
            novoPerfil np = lstPerfis.get(position);
            ((TextView) layout.findViewById(R.id.tvNome)).setText(np.nome);
            ((TextView) layout.findViewById(R.id.tvData)).setText(np.dataCriacao.toString());
            return layout;
        }
    }

}
