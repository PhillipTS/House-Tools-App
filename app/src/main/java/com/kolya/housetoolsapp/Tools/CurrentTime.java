package com.kolya.housetoolsapp.Tools;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class CurrentTime extends Tool {

    public CurrentTime() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_current_time, container, false);

        Date date = new Date();

        ((TextView) view.findViewById(R.id.timeView)).setText(date.toString());

        return view;
    }
}
