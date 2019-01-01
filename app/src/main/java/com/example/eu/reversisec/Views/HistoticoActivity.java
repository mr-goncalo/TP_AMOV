package com.example.eu.reversisec.Views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.eu.reversisec.Jogo.Historico;
import com.example.eu.reversisec.Jogo.Jogador;
import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.MeuJogador;
import com.example.eu.reversisec.R;


public class HistoticoActivity extends AppCompatActivity {

    LogicaJogo jogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histotico);
        LogicaJogo gameData = (LogicaJogo) getApplicationContext();

        ListView listView = findViewById(R.id.my_listView);
        ListAdapter listAdapter = new ListAdapter(gameData);
        listView.setAdapter(listAdapter);
    }

    class ListAdapter extends BaseAdapter {

        LogicaJogo gameData;


        public ListAdapter(LogicaJogo gameData) {
            super();

            this.gameData = gameData;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return gameData.getHistoricos().size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return gameData.getHistoricos().get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }


        @Override
        public View getView(int position, View view, ViewGroup parent) {
            // TODO Auto-generated method stub
            view = getLayoutInflater().inflate(R.layout.layout_historico, null);
            if ((position % 2) == 0) {
                view.setBackgroundColor(0xFF595959);
            }else{
                view.setBackgroundColor(0xFFFFFFFF);
            }

            TextView nameWinner = view.findViewById(R.id.e_name_p1);

            TextView nameLoser = view.findViewById(R.id.e_name_p2);


            TextView resultWinner = view.findViewById(R.id.e_result_p1);

            TextView resultLoser = view.findViewById(R.id.e_result_p2);


            TextView movesWinner = view.findViewById(R.id.e_n_moves_p1);

            TextView movesLoser = view.findViewById(R.id.e_n_moves_p2);


            LogicaJogo gameData = (LogicaJogo) getApplicationContext();
            nameWinner.setText(gameData.getHistoricos().get(position).getVencedor());
            nameLoser.setText(gameData.getHistoricos().get(position).getPerdedor());
            resultWinner.setText("Winner");
            resultLoser.setText("Loser");
            String winnerMoves = String.valueOf(gameData.getHistoricos().get(position).getTVencedor());
            movesWinner.setText(winnerMoves);
            String loserMoves = String.valueOf(gameData.getHistoricos().get(position).getTPerdedor());
            movesLoser.setText(loserMoves);

            resultWinner.setTextColor(0xFF000000);
            resultWinner.setBackgroundColor(0xFF009900);


            resultLoser.setTextColor(0xFFFFFFFF);
            resultLoser.setBackgroundColor(0xFF6600cc);


            return view;
        }
    }

}
