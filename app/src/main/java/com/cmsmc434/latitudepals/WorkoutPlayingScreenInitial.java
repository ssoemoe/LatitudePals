package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

public class WorkoutPlayingScreenInitial extends AppCompatActivity {
    private static int yourBPM = 0, timBPM = 0;
    private static int yourSeconds = 0, timSeconds = 0;
    private static double yourDistance = 0, timDistance = 0;
    private PartnerTimer yourTimer, timTimer;
    private HashMap<String, TextView> yourViews = new HashMap<String, TextView>();
    private HashMap<String, TextView> timViews = new HashMap<String, TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workoutplayingscreeninitial);

        //set views
        yourViews.put("timer", (TextView)findViewById(R.id.yourTimer));
        yourViews.put("bpm", (TextView)findViewById(R.id.yourBPM));
        yourViews.put("distance", (TextView)findViewById(R.id.yourDistance));

        timViews.put("timer", (TextView) findViewById(R.id.timTimer));
        timViews.put("bpm", (TextView) findViewById(R.id.timBPM));
        timViews.put("distance", (TextView) findViewById(R.id.timDistance));

        // start timers
        yourTimer = new PartnerTimer(yourSeconds,yourBPM,yourDistance, yourViews);
        timTimer = new PartnerTimer(timSeconds,timBPM,timDistance, timViews);
        yourTimer.startTimer();
    }

    public void pause(View view) {

        // timer
        yourSeconds = yourTimer.getYourSeconds();
        yourBPM = yourTimer.getYourBPM();
        yourDistance = yourTimer.getYourDistance();
        yourTimer.stoptimertask();
        yourTimer = new PartnerTimer(yourSeconds,yourBPM,yourDistance, yourViews);

        timSeconds = timTimer.getYourSeconds();
        timBPM = timTimer.getYourBPM();
        timDistance = timTimer.getYourDistance();
        timTimer.stoptimertask();
        timTimer = new PartnerTimer(timSeconds,timBPM,timDistance, timViews);

        //visibility
        ConstraintLayout otherComponents = (ConstraintLayout) findViewById(R.id.otherWorkoutComponents);
        otherComponents.setVisibility(View.INVISIBLE);
        otherComponents.setClickable(false);
        ImageView pauseDisplay = (ImageView) findViewById(R.id.pauseDisplay);
        pauseDisplay.setVisibility(View.VISIBLE);
        otherComponents.setClickable(true);
    }

    public void resume(View view) {
        //timer
        yourTimer.startTimer();
        if (timTimer.getYourSeconds() == 0) {
            Toast.makeText(this, "Tim Chen joined the workout", Toast.LENGTH_SHORT).show();
        }
        timTimer.startTimer();
        // visibiltiy
        ConstraintLayout otherComponents = (ConstraintLayout) findViewById(R.id.otherWorkoutComponents);
        otherComponents.setVisibility(View.VISIBLE);
        otherComponents.setClickable(true);
        ImageView pauseDisplay = (ImageView) findViewById(R.id.pauseDisplay);
        pauseDisplay.setVisibility(View.INVISIBLE);
        otherComponents.setClickable(false);
    }

    public void stop(View view) {
        yourTimer.stoptimertask();
        timTimer.stoptimertask();
        Intent intent= new Intent(this, WorkoutDoneScreen.class);
        startActivity(intent);
    }



}

class PartnerTimer {
    private Timer yourTimer;
    private TimerTask yourTimerTask;
    private final Handler yourTimerHandler = new Handler();
    private int yourSeconds, yourBPM;
    private double yourDistance;
    private HashMap<String, TextView> views;
    public PartnerTimer(int seconds, int BPM, double distance, HashMap<String, TextView> views) {
        this.yourSeconds = seconds;
        this.yourBPM = BPM;
        this.yourDistance = distance;
        this.views = views;
    }

    public void initializeTimerTask() {

        yourTimerTask = new TimerTask() {
            public void run() {

                //use a handler to run a toast that shows the current timestamp
                yourTimerHandler.post(new Runnable() {
                    public void run() {
                        //get the current timeStamp
                        yourSeconds++;
                        TextView yourTimeView = views.get("timer");
                        yourTimeView.setText(getTimerString(yourSeconds));

                        Random random = new Random();
                        yourBPM = random.nextInt(70) + 40;
                        TextView yourBPMview = views.get("bpm");
                        yourBPMview.setText(yourBPM + " BPM");

                        DecimalFormat df = new DecimalFormat("#.00");
                        String distanceText = (df.format((yourSeconds * 0.0023))).toString() + " mi";
                        views.get("distance").setText(distanceText);
                        yourDistance = yourSeconds * 0.0023;
                    }
                });
            }
        };
    }

    public String getTimerString(int totalSeconds) {
        String hour = ((totalSeconds / 3600) + "").length() < 2 ? "0"+(totalSeconds / 3600) : (totalSeconds / 3600) + "";
        String minutes = (((totalSeconds % 3600) / 60) + "").length() < 2 ? "0"+((totalSeconds % 3600) / 60) : ((totalSeconds % 3600) / 60) + "";
        String seconds = (((totalSeconds % 3600) % 60) + "").length() < 2 ? "0"+(((totalSeconds % 3600) % 60)) : ((totalSeconds % 3600) % 60) + "";
        return hour + " : " + minutes + " : " + seconds;
    }

    public void startTimer() {
        yourTimer = new Timer();
        //initialize the TimerTask's job
        initializeTimerTask();

        //schedule the timer, after the first 5000ms the TimerTask will run every 10000ms
        yourTimer.schedule(yourTimerTask, 1000, 1000); //
    }

    public void stoptimertask() {
        //stop the timer, if it's not already null
        if (yourTimer != null) {
            yourTimer.cancel();
            yourTimer = null;
        }
    }

    public int getYourSeconds() {return this.yourSeconds;}
    public int getYourBPM() {return this.yourBPM;}
    public double getYourDistance() {return this.yourDistance;}
}
