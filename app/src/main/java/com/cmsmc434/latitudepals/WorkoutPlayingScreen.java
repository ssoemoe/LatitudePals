package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.HashMap;

public class WorkoutPlayingScreen extends AppCompatActivity {

    private static int yourBPM = 90, timBPM = 80;
    private static int yourSeconds = 2700, timSeconds = 2690;
    private static double yourDistance = yourSeconds * 0.0023, timDistance = timSeconds * 0.0023;
    private PartnerTimer yourTimer, timTimer;
    private HashMap<String, TextView> yourViews = new HashMap<String, TextView>();
    private HashMap<String, TextView> timViews = new HashMap<String, TextView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workoutplayingscreen);


        //set views
        yourViews.put("timer", (TextView) findViewById(R.id.yourTimer));
        yourViews.put("bpm", (TextView) findViewById(R.id.yourBPM));
        yourViews.put("distance", (TextView) findViewById(R.id.yourDistance));

        timViews.put("timer", (TextView) findViewById(R.id.timTimer));
        timViews.put("bpm", (TextView) findViewById(R.id.timBPM));
        timViews.put("distance", (TextView) findViewById(R.id.timDistance));

        // start timers
        yourTimer = new PartnerTimer(yourSeconds, yourBPM, yourDistance, yourViews);
        timTimer = new PartnerTimer(timSeconds, timBPM, timDistance, timViews);
        yourTimer.startTimer();
        timTimer.startTimer();
    }

    public void pause(View view) {

        // timer
        yourSeconds = yourTimer.getYourSeconds();
        yourBPM = yourTimer.getYourBPM();
        yourDistance = yourTimer.getYourDistance();
        yourTimer.stoptimertask();
        yourTimer = new PartnerTimer(yourSeconds, yourBPM, yourDistance, yourViews);

        timSeconds = timTimer.getYourSeconds();
        timBPM = timTimer.getYourBPM();
        timDistance = timTimer.getYourDistance();
        timTimer.stoptimertask();
        timTimer = new PartnerTimer(timSeconds, timBPM, timDistance, timViews);

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
        String[] timerComponents =  yourTimer.getTimerString(yourTimer.getYourSeconds()).split(":");
        String yourResult = getResult(timerComponents, yourTimer.getYourDistance(), 105);

        String[] timTimerComponents = timTimer.getTimerString(timTimer.getYourSeconds()).split(":");
        String timResult =  getResult(timTimerComponents, timTimer.getYourDistance(), 95);
        Intent intent = new Intent(this, WorkoutDoneScreen.class);
        intent.putExtra("result", yourResult);
        intent.putExtra("timResult", "Tim Chen\n" + timResult);
        startActivity(intent);
    }

    public String getResult(String[] timerComponents, double distance, int avgBPM) {
        String result = "Total Time: " + timerComponents[1].trim() + " minutes and " + timerComponents[2].trim() + " seconds\n" ;
        result += "Total distance: " + (new DecimalFormat("#.00").format(distance)).toString() + " miles\n";
        result += "Average Heart Rate: " + avgBPM + " BPM";
        return result;
    }
}

