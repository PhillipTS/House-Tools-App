package com.kolya.housetoolsapp.Tools;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kolya.housetoolsapp.Clock;
import com.kolya.housetoolsapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentTime extends Tool {



    TextView display;

    Clock clock;

    public CurrentTime() {
        id = Tool.CURRENT_TIME_TOOL;
        title = "Current Time";
        description = "Displays the current time, updates and 24hr";
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_current_time, container, false);

        display = view.findViewById(R.id.timeView);

        clock = new Clock() {
            @Override
            public void onTick() {
                super.startClock();
                Activity activity = getActivity();
                if (activity != null)
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            display.setText(clock.getTime());
                        }
                    });
            }
        };

        clock.startClock();

        return view;
    }
}
