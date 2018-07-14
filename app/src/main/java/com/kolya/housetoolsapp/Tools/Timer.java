package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class Timer extends Fragment {

    public Timer() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);

        final TextView timerInput = view.findViewById(R.id.timeInput);

        final TextView countdown = view.findViewById(R.id.countdownValue);

        final Button startButton = view.findViewById(R.id.start_stopCountdown);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = Integer.parseInt("" + timerInput.getText());

                new CountDownTimer(time * 1000, 1000) {

                    public void onTick(long millisUntilFinished) {
                        countdown.setText("" + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        countdown.setText("Done!");
                    }
                }.start();
            }
        });

        return view;
    }

}
