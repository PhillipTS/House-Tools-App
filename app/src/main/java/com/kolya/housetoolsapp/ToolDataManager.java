package com.kolya.housetoolsapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Map;

public class ToolDataManager {

    private SharedPreferences sharedPreferences;

    public ToolDataManager(@NonNull Activity activity) {
        sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
    }

    public ArrayList<String> getTools() {
        Map<String, ?> toolsMap = sharedPreferences.getAll();
        ArrayList<String> tools = new ArrayList<>(5);

        for (String key : toolsMap.keySet())
            if ((Boolean) toolsMap.get(key))
                tools.add(key);

        return tools;
    }

    public void removeTool(String toolID) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(toolID, false);
        editor.apply();
    }

    public void addTool(String toolID) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(toolID, true);
        editor.apply();
    }
}
