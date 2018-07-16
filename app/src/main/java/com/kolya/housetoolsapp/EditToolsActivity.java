package com.kolya.housetoolsapp;

import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kolya.housetoolsapp.Tools.Tool;

import java.util.ArrayList;

public class EditToolsActivity extends AppCompatActivity {

    private ToolDataManager toolDataManager;

    private ArrayList<String> toolIDs;

    private Boolean addToolSet = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_tools);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(R.string.edit_tools_title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        toolDataManager = new ToolDataManager(this);

        updateTools();
    }

    private void updateTools() {
        toolIDs = toolDataManager.getTools();
        addToolSet = false;

        updateTool(R.id.tool_title1, R.id.tool_description1, R.id.tool_button1, 0);
        updateTool(R.id.tool_title2, R.id.tool_description2, R.id.tool_button2, 1);
        updateTool(R.id.tool_title3, R.id.tool_description3, R.id.tool_button3, 2);
        updateTool(R.id.tool_title4, R.id.tool_description4, R.id.tool_button4, 3);
    }

    private void updateTool(int titleID, int descID, int buttonID, int idIndex) {

        TextView toolTitleView = findViewById(titleID);
        TextView toolDescView = findViewById(descID);
        Button toolButton = findViewById(buttonID);

        try {
            setToolData(toolTitleView, toolDescView, toolButton, toolIDs.get(idIndex));
        }
        catch (IndexOutOfBoundsException NoTool) {
            if (!addToolSet)
                setAddTool(toolTitleView, toolDescView, toolButton);
        }
    }

    private void setToolData(TextView toolTitleView, TextView toolDescView, Button removeToolButton, String id) {
        final String toolID = id;
        final Tool tool = Tool.makeTool(toolID);

        toolTitleView.setText(tool.getTitle());
        toolDescView.setText(tool.getDescription());
        removeToolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolDataManager.removeTool(toolID);
                updateTools();
                Snackbar.make(view, tool.getTitle() + " Removed", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                toolDataManager.addTool(toolID);
                                updateTools();
                            }
                        }).show();
            }
        });
    }

    private void setAddTool(TextView toolTitleView, TextView toolDescView, Button addToolButton) {
        toolTitleView.setText(R.string.add_tool_title);
        toolDescView.setText(R.string.add_tool_desc);
        addToolButton.setText(R.string.add_tool_button);
        addToolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Adding", Toast.LENGTH_LONG).show();
            }
        });
        addToolSet = true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
