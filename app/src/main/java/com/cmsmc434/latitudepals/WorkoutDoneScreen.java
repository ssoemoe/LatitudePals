package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WorkoutDoneScreen extends AppCompatActivity {
    private String buddyResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workoutdonescreen);

        buddyResult = getIntent().getStringExtra("timResult");

        String result = getIntent().getStringExtra("result");
        TextView resultView = (TextView) findViewById(R.id.result);
        resultView.setText(result);
    }

    public void goToBuddyStats(View view) {
        Intent intent = new Intent(this, ViewBuddyStats.class);
        intent.putExtra("buddyResult" , buddyResult);
        startActivity(intent);
    }

    public void goToHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}