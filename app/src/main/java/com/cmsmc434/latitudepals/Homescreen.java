package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Homescreen extends AppCompatActivity {

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



}
