package com.example.eu.reversisec.Views;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

 import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.Jogo.Constantes;
import com.example.eu.reversisec.R;

public class FragmentBackButton extends DialogFragment implements Constantes {
    Button btChangeGameMode, btMainMenu;
    private View view;
    LogicaJogo gameData;
    Intent intent;


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        LayoutInflater inflater = getActivity().getLayoutInflater();
        gameData = (LogicaJogo) getActivity().getApplication();

        view = inflater.inflate(R.layout.fragment_back_button, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        btChangeGameMode = view.findViewById(R.id.button_change_mode);
        btMainMenu = view.findViewById(R.id.button_main_menu);

        if (gameData.getGameType() == SINGLE) {
            btChangeGameMode.setText(getResources().getString(R.string.multiPlayer));
        } else {
            btChangeGameMode.setText(getResources().getString(R.string.singlePlayer));
        }

        btChangeGameMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // closeThread();
            //    gameData.changeMode();
                if (gameData.getGameType() == SINGLE) {
                    btChangeGameMode.setText(getResources().getString(R.string.multiPlayer));

                     intent = new Intent(getActivity().getApplicationContext(), MultiplayerLocalBoardActivity.class);
                    gameData.setGameType(MULTI_LOCAL);
                } else {
                    btChangeGameMode.setText(getResources().getString(R.string.singlePlayer));

                    intent = new Intent(getActivity().getApplicationContext(), activity_modo_singleplayer.class);
                    gameData.setGameType(SINGLE);
                }

                startActivity(intent);

            }
        });
        btMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeThread();
            //    gameData.resetGameData();
                intent = new Intent(getActivity().getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
        builder.setView(view).setNeutralButton("Cancel", dialogClickListener);
        return builder.create();
    }

    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {

            switch (which) {

                case DialogInterface.BUTTON_NEUTRAL:
                    break;
            }
        }
    };

    private void  closeThread(){
    /*        if(gameData.getTimeThread()!=null){
            gameData.getTimeThread().closeThread();
            gameData.getTimeThread().interrupt();
        }*/
    }
}
