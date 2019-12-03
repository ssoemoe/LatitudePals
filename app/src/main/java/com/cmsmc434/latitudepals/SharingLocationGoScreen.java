package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;


public class SharingLocationGoScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharelocationgoscreen);
    }

    public void Jen(View view){
        Intent intent= new Intent(this, SharingLocationWithJen1.class);
        startActivity(intent);
    }

    public void Tim(View view){
        Intent intent= new Intent(this, SharingLocationWithTim1.class);
        startActivity(intent);
    }

    public void Ask(View view){
        Context context = getApplicationContext();
        CharSequence text = "Asked for everyone's location!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void Send(View view){
        Context context = getApplicationContext();
        CharSequence text = "Sent your location to everyone!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void Back1(View view) {
        Intent intent= new Intent(this, Homescreen.class);
        startActivity(intent);
    }
}
