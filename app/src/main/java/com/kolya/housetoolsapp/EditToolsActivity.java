package com.kolya.housetoolsapp;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kolya.housetoolsapp.Tools.Tool;

import java.util.ArrayList;

public class EditToolsActivity extends AppCompatActivity implements NewToolDialog.NewToolDialogListener {

    private ToolDataManager toolDataManager;

    private ArrayList<Tool> tools;

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
        tools = toolDataManager.getTools();
        addToolSet = false;

        // TODO: Change to dynamic number of tools
        updateTool(R.id.tool_title1, R.id.tool_description1, R.id.tool_button1, 0);
        updateTool(R.id.tool_title2, R.id.tool_description2, R.id.tool_button2, 1);
        updateTool(R.id.tool_title3, R.id.tool_description3, R.id.tool_button3, 2);
        updateTool(R.id.tool_title4, R.id.tool_description4, R.id.tool_button4, 3);
        updateTool(R.id.tool_title5, R.id.tool_description5, R.id.tool_button5, 4);
        updateTool(R.id.tool_title6, R.id.tool_description6, R.id.tool_button6, 5);
        updateTool(R.id.tool_title7, R.id.tool_description7, R.id.tool_button7, 6);
        updateTool(R.id.tool_title8, R.id.tool_description8, R.id.tool_button8, 7);
    }

    private void updateTool(int titleID, int descID, int buttonID, int index) {

        TextView toolTitleView = findViewById(titleID);
        TextView toolDescView = findViewById(descID);
        Button toolButton = findViewById(buttonID);

        try {
            setToolData(toolTitleView, toolDescView, toolButton, tools.get(index));
        }
        catch (IndexOutOfBoundsException NoTool) {
            if (!addToolSet)
                setAddTool(toolTitleView, toolDescView, toolButton);
            else
                resetTool(toolTitleView, toolDescView, toolButton);
        }
    }

    private void setToolData(TextView toolTitleView, TextView toolDescView, Button removeToolButton, Tool initTool) {

        final Tool tool = initTool;

        toolTitleView.setText(tool.getTitle());
        toolDescView.setText(tool.getDescription());
        removeToolButton.setText(R.string.remove_tool_button);
        removeToolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolDataManager.removeTool(tool.getID());
                updateTools();
                Snackbar.make(view, tool.getTitle() + " Removed ", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                toolDataManager.addTool(tool.getID());
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
                new NewToolDialog().show(getSupportFragmentManager(), "newToolDialog");
            }
        });
        addToolSet = true;
    }

    private void resetTool(TextView toolTitleView, TextView toolDescView, Button toolButton) {
        toolTitleView.setText(R.string.default_tool_title);
        toolDescView.setText(R.string.default_tool_desc);
        toolButton.setText("");
        toolButton.setOnClickListener(null);
    }

    @Override
    public void onNewToolSelection(DialogFragment dialog) {
        updateTools();
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
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
