package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 */
public class Timer extends Tool implements AdapterView.OnItemSelectedListener {

    private int timeUnitMultiplier = 1;

    private CountDownTimer countDownTimer = null;

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

        //spinner
        final Spinner timeUnitsSpinner = view.findViewById(R.id.timeUnitSpinner);
        ArrayAdapter<CharSequence> adapterTimeUnits = ArrayAdapter.createFromResource(getActivity(),
                R.array.time_units_selection, android.R.layout.simple_spinner_item);
        adapterTimeUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        timeUnitsSpinner.setAdapter(adapterTimeUnits);

        timeUnitsSpinner.setOnItemSelectedListener(this);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int time = Integer.parseInt("" + timerInput.getText());

                if (countDownTimer != null)
                    countDownTimer.cancel();

                Log.i("" + timeUnitMultiplier, "TIMER");

                countDownTimer = new CountDownTimer(time*timeUnitMultiplier* 1000, timeUnitMultiplier*1000) {

                    public void onTick(long millisUntilFinished) {
                        countdown.setText("" + (1+ millisUntilFinished / 1000/ timeUnitMultiplier));
                    }

                    public void onFinish() {
                        countdown.setText("Done!");
                    }
                }.start();
            }
        });

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("" + i,"ipos");
        switch(i) {
            case 0: timeUnitMultiplier = 1; break;
            case 1: timeUnitMultiplier = 60; break;
            case 2: timeUnitMultiplier = 3600; break;
            case 3: timeUnitMultiplier = 86400; break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
