package com.example.quizzapplicationv1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import com.example.quizzapplicationv1.R;

public class SplashScreen1 extends AppCompatActivity {
    private final int SPLASH_SCREEN_TIMEOUT= 3000;
    private final int SPLASH_SPIN_TIMEOUT= 2000;
    RelativeLayout activity_splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen1);


        this.activity_splash = (RelativeLayout) findViewById(R.id.constraint_splash);

        final ProgressBar progressBar = new ProgressBar(this);
        ViewGroup.LayoutParams params = new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        progressBar.setLayoutParams(params);


        //rediriger vers la page principale "MainActivity" après 3s

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //démarrer une page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish(); //fini cette activité
            }
        };

        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {

                activity_splash.addView(progressBar);
            }
        };

        //handler post delayed
        new Handler().postDelayed(runnable, SPLASH_SCREEN_TIMEOUT);
        new Handler().postDelayed(runnable2, SPLASH_SPIN_TIMEOUT);
    }
}
