package com.example.eu.reversisec.Views;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eu.reversisec.Perfil.CamaraActivity;
import com.example.eu.reversisec.Perfil.EscolherPerfilActivity;
import com.example.eu.reversisec.Perfil.NovoPerfilActivity;
import com.example.eu.reversisec.Perfil.PerfilActual;
import com.example.eu.reversisec.R;

import java.lang.reflect.Method;

public class PerfilActivity extends Activity {

    String imageFilePath=null;
    ImageView imagePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        TextView tv1 = (TextView) findViewById(R.id.tvNomeJogador);
        Button btn1 = (Button) findViewById(R.id.btnCarregarImagem);
        Button btn2 = (Button) findViewById(R.id.btnGuardar);
        Button btn3 = (Button) findViewById(R.id.btnEscolherPerfil);

        /*Typeface font = Typeface.createFromAsset(getAssets(),"fonts/AmaticSC.ttf");
        btn1.setTypeface(font);
        btn2.setTypeface(font);
        btn3.setTypeface(font);
        tv1.setTypeface(font);
        btn1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        btn2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        btn3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
        tv1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 32);
*/
        //VERIFICAR SE TEM PERMISSOES PARA ACEDER AO CARTAO
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED)
                requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }

        //imagePreview = (ImageView) findViewById(R.id.imagePreview);

    }



    public void onCapturarImagem(View view)
    {
        String strNome = ((EditText)findViewById(R.id.edNomeJogador)).getText().toString();
        if (strNome.isEmpty())
        {
            Toast.makeText(PerfilActivity.this, "É necessário preencher o nome!", Toast.LENGTH_SHORT).show();
            findViewById(R.id.edNomeJogador).requestFocus();
            return;
        }
        if(Build.VERSION.SDK_INT>=24)
        {
            try
            {
                Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
                m.invoke(null);
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        /*imageFilePath = getExternalFilesDir(null)+"/"+strNome+".png";
        Uri fileUri;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = Uri.fromFile(new File(imageFilePath));
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, 20);*/

        Intent intent = new Intent(this,CamaraActivity.class);
        intent.putExtra("Nome", strNome);
        startActivity(intent);
    }
/*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        //if(requestCode == 20 && resultCode==RESULT_OK)
            DadosGuardados.setPic(imagePreview,imageFilePath);

      //  super.onActivityResult(requestCode, resultCode, data);
    }*/

    public void onGuardarPerfil(View view)
    {
            String strNome = ((EditText)findViewById(R.id.edNomeJogador)).getText().toString();
            if (strNome.isEmpty())
            {
                findViewById(R.id.edNomeJogador).requestFocus();
                Toast.makeText(PerfilActivity.this, "É necessário preencher o nome!", Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(this, NovoPerfilActivity.class);
            intent.putExtra("Foto", PerfilActual.fotoJogTemp);
            intent.putExtra("Nome", strNome);
            startActivity(intent);
            finish();
    }

    public void onEscolherPerfil(View view)
    {
        Intent intent = new Intent(this,EscolherPerfilActivity.class);
        startActivity(intent);
    }
}
