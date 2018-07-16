package com.kolya.housetoolsapp.Tools;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kolya.housetoolsapp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tool extends Fragment {

    // Tool Keys
    public static final String TEST_TOOL = "TEST_TOOL";

    public static final String NEW_TOOL_TOOL = "NEW_TOOL_TOOL";

    public static final String CURRENT_TIME_TOOL = "CURRENT_TIME_TOOL";

    public static final String COUNTDOWN_TIMER_TOOL = "COUNTDOWN_TIMER_TOOL";

    public static final String STOPWATCH_TOOL = "STOPWATCH_TOOL";

    public static final String SIMPLE_COUNTER_TOOL = "SIMPLE_COUNTER_TOOL";

    public static final String SIMPLE_TALLY_TOOL = "SIMPLE_TALLY_TOOL";

    public Tool() {}

    public static Tool makeTool(String toolID) {
        switch (toolID)
        {
            case TEST_TOOL:
                return new TestFragment();
            case NEW_TOOL_TOOL:
                return new NewTool();
            case CURRENT_TIME_TOOL:
                return new CurrentTime();
            case COUNTDOWN_TIMER_TOOL:
                return new CountdownTimer();
            case STOPWATCH_TOOL:
                return new StopWatch();
            case SIMPLE_COUNTER_TOOL:
                return new SimpleCounter();
            case SIMPLE_TALLY_TOOL:
                return new SimpleTally();
            default:
                return new Tool();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tool, container, false);
    }

    @Override
    public String toString() {
        return "tool";
    }
}
