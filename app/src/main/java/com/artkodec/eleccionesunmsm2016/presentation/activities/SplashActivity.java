package com.artkodec.eleccionesunmsm2016.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


import com.artkodec.eleccionesunmsm2016.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by junior on 10/07/16.
 */
public class SplashActivity extends AppCompatActivity{
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private static final long SPLASH_SCREEN_DELAY = 2000;

    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Hide title bar


        TimerTask task = new TimerTask() {
            @Override
            public void run() {


                    Intent mainIntent = new Intent().setClass(
                            SplashActivity.this, MainActivity.class);
                    startActivity(mainIntent);


                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }





}
