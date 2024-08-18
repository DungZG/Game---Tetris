package com.example.tetris000;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class Gamemodes extends AppCompatActivity {

    Marathon parent;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamemode);
    }

    public void onMarathon(View v){
        parent.playMode = "Marathon";
        Intent intent = new Intent(this, Marathon.class);
        startActivity(intent);
        finish();
    }

    public void onSprint(View v){
            parent.playMode = "Sprint";
            Intent intent = new Intent(this, Marathon.class);
            startActivity(intent);
            finish();
    }
}
