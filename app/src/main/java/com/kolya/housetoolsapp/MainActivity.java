package com.kolya.housetoolsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment testFragment = new TestFragment();

        /*getSupportFragmentManager().beginTransaction()
                .add(R.id.test_fragment, testFragment, "testFragment")
                .addToBackStack("testFragment")
                .commit();*/
    }
}
