package com.example.eu.reversisec.Views;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

import com.example.eu.reversisec.Jogo.LogicaJogo;
import com.example.eu.reversisec.R;

public class CreateProfileActivity extends AppCompatActivity  {
    ImageButton imageButton;
    EditText editTextName;
    Button createProfileButton;
    private static final int CAMERA_REQUEST = 1888;
    Bitmap profilePhoto = null;
    Intent cameraIntent;
    LogicaJogo userData;

    SharedPreferences prefs;
    String profileImgKey = "myPhoto";
    String playerNameKey = "myName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        userData = (LogicaJogo) getApplication();
        imageButton = findViewById(R.id.imgB_profile_pic);
        editTextName = findViewById(R.id.ed_profile_name);
        createProfileButton = findViewById(R.id.bt_create_profile);
        prefs = this.getSharedPreferences("com.example.eu.reversisec", Context.MODE_PRIVATE);
        String myPhoto = "noPhoto";
        String myName = "noName";
        String profileImg = prefs.getString(profileImgKey, myPhoto);
        String profileName = prefs.getString(playerNameKey, myName);

        if (!profileImg.equalsIgnoreCase("noPhoto") && !profileName.equalsIgnoreCase("noName")) {

            userData.getUtilizador1().setNome(profileName);
            userData.getUtilizador1().setImgFile(profileImg);

            Intent startMainMenu = new Intent(this, MainActivity.class);
            startMainMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(startMainMenu);

        }



        createProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String profileName = editTextName.getText().toString();

                if (profileName.equalsIgnoreCase("")) {

                    Toast.makeText(getApplicationContext(), "introduz nome", Toast.LENGTH_LONG).show();
                } else {
                    prefs.edit().putString(playerNameKey, profileName).apply();
                    prefs.edit().putString(profileImgKey,userData.getUtilizador1().getImgFile()).apply();
                    userData.getUtilizador1().setNome(profileName);
                    Intent startMainMenu = new Intent(getApplicationContext(), MainActivity.class);
                    startMainMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(startMainMenu);
                }

            }
        });
    }

    public void onCapturarImagem(View view)
    {
        String strNome = editTextName.getText().toString();
        if (strNome.isEmpty())
        {
            Toast.makeText(CreateProfileActivity.this, "É necessário preencher o nome!", Toast.LENGTH_SHORT).show();
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

        Intent intent = new Intent(this,CamaraActivity.class);
        intent.putExtra("Nome", strNome);
        startActivity(intent);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            profilePhoto = (Bitmap) extras.get("data");
            imageButton.setImageBitmap(profilePhoto);
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }
}
