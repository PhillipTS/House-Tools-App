package com.kolya.housetoolsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

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
        ArrayList<String> toolIDs = toolDataManager.getTools();

        ArrayList<Tool> tools = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {
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

        setTool(tools.get(0), R.id.tool1, tools.get(0).toString());
        setTool(tools.get(1), R.id.tool2, tools.get(1).toString());
        setTool(tools.get(2), R.id.tool3, tools.get(2).toString());
        setTool(tools.get(3), R.id.tool4, tools.get(3).toString());
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
