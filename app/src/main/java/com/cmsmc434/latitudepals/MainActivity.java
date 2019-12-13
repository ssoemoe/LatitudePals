package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
    }



    //goes to share location
    public void goToGPS(View view){
        Intent intent= new Intent(this, SharingLocationGoScreen.class);
        startActivity(intent);
    }

    //goes to feed
    public void goToFeed(View view){
        Intent intent= new Intent(this, Feed.class);
        startActivity(intent);
    }

    //goes to recording a workout
    public void goToWorkout(View view){
        Intent intent= new Intent(this, ChoosingPartner.class);
        startActivity(intent);
    }

}
