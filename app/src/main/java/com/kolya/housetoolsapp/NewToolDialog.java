package com.kolya.housetoolsapp;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import com.kolya.housetoolsapp.Tools.Tool;

import java.util.ArrayList;

public class NewToolDialog extends DialogFragment {

    NewToolDialogListener mListener;

    @Override
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) throws NullPointerException {
        Activity activity = getActivity();
        if (activity == null) {throw new NullPointerException("Null Activity/Context");}

        final ToolDataManager toolDataManager = new ToolDataManager(activity);

        final ArrayList<Tool> tools = Tool.makeAllTools();

        ArrayList<String> setToolsIDs = toolDataManager.getTools();

        ArrayList<String> toolNames = new ArrayList<>(10);
        for (Tool tool : tools) {
            if (!setToolsIDs.contains(tool.getID()))
                toolNames.add(tool.getTitle());
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.new_tool_title)
                .setNegativeButton("Cancel", null)
                .setItems(toolNames.toArray(new String[]{}), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        toolDataManager.addTool(tools.get(i).getID());
                        mListener.onNewToolSelection(NewToolDialog.this);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (NewToolDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(context.toString() + " must implement NoticeDialogListener");
        }
    }

    public interface NewToolDialogListener {
        public void onNewToolSelection(DialogFragment dialog);
    }
}