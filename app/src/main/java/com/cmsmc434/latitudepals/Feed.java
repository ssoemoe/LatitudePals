package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Feed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feed);
    }

    //goes to react for jen
    public void goToJen(View view){
        Intent intent= new Intent(this, ReactJen.class);
        startActivity(intent);
    }

    //goes to react for shane
    public void goToShane(View view){
        Intent intent= new Intent(this, ReactShane.class);
        startActivity(intent);
    }

    //goes to react for tim
    public void goToTim(View view){
        Intent intent= new Intent(this, ReactTim.class);
        startActivity(intent);
    }

    //goes to home screen
    public void goToHomescreen(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
