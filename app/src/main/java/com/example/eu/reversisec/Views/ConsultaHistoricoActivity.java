package com.example.eu.reversisec.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eu.reversisec.Historico.NovoHistorico;
import com.example.eu.reversisec.R;

import java.util.ArrayList;
import java.util.List;


public class ConsultaHistoricoActivity extends Activity
{

    ListView lstView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_historico);
        final int resultCode=0;
        lstView = (ListView) findViewById(R.id.lstHistorico);
      /*  Jogos pfs = new Jogos(DadosGuardados.getListaHistoricos());
        lstView.setAdapter(pfs);
        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
               Intent intent = new Intent(ConsultaHistoricoActivity.this,ExibeHistoricoActivity.class);
                ((DadosGuardados)getApplication()).saveHistorico=DadosGuardados.getListaHistoricos().get(position);
                intent.putExtra("posicao",position);
                startActivityForResult(intent, 1);
            }

        });
*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
            if(resultCode==RESULT_OK)
                this.finish();
    }

    class Jogos extends BaseAdapter
    {

        List<NovoHistorico> lstHistoricos;
        public Jogos(ArrayList<NovoHistorico> listaHistoricos)
        {
            lstHistoricos=listaHistoricos;
        }

        @Override
        public int getCount()
        {
            return lstHistoricos.size();
        }

        @Override
        public Object getItem(int position)
        {
            return lstHistoricos.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }


        public View getView(int position, View convertView, ViewGroup parent)
        {
            View layout = getLayoutInflater().inflate(R.layout.item_lista,null);
            NovoHistorico np = lstHistoricos.get(position);
            ((TextView) layout.findViewById(R.id.tvNome)).setText(np.getVencedor());
            ((TextView) layout.findViewById(R.id.tvData)).setText(np.getDataCriancao().toString());
            return layout;
        }
    }

}
