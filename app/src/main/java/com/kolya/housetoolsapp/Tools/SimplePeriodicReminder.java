package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 */
public class SimplePeriodicReminder extends Tool implements AdapterView.OnItemSelectedListener{

    private boolean buttonIsChecked = false;

    public SimplePeriodicReminder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple_periodic_reminder, container, false);

        final EditText nameInput = view.findViewById(R.id.simplePeriodicReminderInput);

        final Button buttonCheck = view.findViewById(R.id.simplePeriodicReminderButtonCheck);

        Calendar cal = Calendar.getInstance();

        //spinner
        //final Spinner timeUnitsSpinner = view.findViewById(R.id.simplePeriodicReminderSpinner);
        //ArrayAdapter<CharSequence> adapterTimeUnits = ArrayAdapter.createFromResource(getActivity(),
        //R.array.simple_periodic_reminder_time_units_selection, android.R.layout.simple_spinner_item);
        //adapterTimeUnits.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //timeUnitsSpinner.setAdapter(adapterTimeUnits);
//
        //timeUnitsSpinner.setOnItemSelectedListener(this);
//
        //buttonCheck.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        if (buttonIsChecked) {
        //            buttonCheck.setText(" CHECK ");
        //            buttonIsChecked = false;
        //        }
        //        else
        //        {
        //            buttonCheck.setText("UNCHECK");
        //            buttonIsChecked = true;
        //        }
        //    }
        //});

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Log.i("" + i,"ipos");
        switch(i) {

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
