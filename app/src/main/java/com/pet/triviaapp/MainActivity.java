package com.pet.triviaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.pet.triviaapp.view.MainContainer;

public class MainActivity extends AppCompatActivity {

   private int secondsDelayed = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent= new Intent(MainActivity.this, MainContainer.class);
                startActivity(intent);
                finish();
            }
        }, secondsDelayed * 2000);
    }
}