package com.kolya.housetoolsapp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.kolya.housetoolsapp.Tools.Tool;

import java.util.ArrayList;
import java.util.Map;

public class ToolDataManager {

    private static final String FILE_KEY = "HouseToolsApp.Tools";

    private SharedPreferences sharedPreferences;

    ToolDataManager(@NonNull Activity activity) {
        sharedPreferences = activity.getSharedPreferences(FILE_KEY, Context.MODE_PRIVATE);
    }

    public ArrayList<Tool> getTools() {
        ArrayList<String> toolIDs = getToolIDs();

        ArrayList<Tool> tools = new ArrayList<>(toolIDs.size());
        for (String toolID : toolIDs)
            tools.add(Tool.makeTool(toolID));

        return tools;
    }

    public ArrayList<String> getToolIDs() {
        Map<String, ?> toolsMap = sharedPreferences.getAll();
        ArrayList<String> toolIDs = new ArrayList<>(5);

        for (String key : toolsMap.keySet())
            if ((Boolean) toolsMap.get(key))
                toolIDs.add(key);

        return toolIDs;
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
