package com.cmsmc434.latitudepals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SharingLocationWithTim1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sharelocationwithtim1);
    }

    public void AskTim(View view){
        Context context = getApplicationContext();
        CharSequence text = "Asked for Tim's location!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void SendTim(View view){
        Context context = getApplicationContext();
        CharSequence text = "Sent your location to Tim!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void BackTim(View view) {
        Intent intent= new Intent(this, SharingLocationGoScreen.class);
        startActivity(intent);
    }
}
