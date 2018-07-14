package com.kolya.housetoolsapp;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kolya.housetoolsapp.Tools.CurrentTime;
import com.kolya.housetoolsapp.Tools.TestFragment;
import com.kolya.housetoolsapp.Tools.Timer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Timer timer = new Timer();
        CurrentTime currentTime = new CurrentTime();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.tool1, timer, "timer")
                .addToBackStack("timer")
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.tool2, currentTime, "currentTime")
                .addToBackStack("currentTime")
                .commit();
    }
}
