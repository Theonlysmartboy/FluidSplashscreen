package com.otemainc.fluidsplashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.TimerTask;

import me.itangqi.waveloadingview.WaveLoadingView;

public class SplashActivity extends AppCompatActivity {
WaveLoadingView waveLoadingView;
    int total_duration = 21999;
    int duration_of_one_step =  1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        waveLoadingView = findViewById(R.id.wave);
        waveLoadingView.setProgressValue(0);
        splash();
    }

    private void splash() {
        new CountDownTimer(total_duration, duration_of_one_step){

            @Override
            public void onTick(long timetillfinished) {
                // calculate the progress by subtracting the time till finished from the total Duration
                int progress = (int) (((total_duration - timetillfinished) / 1000)*5);
                waveLoadingView.setProgressValue(progress);
                if(progress<45){
                    waveLoadingView.setBottomTitle("Filling up . . . " + progress + " % ");
                    waveLoadingView.setCenterTitle("");
                    waveLoadingView.setTopTitle("");
                }else if(progress<75){
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle("Filling up . . . " + progress + " % ");
                    waveLoadingView.setTopTitle("");
                }else{
                    waveLoadingView.setBottomTitle("");
                    waveLoadingView.setCenterTitle("");
                    waveLoadingView.setTopTitle("Almost Full . . ." + progress + " % ");
                }
            }

            @Override
            public void onFinish() {
                Intent loadMain = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(loadMain);
                finish();
            }
        }.start();
    }
}
