package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

import com.kolya.housetoolsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatch extends Tool {

    private Chronometer clock;

    private Button clockToggle;

    private boolean isClockRunning = false;

    private long clockBase = 0;

    public StopWatch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_stop_watch, container, false);

        clock = view.findViewById(R.id.time_clock);

        clockToggle = view.findViewById(R.id.clock_start_button);

        clockToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isClockRunning) {
                    clock.stop();
                    clockToggle.setText(R.string.clock_toggle_start);
                    isClockRunning = false;
                }
                else {
                    clock.start();
                    clockToggle.setText(R.string.clock_toggle_stop);
                    isClockRunning = true;
                }
            }
        });

        view.findViewById(R.id.clock_reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clock.setBase(SystemClock.elapsedRealtime());
            }
        });

        return view;
    }

}
