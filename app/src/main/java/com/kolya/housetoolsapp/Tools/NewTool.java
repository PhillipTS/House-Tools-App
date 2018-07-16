package com.kolya.housetoolsapp.Tools;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kolya.housetoolsapp.R;

public class NewTool extends Tool {

    public NewTool() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_new_tool, container, false);
    }
}
