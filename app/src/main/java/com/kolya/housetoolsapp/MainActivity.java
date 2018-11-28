package com.kolya.housetoolsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.kolya.housetoolsapp.Tools.Tool;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ToolDataManager toolDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Call super
        super.onCreate(savedInstanceState);
        // Set Layout
        setContentView(R.layout.activity_main);

        // Create Tool Manager
        toolDataManager = new ToolDataManager(this);

        updateTools();
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateTools();
    }

    private void updateTools() {
        // Create Tools
        ArrayList<String> toolIDs = toolDataManager.getToolIDs();

        ArrayList<Tool> tools = new ArrayList<>(toolIDs.size());

        for (int i = 0; i < 8 || i < toolIDs.size(); i++) {
            Tool tool;
            try {
                String toolID = toolIDs.get(i);
                tool = Tool.makeTool(toolID);
            }
            catch (IndexOutOfBoundsException noSavedTool) {
                tool = Tool.makeTool(Tool.NEW_TOOL_TOOL);
            }
            tools.add(tool);
        }

        // TODO: Use Dynamic amount of tools
        setTool(tools.get(0), R.id.tool1, tools.get(0).toString());
        setTool(tools.get(1), R.id.tool2, tools.get(1).toString());
        setTool(tools.get(2), R.id.tool3, tools.get(2).toString());
        setTool(tools.get(3), R.id.tool4, tools.get(3).toString());
        setTool(tools.get(4), R.id.tool5, tools.get(4).toString());
        setTool(tools.get(5), R.id.tool6, tools.get(5).toString());
        setTool(tools.get(6), R.id.tool7, tools.get(6).toString());
        setTool(tools.get(7), R.id.tool8, tools.get(7).toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.change_tools:
                Intent intent = new Intent(this, EditToolsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setTool(Tool tool, int fragmentId, String tag) {
        getSupportFragmentManager().beginTransaction()
                .add(fragmentId, tool, tag)
                .addToBackStack(tag)
                .commit();
    }

}
