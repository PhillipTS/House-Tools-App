package com.kolya.housetoolsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kolya.housetoolsapp.Tools.CurrentTime;
import com.kolya.housetoolsapp.Tools.TestFragment;
import com.kolya.housetoolsapp.Tools.Timer;
import com.kolya.housetoolsapp.Tools.Tool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment testFragment1 = new TestFragment();
        TestFragment testFragment2 = new TestFragment();
        Timer countdownTimer = new Timer();
        CurrentTime currentTime = new CurrentTime();

        setTool(currentTime, R.id.tool1, "currentTime");

        setTool(countdownTimer, R.id.tool2, "countdownTime");

        setTool(testFragment1, R.id.tool3, "testFragment");

        setTool(testFragment2, R.id.tool4, "testFragment");
    }

    private void setTool(Tool tool, int fragmentId, String tag) {
        getSupportFragmentManager().beginTransaction()
                .add(fragmentId, tool, tag)
                .addToBackStack(tag)
                .commit();
    }

}
