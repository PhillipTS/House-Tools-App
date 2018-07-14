package com.kolya.housetoolsapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment testFragment = new TestFragment();
        CurrentTime currentTime = new CurrentTime();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.tool1, testFragment, "testFragment")
                .addToBackStack("testFragment")
                .commit();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.tool2, currentTime, "currentTime")
                .addToBackStack("currentTime")
                .commit();
    }
}
