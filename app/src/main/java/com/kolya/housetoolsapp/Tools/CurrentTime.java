package com.kolya.housetoolsapp.Tools;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kolya.housetoolsapp.R;

import org.w3c.dom.Text;

import java.sql.Time;
import java.util.Date;


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
        View view = inflater.inflate(R.layout.fragment_current_time, container, false);

        Date date = new Date();

        TextView textView = (TextView) view.findViewById(R.id.timeView);

        if (textView != null)
            textView.setText(date.toString());

        return view;
    }
}
