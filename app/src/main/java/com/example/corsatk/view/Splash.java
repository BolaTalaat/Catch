package com.example.corsatk.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.corsatk.R;

public class Splash extends AppCompatActivity {
    private static int Splash_Time_Out=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent i=new Intent(Splash.this,LoginMainDesign.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                finish();

            }


        },Splash_Time_Out);

    }
}
