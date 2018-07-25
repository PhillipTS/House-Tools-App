package com.kolya.housetoolsapp;

import java.util.Calendar;
import java.util.Locale;

public class Clock {

    private int count;

    private boolean running;

    private Thread thread = null;

    protected Clock() {
        count = 0;
        running = false;
    }

    protected void onTick() {}

    public void startClock() {
        running = true;

        if (thread == null) {
            thread = new Thread() {

                @Override
                public void run() {
                    try {
                        while (!isInterrupted()) {
                            Thread.sleep(1000);
                            count++;
                            onTick();
                        }
                    } catch (InterruptedException e) {}
                }
            };
            thread.start();
        }
    }

    public void stop() {
        running = false;
        if (thread != null) {
            Thread temp = thread;
            thread = null;
            temp.interrupt();
        }
    }

    public void reset() {
        count = 0;
    }

    public boolean isRunning() {return running;}

    public int getCount() {return count;}

    public String getTime() {
        Calendar calender = Calendar.getInstance();

        int hours = calender.get(Calendar.HOUR_OF_DAY);
        int minutes = calender.get(Calendar.MINUTE);
        int seconds = calender.get(Calendar.SECOND);

        return String.format(Locale.ENGLISH, "%02d  %02d  %02d", hours, minutes, seconds);
    }
}
