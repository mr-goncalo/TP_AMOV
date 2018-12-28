package com.example.eu.reversisec.Perfil;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;

import game.Constant;
import game.GameData;
import game.player.Human;


public class CreateProfileActivity extends AppCompatActivity implements Constant {
    ImageButton imageButton;
    EditText editTextName;
    Button createProfileButton;
    private static final int CAMERA_REQUEST = 1888;
    Bitmap profilePhoto = null;
    Intent cameraIntent;
    GameData gameData;

    SharedPreferences prefs;
    String profileImgKey = "myPhoto";
    String playerNameKey = "myName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        gameData = (GameData) getApplication();
        imageButton = findViewById(R.id.imgB_profile_pic);
        editTextName = findViewById(R.id.ed_profile_name);
        createProfileButton = findViewById(R.id.bt_create_profile);
        prefs = this.getSharedPreferences("com.example.adriel.mychess", Context.MODE_PRIVATE);
        String myPhoto = "noPhoto";
        String myName = "noName";
        String profileImg = prefs.getString(profileImgKey, myPhoto);
        String profileName = prefs.getString(playerNameKey, myName);

        if (!profileImg.equalsIgnoreCase("noPhoto") && !profileName.equalsIgnoreCase("noName")) {

            File imgFile = new File(profileImg);
            profilePhoto = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

            gameData.setProfilePic(profilePhoto);

            gameData.setPlayer1(new Human(profileName, COLOR_BLACK, BOTTOM_SIDE));

            gameData.readFile();
            Intent startMainMenu = new Intent(this, MainMenuActivity.class);
            startMainMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            startActivity(startMainMenu);

        }

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        createProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GameData gameData = (GameData) getApplicationContext();
                String profileName = editTextName.getText().toString();
                if (profilePhoto != null) {
                    // CALL THIS METHOD TO GET THE URI FROM THE BITMAP
                    Uri tempUri = getImageUri(getApplicationContext(), profilePhoto);

                    // CALL THIS METHOD TO GET THE ACTUAL PATH
                    File finalFile = new File(getRealPathFromURI(tempUri));
                    String photoPath = finalFile.getAbsolutePath();

                    // And Save it to SharedPrefrence.
                    prefs.edit().putString(profileImgKey, photoPath).apply();
                    gameData.setProfilePic(profilePhoto);
                }
                if (profileName.equalsIgnoreCase("")) {

                    Toast.makeText(getApplicationContext(), "introduz nome", Toast.LENGTH_LONG).show();
                } else {
                    prefs.edit().putString(playerNameKey, profileName).apply();
                    gameData.setPlayer1(new Human(profileName, COLOR_BLACK, BOTTOM_SIDE));

                    Intent startMainMenu = new Intent(getApplicationContext(), MainMenuActivity.class);
                    startMainMenu.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    startActivity(startMainMenu);
                }


            }
        });
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
