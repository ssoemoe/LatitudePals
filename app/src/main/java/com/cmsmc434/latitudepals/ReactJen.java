package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ReactJen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reactjen);
    }

    //goes to home screen
    public void goToHomescreen(View view){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //goes back to feed and "sends the reaction"
    public void sendReaction(View view){
        Intent intent= new Intent(this, Feed.class);
        Toast toast = Toast. makeText(getApplicationContext(),"Reaction has been sent!",Toast. LENGTH_SHORT);
        toast. setMargin(50,50);
        toast. show();
        startActivity(intent);
    }
}
