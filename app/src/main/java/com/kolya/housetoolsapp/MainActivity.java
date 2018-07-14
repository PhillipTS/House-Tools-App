package com.kolya.housetoolsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kolya.housetoolsapp.Tools.CurrentTime;
import com.kolya.housetoolsapp.Tools.StopWatch;
import com.kolya.housetoolsapp.Tools.TestFragment;
import com.kolya.housetoolsapp.Tools.CountdownTimer;
import com.kolya.housetoolsapp.Tools.Tool;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurrentTime currentTime = new CurrentTime();
        CountdownTimer countdownTimer = new CountdownTimer();
        StopWatch stopWatch = new StopWatch();
        TestFragment testFragment1 = new TestFragment();

        setTool(currentTime, R.id.tool1, "currentTime");

        setTool(countdownTimer, R.id.tool2, "countdownTime");

        setTool(stopWatch, R.id.tool3, "stopWatch");

        setTool(testFragment1, R.id.tool4, "testFragment");
    }

    private void setTool(Tool tool, int fragmentId, String tag) {
        getSupportFragmentManager().beginTransaction()
                .add(fragmentId, tool, tag)
                .addToBackStack(tag)
                .commit();
    }

}
