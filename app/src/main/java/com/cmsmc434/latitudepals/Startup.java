package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Startup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startup);
    }

    //goes to home screen
    public void goToHomescreen(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
