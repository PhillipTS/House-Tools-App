package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleCounter extends Tool {

    private int counterValue = 0;

    public SimpleCounter() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_counter, container, false);

        final TextView timerOutput = view.findViewById(R.id.simpleCounterOutput);

        final Button buttonSub = view.findViewById(R.id.buttonCounterDecrement);

        final Button buttonAdd = view.findViewById(R.id.buttonCounterIncrement);

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue--;
                timerOutput.setText("" + counterValue);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counterValue++;
                timerOutput.setText("" + counterValue);
            }
        });

        return view;
    }

}
