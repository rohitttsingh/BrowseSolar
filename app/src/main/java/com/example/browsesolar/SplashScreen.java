package com.example.browsesolar;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.Window;

import android.view.WindowManager;
import static com.example.browsesolar.R.layout.activity_main;



public class SplashScreen extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Window window = getWindow() ;


        setContentView(R.layout.activity_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }



        Thread splashTread = new Thread(){


            @Override

            public void run() {

                try {

                    sleep(1400);

                    startActivity(new Intent(SplashScreen.this, MainActivity.class));

                    finish();

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

                super.run();

            }

        };

        splashTread.start();


    } 



}