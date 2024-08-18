package com.example.tetris000;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by capja on 4/3/2019.
 */

public class StartScreen extends AppCompatActivity {

    Marathon parent;
    SharedPreferences mPref;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_screen);

        sharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        boolean isSoundEnabled = sharedPreferences.getBoolean("soundEnabled", true);

        if (isSoundEnabled) {
            startService(new Intent(StartScreen.this, BackgroundSoundService.class));
        }
    }

    public void readPreferences(){
        try {
            parent.randomType = mPref.getInt("Random Type", 1); // Second one means get what value if this does not exist
        } catch (Exception PrefEmpty) {
            parent.randomType = 1;
        }
        try {
            parent.rotationType = mPref.getInt("Rotation Type", 1); // Second one means get what value if this does not exist
        } catch (Exception PrefEmpty) {
            parent.rotationType = 2;
        }
        try {
            parent.softDropSpeed = mPref.getInt("Soft Drop Type", 1); // Second one means get what value if this does not exist
        } catch (Exception PrefEmpty) {
            parent.softDropSpeed = 1;
        }
    }

    public void onStart(View v){
        Intent intent = new Intent(this, Gamemodes.class);
        startActivity(intent);
    }

    public void onSettings(View v){
        Intent intent = new Intent(this, Settings.class);
        startActivity(intent);

    }

    public void onExit(View v){
        finish();
    }


}
