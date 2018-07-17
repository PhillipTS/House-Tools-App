package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleTally extends Tool {

    float tallyValue = 0;

    public SimpleTally() {
        id = Tool.SIMPLE_TALLY_TOOL;
        title = "Simple Tally";
        description = "A simple tally that can count up";
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_tally, container, false);

        final Button buttonAdd = view.findViewById(R.id.tallyAdd);

        final TextView tallyOutput = view.findViewById(R.id.tallyOutput);

        final EditText tallyInput = view.findViewById(R.id.tallyInput);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float newInput = Float.parseFloat("" + tallyInput.getText());
                tallyValue += newInput;
                tallyOutput.setText(String.format(Locale.ENGLISH, "$%f", tallyValue));
            }
        });

        return view;
    }

}
