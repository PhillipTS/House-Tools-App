package com.kolya.housetoolsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kolya.housetoolsapp.Tools.CurrentTime;
import com.kolya.housetoolsapp.Tools.SimpleCounter;
import com.kolya.housetoolsapp.Tools.SimpleTally;
import com.kolya.housetoolsapp.Tools.StopWatch;
import com.kolya.housetoolsapp.Tools.TestFragment;
import com.kolya.housetoolsapp.Tools.CountdownTimer;
import com.kolya.housetoolsapp.Tools.Tool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call super
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.activity_main);

        // Create Tools
        CurrentTime currentTime = new CurrentTime();
        CountdownTimer countdownTimer = new CountdownTimer();
        //StopWatch stopWatch = new StopWatch();
        SimpleCounter simpleCounter = new SimpleCounter();
        SimpleTally simpleTally = new SimpleTally();
        //TestFragment testFragment1 = new TestFragment();

        // Set Tools
        setTool(simpleTally, R.id.tool1, "simpleTally");
        setTool(countdownTimer, R.id.tool2, "countdownTime");
        setTool(currentTime, R.id.tool3, "currentTime");
        setTool(simpleCounter, R.id.tool4, "simpleCounter");
    }

    private void setTool(Tool tool, int fragmentId, String tag) {
        getSupportFragmentManager().beginTransaction()
                .add(fragmentId, tool, tag)
                .addToBackStack(tag)
                .commit();
    }

}
