package com.kolya.housetoolsapp.Tools;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kolya.housetoolsapp.Clock;
import com.kolya.housetoolsapp.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class StopWatch extends Tool {

    private Clock clock;

    private Button clockToggleButton;

    public StopWatch() {
        title = "StopWatch";
        description = "A stopwatch that can count up, stop/start, and reset";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stop_watch, container, false);

        final TextView stopwatch = view.findViewById(R.id.stopwatch_view);

        clock = new Clock() {
            @Override
            protected void onTick() {
                super.onTick();
                Activity activity = getActivity();
                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            stopwatch.setText(String.format(Locale.ENGLISH, "%d", clock.getCount()));
                        }
                    });
            }
        };

        clockToggleButton = view.findViewById(R.id.clock_start_button);

        clockToggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clock.isRunning()) {
                    clock.stop();
                    clockToggleButton.setText(R.string.clock_toggle_start);
                }
                else {
                    clock.startClock();
                    clockToggleButton.setText(R.string.clock_toggle_stop);
                }
            }
        });

        view.findViewById(R.id.clock_reset_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clock.reset();
            }
        });

        return view;
    }

}
